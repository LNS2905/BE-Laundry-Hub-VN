package laundryhubvn.Service;
import laundryhubvn.Entity.Service;
import laundryhubvn.Repository.ServiceRepository;
import lombok.AllArgsConstructor;

import java.util.List;
@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public List<Service> GetAllService(){
        return serviceRepository.findAll();
    }

    public void addService(Service service){
        serviceRepository.save(service);
    }

    public void deleteService(int service_id){
        serviceRepository.deleteById(service_id);
    }

    public void updateService(int service_id, Service newService) {
        Service service = serviceRepository.findById(service_id).orElseThrow(() -> new IllegalStateException("This service with this id is not exist"));
        service.setPrice(service.getPrice());
        service.setDescription(service.getDescription());

        serviceRepository.save(service);
    }
}
