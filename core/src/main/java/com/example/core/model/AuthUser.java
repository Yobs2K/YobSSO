package com.example.core.model;

import com.example.db.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthUser extends org.springframework.security.core.userdetails.User{
    private final SimpleUserModel simpleUserModel;

    public AuthUser(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        simpleUserModel = SimpleUserModel.of(user);
    }

    public SimpleUserModel getUserModel() {
        return simpleUserModel;
    }
}
