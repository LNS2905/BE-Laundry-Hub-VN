package laundryhubvn.Controller;
import laundryhubvn.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import laundryhubvn.Entity.Account;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/account")

public class AccountController {
    private final AccountService accountService;

    @GetMapping()
    public List<Account> listAllAccount(){
       return  accountService.GetAllAccount();
    }
    @PostMapping()
    public void addAccount(@RequestBody  Account account){
        accountService.addAccount(account);
    }
    @DeleteMapping("/{accountID}")
    public void deleteAccount(@PathVariable("accountID") int Id ){
        accountService.deleteAccount(Id);
    }
}
