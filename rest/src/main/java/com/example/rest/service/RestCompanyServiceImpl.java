package com.example.rest.service;

import com.example.core.service.CompanyService;
import com.example.db.entity.Company;
import com.example.db.entity.User;
import com.example.rest.assembler.CompanyRestModelAssembler;
import com.example.rest.assembler.UserRestModelAssembler;
import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestCompanyServiceImpl implements RestCompanyService {

    private final CompanyService companyCoreService;
    private final CompanyRestModelAssembler companyRestModelAssembler;
    private final UserRestModelAssembler userRestModelAssembler;

    private final PagedResourcesAssembler<Company> pagedResourcesAssembler;

    @Autowired
    public RestCompanyServiceImpl(
            CompanyService companyCoreService,
            CompanyRestModelAssembler companyRestModelAssembler,
            UserRestModelAssembler userRestModelAssembler,
            PagedResourcesAssembler<Company> pagedResourcesAssembler
    ) {
        this.companyCoreService = companyCoreService;
        this.companyRestModelAssembler = companyRestModelAssembler;
        this.userRestModelAssembler = userRestModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    public List<CompanyDto> getAll() {
        List<CompanyDto> companyDtoList = new ArrayList<>();
        for (Company company : companyCoreService.getAll()) {
            companyDtoList.add(companyRestModelAssembler.toModel(company));
        }
        return companyDtoList;
    }

    @Override
    public PagedModel<CompanyDto> getAllPageable(Pageable pageable) {
        Page<Company> companies = companyCoreService.getAllPageable(pageable);
        return pagedResourcesAssembler.toModel(companies, companyRestModelAssembler);
    }

    public CompanyDto getById(Long id) {
        return companyRestModelAssembler.toModel(companyCoreService.getById(id));
    }

    public List<UserDto> getCompanyUsers(Long id) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : companyCoreService.getById(id).getUsers()) {
            userDtoList.add(userRestModelAssembler.toModel(user));
        }
        return userDtoList;
    }
}
