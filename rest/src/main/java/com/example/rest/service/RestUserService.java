package com.example.rest.service;

import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;

import java.util.List;

public interface RestUserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    List<CompanyDto> getUserCompanies(Long id);

}
