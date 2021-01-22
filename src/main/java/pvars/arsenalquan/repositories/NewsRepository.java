package pvars.arsenalquan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pvars.arsenalquan.models.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    @Query("SELECT r FROM News r ORDER BY createDate ASC")
    List<News> sortDateASC();

    @Query("SELECT r FROM News r ORDER BY createDate desc ")
    List<News> sortDateDESC();
}
