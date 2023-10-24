package laundryhubvn.Service;

import laundryhubvn.Entity.Account;
import laundryhubvn.Entity.Customer;
import laundryhubvn.Entity.Store;
import laundryhubvn.Repository.AccountRepository;
import laundryhubvn.Repository.CustomerRepository;
import laundryhubvn.Repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final StoreRepository storeRepository;
    public List<Account> GetAllAccount(){
        return accountRepository.findAll();
    }
    public void addAccount(Account account){
        accountRepository.save(account);
//        if(account.getRole_id() == 1){
            Customer cus = new Customer();
            cus.setCustomerID(account.getAccount_id());
            cus.setCustomerName(account.getUsername());// UserName ban đầu sẽ là customerName (sau đó sẽ update chỉnh sửa lại)
            customerRepository.save(cus);
//        }else if (account.getRole_id() == 2){
//            Store store = new Store();
//            store.setStore_id(account.getAccount_id());
//            store.setStore_name(account.getUsername());
//            storeRepository.save(store);
//        }

    }
    public void deleteAccount(int id ){
        Account acc = accountRepository.findById(id).orElseThrow(() -> new IllegalStateException("Account with this"+id +"is not found"));
        accountRepository.deleteById(id);
    }
    public List<Account> getAcccountByRole(String role){
       List<Account> acc = accountRepository.getAccountByRole(role);
        return acc;
    }



}
