package pvars.arsenalquan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pvars.arsenalquan.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("SELECT r FROM User r ORDER BY createDate ASC")
    List<User> sortDateASC();

    @Query("SELECT r FROM User r ORDER BY createDate desc ")
    List<User> sortDateDESC();
}
