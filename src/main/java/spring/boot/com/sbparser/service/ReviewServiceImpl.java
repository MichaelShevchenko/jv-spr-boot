package spring.boot.com.sbparser.service;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.boot.com.sbparser.model.Review;
import spring.boot.com.sbparser.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void addAll(List<Review> reviews) {
        reviewRepository.saveAll(reviews);
    }
}
