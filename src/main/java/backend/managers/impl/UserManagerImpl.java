package backend.managers.impl;

import backend.managers.interfaces.UserManager;
import backend.models.*;
import backend.repositories.*;
import backend.viewModel.BalanceState;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ProductLibraryRepository productLibraryRepository;

    @Autowired
    private LoyaltyRepository loyaltyRepository;

    @Autowired
    private BonusRepository bonusRepository;


    @Override
    public User getByPhone(String phone) {
        return userRepository.getByPhoneNumber(phone);
    }

    @Override
    @Transactional()
    public void activateProduct(Long userId, Long productId) throws Exception {
        ProductLibrary productLibrary = productLibraryRepository.getOne(productId);
        User user = userRepository.getOne(userId);

        validateUserBalance(user.getBalanceValue(), productLibrary.getPrice());

        Product product = new Product();
        product.setProductTemplate(productLibrary);
        List<Product> userProducts = user.getProducts();
        if (userProducts == null) {
            userProducts = new ArrayList<>();
        }
        Product forDeactivate = null;
        for (Product product1 : userProducts) {
            if (product1.getProductTemplate().getId().equals(productLibrary.getId())) {
                throw new Exception("Product exists already");
            } else {
                if (product1.getProductTemplate().getProductCategory().getId().equals(productLibrary.getProductCategory().getId())) {
                    forDeactivate = product1;
                    break;
                }
            }
        }
        if (forDeactivate != null) {
            userProducts.remove(forDeactivate);
        }
        user.setBalanceValue(user.getBalanceValue() - productLibrary.getPrice());
        userProducts.add(product);
        productRepository.save(product);
        userRepository.save(user);
    }

    @Override
    @Transactional()
    public void activateService(Long userId, Long serviceId) throws Exception {
        Service service = serviceRepository.getOne(serviceId);
        User user = userRepository.getOne(userId);

        validateUserBalance(user.getBalanceValue(), service.getPrice());

        List<Service> userServices = user.getServices();
        if (userServices == null) {
            userServices = new ArrayList<>();
        }
        for (Service service1 : userServices) {
            if (service1.getId().equals(serviceId)) {
                throw new Exception("smth went wrong");
            }
        }
        userServices.add(service);
        user.setBalanceValue(user.getBalanceValue() - service.getPrice());
        userRepository.save(user);
    }

    @Override
    @Transactional()
    public void activateServiceUnderProduct(Long userId, Long productId, Long serviceId) throws Exception {
        User user = userRepository.getOne(userId);
        Service service = serviceRepository.getOne(serviceId);

        validateUserBalance(user.getBalanceValue(), service.getPrice());


        Product product = null;
        List<Product> userProducts = user.getProducts();
        for (Product product1 : userProducts) {
            if (product1.getProductTemplate().getId().equals(productId)) {
                product = product1;
            }
        }
        if (product == null) {
            throw new Exception("smth went wrong");
        }
        List<Service> productService = product.getServices();
        if (productService == null) {
            productService = new ArrayList<>();
        }
        for (Service service1 : productService) {
            if (service1.getId().equals(serviceId)) {
                throw new Exception("smth went wrong");
            }
        }
        productService.add(service);
        user.setBalanceValue(user.getBalanceValue() - service.getPrice());
        productRepository.save(product);
        userRepository.save(user);
    }

    @Override
    public void deactivateService(Long userId, Long serviceId) throws Exception {
        Service service = null;
        User user = userRepository.getOne(userId);
        List<Service> services = user.getServices();
        for (Service service1 : services) {
            if (service1.getId().equals(serviceId)) {
                service = service1;
                break;
            }
        }
        if (service == null) {
            deactivateServiceUnderProduct(userId, serviceId);
        }
        services.remove(service);
        userRepository.save(user);
    }

    private void deactivateServiceUnderProduct(Long userId, Long serviceId) throws Exception {
        User user = userRepository.getOne(userId);
        Service service = null;
        for (Product product : user.getProducts()) {
            List<Service> services = product.getServices();
            for (Service service1 : services) {
                if (service1.getId().equals(serviceId)) {
                    service = service1;
                }
            }
            if (service != null) {
                services.remove(service);
                break;
            }
        }

        if (service == null) {
            throw new Exception("You don't have this service");
        }

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void activateBonus(Long userId, Long loyaltyId) throws Exception {
        Loyalty loyalty = loyaltyRepository.getOne(loyaltyId);
        User user = userRepository.getOne(userId);
        if (user.getBonusesValue() < loyalty.getBonusPrice()) {
            throw new Exception("Your bonus balance is " + user.getBonusesValue());
        }

        Bonus bonus = new Bonus();
        bonus.setName(loyalty.getName());
        bonus.setDescription(loyalty.getDescription());
        bonus.setNumber(RandomStringUtils.random(15, true, true));
        bonus.setOrderDate(new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());

        if (user.getBonusHistory() == null) {
            user.setBonusHistory(new ArrayList<>());
        }

        user.getBonusHistory().add(bonus);
        user.setBonusesValue(user.getBonusesValue() - loyalty.getBonusPrice());

        bonusRepository.save(bonus);
        userRepository.save(user);
    }

    @Override
    public List<Bonus> getBonusHistory(Long userId) {
        return userRepository.getBonusesByUserId(userId);
    }

    @Override
    public BalanceState getBalance(Long userId) {
        User user = userRepository.getOne(userId);
        BalanceState balanceState = new BalanceState();
        balanceState.setBalanceValue(user.getBalanceValue());
        balanceState.setBonusValue(user.getBonusesValue());
        return balanceState;
    }

    @Override
    public void deactivateProduct(Long userId, Long productId) throws Exception {
        User user = userRepository.getOne(userId);
        List<Product> userProducts = user.getProducts();
        Product product = null;
        for (Product product1 : userProducts) {
            if (product1.getProductTemplate().getId().equals(productId)) {
                product = product1;
                break;
            }
        }
        if (product != null) {
            userProducts.remove(product);
            userRepository.save(user);
        } else {
            throw new Exception();
        }

    }

    private void validateUserBalance(Integer balance, Integer price) throws Exception {
        if (balance < price) {
            throw new Exception("This item's price bigger then your balance.");
        }
    }
}
