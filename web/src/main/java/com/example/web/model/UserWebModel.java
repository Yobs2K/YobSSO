package com.example.web.model;

public class UserWebModel extends BaseWebModel<UserWebModel> {

    private String username;

    private String email;

    private String password;

    private boolean isBanned = false;

    public String getUsername() {
        return username;
    }

    public UserWebModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserWebModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserWebModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public UserWebModel setBanned(boolean banned) {
        isBanned = banned;
        return this;
    }
}
