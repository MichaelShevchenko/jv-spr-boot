package spring.boot.com.sbparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.com.sbparser.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
