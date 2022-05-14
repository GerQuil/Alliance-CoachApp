package fourth.coachingapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fourth.coachingapp.entity.CoachForm;
import fourth.coachingapp.entity.User;

public interface CoachFormRepository extends JpaRepository<CoachForm, Integer>
{
	public List<CoachForm> findCoachFormByCoachOrderByIdDesc(User user);
}
