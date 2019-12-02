package backend.repositories;

import backend.models.Product;
import backend.models.ProductLibrary;
import backend.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductLibraryRepository extends JpaRepository<ProductLibrary, Long>{


    List<ProductLibrary> getProductByProductCategoryId(Long id);

}
