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
                .setUsername(model.getUsername())
                .setDescription(model.getDescription())
                .setOwnerId(model.getOwnerId());
        return model;
    }
}
