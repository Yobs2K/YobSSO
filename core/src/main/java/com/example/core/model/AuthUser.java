package com.example.core.model;

import com.example.db.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthUser extends org.springframework.security.core.userdetails.User{
    private final UserModel userModel;

    public AuthUser(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        userModel = UserModel.of(user);
    }

    public UserModel getUserModel() {
        return userModel;
    }
}
