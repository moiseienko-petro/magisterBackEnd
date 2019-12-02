package backend.managers.impl;

import backend.managers.interfaces.ServiceManager;
import backend.models.Product;
import backend.models.Service;
import backend.models.User;
import backend.repositories.ProductLibraryRepository;
import backend.repositories.ServiceRepository;
import backend.repositories.UserRepository;
import backend.viewModel.ServiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceManagerImpl implements ServiceManager {

    @Autowired
    private ProductLibraryRepository productLibraryRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Service> getNotProductServices() {
        List<Service> allServices = serviceRepository.findAll();
        return allServices;
    }

    @Override
    public List<Service> getConnectedServicesByUser(Long id) {

        User user = userRepository.getOne(id);
        List<Service> notProductServices = user.getServices();

        for (Product product : user.getProducts()) {
            if (product.getServices() != null) {
                notProductServices.addAll(product.getServices());
            }
        }

        return notProductServices;
    }

    @Override
    public List<ServiceViewModel> getNotProductServicesByUser(Long id) {
        List<Service> allServices = serviceRepository.findAll();
        User user = userRepository.getOne(id);
        List<Service> notProductServices = user.getServices();
        List<ServiceViewModel> serviceViewModels = convert(allServices);
        for (Service userService: notProductServices) {
            for (ServiceViewModel serviceViewModel: serviceViewModels){
                if(serviceViewModel.getId().equals(userService.getId())) {
                    serviceViewModel.setIsActive(true);
                }
            }
        }
        return serviceViewModels;
    }

    private ServiceViewModel convert(Service service) {
        ServiceViewModel serviceViewModel = new ServiceViewModel();
        serviceViewModel.setId(service.getId());
        serviceViewModel.setName(service.getName());
        serviceViewModel.setDescription(service.getDescription());
        serviceViewModel.setPrice(service.getPrice().toString());
        serviceViewModel.setIsActive(false);
        serviceViewModel.setCategory(service.getProductCategory().getName());
        serviceViewModel.setDuration(service.getDuration().getDuration());
        return serviceViewModel;
    }

    private List<ServiceViewModel> convert(List<Service> services) {
        List<ServiceViewModel> serviceViewModels = new ArrayList<>();
        services.forEach(service -> serviceViewModels.add(convert(service)));
        return serviceViewModels;
    }
}
