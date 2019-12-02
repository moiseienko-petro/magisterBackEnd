package backend.controllers.user;

import backend.managers.interfaces.ProductManager;
import backend.managers.interfaces.ServiceManager;
import backend.managers.interfaces.UserManager;
import backend.models.Bonus;
import backend.models.Product;
import backend.models.Service;
import backend.models.User;
import backend.viewModel.BalanceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private ProductManager productManager;

    @Autowired
    private ServiceManager serviceManager;


    @GetMapping("/phone/{phone}")
    public User getUserByPhone(@PathVariable String phone) {
        return userManager.getByPhone(phone);
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByUser(@PathVariable Long id) {
        return productManager.getProductsByUser(id);
    }

    @GetMapping("/{id}/services")
    public List<Service> getServicesByUser(@PathVariable Long id) {
        return serviceManager.getConnectedServicesByUser(id);
    }

    @PostMapping("{userId}/product/{productId}")
    public ResponseEntity activateProduct(@PathVariable Long userId, @PathVariable Long productId) {
        try {
            userManager.activateProduct(userId, productId);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{userId}/product/{productId}")
    public ResponseEntity deactivateProduct(@PathVariable Long userId, @PathVariable Long productId) {
        try {
            userManager.deactivateProduct(userId, productId);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("{userId}/service/{serviceId}")
    public ResponseEntity activateService(@PathVariable Long userId, @PathVariable Long serviceId) {
        try {
            userManager.activateService(userId, serviceId);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("{userId}/product/{productId}/service/{serviceId}")
    public ResponseEntity activateServiceUnderProduct(@PathVariable Long userId,
                                                      @PathVariable Long productId, @PathVariable Long serviceId) {
        try {
            userManager.activateServiceUnderProduct(userId, productId, serviceId);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("{userId}/service/{serviceId}")
    public ResponseEntity deactivateService(@PathVariable Long userId, @PathVariable Long serviceId) {
        try {
            userManager.deactivateService(userId, serviceId);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("{userId}/loyalty/{loyaltyId}")
    public ResponseEntity activateBonus(@PathVariable Long userId, @PathVariable Long loyaltyId) {
        try {
            userManager.activateBonus(userId, loyaltyId);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/bonuses")
    public List<Bonus> getBonusHistory(@PathVariable Long userId) {
        return userManager.getBonusHistory(userId);
    }

    @GetMapping("/{userId}/accountState")
    public BalanceState getBalance(@PathVariable Long userId) {
        return userManager.getBalance(userId);
    }
}
