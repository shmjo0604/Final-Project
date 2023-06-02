package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.ClassProduct;
import com.example.repository.MainRepository;
import com.example.service.classproduct.ClassManageService;
import com.example.service.member.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
    
    final MainRepository mRepository;
    @Autowired ClassManageService cService;

    @GetMapping(value="/home.do")
    public String homeGET(@AuthenticationPrincipal User user,
        Model model
    ) {
        // long mainImg = manageService.selectClassMainImageNo(classcode);
        
        List<ClassProduct> list = mRepository.findAllTopSixByOrderByClasscodeDesc();
        if(!list.isEmpty()){
            for (ClassProduct obj : list ) {
                System.out.println(obj.getClasscode());
                long mainImg = cService.selectClassMainImageNo(obj.getClasscode());
                obj.setMainImg(mainImg);
            }
        }

        model.addAttribute("list", list);
            log.info("select one=> {}", list);
        
        return "home";
    }

    @GetMapping(value="/login.do")
    public String loginGET() {

        return "login";
        
    }

    @GetMapping(value = "/logout.do")
    public String logoutGET(HttpServletRequest request,
    HttpServletResponse response) {
        
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    
    if (authentication != null) {
        new SecurityContextLogoutHandler().logout(request, response, authentication);
    }
    return "redirect:/login.do";

    }

    @GetMapping(value = "/alert.do")
    public String alertGET(HttpSession httpSession, Model model) {

        model.addAttribute("alertMessage", httpSession.getAttribute("alertMessage"));
        model.addAttribute("alertUrl", httpSession.getAttribute("alertUrl"));
        
        httpSession.removeAttribute("alertMessage");
        httpSession.removeAttribute("alertUrl");

        return "alert";
    }

    @GetMapping(value = "/403error.do")
    public String error403GET() {
        return "403";
    }

}
