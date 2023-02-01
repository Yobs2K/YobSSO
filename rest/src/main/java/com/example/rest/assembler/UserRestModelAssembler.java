package com.example.rest.assembler;

import com.example.db.entity.Company;
import com.example.rest.dto.UserDto;
import com.example.db.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserRestModelAssembler {

    public List<UserDto> toDtoList(Collection<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto();
            List<Long> companyIds = new ArrayList<>();
            for (Company company : user.getCompanies()) {
                companyIds.add(company.getId());
            }
            userDto.setId(user.getId())
                   .setCompanyIds(companyIds);
            userDtoList.add(
                    userDto.setId(user.getId())
                           .setCompanyIds(companyIds)
            );
        }
        return userDtoList;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        List<Long> companyIds = new ArrayList<>();
        for (Company company : user.getCompanies()) {
            companyIds.add(company.getId());
        }
        return userDto.setId(user.getId())
                      .setCompanyIds(companyIds);
    }

}
