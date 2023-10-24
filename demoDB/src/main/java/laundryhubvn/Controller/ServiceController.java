package laundryhubvn.Controller;

import laundryhubvn.Entity.Service;
import laundryhubvn.Entity.Store;
import laundryhubvn.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
@GetMapping
    public List<Service>GetAllService() {
        return serviceService.GetAllService();
    }
    @DeleteMapping("/delete/{service_id")
    public void deleteService(@PathVariable int service_id){
    serviceService.deleteService(service_id);
    }

    @PutMapping("/update/{service_id}")
    public void updateService(@PathVariable int service_id, @RequestBody Service newService){
    serviceService.updateService(service_id,newService);
    }

    @PostMapping("/insert")
    public void addService(@RequestBody Service service){
    serviceService.addService(service);
    }
}
