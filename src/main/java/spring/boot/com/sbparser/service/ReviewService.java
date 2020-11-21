package spring.boot.com.sbparser.service;

import java.util.List;
import spring.boot.com.sbparser.model.Review;

public interface ReviewService {
    void addAll(List<Review> reviews);
}
