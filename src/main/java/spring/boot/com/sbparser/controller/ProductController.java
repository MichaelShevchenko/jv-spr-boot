package spring.boot.com.sbparser.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.com.sbparser.dto.ProductResponseDto;
import spring.boot.com.sbparser.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final String DEFAULT_PRODUCTS_QUANTITY = "1000";
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/most-commented")
    public List<ProductResponseDto> getMostCommentedProducts(
            @RequestParam(defaultValue = DEFAULT_PRODUCTS_QUANTITY) int productsQuantity) {
        return productService.findMostCommented(productsQuantity);
    }
}
