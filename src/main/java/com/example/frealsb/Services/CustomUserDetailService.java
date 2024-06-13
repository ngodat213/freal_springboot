package com.example.frealsb.Services;

import com.example.frealsb.Entities.CustomUserDetail;
import com.example.frealsb.Entities.User;
import com.example.frealsb.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetail loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        CustomUserDetail userDetails = new CustomUserDetail(user);
        System.out.println(userDetails.getAuthorities());
        return userDetails;
    }

    public List<GrantedAuthority> BuildRolesFromRole(String Role){
        List<GrantedAuthority> authorities = new ArrayList<>();
        String roles = "ADMIN,PARTNER,USER";
        int index = roles.indexOf(Role);
        String substring = roles.substring(index);
        String authString[] = substring.split(",");
        for (String auth : authString) {
            authorities.add(new SimpleGrantedAuthority(auth));
        }
        return authorities;
    }
}