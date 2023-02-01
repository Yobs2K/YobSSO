package com.example.rest.service;

import com.example.core.service.UserService;
import com.example.rest.assembler.CompanyRestModelAssembler;
import com.example.rest.assembler.UserRestModelAssembler;
import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestUserServiceImpl implements RestUserService {

    private final UserService userCoreService;
    private final UserRestModelAssembler userRestModelAssembler;
    private final CompanyRestModelAssembler companyRestModelAssembler;

    @Autowired
    public RestUserServiceImpl(UserService userCoreService, UserRestModelAssembler userRestModelAssembler, CompanyRestModelAssembler companyRestModelAssembler) {
        this.userCoreService = userCoreService;
        this.userRestModelAssembler = userRestModelAssembler;
        this.companyRestModelAssembler = companyRestModelAssembler;
    }

    public List<UserDto> getAllUsers() {
        return  userRestModelAssembler.toDtoList(userCoreService.getAllUsers());
    }

    public UserDto getUserById(Long id) {
        return userRestModelAssembler.toDto(userCoreService.getUserById(id));
    }

    public List<CompanyDto> getUserCompanies(Long id) {
        return companyRestModelAssembler.toDtoList(userCoreService.getUserById(id).getCompanies());
    }
}
