package laundryhubvn.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private int account_id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="role_id")
    private int role_id;

//    @OneToOne(fetch = FetchType.LAZY,mappedBy = "account",cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private Customer customer;

//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="role_id",referencedColumnName = "role_id",insertable=false, updatable=false)
//    private Role role;

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id='" + account_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role_id='" + role_id + '\'' +
                '}';
    }
}
