package com.yun.demoDB.Service;
import com.yun.demoDB.Controller.RoleController;
import com.yun.demoDB.DTO.RoleDTO;
import com.yun.demoDB.Entity.Account;
import com.yun.demoDB.Entity.Role;
import com.yun.demoDB.Repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    public List<Role> listAllRole(){

        return roleRepository.findAll();
    }
    public void addRole(@RequestBody Role role){
        roleRepository.save(role);
    }
    public void deleteRoleID( int Id ) {
        Role role = roleRepository.findById(Id).orElseThrow(() -> new IllegalStateException("This role is not found"));
        roleRepository.deleteById(Id);
    }
    public void updateRole(@PathVariable("roleID") int Id, RoleDTO request )  {
        Role role = roleRepository.findById(Id).orElseThrow(() -> new IllegalStateException("This role is not found"));
        role.setRoleName(request.getRoleName());
        roleRepository.save(role);
    }

}
