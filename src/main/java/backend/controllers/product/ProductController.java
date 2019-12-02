package backend.controllers.product;

import backend.managers.interfaces.ProductManager;
import backend.models.ProductLibrary;
import backend.viewModel.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @GetMapping
    public List<ProductLibrary> getProducts() {
        return productManager.getProducts();
    }

    @GetMapping("/{id}")
    public ProductLibrary getProduct(@PathVariable Long id) {
        return productManager.getProductById(id);
    }

    @GetMapping("/category/{id}")
    public List<ProductLibrary> getProductByCategory(@PathVariable Long id) {
        return productManager.getProductsByCategoryId(id);
    }

    @GetMapping("/category/{id}/user/{userId}")
    public List<ProductViewModel> getProductsByUser(@PathVariable Long id,
                                                    @PathVariable Long userId) {
        return productManager.getProductsByUser(id, userId);
    }
}
