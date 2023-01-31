package com.example.web.controller;

import com.example.core.assemblers.TestClass;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("")
public class GreetingsController {
    private final TestClass testClass;

    public GreetingsController(TestClass testClass) {
        this.testClass = testClass;
    }

    @GetMapping
    @ResponseBody
    public String helloWorld(){
        return "helloWorld";
    }
}
