package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.Administrator;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    @GetMapping(value = "/home.do")
    public String homeGET() {
        return "/admin/home";
    }

    @GetMapping(value = "/login.do")
    public String loginGET() {
        return "/admin/login";
    }
   
    

}
