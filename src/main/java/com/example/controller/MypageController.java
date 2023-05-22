package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

    @GetMapping(value="/mypage.do")
    public String homeGET() {
        return "mypage/main";
    }


    
}
