package spring.boot.com.sbparser.mapper;

import org.springframework.stereotype.Component;
import spring.boot.com.sbparser.dto.ReviewDto;
import spring.boot.com.sbparser.model.Product;

@Component
public class ProductMapper {
    public Product convertDtoToProduct(ReviewDto reviewDto) {
        return new Product(reviewDto.getProductId());
    }
}
