package laundryhubvn.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @Column(name = "customer_id")

    private int customerID;

    @Column(name="customer_name")

    private String customerName;

    @Column(name = "phone_number")
    private String phoneNumber;


    // Các phương thức và thuộc tính khác

//    public void setAccount(Account account) {
//        this.account = account;
//    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +


                '}';
    }


}
