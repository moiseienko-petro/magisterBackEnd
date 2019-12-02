package backend.viewModel;

public class LoyaltyViewModel {

    private Long id;
    private String name;
    private String description;
    private String bonusPrice;

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

    public String getBonusPrice() {
        return bonusPrice;
    }

    public void setBonusPrice(String bonusPrice) {
        this.bonusPrice = bonusPrice;
    }
}
