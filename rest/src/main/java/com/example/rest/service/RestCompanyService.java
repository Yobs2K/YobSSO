package com.example.rest.service;

import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;

import java.util.List;

public interface RestCompanyService {

    List<CompanyDto> getAllCompanies();

    CompanyDto getCompanyById(Long id);

    List<UserDto> getCompanyUsers(Long id);
}
