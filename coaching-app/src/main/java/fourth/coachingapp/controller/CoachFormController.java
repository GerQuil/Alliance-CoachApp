package fourth.coachingapp.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fourth.coachingapp.entity.CoachForm;
import fourth.coachingapp.entity.User;
import fourth.coachingapp.service.UserService;

@Controller
@RequestMapping("/coach-form")
public class CoachFormController
{
	Logger log = Logger.getLogger(CoachFormController.class);

	@Autowired
	UserService userService;
	@GetMapping("/addform")
	public String forms(Model model)
	{
		CoachForm coachForm = new CoachForm();
		model.addAttribute("coachform", coachForm);
		return ("coaches/coachform");
	}
/////////////////////////////////////////
	@GetMapping("/updateform")
	public String updateforms(Model model)
	{
		CoachForm updateForm = new CoachForm();
		model.addAttribute("updateforms", updateForm);
		return ("coaches/updateforms");
	}
/////////////////////////////////////////
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

	/*
	 * ################
	 * ################
	 * ### Add coach form ###
	 * ################
	 * ################
	 */

	@PostMapping("/add")
	public String addCoachForm(
			Model model,
			@ModelAttribute CoachForm coachform)
	{
		log.info("posting");
		//userService.addUser(coachform);
		model.addAttribute("coach-form", coachform);
		return "coaches/coachform";
	}
	
	/*
	 * #########################
	 * #########################
	 * ### Update coach form ###
	 * #########################
	 * #########################
	 */

	// @PostMapping("/update")
	// public String updateCoachForm(
	// 		Model model,
	// 		@ModelAttribute CoachForm coachform)
	// {
	// 	log.info("posting");
	// 	//userService.addUser(coachform);
	// 	model.addAttribute("coach-form", coachform);
	// 	return "coaches/updateforms";
	// }
	
	/*
	 * ###################
	 * ###################
	 * ### Update User ###
	 * ###################
	 * ###################
	 */

	@PutMapping("")
	public String updateUser(@RequestBody User user)
	{
		userService.updateUser(user);
		return null;
	}

	/*
	 * ###################
	 * ###################
	 * ### Delete User ###
	 * ###################
	 * ###################
	 */

	@DeleteMapping("")
	public String deleteUser(@RequestParam(name = "id") int id)
	{
		userService.deleteUserById(id);
		return null;
	}

}
