package com.example.web.service;

import com.example.core.exceptions.CompanyNotFoundException;
import com.example.core.model.SimpleUserModel;
import com.example.core.service.CompanyService;
import com.example.core.service.UserService;
import com.example.db.entity.Company;
import com.example.db.entity.User;
import com.example.web.assembler.CompanyWebModelAssembler;
import com.example.web.form.CreateCompanyForm;
import com.example.web.model.CompanyWebModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyWebServiceImpl implements CompanyWebService {

    private final CompanyService companyService;

    private final UserService userService;

    private final CompanyWebModelAssembler companyAssembler;
    public CompanyWebServiceImpl(
            CompanyService companyService,
            UserService userService,
            CompanyWebModelAssembler companyAssembler
    ) {
        this.companyService = companyService;
        this.userService = userService;
        this.companyAssembler = companyAssembler;
    }

    @Override
    public Page<CompanyWebModel> findAllCompaniesPageable(Pageable pageable) {
        return companyService.getAllPageable(pageable).map(companyAssembler::toModel);
    }

    @Override
    public List<CompanyWebModel> findAllAuthUserCompanies(Long userId) {
        return companyAssembler.toModelList(companyService.findAllUserCompaniesByUserId(userId));
    }

    @Override
    public List<CompanyWebModel> findAllAuthUserIsAdminCompanies(Long userId) {
        return companyAssembler.toModelList(companyService.findAllUserIsAdminCompaniesByUserId(userId));
    }

    @Override
    public CompanyWebModel findCompanyById(Long id) {
        return companyAssembler.toModel(companyService.getById(id));
    }


    @Override
    public CompanyWebModel addCompany(CreateCompanyForm companyForm, Long ownerId) {
        Company company = new Company();
        User owner = userService.getById(ownerId);
        owner.getCompanies().add(company);
        company
                .setOwnerId(ownerId)
                .setUsername(companyForm.getUsername())
                .setDescription(companyForm.getDescription())
                .getUsers().add(owner);
        userService.addUser(owner);
        return companyAssembler.toModel(companyService.addCompany(company));
    }
    @Override
    public CompanyWebModel updateCompany(CreateCompanyForm companyForm, Long companyId, Long userId) {
        Company company;
        try {
            company = companyService.getById(companyForm.getId());
        }
        catch (CompanyNotFoundException | IllegalArgumentException e) {
            // Если компании с таким ID нет либо ID - null, мы создаём новую
            company = new Company();
            User owner = userService.getById(userId); // В таком случае мы должны задать ей овнера
            owner.getCompanies().add(company);        // Овнеру мы тоже должны добавить эту компанию
            company
                    .setOwnerId(userId)
                    .getUsers().add(owner);
            userService.addUser(owner); // Сохраняем обновлённую сущность юзера-овнера
        }
        company
                .setUsername(companyForm.getUsername())
                .setDescription(companyForm.getDescription());
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
