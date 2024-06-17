package com.example.frealsb.Modules.Role;

import com.example.frealsb.Modules.Role.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    @Query("SELECT r FROM Role r where r.role_name=?1 ")
    Role findOneByName(String roleName);
}
