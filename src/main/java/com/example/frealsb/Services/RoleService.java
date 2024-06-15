package com.example.frealsb.Services;

import com.example.frealsb.Entities.Role;
import com.example.frealsb.Repositories.RoleRepository;
import com.example.frealsb.RequestEntities.RequestRole;
import com.example.frealsb.Services.Interface.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(String id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role createRole(RequestRole requestRole) {
        Role role = new Role();
        role.setRole_name(requestRole.getRole_name());
        return roleRepository.save(role);
    }
}