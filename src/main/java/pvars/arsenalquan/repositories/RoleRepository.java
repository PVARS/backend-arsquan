package pvars.arsenalquan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pvars.arsenalquan.models.Role;
import pvars.arsenalquan.models.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
