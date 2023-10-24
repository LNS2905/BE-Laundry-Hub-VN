package laundryhubvn.Controller;

import laundryhubvn.Entity.Services;
import laundryhubvn.Service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/service")
public class ServiceController {

    private ServicesService serviceService;
    @GetMapping
    public List<Services>GetAllService() {
        return serviceService.GetAllService();
    }
    @DeleteMapping("/delete/{service_id}")
    public void deleteService(@PathVariable int service_id){
    serviceService.deleteService(service_id);
    }

    @PutMapping("/update/{service_id}")
    public void updateService(@PathVariable int service_id, @RequestBody Services newService){
    serviceService.updateService(service_id,newService);
    }

    @PostMapping("/insert")
    public void addService(@RequestBody Services service){
    serviceService.addService(service);
    }
}
