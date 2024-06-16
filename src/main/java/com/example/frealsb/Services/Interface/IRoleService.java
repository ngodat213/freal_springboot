package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Role;
import com.example.frealsb.RequestEntities.RequestRole;

import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();
    Role createRole(RequestRole requestRole);
    Role getRoleById(String id);

}
