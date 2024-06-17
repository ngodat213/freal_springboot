package com.example.frealsb.Configs;

import com.example.frealsb.Modules.Auth.Service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                request->request
                        .requestMatchers("/").hasAuthority("USER")
                        .requestMatchers("/users/**").hasAuthority("PARTNER,USER")
                        .requestMatchers("/roles").hasAuthority("ADMIN,PARTNER,USER")
                        .anyRequest().permitAll()
        ).formLogin(AbstractConfiguredSecurityBuilder
                ->AbstractConfiguredSecurityBuilder.loginPage("/login")
                .successHandler(new HandleSuccessLogin())
                .permitAll()
        ).logout(logout->logout.logoutUrl("/logout")).build();
    }

    public UserDetailsService UserDetailsService() {
        return customUserDetailService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(UserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}