package com.example.rest.dto;

public class CompanyDto extends BaseRestModel<CompanyDto> {

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public CompanyDto setName(String name) {
        this.name = name;
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
