package com.example.frealsb.Modules.Auth.Request;

import com.example.frealsb.Const.Constants;
import com.example.frealsb.Enums.UserRole;
import com.example.frealsb.Modules.User.Model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestRegisterUser {
    private String firstName;

    private String lastName;

    @Email()
    private String email;

    @Size.List({
            @Size(min = 8, message = "Password too short"),
            @Size(max = 80, message = "Password too long")
    })
    private String confirmPassword;

    @Size.List({
            @Size(min = 8, message = "Password too short"),
            @Size(max = 80, message = "Password too long")
    })
    private String password;

    public User toUser(){
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEnabled(true);
        user.setRole(UserRole.USER);
        return user;
    }
}
