package fourth.coachingapp.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fourth.coachingapp.entity.User;
import fourth.coachingapp.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController
{
	Logger log = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/*
	 * ##################################################
	 * ##################################################
	 * ### List of users, with/without role parameter ###
	 * ##################################################
	 * ##################################################
	 */
	@GetMapping("/list")
	public String getUserList(
			Model model,
			@RequestParam(name = "role", required = false) String role)
	{
		List<User> users;

		if(role == null)
		{
			users = userService.getUsers();
			return null;
		}

		users = userService.getUsersByRole(role);
		return null;
	}

	/*
	 * #########################
	 * #########################
	 * ### get user using id ###
	 * #########################
	 * #########################
	 */

	@GetMapping("/user")
	public String getUserById(
			Model model,
			@RequestParam(name = "id") int id)
	{
		User user = userService.getUserById(id);
		return null;
	}

	@DeleteMapping("")
	public String deleteUser(@RequestParam(name = "id") int id)
	{
		userService.deleteUserById(id);
		return null;
	}

}
