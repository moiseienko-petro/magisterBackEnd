package backend.managers.interfaces;

import backend.models.Loyalty;
import backend.viewModel.LoyaltyViewModel;

import java.util.List;

public interface LoyaltyManager {

    List<LoyaltyViewModel> getLoyalties();
}
