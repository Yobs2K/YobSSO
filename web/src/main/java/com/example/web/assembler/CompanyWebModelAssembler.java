package com.example.web.assembler;

import com.example.db.entity.Company;
import com.example.web.model.CompanyWebModel;
import org.springframework.stereotype.Component;

@Component
public class CompanyWebModelAssembler extends BaseWebModelAssembler<Company, CompanyWebModel> {
    @Override
    public CompanyWebModel toModel(Company entity) {
        CompanyWebModel model = new CompanyWebModel();
        model
                .setId(model.getId())
                .setName(model.getName())
                .setDescription(model.getDescription());
        return model;
    }

    @Override
    public Company toEntity(CompanyWebModel model) {
        Company entity = (Company)new Company()
                .setId(model.getId());
        entity
                .setName(model.getName())
                .setDescription(model.getDescription());
        return entity;
    }
}
