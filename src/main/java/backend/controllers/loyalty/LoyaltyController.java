package backend.controllers.loyalty;


import backend.managers.interfaces.LoyaltyManager;
import backend.models.Loyalty;
import backend.viewModel.LoyaltyViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loyalties")
public class LoyaltyController {

    @Autowired
    private LoyaltyManager loyaltyManager;

    @GetMapping()
    public List<LoyaltyViewModel> getLoyalties() {
        return loyaltyManager.getLoyalties();
    }
}
