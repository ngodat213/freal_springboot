package com.example.frealsb.Modules.Role.Service;

import com.example.frealsb.Modules.Role.Model.Role;
import com.example.frealsb.Modules.Role.RequestRole;

import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();
    Role createRole(RequestRole requestRole);
    Role getRoleById(String id);

}
