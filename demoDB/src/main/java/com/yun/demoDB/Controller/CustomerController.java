package com.yun.demoDB.Controller;
import com.yun.demoDB.Repository.CustomerRepository;
import com.yun.demoDB.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String customerName,
            String phoneNumber


    ){

    }
    record UpdateCustomerRequest(
            String customerName,
            String phoneNumber,
            int buildingID


    ){

    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){

        Customer cus = new Customer();
        cus.setCustomerName(request.customerName());
        cus.setPhoneNumber(request.phoneNumber());

        customerRepository.save(cus);
    }

    @GetMapping("{customerID}")
    public Customer searchCustomer (int ID){
        Customer cus = customerRepository.findById(ID).orElseThrow();
        return cus;
    }

    @PutMapping("{customerID}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerID") Integer id, @RequestBody UpdateCustomerRequest request ) throws ConfigDataResourceNotFoundException{

        Customer cus = customerRepository.findById(id).orElseThrow();
            cus.setCustomerID(id);
            cus.setCustomerName(request.customerName());
            cus.setPhoneNumber(request.phoneNumber());
            final Customer updateCustomer = customerRepository.save(cus);
            return ResponseEntity.ok(updateCustomer);


    }
    @DeleteMapping("{customerID}")
    public void deleteAccount(@PathVariable("customerID") int Id ){

        boolean  cus = customerRepository .existsById(Id);
        if(!cus){
            System.out.println("Don't have this account");
        }else{
            customerRepository.deleteById(Id);
            System.out.println("Delete successfully");
        }
    }


}
