package com.yun.demoDB.Controller;
import com.yun.demoDB.Repository.AccountRepository;
import com.yun.demoDB.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/account")

public class AccountController {
    @Autowired
    public AccountRepository accountRepository;


    @GetMapping
    public List<Account> listAllAccount(){
        return accountRepository.findAll();
    }
    record AddAccount (
            String username,
            String password,
            String role_id
    ){

    }
    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }
    @PostMapping
    public void addAccount(@RequestBody AddAccount  request){
        Account acc = new Account();

        acc.setUsername(request.username());
        acc.setPassword(request.password());
        acc.setRole_id(request.role_id());
       accountRepository.save(acc);

    }
    @DeleteMapping("{accountID}")
    public void deleteAccount(@PathVariable("accountID") int Id ){
        boolean  acc = accountRepository.existsById(Id);
        if(!acc){
            System.out.println("Don't have this account");
        }else{
            accountRepository.deleteById(Id);
            System.out.println("Delete successfully");
        }
    }
}
