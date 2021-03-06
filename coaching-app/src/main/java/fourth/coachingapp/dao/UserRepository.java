package fourth.coachingapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fourth.coachingapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	public List<User> findByRole(String role);

	public User findByEmail(String email);

	@Query("SELECT u FROM User u WHERE "
			+ "concat(u.firstName, ' ',u.lastName) LIKE :name"
			+ " AND u.disabled = :disabled"
			+ " AND u.email != :email")
	public List<User> findBySearch(
			@Param("name") String name,
			boolean disabled,
			@Param("email") String email);
}
