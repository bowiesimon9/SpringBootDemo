//package com.example.AuthorizationServer.service;
//
//import com.example.AuthorizationServer.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//
//public class CustomUserDetails implements UserDetails {
//
//    private User user;
//
//    public CustomUserDetails(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//        String[] roless = null;
//
//        if (user!=null) {
//            roless = user.getRoles();
//        }
//
//        if (roless!=null) {
//            for (String role : roless) {
//                authorities.add(new SimpleGrantedAuthority(role));
//            }
//        }
//
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword_();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}