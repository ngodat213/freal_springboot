package com.example.frealsb.RequestEntities;

import com.example.frealsb.Entities.User;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateUser {
    private String password;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String bio;
    private String avatarPublicId;

    public User toUpdate(User user){
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setAvatarPublicId(avatarPublicId);
        user.setPhone(phone);
        user.setBio(bio);
        user.setUpdatedAt(new Date());
        return user;
    }
}
