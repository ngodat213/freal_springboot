package com.example.frealsb.Entities;

import com.example.frealsb.Services.CloudinaryService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomUserDetail implements UserDetails{
    private String link = "https://res.cloudinary.com/duhncgkpo/image/upload/v1717508494/";
    private String extensionImage = ".png";
    private User user;
    public CustomUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        String roles = "ADMIN,PARTNER,USER";
        int index = roles.indexOf(user.getRole().getRole_name());
        String substring = roles.substring(index);
        String authString[] = substring.split(",");
        for (String auth : authString) {
            authorities.add(new SimpleGrantedAuthority(auth));
        }
        return authorities;
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
        return link + user.getAvatarPublicId() + extensionImage;
    }
}
