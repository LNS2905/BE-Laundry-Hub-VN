package com.yun.demoDB.Controller;
import com.yun.demoDB.DTO.CustomerDTO;
import com.yun.demoDB.Repository.CustomerRepository;
import com.yun.demoDB.Entity.Customer;
import com.yun.demoDB.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping()
    public List<Customer> getListCustomer(){
        return customerService.getAllCustomer();
    }
    @PostMapping()
    public void addCustomer(@RequestBody Customer customer){
       customerService.addCustomer(customer);
    }

    @GetMapping("/{customerID}")
    public Customer searchCustomer (@PathVariable("customerID") int ID){
       return customerService.searchCustomer(ID);
    }

    @PutMapping("/{customerID}")
    public void updateCustomer(@PathVariable("customerID") Integer id, @RequestBody CustomerDTO request ) {
         customerService.updateCustomer(id, request);
    }

    @DeleteMapping("/{customerID}")
    public void deleteAccount(@PathVariable("customerID") int Id ){
        customerService.deleteCustomer(Id);
    }


}
