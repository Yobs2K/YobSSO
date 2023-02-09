package com.example.web.assembler;

import com.example.db.entity.Company;
import com.example.web.model.CompanyWebModel;

public class CompanyWebModelAssembler extends BaseWebModelAssembler<Company, CompanyWebModel> {
    @Override
    public CompanyWebModel toModel(Company entity) {
        return null; //TODO доделать companyToModel
    }
}
