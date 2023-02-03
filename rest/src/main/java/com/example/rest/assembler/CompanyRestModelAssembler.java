package com.example.rest.assembler;
import com.example.rest.dto.CompanyDto;
import com.example.db.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyRestModelAssembler extends BaseRestModelAssembler<Company, CompanyDto>{

    public CompanyDto toModel(Company company) {
        CompanyDto model = new CompanyDto();

        return model
                .setId(company.getId())
                .setDescription(company.getDescription())
                .setName(company.getName());
    }

}
