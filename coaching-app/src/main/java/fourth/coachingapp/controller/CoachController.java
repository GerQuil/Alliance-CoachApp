package fourth.coachingapp.controller;

import java.security.Principal;
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

import fourth.coachingapp.entity.CoachForm;
import fourth.coachingapp.entity.User;
import fourth.coachingapp.service.CoachFormService;
import fourth.coachingapp.service.UserService;

@Controller
@RequestMapping("/coach")
public class CoachController
{
	Logger log = Logger.getLogger(CoachController.class);

	@Autowired
	UserService userService;

	@Autowired
	CoachFormService coachFormService;

	/*
	 * ############################################
	 * ############################################
	 * ####### RETURNS LIST OF COACH FORM #########
	 * ############################################
	 * ############################################
	 */

	@GetMapping("/coach-forms")
	public String forms(Model model)
	{
		List<CoachForm> coachForms = coachFormService.getCoachForms();
		model.addAttribute("coachForms", coachForms);
		return ("coaches/home");
	}

	/*
	 * ############################################
	 * ############################################
	 * ########### RETURNS COACH FORM #############
	 * ############################################
	 * ############################################
	 */

	@GetMapping("/coach-form")
	public String form(Model model)
	{
		CoachForm coachForm = new CoachForm();
		model.addAttribute("coachform", coachForm);
		return ("coaches/coachform");
	}

	/*
	 * ############################################
	 * ############################################
	 * ###### RETURNS COACH FORM WITH DATA ########
	 * ############################################
	 * ############################################
	 */

	@GetMapping("/view/coach-form")
	public String forms(
			Model model,
			@RequestParam(value = "id") int id)
	{
		CoachForm coachForm = coachFormService.getCoachFormById(id);
		model.addAttribute("coachform", coachForm);
		return ("coaches/coachform");
	}

	/*
	 * ############################################
	 * ############################################
	 * ########## ADD COACH FORM ##################
	 * ############################################
	 * ############################################
	 */

	@PostMapping("/add/coach-form")
	public String addCoachForm(
			Model model,
			@ModelAttribute CoachForm coachform)
	{
		log.info("posting");
		coachFormService.addCoachForm(coachform);

		return "redirect:/coaches/coachform";
	}

	/*
	 * ############################################
	 * ############################################
	 * ########## UPDATE COACH FORM ###############
	 * ############################################
	 * ############################################
	 */

	@PostMapping("/update/coach-form")
	public String updateCoachForm(
			Model model,
			@ModelAttribute CoachForm coachform)
	{
		log.info("posting");
		coachFormService.update(coachform);

		return "redirect:/coaches/coachform";
	}

	/*
	 * ############################################
	 * ############################################
	 * ##### RETURNS COACH PROFILE PAGE FORM ######
	 * ############################################
	 * ############################################
	 */

	@GetMapping("/profile")
	public String adminProfile(
			Model model,
			Principal principal)
	{
		User user = userService.getUserByEmail(principal.getName());

		model.addAttribute("user", user);
		return ("/coaches/profile");
	}

}
