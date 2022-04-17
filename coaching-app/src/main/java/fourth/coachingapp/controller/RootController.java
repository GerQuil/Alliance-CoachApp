package fourth.coachingapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return ("login");
	}

	@GetMapping("/coach/home")
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

	@RequestMapping("/success")
	public String loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult)
			throws IOException, ServletException
	{

		String role = authResult.getAuthorities().toString();

		if(role.contains("ROLE_Admin"))
		{
			return "redirect:/admin/admin-page";
		}
		else if(role.contains("ROLE_Coach"))
		{
			return "redirect:/coach/home";
		}

		return "redirect:/login";
	}
}
