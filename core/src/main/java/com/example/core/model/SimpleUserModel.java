package com.example.core.model;

import com.example.db.entity.User;

public class SimpleUserModel {
    private Long id;
    private String username;
    private String email;

    public static SimpleUserModel of(User user) {
        SimpleUserModel simpleUserModel = new SimpleUserModel();
        simpleUserModel.setEmail(user.getEmail());
        simpleUserModel.setUsername(user.getUsername());
        simpleUserModel.setId(user.getId());
        return simpleUserModel;
    }

    public String getUsername() {
        return username;
    }

    public SimpleUserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SimpleUserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SimpleUserModel setId(Long id) {
        this.id = id;
        return this;
    }
}
