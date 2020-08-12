package pvars.arsenalquan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pvars.arsenalquan.models.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
