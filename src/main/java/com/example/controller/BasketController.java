package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Basket;
import com.example.entity.Member;
import com.example.service.basket.BasketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/member")
@RequiredArgsConstructor

public class BasketController {

    final String format = "BasketController => {}";

    @Autowired BasketService bService;

    @PostMapping(value = "/basket.do")
    public String BasketPOST(Basket basket, HttpServletRequest request) {
        // 로그인 체크
        HttpSession session = request.getSession();
        Member id = (Member)session.getAttribute("member");
        if(id == null) {
            return "0";
        }

        // 카드 등록

        int result = bService.insertBasketOne(basket);

        return result + "";

    }

    // 2. 카트 목록
    @GetMapping(value = "/member/basket/{memberId}")
	public String basketPageGET(@PathVariable("memberid") String memberId, Model model) {
		
		model.addAttribute("cartInfo", bService.BasketList(memberId));
		
		return "/home";
	}

    // 3. 상품 정보 수정
    @PostMapping(value = "/basket/update")
    public String updateBasketPOST(Basket obj) {

        bService.updateBasketOne(obj);

        return "redirect:/basket/" + obj.getMember(); 

    }

    // 3. 상품 정보 삭제
    @PostMapping(value = "/basket/delete")
    public String deleteBasketPOST(int obj) {

        bService.deleteBasketOne(obj);

        return "redirect:/basket/" + obj; 

    }




    // 장바구니 페이지 접속
    // 127.0.0.1:8080/specialday/member/basket.do
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
