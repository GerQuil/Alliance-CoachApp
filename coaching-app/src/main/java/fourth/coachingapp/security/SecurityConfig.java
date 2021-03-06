package fourth.coachingapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	UserDetailServiceImpl userDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				.csrf()
				.disable()
				.authorizeRequests()
//		.antMatchers("/**").permitAll();
				.antMatchers("/admin/**").hasRole("Admin")
				.antMatchers("/coach/**").hasRole("Coach")
				.antMatchers("/*", "resources/**").permitAll()
				.and().formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/success");

	}

}
