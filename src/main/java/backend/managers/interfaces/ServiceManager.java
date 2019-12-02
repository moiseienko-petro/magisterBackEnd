package backend.managers.interfaces;

import backend.models.Service;
import backend.viewModel.ServiceViewModel;

import java.util.List;

public interface ServiceManager {

    List<Service> getNotProductServices();

    List<Service> getConnectedServicesByUser(Long id);

    List<ServiceViewModel> getNotProductServicesByUser(Long id);
}
