package com.example.web.controller;

import com.example.core.model.AuthUser;
import com.example.web.form.CreateCompanyForm;
import com.example.web.model.CompanyWebModel;
import com.example.web.service.CompanyWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
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
    public ModelAndView getAllCompanies(Pageable pageable) {
        return new ModelAndView("companies")
                .addObject(companyWebService.findAllCompaniesPageable(pageable));
    }

    @GetMapping("/mine")
    public ModelAndView getAllAuthUserCompanies(@AuthenticationPrincipal AuthUser authUser) {
        return new ModelAndView("companies")
                .addObject(
                        companyWebService.findAllAuthUserCompanies(authUser.getUserModel().getId())
                );
    }

    @GetMapping("/owned")
    public ModelAndView getAllOwnedCompanies(@AuthenticationPrincipal AuthUser authUser) {
        return new ModelAndView("companies")
                .addObject(
                        companyWebService.findAllOwnedCompanies(authUser.getUserModel().getId())
                );
    }

    @GetMapping("/{id}")
    public ModelAndView getCompany(@PathVariable Long id) {
        return new ModelAndView("company_info")
                .addObject(companyWebService.findCompanyById(id));
    }

    // Пока не знаю как правильно реализовать, возможно это лучше делать уже в UserWebService, а не в CompanyWebService

    /*@GetMapping("/{companyId}/users")
    public ModelAndView getCompanyUsers(@AuthenticationPrincipal AuthUser authUser, @PathVariable Long companyId) {
        ModelAndView modelAndView = new ModelAndView("company_users.ftlh")
                .addObject(companyWebService.findAllCompanyUsers(companyId));
        return modelAndView;
    }*/

    @PostMapping("")// Должен быть другой адрес
    public ModelAndView createCompany(@AuthenticationPrincipal AuthUser authUser, CreateCompanyForm companyForm) {
        CompanyWebModel companyWebModel = companyWebService.addCompany(companyForm, authUser.getUserModel().getId());
        return new ModelAndView(
                String.format("redirect:/api-web/company/%d", companyWebModel.getId())
        );
    }

    @PreAuthorize("@companySecurityService.hasAccess(#authUser, #id, 'OWNER')")
    @PutMapping("/{id}")
    public ModelAndView updateCompany(
            @AuthenticationPrincipal AuthUser authUser,
            CreateCompanyForm companyForm,
            @PathVariable Long id
    ) {
        return new ModelAndView("company_info").addObject(
                companyWebService.updateCompany(companyForm, id, authUser.getUserModel().getId())
        );
    }

    @PreAuthorize("@companySecurityService.hasAccess(#authUser, #id, 'OWNER')")
    @DeleteMapping("/{id}")
    public ModelAndView deleteCompany(@AuthenticationPrincipal AuthUser authUser, @PathVariable Long id) {
        return new ModelAndView("company_info")
                .addObject(companyWebService.deleteCompany(id));
    }

    @PreAuthorize("@companySecurityService.hasAccess(#authUser, #companyId, 'ADMIN')")
    @PostMapping("/{companyId}/users")
    public ModelAndView addUser(
            @AuthenticationPrincipal AuthUser authUser,
            @PathVariable Long companyId,
            @RequestParam("user_id") Long userId
    ) {
        // companyWebService.addUserToCompany() возвращает UserToCompany а должен быть List<UserWebModel>,
        // но для этого по идее нужен UserWebService
        return new ModelAndView("company_users")
                .addObject(companyWebService.addUserToCompany(userId, companyId));
    }
}
