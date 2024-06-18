package com.example.frealsb.Modules.User.Model;
import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, length = 80)
    @Size.List({
            @Size(min = 8, message = "Password too short"),
            @Size(max = 80, message = "Password too long")
    })
    private String password;

    @Column(unique = true, nullable = false, length = 50)
    @Email()
    private String email;

    @Column(nullable = true)
    private String phone;


    @Column(nullable = true)
    private String avatarPublicId;

    @Column(nullable = true)
    private String location;

    @Column(nullable = true, length = 1000)
    @Size(max = 1000)
    private String bio;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private boolean enabled = true;

    private int countFail;
    private Date lockExpired;
    private String tokenResetPassword;
    private Date tokenResetPasswordExpired;
}