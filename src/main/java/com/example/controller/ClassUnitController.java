package com.example.controller;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/classunit")
public class ClassUnitController {

    @GetMapping(value = "/myunit.do")
    public String myunitGET(
        @RequestParam(name = "menu", defaultValue = "0") int menu,
        @AuthenticationPrincipal User user,
        Model model) {

        String id = user.getUsername();

        if(menu == 0){
            return "redirect:/classunit/myunit.do?menu=1";
        }

        if(menu == 1){
            
        }

        else if(menu == 2){

        }

        return "/classunit/unit";
    }
    
}
