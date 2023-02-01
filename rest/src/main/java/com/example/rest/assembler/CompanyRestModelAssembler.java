package com.example.rest.assembler;

import com.example.db.entity.User;
import com.example.rest.dto.CompanyDto;
import com.example.db.entity.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CompanyRestModelAssembler {

    public List<CompanyDto> toDtoList(Collection<Company> companies) {
        List <CompanyDto> companyDtoList = new ArrayList<>();
        for (Company company : companies) {
            CompanyDto companyDto = new CompanyDto();
            List<Long> userIds = new ArrayList<>();
            for (User user : company.getUsers()) {
                userIds.add(user.getId());
            }
            companyDto.setId(company.getId())
                      .setUserIds(userIds);
            companyDtoList.add(
                    companyDto.setId(company.getId())
                              .setUserIds(userIds)
            );
        }
        return companyDtoList;
    }

    public CompanyDto toDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        List<Long> userIds = new ArrayList<>();
        for (User user : company.getUsers()) {
            userIds.add(user.getId());
        }
        return companyDto.setId(company.getId())
                         .setUserIds(userIds);
    }
}
