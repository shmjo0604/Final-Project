package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ClassUnitView;
import com.example.dto.Member;
import com.example.service.classproduct.ClassManageService;
import com.example.service.classproduct.ClassUnitService;
import com.example.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/apply")
@Slf4j
public class ApplyController {

    final String format = "ApplyController => {}";

    @Autowired ClassUnitService unitService;
    @Autowired ClassManageService manageService;
    @Autowired MemberService mService;

    @GetMapping(value = "/insert.do")
    public String applyGET(
        Model model, 
        @AuthenticationPrincipal User user,
        @RequestParam(name = "unitno", defaultValue = "0", required = false) long unitno,
        @RequestParam(name = "person", defaultValue = "0", required = false) int person) {

        log.info(format, unitno);
        log.info(format, person);

        if(unitno == 0 || person == 0) {
            return "redirect:/class/select.do";
        }

        ClassUnitView obj = unitService.selectClassUnitViewOne(unitno);

        //log.info(format, obj.toString());

        if(obj.getMaximum()-obj.getCnt() < person) {

            // httpsession에 message, url 저장
            return "redirect:/alert.do";
        }

        long mainImg = manageService.selectClassMainImageNo(obj.getClasscode());

        if(user != null) {

            String id = user.getUsername();
            Member member = mService.selectMemberOne(id);
            model.addAttribute("member", member);
            
        }

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

    @GetMapping(value = "/insertbatch.do")
    public String applybatchGET(@RequestParam(name = "unitno[]", required = false) List<Long> unitnoList, @RequestParam(name = "person[]", required = false) List<Long> personList) {

        return "/apply/insert";
    }
    
}
