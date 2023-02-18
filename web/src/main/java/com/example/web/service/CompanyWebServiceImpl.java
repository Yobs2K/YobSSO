package com.example.web.service;

import com.example.core.exception.CompanyNotFoundException;
import com.example.core.service.CompanyService;
import com.example.core.service.UserToCompanyService;
import com.example.db.entity.Company;
import com.example.db.entity.UserToCompany;
import com.example.db.entity.enumerated.UserCompanyRole;
import com.example.web.assembler.CompanyWebModelAssembler;
import com.example.web.form.CreateCompanyForm;
import com.example.web.model.CompanyWebModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyWebServiceImpl implements CompanyWebService {

    private final CompanyService companyService;

    private final UserToCompanyService userToCompanyService;

    private final CompanyWebModelAssembler companyAssembler;
    public CompanyWebServiceImpl(
            CompanyService companyService,
            UserToCompanyService userToCompanyService,
            CompanyWebModelAssembler companyAssembler
    ) {
        this.companyService = companyService;
        this.userToCompanyService = userToCompanyService;
        this.companyAssembler = companyAssembler;
    }

    @Override
    public Page<CompanyWebModel> findAllCompaniesPageable(Pageable pageable) {
        return companyService.getAllPageable(pageable).map(companyAssembler::toModel);
    }

    @Override
    public Page<CompanyWebModel> findAllAuthUserCompanies(Long userId, Pageable pageable) {
        return companyService.findAllUserCompaniesByUserId(userId, pageable).map(companyAssembler::toModel);
    }

    @Override
    public Page<CompanyWebModel> findAllOwnedCompanies(Long userId, Pageable pageable) {
        return companyService
                .findAllUserCompaniesByUserIdAndRole(userId, UserCompanyRole.OWNER, pageable)
                .map(companyAssembler::toModel);
    }

    @Override
    public CompanyWebModel findCompanyById(Long id) {
        return companyAssembler.toModel(companyService.getById(id));
    }


    @Override
    public CompanyWebModel addCompany(CreateCompanyForm companyForm, Long ownerId) {
        Company company = new Company();
        company
                .setOwnerId(ownerId)
                .setName(companyForm.getName())
                .setDescription(companyForm.getDescription());
        company = companyService.addCompany(company);
        userToCompanyService.addUserToCompany(ownerId, company.getId(), UserCompanyRole.OWNER);
        return companyAssembler.toModel(company);
    }
    @Override
    public CompanyWebModel updateCompany(CreateCompanyForm companyForm, Long companyId, Long userId) {
        Company company;
        try {
            company = companyService
                    .getById(companyId)
                    .setName(companyForm.getName())
                    .setDescription(companyForm.getDescription());
        }
        catch (CompanyNotFoundException e) {
            // Если компании с таким ID нет, мы создаём новую
            company = new Company();
            company
                    .setOwnerId(userId)
                    .setName(companyForm.getName())
                    .setDescription(companyForm.getDescription());
            company = companyService.addCompany(company);
            userToCompanyService.addUserToCompany(userId, company.getId(), UserCompanyRole.OWNER);
            return companyAssembler.toModel(company);
        }
        return companyAssembler.toModel(companyService.addCompany(company));
    }

    @Override
    public CompanyWebModel deleteCompany(Long id) {
        return companyAssembler.toModel(companyService.deleteCompanyById(id));
    }

    @Override
    public UserToCompany addUserToCompany(Long userId, Long companyId) {
        return userToCompanyService.addUserToCompany(userId, companyId, UserCompanyRole.USER);
    }
}
