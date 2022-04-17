package fourth.coachingapp.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fourth.coachingapp.entity.CoachForm;
import fourth.coachingapp.service.UserService;

@Controller
@RequestMapping("/coach")
public class CoachController
{
	Logger log = Logger.getLogger(CoachController.class);

	@Autowired
	UserService userService;

	/*
	 * ############################################
	 * ############################################
	 * ########### RETURNS COACH FORM #############
	 * ############################################
	 * ############################################
	 */

	@GetMapping("/coach-form")
	public String forms(Model model)
	{
		CoachForm coachForm = new CoachForm();
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

	@PostMapping("/coach-form")
	public String addCoachForm(
			Model model,
			@ModelAttribute CoachForm coachform)
	{
		log.info("posting");
		// userService.addUser(coachform);
		model.addAttribute("coach-form", coachform);
		return "coaches/coachform";
	}

}
