package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("")
public class GreetingsController {

    @GetMapping
    @ResponseBody
    public String helloWorld(){
        return "helloWorld";
    }
}
