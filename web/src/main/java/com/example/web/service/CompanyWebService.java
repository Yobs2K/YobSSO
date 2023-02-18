package com.example.web.service;

import com.example.db.entity.UserToCompany;
import com.example.web.form.CreateCompanyForm;
import com.example.web.model.CompanyWebModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyWebService {

    Page<CompanyWebModel> findAllCompaniesPageable(Pageable pageable);

    Page<CompanyWebModel> findAllAuthUserCompanies(Long userId, Pageable pageable);

    Page<CompanyWebModel> findAllOwnedCompanies(Long userId, Pageable pageable);

    CompanyWebModel findCompanyById(Long id);

    CompanyWebModel deleteCompany(Long id);

    UserToCompany addUserToCompany(Long userId, Long companyId); //Добавить модель для UserToCompany

    CompanyWebModel addCompany(CreateCompanyForm companyForm, Long ownerId);

    CompanyWebModel updateCompany(CreateCompanyForm companyForm, Long companyId, Long userId);
}
