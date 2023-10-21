package com.yun.demoDB.Entity;

import jakarta.persistence.*;

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
    private String role_id;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL, orphanRemoval = true)
    private Customer customer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id",referencedColumnName = "role_id",insertable=false, updatable=false)
    private Role role;

    public Account(int account_id, String username, String password, String role_id) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
        this.role_id = role_id;
    }

    public Account() {

    }

    // Hàm setCustomer

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }


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
