package com.example.web.controller;

import com.example.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("")
public class GreetingsController {
    private final UserService userService;

    public GreetingsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView helloWorld(){
        return new ModelAndView("dashboard");
    }
}
