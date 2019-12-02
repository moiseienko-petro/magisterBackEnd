package backend.controllers.service;

import backend.managers.interfaces.ServiceManager;
import backend.models.Service;
import backend.viewModel.ServiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceManager serviceManager;

    @GetMapping()
    public List<Service> getNotProductServices() {
        return serviceManager.getNotProductServices();
    }

    @GetMapping("/{userId}")
    public List<ServiceViewModel> getServicesByUser(@PathVariable Long userId){
        return serviceManager.getNotProductServicesByUser(userId);
    }
}
