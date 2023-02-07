package com.example.db.entity.enumerated;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserCompanyRoleTest {

    @Test
    public void hasAccess(){
        Assertions.assertTrue(UserCompanyRole.ADMIN.hasAccess(UserCompanyRole.ADMIN));
        Assertions.assertFalse(UserCompanyRole.ADMIN.hasAccess(UserCompanyRole.USER));
        Assertions.assertTrue(UserCompanyRole.USER.hasAccess(UserCompanyRole.USER));
        Assertions.assertTrue(UserCompanyRole.USER.hasAccess(UserCompanyRole.ADMIN));

    }


    @Test
    public void ordinalTest(){
        Assertions.assertEquals(UserCompanyRole.ADMIN.ordinal(), 1);
        Assertions.assertEquals(UserCompanyRole.USER.ordinal(), 0);
    }
}