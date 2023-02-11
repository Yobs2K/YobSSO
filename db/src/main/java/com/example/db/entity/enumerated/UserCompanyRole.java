package com.example.db.entity.enumerated;

public enum UserCompanyRole {
    USER,
    ADMIN,
    OWNER
    ;

    public boolean hasAccess(UserCompanyRole role){
        return this.ordinal() <= role.ordinal();
    }
}
