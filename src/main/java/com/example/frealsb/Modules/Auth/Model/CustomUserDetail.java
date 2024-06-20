package com.example.frealsb.Modules.Auth.Model;

import com.example.frealsb.Modules.User.Model.User;
import jakarta.persistence.EntityListeners;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CustomUserDetail implements UserDetails{
    private String link = "https://res.cloudinary.com/duhncgkpo/image/upload/v1717508494/";
    private String defaultPublicIdAvatar = "Freal/public/zmhc6q9km7psp7eymp8w";
    private String extensionImage = ".png";
    private User user;
    public CustomUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(user.getRole());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public String getDisplayName(){
        return user.getFirstName() + " " + user.getLastName();
    }

    public String getAvatar(){
        if(user.getAvatar()!=null){
            return user.getAvatar().getUrl();
        }
        return link + defaultPublicIdAvatar + extensionImage;
    }

    public String getLastName() {return user.getLastName();}
}
