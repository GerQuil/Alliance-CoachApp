package fourth.coachingapp.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fourth.coachingapp.entity.User;
import fourth.coachingapp.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController
{
	Logger log = Logger.getLogger(AdminController.class);

	@Autowired
	UserService userService;

	@GetMapping("/admin-page")
	public String admins(
			Model model,
			@RequestParam(value = "search", defaultValue = "") String search)
	{
		List<User> users;
		if(!search.equals(""))
		{
			users = userService.getUserBySearch(search);

		}
		else
		{
			users = userService.getUsers();
		}
		model.addAttribute("search", search);
		model.addAttribute("users", users);

		User user = new User();
		model.addAttribute("user", user);
		return ("admin/adminpage");
	}

	@PostMapping("users/add")
	public String addUser(
			@ModelAttribute User user)
	{

		userService.addUser(user);
		return "redirect:/admin/admin-page";
	}

	@PostMapping("users/update")
	public String updateUser(
			@ModelAttribute User user)
	{

		userService.updateUser(user);
		return "redirect:/admin/admin-page";
	}

	@PostMapping("users/delete")
	public String deleteUser(
			@ModelAttribute User user)
	{
		userService.deleteUserById(user.getId());
		return "redirect:/admin/admin-page";
	}
}
