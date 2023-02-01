package com.example.rest.service;

import com.example.core.service.CompanyService;
import com.example.rest.assembler.CompanyRestModelAssembler;
import com.example.rest.assembler.UserRestModelAssembler;
import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestCompanyServiceImpl implements RestCompanyService {

    private final CompanyService companyCoreService;
    private final CompanyRestModelAssembler companyRestModelAssembler;
    private final UserRestModelAssembler userRestModelAssembler;

    @Autowired
    public RestCompanyServiceImpl(CompanyService companyCoreService, CompanyRestModelAssembler companyRestModelAssembler, UserRestModelAssembler userRestModelAssembler) {
        this.companyCoreService = companyCoreService;
        this.companyRestModelAssembler = companyRestModelAssembler;
        this.userRestModelAssembler = userRestModelAssembler;
    }

    public List<CompanyDto> getAllCompanies() {
        return companyRestModelAssembler.toDtoList(companyCoreService.getAllCompanies());
    }

    public CompanyDto getCompanyById(Long id) {
        return companyRestModelAssembler.toDto(companyCoreService.getCompanyById(id));
    }

    public List<UserDto> getCompanyUsers(Long id) {
        return  userRestModelAssembler.toDtoList(companyCoreService.getCompanyById(id).getUsers());
    }
}
