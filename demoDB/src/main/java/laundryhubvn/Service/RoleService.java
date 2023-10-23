package laundryhubvn.Service;
import laundryhubvn.DTO.RoleDTO;
import laundryhubvn.Entity.Role;
import laundryhubvn.Repository.RoleRepository;
import lombok.AllArgsConstructor;
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
    public void addRole( Role role){
        roleRepository.save(role);
    }
    public void deleteRoleID( int Id ) {
        Role role = roleRepository.findById(Id).orElseThrow(() -> new IllegalStateException("This role is not found"));
        roleRepository.deleteById(Id);
    }
    public void updateRole( int Id, RoleDTO request )  {
        Role role = roleRepository.findById(Id).orElseThrow(() -> new IllegalStateException("This role is not found"));
        role.setRoleName(request.getRoleName());
        roleRepository.save(role);
    }


}
