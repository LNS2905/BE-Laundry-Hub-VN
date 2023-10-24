package laundryhubvn.Controller;

import laundryhubvn.Entity.Store;
import laundryhubvn.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/store")
public class StoreController {
    @Autowired
    private  StoreService storeService;


    @GetMapping
    public List<Store> listAllStore(){
        return storeService.GetAllStore();
    }

    @GetMapping("/{store_id}")
    public Optional<Store> listStoreById(@PathVariable int store_id){
        return storeService.GetStoreById(store_id);
    }

    @DeleteMapping("/delete/{store_id}")
    public void deleteStore(@PathVariable int store_id){
        storeService.deleteStore(store_id);
    }

    @PutMapping("/update/{store_id}")
    public void updateStore(@PathVariable int store_id, @RequestBody Store newStore){
        storeService.updateStore(store_id,newStore);
    }
    @PostMapping("/insert")
    public void addStore (@RequestBody Store store){
        storeService.addStore(store);
    }

}
