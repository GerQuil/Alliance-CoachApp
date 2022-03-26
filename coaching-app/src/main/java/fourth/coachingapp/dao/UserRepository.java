package fourth.coachingapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fourth.coachingapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	public List<User> findByRole(String role);
}
