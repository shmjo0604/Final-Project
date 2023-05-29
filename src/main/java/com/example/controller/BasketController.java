package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.basket.BasketService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/basket")
@Slf4j
public class BasketController {

    final String format = "BasketController => {}";

    @Autowired BasketService bService;

    // 127.0.0.1:8080/specialday/basket/basket.do
    @GetMapping(value = "/basket.do")
    public String  BasketGET() {
        try{
            return "/member/basket";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home.do";
        }
    }
}
