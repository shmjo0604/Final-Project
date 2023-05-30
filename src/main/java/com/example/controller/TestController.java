package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = "/customercenter.do")
    public String customercenterGET(
        @RequestParam(name = "menu", defaultValue = "0") int menu,
        @AuthenticationPrincipal User user,
        Model model
    ) {
        String id = user.getUsername();
        
        if(menu == 0) {
            return "redirect:/test/customercenter.do?menu=1";
        }
    
         if(menu == 1) {
            
        }

        else if(menu == 2) {
    
        }

        model.addAttribute("user", user);

        return "/inquery/customercenter";
            
        }

@PostMapping(value = "/customercenter.do")
public String customercenterPOST() {

    return "redirect:/test/customercenter.do?menu=1";
}

}
