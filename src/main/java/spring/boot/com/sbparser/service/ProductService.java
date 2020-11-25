package spring.boot.com.sbparser.service;

import java.util.List;
import spring.boot.com.sbparser.dto.ProductResponseDto;

public interface ProductService {
    List<ProductResponseDto> findMostCommented(int quantity);
}
