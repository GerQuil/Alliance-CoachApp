package fourth.coachingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fourth.coachingapp.security.BcryptSecurity;

@SpringBootApplication
public class CoachingAppApplication
{

	public static void main(String [] args)
	{
		SpringApplication.run(CoachingAppApplication.class, args);
	}

	@Bean
	public BcryptSecurity bcryptSecurity()
	{
		return new BcryptSecurity();
	}

}
