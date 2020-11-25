package spring.boot.com.sbparser.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.com.sbparser.dto.UserResponseDto;
import spring.boot.com.sbparser.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT NEW spring.boot.com.sbparser.dto.UserResponseDto(u.profileName)"
            + " FROM Review AS r JOIN r.user AS u"
            + " GROUP BY u.profileName ORDER BY COUNT(r) DESC")
    List<UserResponseDto> findMostActive(Pageable pageable);
}
