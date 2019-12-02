package backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    private List<Service> services;
    @ManyToOne
    private ProductLibrary productTemplate;

    public Product() {
    }


    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public ProductLibrary getProductTemplate() {
        return productTemplate;
    }

    public void setProductTemplate(ProductLibrary productTemplate) {
        this.productTemplate = productTemplate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
