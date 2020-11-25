package spring.boot.com.sbparser;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import spring.boot.com.sbparser.dto.ReviewDto;
import spring.boot.com.sbparser.mapper.ProductMapper;
import spring.boot.com.sbparser.mapper.ReviewMapper;
import spring.boot.com.sbparser.mapper.UserMapper;
import spring.boot.com.sbparser.model.Product;
import spring.boot.com.sbparser.model.Review;
import spring.boot.com.sbparser.model.Role;
import spring.boot.com.sbparser.model.User;

public class ReviewMapperTest {
    private static final String DEFAULT_PASSWORD = "1111";
    private static final String DEFAULT_ROLENAME = "USER";
    private static final String PRODUCT_ID = "B001GVISJM";
    private static UserMapper userMapper = new UserMapper();
    private static ProductMapper productMapper = new ProductMapper();
    private static ReviewMapper reviewMapper = new ReviewMapper(productMapper, userMapper);
    private static ReviewDto properReviewDto = new ReviewDto();
    private static ReviewDto emptyFieldsReviewDto = new ReviewDto();

    static {
        properReviewDto.setReviewId(18);
        properReviewDto.setProductId(PRODUCT_ID);
        properReviewDto.setUserId("AFKW14U97Z6QO");
        properReviewDto.setProfileName("Becca");
        properReviewDto.setHelpfulnessNumerator(0);
        properReviewDto.setHelpfulnessDenominator(0);
        properReviewDto.setScore(5);
        properReviewDto.setTime(LocalDateTime
                .ofInstant(Instant.ofEpochSecond(1345075200), ZoneId.systemDefault()));
        properReviewDto.setSummary("Love it!");
        properReviewDto.setText("I am very satisfied with my Twizzler purchase.  I shared "
                + "these with others and we have all enjoyed them.  I will definitely be "
                + "ordering more.");

        emptyFieldsReviewDto.setReviewId(18);
        emptyFieldsReviewDto.setProductId(PRODUCT_ID);
        emptyFieldsReviewDto.setScore(5);
        emptyFieldsReviewDto.setTime(LocalDateTime
                .ofInstant(Instant.ofEpochSecond(1345075200), ZoneId.systemDefault()));
        emptyFieldsReviewDto.setSummary("Love it!");
        emptyFieldsReviewDto.setText("I am very satisfied with my Twizzler purchase.  I shared "
                + "these with others and we have all enjoyed them.  I will definitely be "
                + "ordering more.");
    }

    @Test
    public void convertReviewDtoToReviewOk() {
        Review expected = new Review();
        expected.setExternalReviewId(18);
        Product newProduct = new Product(PRODUCT_ID);
        expected.setProduct(newProduct);
        User newUser = new User(DEFAULT_PASSWORD, Set.of(Role.of(DEFAULT_ROLENAME)));
        newUser.setExternalUserId("AFKW14U97Z6QO");
        newUser.setProfileName("Becca");
        expected.setUser(newUser);
        expected.setHelpfulnessNumerator(0);
        expected.setHelpfulnessDenominator(0);
        expected.setScore(5);
        expected.setTime(LocalDateTime
                .ofInstant(Instant.ofEpochSecond(1345075200), ZoneId.systemDefault()));
        expected.setSummary("Love it!");
        expected.setText("I am very satisfied with my Twizzler purchase.  I shared "
                + "these with others and we have all enjoyed them.  I will definitely be "
                + "ordering more.");
        Review actual = reviewMapper.convertDtoToReview(properReviewDto);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertReviewDtoWithMissingData() {
        Review expected = new Review();
        expected.setExternalReviewId(18);
        Product newProduct = new Product(PRODUCT_ID);
        expected.setProduct(newProduct);
        User newUser = new User(DEFAULT_PASSWORD, Set.of(Role.of(DEFAULT_ROLENAME)));
        expected.setUser(newUser);
        expected.setScore(5);
        expected.setTime(LocalDateTime
                .ofInstant(Instant.ofEpochSecond(1345075200), ZoneId.systemDefault()));
        expected.setSummary("Love it!");
        expected.setText("I am very satisfied with my Twizzler purchase.  I shared "
                + "these with others and we have all enjoyed them.  I will definitely be "
                + "ordering more.");
        Review actual = reviewMapper.convertDtoToReview(emptyFieldsReviewDto);
        Assert.assertEquals(expected, actual);
    }
}
