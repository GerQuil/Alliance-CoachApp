package fourth.coachingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fourth.coachingapp.dao.ProgressRepository;
import fourth.coachingapp.entity.Progress;
import fourth.coachingapp.response.NotFoundException;

@Service
public class ProgressService
{

	@Autowired
	ProgressRepository progressRepository;

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
		progress = progressRepository.save(progress);
	}

	public void updateProgress(Progress progress, MultipartFile file)
	{
		progressRepository.save(progress);
	}

	public void deleteProgress(Progress progress)
	{
		progressRepository.delete(progress);
	}
}
