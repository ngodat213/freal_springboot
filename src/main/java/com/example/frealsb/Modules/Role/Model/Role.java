package com.example.frealsb.Modules.Role.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.User.Model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Role extends AbstractEntity {
    @Column(unique = true, nullable = false, length = 50)
    private String role_name;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
