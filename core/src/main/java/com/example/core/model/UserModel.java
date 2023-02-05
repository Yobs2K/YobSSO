package com.example.core.model;

import com.example.db.entity.User;

public class UserModel {
    private Long id;
    private String username;
    private String email;

    public static UserModel of(User user) {
        UserModel userModel = new UserModel();
        userModel.setEmail(user.getEmail());
        userModel.setUsername(user.getUsername());
        userModel.setId(user.getId());
        return userModel;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }
}
