package backend.managers.impl;

import backend.managers.interfaces.ProductManager;
import backend.models.Product;
import backend.models.ProductLibrary;
import backend.models.User;
import backend.repositories.ProductLibraryRepository;
import backend.repositories.ProductRepository;
import backend.repositories.UserRepository;
import backend.viewModel.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManagerImpl implements ProductManager {


    @Autowired
    private ProductLibraryRepository productLibraryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProductLibrary> getProducts() {
        return productLibraryRepository.findAll();
    }

    @Override
    public ProductLibrary getProductById(Long id) {
        return productLibraryRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductLibrary> getProductsByCategoryId(Long id) {
        return productLibraryRepository.getProductByProductCategoryId(id);
    }

    @Override
    public List<Product> getProductsByUser(Long id) {
        return userRepository.getProductsByUserId(id);
    }

    @Override
    public List<ProductViewModel> getProductsByUser(Long categoryId, Long userId) {
        List<ProductLibrary> productLibraries = productLibraryRepository.getProductByProductCategoryId(categoryId);
        User user = userRepository.getOne(userId);
        List<Product> userProducts = user.getProducts();
        List<ProductViewModel> productViewModels = convert(productLibraries);
        for (Product userProduct : userProducts) {
            for (ProductViewModel productViewModel : productViewModels) {
                if (productViewModel.getId().equals(userProduct.getProductTemplate().getId())) {
                    productViewModel.setIsActive(true);
                }
            }
        }
        return productViewModels;
    }

    private ProductViewModel convert(ProductLibrary productLibrary) {
        ProductViewModel productViewModel = new ProductViewModel();
        productViewModel.setId(productLibrary.getId());
        productViewModel.setName(productLibrary.getName());
        productViewModel.setDescription(productLibrary.getDescription());
        productViewModel.setPrice(productLibrary.getPrice().toString());
        productViewModel.setIsActive(false);
        productViewModel.setCategory(productLibrary.getProductCategory().getName());
        productViewModel.setDuration(productLibrary.getDuration().getDuration());
        return productViewModel;
    }

    private List<ProductViewModel> convert(List<ProductLibrary> productLibraries) {
        List<ProductViewModel> productViewModels = new ArrayList<>();
        productLibraries.forEach(productLibrary -> productViewModels.add(convert(productLibrary)));
        return productViewModels;
    }
}
