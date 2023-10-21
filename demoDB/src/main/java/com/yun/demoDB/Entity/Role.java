package com.yun.demoDB.Entity;

import com.yun.demoDB.Entity.Account;
import jakarta.persistence.*;


import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private String roleId;
    @Column(name="role")
    private String roleName;

    public Role() {
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role")
    private Set<Account> accounts;
    public Role(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
