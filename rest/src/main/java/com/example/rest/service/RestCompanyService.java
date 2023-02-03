package com.example.rest.service;

import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import java.util.List;

public interface RestCompanyService {

    List<CompanyDto> getAll();

    PagedModel<CompanyDto> getAllPageable(Pageable pageable);

    CompanyDto getById(Long id);

    List<UserDto> getCompanyUsers(Long id);
}
