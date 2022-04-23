package fourth.coachingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fourth.coachingapp.dao.CoachFormRepository;
import fourth.coachingapp.entity.CoachForm;
import fourth.coachingapp.security.BcryptSecurity;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoachFormService
{
	@Autowired
	CoachFormRepository coachFormRepsository;

	@Autowired
	BcryptSecurity bcrypt;

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

	public void addCoachForm(CoachForm coachForm)
	{
		coachForm.setId(0);
		coachFormRepsository.save(coachForm);
	}

	public void update(CoachForm coachForm)
	{
		coachFormRepsository.save(coachForm);
	}

}
