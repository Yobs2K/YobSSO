package com.example.web.service;

import com.example.db.entity.UserToCompany;
import com.example.web.form.CreateCompanyForm;
import com.example.web.model.CompanyWebModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyWebService {

    Page<CompanyWebModel> findAllCompaniesPageable(Pageable pageable);

    List<CompanyWebModel> findAllAuthUserCompanies(Long userId);

    List<CompanyWebModel> findAllAuthUserIsAdminCompanies(Long userId);

    CompanyWebModel findCompanyById(Long id);

    CompanyWebModel deleteCompany(Long id);

    UserToCompany addUserToCompany(Long userId, Long companyId); //Добавить модель для UserToCompany

    CompanyWebModel addCompany(CreateCompanyForm companyForm, Long ownerId);

    CompanyWebModel updateCompany(CreateCompanyForm companyForm, Long companyId, Long userId);
}
