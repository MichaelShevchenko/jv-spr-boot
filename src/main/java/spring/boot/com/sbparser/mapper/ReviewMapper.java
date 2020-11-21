package spring.boot.com.sbparser.mapper;

import org.springframework.stereotype.Component;
import spring.boot.com.sbparser.dto.ReviewDto;
import spring.boot.com.sbparser.model.Review;

@Component
public class ReviewMapper {
    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    public ReviewMapper(ProductMapper productMapper, UserMapper userMapper) {
        this.productMapper = productMapper;
        this.userMapper = userMapper;
    }

    public Review convertDtoToReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setExternalReviewId(reviewDto.getReviewId());
        review.setHelpfulnessNumerator(reviewDto.getHelpfulnessNumerator());
        review.setHelpfulnessDenominator(reviewDto.getHelpfulnessDenominator());
        review.setScore(reviewDto.getScore());
        review.setTime(reviewDto.getTime());
        review.setSummary(reviewDto.getSummary());
        review.setText(reviewDto.getText());
        review.setProduct(productMapper.convertDtoToProduct(reviewDto));
        review.setUser(userMapper.convertDtoToUser(reviewDto));
        return review;
    }
}
