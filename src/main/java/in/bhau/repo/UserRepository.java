package in.bhau.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import in.bhau.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	
}
