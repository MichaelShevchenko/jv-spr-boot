package spring.boot.com.sbparser;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVRecord;

public class DataParser {
    private static final int REVIEW_ID_INDEX = 0;
    private static final int REVIEW_PRODUCT_ID_INDEX = 1;
    private static final int REVIEW_USER_ID_INDEX = 2;
    private static final int REVIEW_PROFILE_NAME_INDEX = 3;
    private static final int REVIEW_HELPFULNESS_NUMERATOR_INDEX = 4;
    private static final int REVIEW_HELPFULNESS_DENOMINATOR_INDEX = 5;
    private static final int REVIEW_SCORE_INDEX = 6;
    private static final int REVIEW_TIME_INDEX = 7;
    private static final int REVIEW_SUMMARY_INDEX = 8;
    private static final int REVIEW_TEXT_INDEX = 9;

    public List<Review> parseDataToReviews(List<CSVRecord> dataFromFile) {
        List<Review> result = new ArrayList<>();
        for (CSVRecord lineFromFile : dataFromFile) {
            Review newReview = new Review();
            newReview.setReviewId(Integer.parseInt(lineFromFile.get(REVIEW_ID_INDEX)));
            newReview.setProductId(String.valueOf(lineFromFile.get(REVIEW_PRODUCT_ID_INDEX)));
            newReview.setUserId(String.valueOf(lineFromFile.get(REVIEW_USER_ID_INDEX)));
            newReview.setProfileName(String.valueOf(lineFromFile.get(REVIEW_PROFILE_NAME_INDEX)));
            newReview.setHelpfulnessNumerator(Integer
                    .parseInt(lineFromFile.get(REVIEW_HELPFULNESS_NUMERATOR_INDEX)));
            newReview.setHelpfulnessDenominator(Integer
                    .parseInt(lineFromFile.get(REVIEW_HELPFULNESS_DENOMINATOR_INDEX)));
            newReview.setScore(Integer.parseInt(lineFromFile.get(REVIEW_SCORE_INDEX)));
            newReview.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(Integer
                    .parseInt(lineFromFile.get(REVIEW_TIME_INDEX))), ZoneId.systemDefault()));
            newReview.setSummary(String.valueOf(lineFromFile.get(REVIEW_SUMMARY_INDEX)));
            newReview.setText(String.valueOf(lineFromFile.get(REVIEW_TEXT_INDEX)));
            result.add(newReview);
        }
        return result;
    }
}
