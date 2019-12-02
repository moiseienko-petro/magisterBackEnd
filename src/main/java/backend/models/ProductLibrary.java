package backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
    private Integer price;
    private String duration;

    public ProductLibrary(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProductLibrary() {
    }

    public Duration getDuration() {
        return Duration.valueOf(duration.toUpperCase());
    }

    public void setDuration(Duration duration) {
        this.duration = duration.getDuration();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
