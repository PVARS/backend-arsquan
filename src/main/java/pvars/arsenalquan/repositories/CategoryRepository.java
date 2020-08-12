package pvars.arsenalquan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pvars.arsenalquan.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
