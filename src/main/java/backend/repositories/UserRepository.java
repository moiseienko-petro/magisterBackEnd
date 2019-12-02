package backend.repositories;

import backend.models.Bonus;
import backend.models.Product;
import backend.models.Service;
import backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    String FIND_PRODUCTS = "SELECT u.products FROM User u  where u.id=:uid";

    String FIND_SERVICES = "SELECT u.services FROM User u  where u.id=:uid";

    String FIND_BONUSES = "SELECT u.bonusHistory FROM User u  where u.id=:uid";



    User getByPhoneNumber(String phoneNumber);

    @Query(value = FIND_PRODUCTS)
    List<Product> getProductsByUserId(@Param("uid") Long id);

    @Query(value = FIND_SERVICES)
    List<Service> getServicesByUserId(@Param("uid") Long id);

    @Query(value = FIND_BONUSES)
    List<Bonus> getBonusesByUserId(@Param("uid") Long id);
}
