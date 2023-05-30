package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.ClassUnitView;
import com.example.service.classproduct.ClassManageService;
import com.example.service.classproduct.ClassUnitService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/apply")
@Slf4j
public class ApplyController {

    final String format = "ApplyController => {}";

    @Autowired ClassUnitService unitService;
    @Autowired ClassManageService manageService;

    @GetMapping(value = "/insert.do")
    public String applyGET(Model model, HttpSession httpSession, @AuthenticationPrincipal User user) {

        long unitno = (long)httpSession.getAttribute("unitno");
        int person = (int)httpSession.getAttribute("person");

        log.info(format, unitno);
        log.info(format, person);

        httpSession.removeAttribute("unitno");
        httpSession.removeAttribute("person");

        ClassUnitView obj = unitService.selectClassUnitViewOne(unitno);

        //log.info(format, obj.toString());

        long mainImg = manageService.selectClassMainImageNo(obj.getClasscode());

        model.addAttribute("obj", obj);
        model.addAttribute("mainImg", mainImg);
        model.addAttribute("person", person);
        model.addAttribute("user", user);
        
        return "/apply/insert";
        
    }

    @PostMapping(value = "/insert.do")
    public String applyPOST() {

        return "redirect:/home.do";
    }
    
}
