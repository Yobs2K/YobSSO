package com.example.rest.api;

import com.example.rest.dto.CompanyDto;
import com.example.rest.dto.UserDto;
import com.example.rest.service.RestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final RestUserService restUserService;

    @Autowired
    public UserController(RestUserService restUserService) {
        this.restUserService = restUserService;
    }

    @GetMapping()
    public PagedModel<UserDto> getAllUsers(@PageableDefault Pageable pageable) {
        return restUserService.getAllPageable(pageable);
    }

    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable final Long id) {
        return restUserService.getById(id);
    }

    @GetMapping("{id}/company")
    public List<CompanyDto> getUserCompanies(@PathVariable final Long id) {
        return restUserService.getUserCompanies(id);
    }
}
