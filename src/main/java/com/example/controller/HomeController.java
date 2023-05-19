package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        return "test";
    }

    @GetMapping(value = "/header1.do")
    public String header1GET() {

        return "header1";
    }

    @GetMapping(value = "/headerlist.do")
    public String headerlistGET() {

        return "headerlist";
    }

    @GetMapping(value = "/alert.do")
    public String alertGET(HttpSession httpSession, Model model) {

        model.addAttribute("alertMessage", httpSession.getAttribute("alertMessage"));
        model.addAttribute("alertUrl", httpSession.getAttribute("alertUrl"));

        return "alert";
    }

    @GetMapping(value = "/403error.do")
    public String error403GET() {
        return "403";
    }

    
    
}
