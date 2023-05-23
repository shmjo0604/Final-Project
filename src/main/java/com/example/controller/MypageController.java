package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MypageController {

    final String format = "MypageController => {}";

    @GetMapping(value="/mypage.do")
    public String myppageGET() {
        return "mypage/main";
    }

}
