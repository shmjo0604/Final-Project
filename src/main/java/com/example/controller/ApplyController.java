package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.Apply;
import com.example.dto.ApplyList;
import com.example.dto.ClassUnitView;
import com.example.service.classproduct.ClassUnitService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/apply")
@Slf4j
public class ApplyController {

    final String format = "ApplyController => {}";

    @Autowired ClassUnitService unitService;

    @GetMapping(value = "/insert.do")
    public String applyGET(@ModelAttribute ApplyList applyList, Model model, HttpSession httpSession) {
        return "/apply/insert";

        // List<Apply> list = applyList.getApplylist();
        
        // log.info(format, list.toString());

        // int outcome=1;

        // List<ClassUnitView> infolist = new ArrayList<>();

        // for(Apply obj : list) {

        //     ClassUnitView result = unitService.selectClassUnitViewOne(obj.getUnitno());

        //     int remain = result.getMaximum()-result.getCnt();

        //     if(remain > obj.getPerson()) {
        //         result.setPerson(obj.getPerson());
        //         infolist.add(result);
        //     }
        //     else {
        //         outcome = 0;
        //         String message = "신청 인원을 초과하여 신청이 불가능합니다.";
        //         httpSession.setAttribute("message", message);
        //         // httpSession.setAttribute("url", ); 주소는 장바구니 url로 이동을 시켜야겠네, 어디서 왔는지를 확인할 수 있으면 좋지
        //     }
            
        // }

        // if(outcome == 0) {

        //     return "redirect:/alert.do";
            
        // }

        // model.addAttribute("list", infolist);
        // return "/apply/insert";
        
    }

    @PostMapping(value = "/insert.do")
    public String applyPOST() {

        return "redirect:/home.do";
    }
    
}
