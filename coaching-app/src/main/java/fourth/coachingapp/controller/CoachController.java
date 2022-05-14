package fourth.coachingapp.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fourth.coachingapp.entity.CoachForm;
import fourth.coachingapp.entity.Progress;
import fourth.coachingapp.entity.User;
import fourth.coachingapp.service.CoachFormService;
import fourth.coachingapp.service.DocumentService;
import fourth.coachingapp.service.ProgressService;
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

	@Autowired
	ProgressService progressService;

	@Autowired
	DocumentService documentService;

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

	/*
	 * ############################################
	 * ############################################
	 * ### RETURNS LIST OF USERS BASED ON SEARCH ##
	 * ############################################
	 * ############################################
	 */

	@GetMapping("/trainees")
	@ResponseBody
	public List<User> traineeList(
			Principal principal,
			Model model,
			@RequestParam(name = "value") String value)
	{
		List<User> users = userService.getUserBySearch(value, false, principal.getName());

		return users;
	}

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
	public String form(
			Model model,
			Principal principal)
	{
		User user = userService.getUserByEmail(principal.getName());
		CoachForm coachForm = new CoachForm();
		coachForm.setCoach(user);
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
	public String getCoachFormView(
			Model model,
			@RequestParam(value = "id") int id)
	{
		CoachForm coachForm = coachFormService.getCoachFormById(id);
		model.addAttribute("coachform", coachForm);
		return ("coaches/viewform");
	}

	@GetMapping("/update/coach-form")
	public String getCoachformUpdate(
			Model model,
			@RequestParam(value = "id") int id)
	{
		CoachForm coachForm = coachFormService.getCoachFormById(id);
		model.addAttribute("coachform", coachForm);
		return ("coaches/updateforms");
	}
	///I added this one
	@GetMapping("/add/progress/coach-form")
	public String getCoachformProgress(
			Model model,
			@RequestParam(value = "id") int id)
	{
		CoachForm coachForm = coachFormService.getCoachFormById(id);
		model.addAttribute("coachform", coachForm);
		return ("coaches/updateprogress");
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
			@ModelAttribute CoachForm coachForm,
			@RequestParam(name = "file", required = false) MultipartFile file)
	{

		coachFormService.addCoachForm(coachForm, file);

		return "redirect:/coach/coach-forms";
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
			@ModelAttribute CoachForm coachform,
			@RequestParam(name = "file", required = false) MultipartFile file)
	{
		log.info("posting");
		if(file == null)
		{
			coachFormService.update(coachform);
		}
		else
		{
			coachFormService.update(coachform, file);
		}

		return "redirect:/coach/coachforms";
	}
	// I added this
	@PostMapping("/updateprog/coach-form")
	public String updateProgressCoachForm(
			Model model,
			@ModelAttribute CoachForm coachform,
			@RequestParam(name = "file", required = false) MultipartFile file)
	{
		log.info("posting");
		if(file == null)
		{
			coachFormService.update(coachform);
		}
		else
		{
			coachFormService.update(coachform, file);
		}

		return "redirect:/coach/coachforms";
	}

	/*
	 * ############################################
	 * ############################################
	 * ############# ADDING PROGRESS ##############
	 * ############################################
	 * ############################################
	 */

	@PostMapping("/add/progress")
	public String addProgress(
			@ModelAttribute Progress progress,
			@RequestParam(name = "file", required = false) MultipartFile file)
	{
		progressService.addProgress(progress, file);
		return "";
	}

	/*
	 * ############################################
	 * ############################################
	 * ############# UPDATE PROGRESS ##############
	 * ############################################
	 * ############################################
	 */

	@PostMapping("/update/progress")
	public String updateProgress(
			@ModelAttribute Progress progress,
			@RequestParam(name = "file", required = false) MultipartFile file)
	{
		progressService.updateProgress(progress, file);
		return "";
	}

	/*
	 * ############################################
	 * ############################################
	 * ############# GET DOCUMENTS ################
	 * ############################################
	 * ############################################
	 */

	@GetMapping(value = "/documents/{entity}/{id}",
			produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody byte [] pdf(
			@PathVariable(name = "entity") String entity,
			@PathVariable(name = "id") int id) throws IOException
	{
		return documentService.getDocument(entity, id);

	}

}
