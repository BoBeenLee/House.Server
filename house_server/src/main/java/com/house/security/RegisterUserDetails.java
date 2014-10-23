package com.house.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.house.model.User;


public class RegisterUserDetails implements UserDetails {
    private static Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(){{
        add(new SimpleGrantedAuthority("read"));
        add(new SimpleGrantedAuthority("write"));
        add(new SimpleGrantedAuthority("ROLE_USER"));
    }};
    
    private User user;
    
    public RegisterUserDetails(User user) {
        this.user = user;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }
    public String getUsername() {
        return user.getUsrId();
    }
    public boolean isAccountNonExpired() {
        return isEnabled();
    }
    public boolean isAccountNonLocked() {
        return isEnabled();
    }
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }
    public boolean isEnabled() {
        return true;
    }
    public String getPassword() {
        return user.getUsrPw();
    }
    
}