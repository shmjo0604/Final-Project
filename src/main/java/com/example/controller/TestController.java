package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.Administrator;
import com.example.service.administrator.AdministratorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/test")
@Slf4j
@RequiredArgsConstructor
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

    /******************************************* admin 관련 추가 ******************************************* */
    
    BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
    @Autowired AdministratorService adService;
    
    // 관리자 등록
    @GetMapping(value="/insert.do")
    public String insertGET() {
        return "/admin/insert";
    }

    @PostMapping(value = "/insert.do")
    public String insertPOST( @ModelAttribute Administrator obj, HttpSession httpSession) {

        log.info("insert.do POST => {}", obj.toString());

        obj.setPassword(bcpe.encode(obj.getPassword()));

        int ret = adService.insertAdminOne(obj);

        if(ret==1) {
            return "redirect:/test/login.do";
        }
        return "redirect:/test/insert.do";
    }

     // 관리자 로그인
     @GetMapping(value="/login.do")
     public String loginGET() {
         return "/admin/login";
     }

    // Admin 메인화면
    @GetMapping(value = "/home.do")
    public String home1GET(){
        return "/admin/home";
    }
}
