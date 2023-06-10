package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/test.do")
    public String testGET() {

        return "test";
    }

    @GetMapping(value = "/test1.do")
    public String test1GET() {
        return "/test/selectone";
    }

    @GetMapping(value = "/applytest.do")
    public String header1GET(@AuthenticationPrincipal User user, Model model) {

        model.addAttribute("user", user);
        
        return "/apply/insert";
    }

    @GetMapping(value = "/test2.do")
    public String headerlistGET() {

        return "/test/productdetail";
    }

    // 임시 admin화면 연결용
    @GetMapping(value = "/home.do")
    public String home1GET(){
        return "/admin/home";
    }

}
