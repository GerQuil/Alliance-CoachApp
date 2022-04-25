package fourth.coachingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fourth.coachingapp.entity.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Integer>
{

}
