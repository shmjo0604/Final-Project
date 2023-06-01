package com.example.controller;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/classunit")
public class ClassUnitController {

    final String format = "ClassUnitController => {}";

    @GetMapping(value = "/myunit.do")
    public String myunitGET(
        @RequestParam(name = "menu", defaultValue = "0") int menu,
        @RequestParam(name = "classcode", defaultValue = "0", required = false) long classcode,
        @AuthenticationPrincipal User user,
        Model model) {

        log.info(format, classcode);

        if(menu == 0){
            return "redirect:/classunit/myunit.do?menu=1";
        }

        if(menu == 1){
            
        }

        else if(menu == 2){

        }

        model.addAttribute("user", user);

        return "/classunit/unit";
    }
}
