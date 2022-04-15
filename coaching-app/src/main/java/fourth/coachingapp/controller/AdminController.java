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
import org.springframework.web.bind.annotation.ResponseBody;

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
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "search", defaultValue = "false") boolean disabled)
	{
		List<User> users = userService.getUserBySearch(search, disabled);

		model.addAttribute("search", search);
		model.addAttribute("disabled", disabled);
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

	@PostMapping("users/enable")
	public String enableUser(
			@ModelAttribute User user)
	{
		userService.enableUser(user.getId());
		return "redirect:/admin/admin-page";
	}

	@PostMapping("users/disable")
	public String disableUser(
			@ModelAttribute User user)
	{
		userService.disableUser(user.getId());
		return "redirect:/admin/admin-page";
	}

	@GetMapping("/email-check")
	@ResponseBody
	public boolean emailCheck(@RequestParam String email)
	{
		return userService.isEmailTaken(email);
	}
}
