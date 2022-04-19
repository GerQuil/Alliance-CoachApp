package fourth.coachingapp.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fourth.coachingapp.entity.User;

@Controller
public class RootController
{
	Logger log = Logger.getLogger(RootController.class);

	/*
	 * #########################################
	 * ############# index page ################
	 * #########################################
	 */
	@GetMapping("/")
	public String index(Model model)
	{
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return ("admin/adminlogin");
	}

	@GetMapping("/profile")
	public String profile(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return ("admin/profile");
	}
	

	@GetMapping("/home")
	public String home(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return ("coaches/home");
	}

	@GetMapping("/updateforms")
	public String updateforms(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return ("coaches/updateform");
	}
}
