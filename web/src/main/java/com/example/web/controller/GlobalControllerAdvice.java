package com.example.web.controller;

import com.example.web.component.HeaderNavbar;
import com.example.web.component.navigation.NavBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice(basePackages = "com.example.web.controller")
public class GlobalControllerAdvice {
    private final HeaderNavbar headerNavbar;

    @Autowired
    public GlobalControllerAdvice(HeaderNavbar headerNavbar) {
        this.headerNavbar = headerNavbar;
    }

    @ModelAttribute("navBar")
    public List<NavBar> navBar() {
        return headerNavbar.getHeaderNavBar();
    }
}
