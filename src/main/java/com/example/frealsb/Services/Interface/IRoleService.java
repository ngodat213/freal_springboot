package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Role;
import com.example.frealsb.RequestEntities.RequestRole;

import java.util.List;

public interface IRoleService {
    public List<Role> getAllRoles();
    public Role createRole(RequestRole requestRole);
    public Role getRoleById(String id);

}
