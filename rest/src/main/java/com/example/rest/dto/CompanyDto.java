package com.example.rest.dto;

import java.util.List;

public class CompanyDto {

    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public CompanyDto setId(Long id) {
        this.id = id;
        return this;
    }

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
