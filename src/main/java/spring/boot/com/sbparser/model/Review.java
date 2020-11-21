package spring.boot.com.sbparser.model;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int externalReviewId;
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private int score;
    private LocalDateTime time;
    private String summary;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExternalReviewId() {
        return externalReviewId;
    }

    public void setExternalReviewId(int externalReviewId) {
        this.externalReviewId = externalReviewId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Review{" + "id=" + id + "reviewId=" + externalReviewId + ", product='" + product
                + '\'' + ", user='" + user + '\'' + ", helpfulnessNumerator=" + helpfulnessNumerator
                + ", helpfulnessDenominator=" + helpfulnessDenominator + ", score=" + score
                + ", time=" + time + ", summary='" + summary + '\'' + ", text='" + text + "'}";
    }

    @Override
    public boolean equals(Object o) {
        Review review = (Review) o;
        return Objects.equals(this.id, review.id)
                && Objects.equals(this.externalReviewId, review.externalReviewId)
                && Objects.equals(this.product, review.product)
                && Objects.equals(this.user, review.user)
                && Objects.equals(this.helpfulnessNumerator, review.helpfulnessNumerator)
                && Objects.equals(this.helpfulnessDenominator, review.helpfulnessDenominator)
                && Objects.equals(this.score, review.score)
                && Objects.equals(this.time, review.time)
                && Objects.equals(this.summary, review.summary)
                && Objects.equals(this.text, review.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalReviewId, product, user, helpfulnessNumerator,
                helpfulnessDenominator, score, time, summary, text);
    }
}
