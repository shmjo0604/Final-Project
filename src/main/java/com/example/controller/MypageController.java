package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MypageController {

    @GetMapping(value="/mypage.do")
    public String homeGET(@RequestParam(name = "menu") long menu) {

        // 메뉴번호 파라미터 받아오기

        // 초기화면 menu_apply로 설정

        // #1 신청관리

        // #2 리뷰관리

        // #3 문의내역

        // #4-1 계정관리-개인정보변경
        // #4-2 계정관리-비밀번호재설정
        // #4-3 계정관리-탈퇴하기

        return "mypage/main";
    }


    
}
