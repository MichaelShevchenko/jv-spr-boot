package spring.boot.com.sbparser.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    private Long quantity;

    public Word() {
    }

    public Word(String word, Long quantity) {
        this.word = word;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Word{" + "id=" + id + ", word='" + word + '\'' + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        Word word = (Word) o;
        return Objects.equals(this.id, word.id)
                && Objects.equals(this.word, word.word)
                && Objects.equals(this.quantity, word.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, quantity);
    }
}
