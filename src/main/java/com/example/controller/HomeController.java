package com.example.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value="/home.do")
    public String homeGET(@AuthenticationPrincipal User user, Model model) {

        model.addAttribute("user", user);

        return "home";
    }

    @GetMapping(value="/login.do")
    public String loginGET() {
        return "login";
    }

    
    
}
