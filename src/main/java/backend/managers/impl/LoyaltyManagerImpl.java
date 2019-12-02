package backend.managers.impl;

import backend.managers.interfaces.LoyaltyManager;
import backend.models.Loyalty;
import backend.repositories.LoyaltyRepository;
import backend.viewModel.LoyaltyViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoyaltyManagerImpl implements LoyaltyManager {

    @Autowired
    private LoyaltyRepository loyaltyRepository;

    @Override
    public List<LoyaltyViewModel> getLoyalties() {
        List<Loyalty> loyalties =  loyaltyRepository.findAll();
        return convert(loyalties);
    }

    private List<LoyaltyViewModel> convert(List<Loyalty> loyalties) {
        List<LoyaltyViewModel> loyaltyViewModels = new ArrayList<>();
        loyalties.forEach(loyalty -> loyaltyViewModels.add(convert(loyalty)));
        return loyaltyViewModels;
    }

    private LoyaltyViewModel convert(Loyalty loyalty){
        LoyaltyViewModel loyaltyViewModel = new LoyaltyViewModel();
        loyaltyViewModel.setId(loyalty.getId());
        loyaltyViewModel.setName(loyalty.getName());
        loyaltyViewModel.setDescription(loyalty.getDescription());
        loyaltyViewModel.setBonusPrice(loyalty.getBonusPrice().toString());
        return loyaltyViewModel;
    }
}
