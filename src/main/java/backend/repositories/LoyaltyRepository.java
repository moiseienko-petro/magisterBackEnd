package backend.repositories;

import backend.models.Loyalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyRepository extends JpaRepository<Loyalty, Long>{
}
