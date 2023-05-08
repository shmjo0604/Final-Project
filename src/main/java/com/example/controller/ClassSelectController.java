package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ActivityCate;
import com.example.dto.CityCate;
import com.example.service.ClassSelectService;

@Controller
@RequestMapping(value = "/class")
public class ClassSelectController {

    @Autowired ClassSelectService cService;

    @GetMapping(value = "select.do")
    public String selectGET(@RequestParam(name = "search", defaultValue = "", required = false) String search, Model model) {

        if(search.equals("")) {
            return "redirect:/class/select.do?search=list";
        }

        if(search.equals("list")) {
            List<ActivityCate> list1 = cService.selectActivityCateList();
            List<CityCate> list2 = cService.selectCityCateList();
            model.addAttribute("list1", list1);
            model.addAttribute("list2", list2);
        }

        else if(search.equals("map")) {

        }

        return "/class/select";
    }
    
}
