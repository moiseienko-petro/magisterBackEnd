package backend.managers.interfaces;

import backend.models.Bonus;
import backend.models.Product;
import backend.models.User;
import backend.viewModel.BalanceState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserManager {

    User getByPhone(String phone);

    void activateProduct(Long userId, Long productId) throws Exception;

    void activateService(Long userId, Long serviceId) throws Exception;

    void activateServiceUnderProduct(Long userId, Long productId, Long serviceId)  throws Exception;

    void deactivateService(Long userId, Long serviceId) throws Exception;

    void deactivateProduct(Long userId, Long productId) throws Exception;

    void activateBonus(Long userId, Long loyaltyId) throws Exception;

    List<Bonus> getBonusHistory(Long userId);

    BalanceState getBalance(Long userId);

}
