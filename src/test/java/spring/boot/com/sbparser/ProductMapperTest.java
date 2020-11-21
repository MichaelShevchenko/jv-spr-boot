package spring.boot.com.sbparser;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.Assert;
import org.junit.Test;
import spring.boot.com.sbparser.dto.ReviewDto;
import spring.boot.com.sbparser.mapper.ProductMapper;
import spring.boot.com.sbparser.model.Product;

public class ProductMapperTest {
    private static final String PRODUCT_ID = "B001GVISJM";
    private static final ProductMapper productMapper = new ProductMapper();
    private static final ReviewDto properReviewDto = new ReviewDto();
    private static final ReviewDto noProductReviewDto = new ReviewDto();

    static {
        properReviewDto.setReviewId(14);
        properReviewDto.setProductId(PRODUCT_ID);
        properReviewDto.setUserId("A18ECVX2RJ7HUE");
        properReviewDto.setProfileName("\"willie \"\"roadie\"\"\"");
        properReviewDto.setHelpfulnessNumerator(2);
        properReviewDto.setHelpfulnessDenominator(2);
        properReviewDto.setScore(4);
        properReviewDto.setTime(LocalDateTime
                .ofInstant(Instant.ofEpochSecond(1288915200), ZoneId.systemDefault()));
        properReviewDto.setSummary("fresh and greasy!");
        properReviewDto.setText("good flavor! these came securely packed... they were "
                + "fresh and delicious! i love these Twizzlers!");

        noProductReviewDto.setReviewId(14);
        noProductReviewDto.setUserId("A18ECVX2RJ7HUE");
        noProductReviewDto.setProfileName("\"willie \"\"roadie\"\"\"");
        noProductReviewDto.setHelpfulnessNumerator(2);
        noProductReviewDto.setHelpfulnessDenominator(2);
        noProductReviewDto.setScore(4);
        noProductReviewDto.setTime(LocalDateTime
                .ofInstant(Instant.ofEpochSecond(1288915200), ZoneId.systemDefault()));
        noProductReviewDto.setSummary("fresh and greasy!");
        noProductReviewDto.setText("good flavor! these came securely packed... they were "
                + "fresh and delicious! i love these Twizzlers!");
    }

    @Test
    public void convertReviewDtoToProductOk() {
        Product expected = new Product(PRODUCT_ID);
        Product actual = productMapper.convertDtoToProduct(properReviewDto);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertReviewDtoWithNoProductInfo() {
        Product expected = new Product();
        Product actual = productMapper.convertDtoToProduct(noProductReviewDto);
        Assert.assertEquals(expected, actual);
    }
}
