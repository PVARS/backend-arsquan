package pvars.arsenalquan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pvars.arsenalquan.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
