package com.example.rest.dto;

public class UserDto extends BaseRestModel<UserDto> {

    private String username;

    private String password;

    private String email;

    private boolean isBanned;

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
