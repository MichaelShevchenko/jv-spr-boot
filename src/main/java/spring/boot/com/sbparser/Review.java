package spring.boot.com.sbparser;

import java.time.LocalDateTime;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (reviewId != review.reviewId) return false;
        if (helpfulnessNumerator != review.helpfulnessNumerator) return false;
        if (helpfulnessDenominator != review.helpfulnessDenominator) return false;
        if (score != review.score) return false;
        if (productId != null ? !productId.equals(review.productId) : review.productId != null) return false;
        if (userId != null ? !userId.equals(review.userId) : review.userId != null) return false;
        if (profileName != null ? !profileName.equals(review.profileName) : review.profileName != null) return false;
        if (time != null ? !time.equals(review.time) : review.time != null) return false;
        if (summary != null ? !summary.equals(review.summary) : review.summary != null) return false;
        return text != null ? text.equals(review.text) : review.text == null;
    }

    @Override
    public int hashCode() {
        int result = reviewId;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (profileName != null ? profileName.hashCode() : 0);
        result = 31 * result + helpfulnessNumerator;
        result = 31 * result + helpfulnessDenominator;
        result = 31 * result + score;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
