package com.example.rest.dto;

import java.util.List;

public class UserDto {

    private Long id;

    private List<Long> companyIds;

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Long> getCompanyIds() {
        return companyIds;
    }

    public UserDto setCompanyIds(List<Long> companyIds) {
        this.companyIds = companyIds;
        return this;
    }
}
