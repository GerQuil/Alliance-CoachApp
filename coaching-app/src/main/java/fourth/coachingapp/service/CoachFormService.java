package fourth.coachingapp.service;

import java.nio.file.FileSystems;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fourth.coachingapp.dao.CoachFormRepository;
import fourth.coachingapp.entity.CoachForm;
import fourth.coachingapp.response.EmailTemplate;
import fourth.coachingapp.security.BcryptSecurity;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoachFormService
{
	@Autowired
	UserService userService;

	@Autowired
	CoachFormRepository coachFormRepsository;

	@Autowired
	DocumentService documentService;

	@Autowired
	BcryptSecurity bcrypt;

	@Autowired
	EmailSenderService emailSender;

	public List<CoachForm> getCoachForms()
	{
		return coachFormRepsository.findAll();
	}

	public CoachForm getCoachFormById(int id)
	{
		Optional<CoachForm> result = coachFormRepsository.findById(id);

		if(result.isEmpty())
		{
			return null;
		}
		return result.get();
	}

	public void addCoachForm(CoachForm coachForm, MultipartFile file)
	{
		coachForm.setId(0);
		coachForm.setCoach(userService.getUserByEmail(coachForm.getCoach().getEmail()));
		coachForm.setTrainee(userService.getUserByEmail(coachForm.getTrainee().getEmail()));
		coachForm = coachFormRepsository.save(coachForm);

		documentService.saveDocument(file, "coachform", coachForm.getId());

//		for email
		String basePath = FileSystems.getDefault()
				.getPath(".", "src", "main", "resources", "evidence", "coachform", coachForm.getId() + "")
				.toString();

		emailSender.sendEmail(
				coachForm.getTrainee().getEmail(),
				"Alliance CoachForm Evidence",
				EmailTemplate.coachFormBody(
						coachForm.getCoach().getFirstName(),
						coachForm.getCoach().getLastName(),
						coachForm.getTrainee().getFirstName(),
						coachForm.getTrainee().getLastName()),
				basePath);

	}

	public void update(CoachForm coachForm)
	{
		coachFormRepsository.save(coachForm);
	}

	public void update(CoachForm coachForm, MultipartFile file)
	{
		documentService.saveDocument(file, "coachform", coachForm.getId());
		coachFormRepsository.save(coachForm);

//		for email
		String basePath = FileSystems.getDefault()
				.getPath(".", "src", "main", "resources", "evidence", "coachform", coachForm.getId() + "")
				.toString();

		emailSender.sendEmail(
				coachForm.getTrainee().getEmail(),
				"Alliance CoachForm Evidence",
				EmailTemplate.coachFormBody(
						coachForm.getCoach().getFirstName(),
						coachForm.getCoach().getLastName(),
						coachForm.getTrainee().getFirstName(),
						coachForm.getTrainee().getLastName()),
				basePath);
	}

}
