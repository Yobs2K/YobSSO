package com.example.rest.dto;

import java.util.List;

public class UserDto {

    private Long id;

    private String username;

    private String password;

    private String email;

    private boolean isBanned;

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public UserDto setBanned(boolean banned) {
        isBanned = banned;
        return this;
    }
}
