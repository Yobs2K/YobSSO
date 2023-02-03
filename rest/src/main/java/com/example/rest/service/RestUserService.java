package com.example.rest.service;

import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import java.util.List;

public interface RestUserService {

    List<UserDto> getAll();

    PagedModel<UserDto> getAllPageable(Pageable pageable);

    UserDto getById(Long id);

    List<CompanyDto> getUserCompanies(Long id);

}
