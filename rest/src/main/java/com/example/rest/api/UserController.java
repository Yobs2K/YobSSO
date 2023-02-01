package com.example.rest.api;

import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;
import com.example.rest.service.RestUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final RestUserService restUserService;

    public UserController(RestUserService restUserService) {
        this.restUserService = restUserService;
    }

    @GetMapping(value = "api/v1/users/")
    public List<UserDto> getAllUsers() {
        return restUserService.getAllUsers();
    }

    @GetMapping(value = "api/v1/users/{id}")
    public UserDto getUserById(@PathVariable final Long id) {
        return restUserService.getUserById(id);
    }

    @GetMapping(value = "api/v1/users/{id}/company")
    public List<CompanyDto> getUserCompanies(@PathVariable final Long id) {
        return restUserService.getUserCompanies(id);
    }
}
