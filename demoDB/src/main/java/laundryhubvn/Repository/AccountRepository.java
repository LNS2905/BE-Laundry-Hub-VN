package laundryhubvn.Repository;

import laundryhubvn.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("select a from Account a join Role r  on a.role_id = r.roleId where r.roleName like %?1%")
    List<Account> getAccountByRole(String role);
}
