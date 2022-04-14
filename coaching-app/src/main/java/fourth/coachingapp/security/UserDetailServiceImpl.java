package fourth.coachingapp.security;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fourth.coachingapp.entity.User;
import fourth.coachingapp.service.UserService;

@Service
public class UserDetailServiceImpl implements UserDetailsService
{
	Logger log = Logger.getLogger(UserDetailServiceImpl.class.getName());
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		User user = userService.getUserByEmail(email);

		if(user == null)
		{
			throw new UsernameNotFoundException("Email not found: " + email);
		}

		return new UserDetailsImpl(user);
	}

}
