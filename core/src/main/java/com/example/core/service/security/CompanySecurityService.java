package com.example.core.service.security;

import com.example.core.model.AuthUser;
import com.example.core.service.UserToCompanyService;
import com.example.db.entity.UserToCompany;
import com.example.db.entity.enumerated.UserCompanyRole;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component("companySecurityService")
public class CompanySecurityService {
    private final UserToCompanyService userToCompanyService;

    @Autowired
    public CompanySecurityService(UserToCompanyService userToCompanyService) {
        this.userToCompanyService = userToCompanyService;
    }

    public boolean hasAccess(AuthUser authUser, @NotNull Long companyId, @NotNull String minRole) {
        if (Objects.isNull(authUser) || Objects.isNull(companyId) || Objects.isNull(minRole))
            return false;

        Optional<UserToCompany> userToCompanyOptional =
                userToCompanyService.findByCompanyIdAndUserId(authUser.getUserModel().getId(), companyId);

        if (userToCompanyOptional.isEmpty())
            return false;

        UserToCompany userToCompany = userToCompanyOptional.get();
        UserCompanyRole userCompanyRole = UserCompanyRole.valueOf(minRole);

        if (userCompanyRole.hasAccess(userToCompany.getUserRole()))
            return true;

        return false;
    }
}
