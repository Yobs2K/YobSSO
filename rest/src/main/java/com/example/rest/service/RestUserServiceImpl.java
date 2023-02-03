package com.example.rest.service;

import com.example.core.service.UserService;
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
public class RestUserServiceImpl implements RestUserService {

    private final UserService userCoreService;
    private final UserRestModelAssembler userRestModelAssembler;
    private final CompanyRestModelAssembler companyRestModelAssembler;

    private final PagedResourcesAssembler<User> pagedResourcesAssembler;

    @Autowired
    public RestUserServiceImpl(
            UserService userCoreService,
            UserRestModelAssembler userRestModelAssembler,
            CompanyRestModelAssembler companyRestModelAssembler,
            PagedResourcesAssembler<User> pagedResourcesAssembler
    ) {
        this.userCoreService = userCoreService;
        this.userRestModelAssembler = userRestModelAssembler;
        this.companyRestModelAssembler = companyRestModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    public List<UserDto> getAll() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userCoreService.getAll()) {
            userDtoList.add(userRestModelAssembler.toModel(user));
        }
        return userDtoList;
    }

    @Override
    public PagedModel<UserDto> getAllPageable(Pageable pageable) {
        Page<User> users = userCoreService.getAllPageable(pageable);
        return pagedResourcesAssembler.toModel(users, userRestModelAssembler);
    }

    public UserDto getById(Long id) {
        return userRestModelAssembler.toModel(userCoreService.getById(id));
    }

    public List<CompanyDto> getUserCompanies(Long id) {
        List<CompanyDto> companyDtoList = new ArrayList<>();
        for (Company company : userCoreService.getById(id).getCompanies()) {
            companyDtoList.add(companyRestModelAssembler.toModel(company));
        }
        return companyDtoList;
    }
}
