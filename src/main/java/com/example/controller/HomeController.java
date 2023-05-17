package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value="/home.do")
    public String homeGET() {

        return "home";
    }

    @GetMapping(value="/login.do")
    public String loginGET() {

        return "login";
        
    }

    @GetMapping(value = "/test.do")
    public String testGET() {

        return "header1";
    }

    @GetMapping(value = "/headerlist.do")
    public String headerlistGET() {

        return "headerlist";
    }

    
    
}
