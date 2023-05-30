package com.example.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Community;
import com.example.repository.CommunityRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/community")
@RequiredArgsConstructor
public class CommunityController {
    final String format = "CommunityController => {}";
    final CommunityRepository communityRepository;
    
    // 커뮤니티 글작성
    @GetMapping(value = "/insert.do")
    public String insertGET(){ 
        return "/community/insert";
    }

    @PostMapping(value = "/insert.do")
    public String insertPOST( @ModelAttribute Community community){
        
        communityRepository.save(community);
    }
    //커뮤니티 게시판 보기
    @GetMapping(value = "/selectlist.do")
    public String selectlistGET(Model model) {
        List<Community> list = communityRepository.findAllByOrderByNoDesc();

        model.addAttribute("list", list);

        return "/community/communitylist";
    }
    //커뮤니티 게시판글 보기
    @GetMapping(value = "selectone.do")
    public String selectoneGET(Model model, @RequestParam(name = "no") long no) {
        Community community = communityRepository.findById(no).orElse(null);
        
        model.addAttribute("community", community);
        return "/community/selectone";

    }

}

