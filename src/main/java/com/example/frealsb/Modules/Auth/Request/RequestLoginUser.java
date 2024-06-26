package com.example.frealsb.Modules.Auth.Request;

import com.example.frealsb.Modules.User.Model.User;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestLoginUser {
    private String password;
    private String email;

    public User toUser(){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
}