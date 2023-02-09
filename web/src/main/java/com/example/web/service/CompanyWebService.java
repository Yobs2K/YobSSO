package com.example.web.service;

import com.example.core.model.SimpleUserModel;
import com.example.web.model.CompanyWebModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyWebService {

    Page<CompanyWebModel> findAllCompaniesPageable(Pageable pageable);

    List<CompanyWebModel> findAllAuthUserCompanies(SimpleUserModel userModel);

    List<CompanyWebModel> findAllAuthUserIsAdminCompanies(SimpleUserModel userModel);

    CompanyWebModel findCompanyById(Long id);

    CompanyWebModel createCompany(CompanyWebModel companyWebModel);

    CompanyWebModel updateCompany(CompanyWebModel companyWebModel, Long id);

    CompanyWebModel deleteCompany(Long id);

    CompanyWebModel addUserToCompany(Long userId, Long companyId);
}
