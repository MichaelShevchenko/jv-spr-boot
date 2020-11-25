package spring.boot.com.sbparser.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.com.sbparser.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query("SELECT word FROM Word ORDER BY quantity DESC")
    List<String> findMostUsed(Pageable pageable);
}
