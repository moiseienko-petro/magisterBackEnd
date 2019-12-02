import backend.models.*;
import backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication(scanBasePackages = {"backend.controllers", "backend.managers", "backend.repositories"})
@EnableJpaRepositories({"backend.repositories"})
@EntityScan({"backend.models"})
public class Application implements CommandLineRunner{

    @Autowired
    private ProductLibraryRepository productLibraryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LoyaltyRepository loyaltyRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        ProductCategory phone = new ProductCategory(1L, "Phone Plans");
//        ProductCategory tv = new ProductCategory(2L, "TV Plans");
//        ProductCategory intenet = new ProductCategory(3L, "Internet plans");
//        ProductCategory ott = new ProductCategory(4L, "OTT");
//
//        productCategoryRepository.save(phone);
//        productCategoryRepository.save(tv);
//        productCategoryRepository.save(intenet);
//        productCategoryRepository.save(ott);
//
//        Service service1=new Service(1L, "Additional 100Mb/day", "Get 100 mb of 3G/4G mobile internet" +
//                "with 1Mb/s speed. Additional Mbs have to be used on the day of connection.", 10);
//        service1.setProductCategory(phone);
//        service1.setDuration(Duration.DAY);
//        Service service2=new Service(2L, "Additional 300Mb/day", "Get 300 mb of 3G/4G mobile internet" +
//                "with 1Mb/s speed. Additional Mbs have to be used on the day of connection.", 20);
//        service2.setProductCategory(phone);
//        service2.setDuration(Duration.DAY);
//        Service service3=new Service(3L, "Additional 500Mb/day", "Get 500 mb of 3G/4G mobile internet" +
//                "with 2Mb/s speed. Additional Mbs have to be used on the 7 days after connection.", 40);
//        service3.setProductCategory(phone);
//        service3.setDuration(Duration.WEEK);
//        Service service4=new Service(4L, "Travel roaming", "Get 500 Mb in 55 countries for 1 week", 50);
//        service4.setProductCategory(phone);
//        service4.setDuration(Duration.WEEK);
//        Service service5=new Service(5L, "Free Travel roaming", "Get 500 Mb and 100 minutes in 55 countries for 1 week", 70);
//        service5.setProductCategory(phone);
//        service5.setDuration(Duration.WEEK);
//        Service service6=new Service(6L, "Sports Channel Pack", "Get more then 20 sports channels for month", 50);
//        service6.setProductCategory(tv);
//        service6.setDuration(Duration.MONTH);
//        Service service7=new Service(7L, "Movies Channel Pack", "Get more then 40 movies channels without advertising for month", 50);
//        service7.setProductCategory(tv);
//        service7.setDuration(Duration.MONTH);
//        Service service8=new Service(8L, "Postpaid internet", "Get one week of using internet and pay after it", 10);
//        service8.setProductCategory(intenet);
//        service8.setDuration(Duration.WEEK);
//
//
//        serviceRepository.save(service1);
//        serviceRepository.save(service2);
//        serviceRepository.save(service3);
//        serviceRepository.save(service4);
//        serviceRepository.save(service5);
//        serviceRepository.save(service6);
//        serviceRepository.save(service7);
//        serviceRepository.save(service8);
//
//
//        ProductLibrary productLibrary1= new ProductLibrary("Basic Pack", "Get more then 50 movies, music and documentary channels");
//        productLibrary1.setProductCategory(tv);
//        productLibrary1.setPrice(90);
//        productLibrary1.setDuration(Duration.MONTH);
//        ProductLibrary productLibrary2 = new ProductLibrary("Premium Pack", "Get more then 150 movies, music and documentary channels");
//        productLibrary2.setProductCategory(tv);
//        productLibrary2.setPrice(120);
//        productLibrary2.setDuration(Duration.MONTH);
//        ProductLibrary productLibrary3 = new ProductLibrary("Unlim 50", "Get the internet with 50 Mb/s speed");
//        productLibrary3.setProductCategory(intenet);
//        productLibrary3.setPrice(80);
//        productLibrary3.setDuration(Duration.MONTH);
//        ProductLibrary productLibrary4 = new ProductLibrary("Unlim 100", "Get the internet with 100 Mb/s speed");
//        productLibrary4.setProductCategory(intenet);
//        productLibrary4.setPrice(100);
//        productLibrary4.setDuration(Duration.MONTH);
//        ProductLibrary productLibrary5= new ProductLibrary("Freedom 100", "Get 100 local minutes," +
//                " 50 international minutes, 100 SMS and 1GB of internet");
//        productLibrary5.setProductCategory(phone);
//        productLibrary5.setPrice(90);
//        productLibrary5.setDuration(Duration.MONTH);
//        ProductLibrary productLibrary6 = new ProductLibrary("Freedom Unlim", "Get unlimited local minutes, unlimited SMS, " +
//                "20 international minutes and unlimited internet");
//        productLibrary6.setProductCategory(phone);
//        productLibrary6.setPrice(100);
//        productLibrary6.setDuration(Duration.MONTH);
//        ProductLibrary productLibrary7 = new ProductLibrary("Freedom 100 Year", "Get unlimited local minutes, unlimited SMS, " +
//                "20 international minutes and unlimited internet per month");
//        productLibrary7.setProductCategory(phone);
//        productLibrary7.setPrice(1000);
//        productLibrary7.setDuration(Duration.YEAR);
//        ProductLibrary productLibrary8 = new ProductLibrary("Netflix", "Connect Netflix for month");
//        productLibrary8.setProductCategory(ott);
//        productLibrary8.setPrice(300);
//        productLibrary8.setDuration(Duration.MONTH);
//        ProductLibrary productLibrary9 = new ProductLibrary("Amazon Prime", "Connect Amazone Prime for month");
//        productLibrary9.setProductCategory(ott);
//        productLibrary9.setPrice(300);
//        productLibrary9.setDuration(Duration.YEAR);
//
//        productLibraryRepository.save(productLibrary1);
//        productLibraryRepository.save(productLibrary2);
//        productLibraryRepository.save(productLibrary3);
//        productLibraryRepository.save(productLibrary4);
//        productLibraryRepository.save(productLibrary5);
//        productLibraryRepository.save(productLibrary6);
//        productLibraryRepository.save(productLibrary7);
//        productLibraryRepository.save(productLibrary8);
//        productLibraryRepository.save(productLibrary9);
//
//
//        Loyalty loyalty1 = new Loyalty(50, "50 bonuses", "Get 10% discount in Online Store on clothes");
//        Loyalty loyalty2 = new Loyalty(75, "75 bonuses", "2 UAH discount per liter for fuel");
//        Loyalty loyalty3 = new Loyalty(80, "80 bonuses", "15% discount in Store on cl0thes");
//        Loyalty loyalty4 = new Loyalty(90, "90 bonuses", "1 mont of Premium Subscription for studying English");
//        Loyalty loyalty5 = new Loyalty(100, "100 bonuses", "100 UAH delivery certificate in Restaurant. " +
//                "The minimum order amount including payment with the promo code is 150UAH");
//        Loyalty loyalty6 = new Loyalty(200, "200 bonuses", "200 UAH delivery certificate in Restaurant. " +
//                "The minimum order amount including payment with the promo code is 450UAH");
//
//        loyaltyRepository.save(loyalty1);
//        loyaltyRepository.save(loyalty2);
//        loyaltyRepository.save(loyalty3);
//        loyaltyRepository.save(loyalty4);
//        loyaltyRepository.save(loyalty5);
//        loyaltyRepository.save(loyalty6);
//
//
//
//        User user = new User();
//        user.setFirstName("Petro");
//        user.setLastName("Moiseienko");
//        user.setPhoneNumber("380951166798");
//        user.setBonusesValue(10000);
//        user.setBalanceValue(10000);
//        userRepository.save(user);

    }
}
