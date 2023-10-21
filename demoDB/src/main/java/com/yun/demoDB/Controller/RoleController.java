package com.yun.demoDB.Controller;
import com.yun.demoDB.Repository.RoleRepository;
import com.yun.demoDB.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController

@RequestMapping("api/v1/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> listallRole(){
        return roleRepository.findAll();
    }

    record UpdateRoleRequest(
        String roleName

    ){}

    @DeleteMapping("{roleID}")
    public void deleteroleID(@PathVariable("roleID") String Id ) {

        boolean role = roleRepository.existsById(Id);
        if (!role) {
            System.out.println("Don't have this customer");
        } else {
            roleRepository.deleteById(Id);
            System.out.println("Delete successfully");
        }
    }
    @PutMapping("{roleID}")
    public ResponseEntity<Role> updateRole(@PathVariable("roleID") String Id, @RequestBody UpdateRoleRequest request )  {
        Role role = roleRepository.findById(Id).orElseThrow();

            roleRepository.deleteById(Id);
            role.setRoleName(request.roleName);
            final Role updateRole = roleRepository.save(role);
            return ResponseEntity.ok(updateRole);
    }

    record AddRole(
            String role
    ){
    }
    @PostMapping
    public void addRole(@RequestBody AddRole request){
        Role role = new Role();
        role.setRoleName(request.role());
        roleRepository.save(role);
    }

}

