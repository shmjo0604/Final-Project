package com.example.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ApplyView;
import com.example.dto.ClassUnit;
import com.example.mapper.ClassUnitMapper;
import com.example.service.apply.ApplyService;
import com.example.service.classproduct.ClassUnitService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping(value = "/classunit")
public class ClassUnitController {

    final String format = "ClassUnitController => {}";    
    
    @Autowired ClassUnitService cuService;
    @Autowired ApplyService aService;
    

    @GetMapping(value = "/myunit.do")
    public String myunitGET(
        @RequestParam(name = "menu", defaultValue = "0") int menu,
        @RequestParam(name = "classcode", defaultValue = "0") long classcode,
        @AuthenticationPrincipal User user,
        Model model) {
        Map<String,Object> map = new HashMap<String,Object>();
        
        if(menu == 0 & classcode == 0){
            return "redirect:/classunit/myunit.do?menu=1";
        }

        if(menu == 1) {
            long defaultPrice = cuService.selectPriceOne(classcode);
            List<ClassUnit> list = cuService.selectUnitListToCal(classcode);
            log.info(format, list.toString());

            model.addAttribute("classcode", classcode);
            model.addAttribute("defaultPrice", defaultPrice);
            model.addAttribute("list", list);
        }

        else if(menu == 2){

            map.put("classcode", classcode);
                        
            List<ApplyView> list = aService.selectApplyViewListByClasscode(map);
            // log.info(format, list);

            model.addAttribute("classcode", classcode);
            model.addAttribute("list", list);
        }

        model.addAttribute("user", user);
        return "/classunit/unit";
    }
    
}
