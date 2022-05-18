package fourth.coachingapp.service;

import java.nio.file.FileSystems;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fourth.coachingapp.dao.ProgressRepository;
import fourth.coachingapp.entity.Progress;
import fourth.coachingapp.response.EmailTemplate;
import fourth.coachingapp.response.NotFoundException;

@Service
public class ProgressService
{

	@Autowired
	ProgressRepository progressRepository;

	@Autowired
	DocumentService documentService;

	@Autowired
	EmailSenderService emailSender;

	@Autowired
	CoachFormService coachFormService;

	public List<Progress> getProgress()
	{
		return progressRepository.findAll();
	}

	public Progress getProgressById(int id)
	{
		Optional<Progress> result = progressRepository.findById(id);

		if(result.isEmpty())
		{
			throw new NotFoundException("PROGRESS WITH ID: " + id);
		}

		return result.get();
	}

	public void addProgress(Progress progress, MultipartFile file)
	{
		progress.setId(0);
		progress.setCoachForm(coachFormService.getCoachFormById(progress.getCoachForm().getId()));
		progress = progressRepository.save(progress);
		documentService.saveDocument(file, "progress", progress.getId());

		String basePath = FileSystems.getDefault()
				.getPath(".", "src", "main", "resources", "evidence", "progress", progress.getId() + "")
				.toString();

		emailSender.sendEmail(
				progress.getCoachForm().getTrainee().getEmail(),
				"Alliance Progress Evidence",
				EmailTemplate.progressFormBody(
						progress.getCoachForm().getCoach().getFirstName(),
						progress.getCoachForm().getCoach().getLastName(),
						progress.getCoachForm().getTrainee().getFirstName(),
						progress.getCoachForm().getTrainee().getLastName()),
				basePath);
	}

	public void updateProgress(Progress progress, MultipartFile file)
	{
		progress.setCoachForm(coachFormService.getCoachFormById(progress.getCoachForm().getId()));
		progressRepository.save(progress);
		documentService.saveDocument(file, "progress", progress.getId());

		String basePath = FileSystems.getDefault()
				.getPath(".", "src", "main", "resources", "evidence", "progress", progress.getId() + "")
				.toString();

		emailSender.sendEmail(
				progress.getCoachForm().getTrainee().getEmail(),
				"Alliance Progress Evidence",
				EmailTemplate.progressFormBody(
						progress.getCoachForm().getCoach().getFirstName(),
						progress.getCoachForm().getCoach().getLastName(),
						progress.getCoachForm().getTrainee().getFirstName(),
						progress.getCoachForm().getTrainee().getLastName()),
				basePath);
	}

	public void updateProgress(Progress progress)
	{
		progressRepository.save(progress);
	}

	public void deleteProgress(Progress progress)
	{
		progressRepository.delete(progress);
	}
}
