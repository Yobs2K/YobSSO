package com.example.rest.api;

import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;
import com.example.rest.service.RestCompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    private final RestCompanyService restCompanyService;

    public CompanyController(RestCompanyService restCompanyService) {
        this.restCompanyService = restCompanyService;
    }

    @GetMapping(value = "api/v1/company/")
    List<CompanyDto> getAllCompanies() {
        return restCompanyService.getAllCompanies();
    }

    @GetMapping(value = "api/v1/company/{id}")
    public CompanyDto getCompanyById(@PathVariable final Long id) {
        return restCompanyService.getCompanyById(id);
    }

    @GetMapping (value = "api/v1/company/{id}/users")
    public List<UserDto> getCompanyUsers(@PathVariable final Long id) {
        return restCompanyService.getCompanyUsers(id);
    }
}
