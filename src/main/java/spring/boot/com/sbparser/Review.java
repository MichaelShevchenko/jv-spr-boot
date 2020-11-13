package spring.boot.com.sbparser;

import java.time.LocalDateTime;
import java.util.Objects;

public class Review {
    private int reviewId;
    private String productId;
    private String userId;
    private String profileName;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private int score;
    private LocalDateTime time;
    private String summary;
    private String text;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getHelpfulnessNumerator() {
        return helpfulnessNumerator;
    }

    public void setHelpfulnessNumerator(int helpfulnessNumerator) {
        this.helpfulnessNumerator = helpfulnessNumerator;
    }

    public int getHelpfulnessDenominator() {
        return helpfulnessDenominator;
    }

    public void setHelpfulnessDenominator(int helpfulnessDenominator) {
        this.helpfulnessDenominator = helpfulnessDenominator;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Review{" + "reviewId=" + reviewId + ", productId='" + productId + '\''
                + ", userId='" + userId + '\'' + ", profileName='" + profileName + '\''
                + ", helpfulnessNumerator=" + helpfulnessNumerator
                + ", helpfulnessDenominator=" + helpfulnessDenominator
                + ", score=" + score + ", time=" + time + ", summary='" + summary + '\''
                + ", text='" + text + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        Review review = (Review) o;
        return Objects.equals(this.reviewId, review.reviewId)
                && Objects.equals(this.productId, review.productId)
                && Objects.equals(this.userId, review.userId)
                && Objects.equals(this.profileName, review.profileName)
                && Objects.equals(this.helpfulnessNumerator, review.helpfulnessNumerator)
                && Objects.equals(this.helpfulnessDenominator, review.helpfulnessDenominator)
                && Objects.equals(this.score, review.score)
                && Objects.equals(this.time, review.time)
                && Objects.equals(this.summary, review.summary)
                && Objects.equals(this.text, review.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, productId, userId, profileName,
                helpfulnessNumerator, helpfulnessDenominator, score, time, summary, text);
    }
}
