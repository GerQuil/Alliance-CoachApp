package fourth.coachingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fourth.coachingapp.entity.CoachForm;

public interface CoachFormRepository extends JpaRepository<CoachForm, Integer>
{

}
