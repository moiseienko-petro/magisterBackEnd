package backend.models;

import javax.persistence.*;

@Entity
public class Service {

    @Id
    private Long id;
    private String name;
    private String description;
    private Integer price;
    @OneToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
    private String duration;

    public Service() {
    }

    public Service(Long id, String name, String description, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Duration getDuration() {
        return Duration.valueOf(duration.toUpperCase());
    }

    public void setDuration(Duration duration) {
        this.duration = duration.getDuration();
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
