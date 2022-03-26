package fourth.coachingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fourth.coachingapp.dao.UserRepository;
import fourth.coachingapp.entity.User;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService
{
	@Autowired
	UserRepository userRepository;

	public List<User> getUsers()
	{
		return userRepository.findAll();
	}

	public List<User> getUsersByRole(String role)
	{
		return userRepository.findByRole(role);
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

	public User addUser(User user)
	{
		try
		{
			user.setId(0);
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
			userRepository.save(user);
		}
		catch (Exception e)
		{

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
