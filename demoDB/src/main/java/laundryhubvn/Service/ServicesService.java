package laundryhubvn.Service;
import laundryhubvn.Entity.Services;
import laundryhubvn.Repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class ServicesService {
    private final ServiceRepository serviceRepository;

    public List<Services> GetAllService(){
        return serviceRepository.findAll();
    }

    public void addService(Services service){
        serviceRepository.save(service);
    }

    public void deleteService(int service_id){
        serviceRepository.deleteById(service_id);
    }

    public void updateService(int service_id, Services newService) {
        Services service = serviceRepository.findById(service_id).orElseThrow(() -> new IllegalStateException("This service with this id is not exist"));
        service.setPrice(service.getPrice());
        service.setDescription(service.getDescription());

        serviceRepository.save(service);
    }
}
