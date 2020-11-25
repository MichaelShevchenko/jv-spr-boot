package spring.boot.com.sbparser.service;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.boot.com.sbparser.dto.ProductResponseDto;
import spring.boot.com.sbparser.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseDto> findMostCommented(int quantity) {
        return productRepository.findMostCommented(PageRequest.of(0, quantity));
    }
}
