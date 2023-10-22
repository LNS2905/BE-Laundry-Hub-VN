package laundryhubvn.Service;
import laundryhubvn.DTO.CustomerDTO;
import lombok.AllArgsConstructor;
import laundryhubvn.Entity.Customer;
import laundryhubvn.Repository.CustomerRepository;
import org.springframework.stereotype.Service;



import java.util.List;
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public Customer searchCustomer ( int ID){
        return customerRepository.findById(ID).orElseThrow();
    }
    public void  updateCustomer( Integer id, CustomerDTO request )  {
        Customer cus = customerRepository.findById(id).orElseThrow(() -> new IllegalStateException("Customer with this"+id +"is not found"));
        cus.setCustomerName(request.getCustomerName());
        cus.setPhoneNumber(request.getPhoneNumber());
        customerRepository.save(cus);

    }

    public void deleteCustomer(int id ){
        Customer cus = customerRepository.findById(id).orElseThrow(() -> new IllegalStateException("Customer with this"+id +"is not found"));
        customerRepository.deleteById(id);
    }

}
