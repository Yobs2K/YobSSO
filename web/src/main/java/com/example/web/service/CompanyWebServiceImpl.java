package com.example.web.service;

import com.example.core.exceptions.CompanyNotFoundException;
import com.example.core.model.SimpleUserModel;
import com.example.core.service.CompanyService;
import com.example.db.entity.Company;
import com.example.web.assembler.CompanyWebModelAssembler;
import com.example.web.model.CompanyWebModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyWebServiceImpl implements CompanyWebService {

    private final CompanyService companyService;

    private final CompanyWebModelAssembler companyAssembler;
    public CompanyWebServiceImpl(
            CompanyService companyService,
            CompanyWebModelAssembler companyAssembler
    ) {
        this.companyService = companyService;
        this.companyAssembler = companyAssembler;
    }

    @Override
    public Page<CompanyWebModel> findAllCompaniesPageable(Pageable pageable) {
        return companyService.getAllPageable(pageable).map(companyAssembler::toModel);
    }

    @Override
    public List<CompanyWebModel> findAllAuthUserCompanies(SimpleUserModel userModel) {
        return companyAssembler.toModelList(companyService.findAllUserCompaniesByUserId(userModel.getId()));
    }

    @Override
    public List<CompanyWebModel> findAllAuthUserIsAdminCompanies(SimpleUserModel userModel) {
        return companyAssembler.toModelList(companyService.findAllUserIsAdminCompaniesByUserId(userModel.getId()));
    }

    @Override
    public CompanyWebModel findCompanyById(Long id) {
        return companyAssembler.toModel(companyService.getById(id));
    }

    @Override
    public CompanyWebModel createCompany(CompanyWebModel companyWebModel, SimpleUserModel userModel) {
        Company company = companyAssembler.toEntity(companyWebModel);
        return companyAssembler.toModel(
                companyService.addUserToCompanyByIds(
                    companyService.addCompany(company).getId(),
                    userModel.getId()
                )
        );

    }

    @Override
    public CompanyWebModel updateCompany(CompanyWebModel companyWebModel, Long id) {
        Company company;
        try {
            company = companyService.getById(id);
        }
        catch (CompanyNotFoundException e) {
            company = new Company();
        }
        company
                .setName(companyWebModel.getName())
                .setDescription(companyWebModel.getDescription());
        return companyAssembler.toModel(companyService.addCompany(company));
    }

    @Override
    public CompanyWebModel deleteCompany(Long id) {
        return companyAssembler.toModel(companyService.deleteCompanyById(id));
    }

    @Override
    public CompanyWebModel addUserToCompany(Long userId, Long companyId) {
        return companyAssembler.toModel(companyService.addUserToCompanyByIds(userId, companyId));
    }
}
