package com.example.web.api.reference;

import com.example.web.service.CompanyWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api-web/company")
public class CompanyController {

    private final CompanyWebService companyWebService;

    @Autowired
    public CompanyController(
            CompanyWebService companyWebService
    ) {
        this.companyWebService = companyWebService;
    }

    //getAllCompaniesPageable(Pageable pageable)

    //getAllAuthUserCompanies(AuthUser authUser)

    //getAllAuthUserIsAdminCompanies(AuthUser authUser)

    //getCompanyById(Long id)

    //createCompany(CompanyWebModel model)

    //updateCompany(CompanyWebModel model, Long id)

    //deleteCompany(Lond id)

    //addUserToCompany(Long userId, Long companyId)
}
