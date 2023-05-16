package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @GetMapping(value = "/join.do")
    public String joinGET() {

        return "/member/join";

    }

    @PostMapping(value = "/join.do")
    public String joinPOST() {

        return "redirect:/login.do";

    }

    @GetMapping(value = "/mypage.do")
    public String mypageGET() {

        return "/member/mypage";

    }

    @PostMapping(value = "/mypage.do")
    public String mypagePOST(
        @RequestParam(name = "menu", defaultValue = "0", required = false) int menu
    ) {

        return "redirect:/mypage.do?menu="+menu;
        
    }
    
}
