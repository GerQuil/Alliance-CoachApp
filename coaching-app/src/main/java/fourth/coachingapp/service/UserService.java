package fourth.coachingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fourth.coachingapp.dao.UserRepository;
import fourth.coachingapp.entity.User;
import fourth.coachingapp.security.BcryptSecurity;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService
{
	@Autowired
	UserRepository userRepository;

	@Autowired
	BcryptSecurity bcrypt;

	public List<User> getUsers()
	{
		return userRepository.findAll();
	}

	public List<User> getUsersByRole(String role)
	{
		return userRepository.findByRole(role);
	}

	public List<User> getUserBySearch(String search)
	{
		search = "%" + search + "%";
		return userRepository.findBySearch(search);
	}

	public User getUserById(int id)
	{
		try
		{
			Optional<User> result = userRepository.findById(id);

			if(!result.isEmpty())
			{
				return result.get();
			}
		}
		catch (Exception e)
		{

		}

		return null;
	}

	public User getUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}

	public User addUser(User user)
	{
		try
		{
			user.setId(0);
			user.setPassword(bcrypt.encode(user.getPassword()));
			userRepository.save(user);
		}
		catch (Exception e)
		{

		}

		return user;
	}

	public User updateUser(User user)
	{
		try
		{
			if(user.getPassword().equals(""))
			{
				System.out.println(user);
				User userdb = getUserById(user.getId());
				user.setPassword(userdb.getPassword());
			}
			else
			{
				user.setPassword(bcrypt.encode(user.getPassword()));
			}

			System.out.println("user to be saved");
			userRepository.save(user);

		}
		catch (Exception e)
		{
//			e.printStackTrace();
		}
		return user;
	}

	public void deleteUser(User user)
	{
		try
		{
			userRepository.delete(user);
		}
		catch (Exception e)
		{

		}
	}

	public void deleteUserById(int id)
	{
		try
		{
			userRepository.deleteById(id);
		}
		catch (Exception e)
		{

		}
	}
}
