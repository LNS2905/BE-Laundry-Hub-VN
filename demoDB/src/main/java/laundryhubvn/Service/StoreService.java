package laundryhubvn.Service;

import laundryhubvn.Entity.Store;
import laundryhubvn.Repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {
private final StoreRepository storeRepository;

    public List<Store> GetAllStore(){
        return  storeRepository.findAll();
    }

    public Optional<Store> GetStoreById(int store_id){
        return storeRepository.findById(store_id);
    }

    public void addStore(Store store){
        storeRepository.save(store);
    }

    public void deleteStore(int store_id){
        storeRepository.deleteById(store_id);
    }

    public void updateStore(int store_id, Store newStore) {
        Store store = storeRepository.findById(store_id).orElseThrow(() -> new IllegalStateException("This store with this id is not exist"));
        store.setStore_name(newStore.getStore_name());
        store.setAddress(newStore.getAddress());
        store.setPhone_number(newStore.getPhone_number());
        storeRepository.save(store);
    }
}
