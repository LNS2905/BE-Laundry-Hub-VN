package com.yun.demoDB.Controller;
import com.yun.demoDB.DTO.RoleDTO;
import com.yun.demoDB.Repository.RoleRepository;
import com.yun.demoDB.Entity.Role;
import com.yun.demoDB.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/role")
public class RoleController {
    private final RoleService roleService;


    @GetMapping
    public List<Role> listAllRole(){
        return roleService.listAllRole();
    }


    @DeleteMapping("{roleID}")
    public void deleteRoleID(@PathVariable("roleID") int Id ) {
        roleService.deleteRoleID(Id);
    }
    @PutMapping("{roleID}")
    public void updateRole(@PathVariable("roleID") int Id, RoleDTO request )  {
       roleService.updateRole(Id,request);
    }

    @PostMapping
    public void addRole(@RequestBody Role role){
        roleService.addRole(role);
    }

}

