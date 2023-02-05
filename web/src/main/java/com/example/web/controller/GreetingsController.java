package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller("")
public class GreetingsController {

    @GetMapping
    public ModelAndView helloWorld(){
        return new ModelAndView("dashboard");
    }
}
