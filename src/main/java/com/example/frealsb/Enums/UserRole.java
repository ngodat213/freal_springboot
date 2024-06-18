package com.example.frealsb.Enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER("ROLE_USER"),
    PARTNER("PARTNER"),
    ADMIN("ROLE_ADMIN");

    private String authority;
    UserRole(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
