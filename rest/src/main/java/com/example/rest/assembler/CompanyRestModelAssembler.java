package com.example.rest.assembler;
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
            companyDtoList.add(toDto(company));
        }
        return companyDtoList;
    }

    public CompanyDto toDto(Company company) {
        CompanyDto model = new CompanyDto();

        return model.setId(company.getId())
                .setDescription(company.getDescription())
                .setName(company.getName());
    }
}
