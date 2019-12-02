package backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Loyalty {

    @Id
    @GeneratedValue
    private Long id;
    private Integer bonusPrice;
    private String name;
    private String description;

    public Loyalty(Integer bonusPrice, String name, String description) {
        this.bonusPrice = bonusPrice;
        this.name = name;
        this.description = description;
    }

    public Loyalty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBonusPrice() {
        return bonusPrice;
    }

    public void setBonusPrice(Integer bonusPrice) {
        this.bonusPrice = bonusPrice;
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
