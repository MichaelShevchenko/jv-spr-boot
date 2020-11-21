package spring.boot.com.sbparser.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String externalProductId;

    public Product() {
    }

    public Product(String externalProductId) {
        this.externalProductId = externalProductId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalProductId() {
        return externalProductId;
    }

    public void setExternalProductId(String externalProductId) {
        this.externalProductId = externalProductId;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", externalProductId='" + externalProductId + "'}";
    }

    @Override
    public boolean equals(Object o) {
        Product product = (Product) o;
        return Objects.equals(this.id, product.id)
                && Objects.equals(this.externalProductId, product.externalProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalProductId);
    }
}
