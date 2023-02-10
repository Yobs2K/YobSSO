package com.example.web.model;

public class CompanyWebModel extends BaseWebModel<CompanyWebModel> {

    private String username;

    private String description;

    private Long ownerId;

    public String getUsername() {
        return username;
    }

    public CompanyWebModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyWebModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public CompanyWebModel setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }
}
