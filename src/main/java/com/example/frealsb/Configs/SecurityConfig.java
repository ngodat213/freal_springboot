package com.example.frealsb.Configs;

import com.example.frealsb.Enums.UserRole;
import com.example.frealsb.Managers.ManagerRouter;
import com.example.frealsb.Modules.Auth.Service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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
        return http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request->request
                        .requestMatchers(ManagerRouter.AdminMatchers).hasAuthority(UserRole.ADMIN.getAuthority())
                        .requestMatchers(ManagerRouter.UserMatchers).hasAuthority(UserRole.USER.getAuthority())
                        .requestMatchers(ManagerRouter.PartnerMatchers).hasAuthority(UserRole.PARTNER.getAuthority())
                        .anyRequest().permitAll()
                ).formLogin(AbstractConfiguredSecurityBuilder
                        ->AbstractConfiguredSecurityBuilder
                        .loginPage(ManagerRouter.loginPage)
                        .defaultSuccessUrl(ManagerRouter.defaultPage)
                        .successHandler(new HandleSuccessLogin())
                        .permitAll()
                ).rememberMe(rememberMe -> rememberMe.key(ManagerRouter.rememberMeKey)
                        .rememberMeCookieName(ManagerRouter.rememberMeKey)
                        .tokenValiditySeconds(ManagerRouter.rememberMeTimeExpired)
                        .userDetailsService(customUserDetailService)

                ).sessionManagement(sessionManagement -> sessionManagement
                        .maximumSessions(1)
                        .expiredUrl(ManagerRouter.loginPage)
                ).logout(logout->logout.logoutUrl(ManagerRouter.logoutPage)).build();
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