package spring.boot.com.sbparser.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.com.sbparser.dto.ProductResponseDto;
import spring.boot.com.sbparser.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT NEW spring.boot.com.sbparser.dto.ProductResponseDto(p.externalProductId)"
            + " FROM Review AS r JOIN r.product AS p"
            + " GROUP BY p.externalProductId ORDER BY COUNT(r) DESC")
    List<ProductResponseDto> findMostCommented(Pageable pageable);
}
