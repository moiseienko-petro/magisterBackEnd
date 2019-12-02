package backend.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @ManyToMany()
    private List<Product> products;
    @ManyToMany()
    private List<Service> services;
    private Integer bonusesValue;
    private Integer balanceValue;
    @ManyToMany
    private List<Bonus> bonusHistory;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, List<Product> products, Integer bonusesValue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.products = products;
        this.bonusesValue = bonusesValue;
    }

    public List<Bonus> getBonusHistory() {
        return bonusHistory;
    }

    public void setBonusHistory(List<Bonus> bonusHistory) {
        this.bonusHistory = bonusHistory;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Integer getBalanceValue() {
        return balanceValue;
    }

    public void setBalanceValue(Integer balanceValue) {
        this.balanceValue = balanceValue;
    }

    public Integer getBonusesValue() {
        return bonusesValue;
    }

    public void setBonusesValue(Integer bonusesValue) {
        this.bonusesValue = bonusesValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
