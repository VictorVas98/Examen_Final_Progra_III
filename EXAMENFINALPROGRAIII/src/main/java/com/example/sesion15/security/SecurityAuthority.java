package com.example.sesion15.security;

import com.example.sesion15.entities.Authority;
import org.springframework.security.core.GrantedAuthority;

public class SecurityAuthority implements GrantedAuthority {
    private final Authority authority;
    public SecurityAuthority(Authority authority){
        this.authority = authority;
    }
    @Override
    public String getAuthority() {
        return this.authority.getName().toString();
    }
}
