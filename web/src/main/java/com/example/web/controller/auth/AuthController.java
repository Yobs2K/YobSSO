package com.example.web.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth/")
public class AuthController {

    @GetMapping("login")
    public ModelAndView getLoginPage(){
        return new ModelAndView("login");
    }
}
