package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.Member;
import com.example.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/member")
public class MemberController {

    final String format = "MemberController => {}";

    @Autowired MemberService mService;

    BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();

    @GetMapping(value = "/join.do")
    public String joinGET() {

        return "/member/join";

    }

    @PostMapping(value = "/join.do")
    public String joinPOST(@ModelAttribute Member obj, HttpSession httpSession) {

        log.info(format, obj.getPassword());

        obj.setPassword(bcpe.encode(obj.getPassword()));

        int ret = mService.insertMemberOne(obj);

        log.info(format, ret);

        if(ret == 1) {
            httpSession.setAttribute("alertMessage", "회원 가입 완료했습니다.");
            httpSession.setAttribute("alertUrl", "/home.do");
            return "redirect:/alert.do";
        }
        else {
            return "redirect:/member/join.do";
        }

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
