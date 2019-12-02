package backend.managers.interfaces;

import backend.models.Product;
import backend.models.ProductLibrary;
import backend.viewModel.ProductViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductManager {

    List<ProductLibrary> getProducts();

    ProductLibrary getProductById(Long id);

    List<ProductLibrary> getProductsByCategoryId(Long id);

    List<Product> getProductsByUser(Long id);

    List<ProductViewModel> getProductsByUser(Long categoryId, Long userId);

}
