package com.example.rest.dto;

public class CompanyDto extends BaseRestModel<CompanyDto> {

    private String username;

    private String description;

    public String getUsername() {
        return username;
    }

    public CompanyDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
