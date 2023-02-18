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
                .setId(entity.getId())
                .setName(entity.getName())
                .setDescription(entity.getDescription())
                .setOwnerId(entity.getOwnerId());
        return model;
    }
}
