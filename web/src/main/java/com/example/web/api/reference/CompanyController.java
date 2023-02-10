package com.example.web.api.reference;

import com.example.core.model.AuthUser;
import com.example.web.form.CreateCompanyForm;
import com.example.web.model.CompanyWebModel;
import com.example.web.service.CompanyWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<CompanyWebModel> getAllCompaniesPageable(Pageable pageable) {
        return companyWebService.findAllCompaniesPageable(pageable);
    }

    @GetMapping("/belongTo") // Придумать адрес получше
    public List<CompanyWebModel> getAllAuthUserCompanies(@AuthenticationPrincipal AuthUser authUser) {
        return companyWebService.findAllAuthUserCompanies(authUser.getUserModel());
    }

    @GetMapping("/admin") // Придумать адрес получше
    public List<CompanyWebModel> getAllAuthUserIsAdminCompanies(@AuthenticationPrincipal AuthUser authUser) {
        return companyWebService.findAllAuthUserIsAdminCompanies(authUser.getUserModel());
    }

    @GetMapping("/{id}")
    public CompanyWebModel getCompanyById(@PathVariable Long id) {
        return companyWebService.findCompanyById(id);
    }

    @PostMapping("")
    public CompanyWebModel createCompany(@AuthenticationPrincipal AuthUser authUser, CreateCompanyForm companyForm) {
        return companyWebService.addCompany(companyForm, authUser.getUserModel().getId());
    }

    //PreAuthorize - ADMIN
    @PutMapping("/{id}")
    public CompanyWebModel updateCompany(
            @AuthenticationPrincipal AuthUser authUser,
            CreateCompanyForm companyForm,
            @PathVariable Long id)
    {
        return companyWebService.updateCompany(companyForm, id, authUser.getUserModel().getId());
    }

    @DeleteMapping("/{id}")
    public CompanyWebModel deleteCompany(@PathVariable Long id) {
        return companyWebService.deleteCompany(id);
    }

    @PostMapping("/{companyId}")
    public CompanyWebModel addUserToCompany(@PathVariable Long companyId, @RequestParam("user_id") Long userId){
        return companyWebService.addUserToCompany(userId, companyId);
        // Может быть лучше сделать, чтобы отправлялся не параметр user_id, а объект UserWebModel
    }

}
