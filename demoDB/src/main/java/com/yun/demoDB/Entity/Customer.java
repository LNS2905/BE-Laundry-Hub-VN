package com.yun.demoDB.Entity;

import com.yun.demoDB.Entity.Account;
import jakarta.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerID;

    private String customerName;

    @Column(name = "phone_number")
    private String phoneNumber;





    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId
    @JoinColumn(name="customer_id",referencedColumnName = "account_id")
    private Account account;



    public Customer(int customerID, String customerName, String phoneNumber) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;

    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +


                '}';
    }

    public Customer() {
    }


}
