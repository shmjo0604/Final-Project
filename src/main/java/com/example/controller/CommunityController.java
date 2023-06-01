package com.example.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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
    private Object Community;

    // 커뮤니티 글작성
    @GetMapping(value = "/insert.do")
    public String insertGET(
            @AuthenticationPrincipal User user,
            Model model) {
        if (user != null) {
            model.addAttribute("user", user);
        }

        return "/community/insert";
    }

    @PostMapping(value = "/insert.do")
    public String insertPOST(
            @ModelAttribute Community community,
            @AuthenticationPrincipal User user, Model model) throws IOException {
        if (user != null) {
            System.out.println(community.toString());

            // communityRepository.save(community);

        }
        return "redirect:/community/selectlist.do";
    }

    // 커뮤니티 게시판 보기
    @GetMapping(value = "/selectlist.do")
    public String selectlistGET(Model model, @AuthenticationPrincipal User user) {
        List<Community> list = communityRepository.findAllByOrderByNoDesc();
        model.addAttribute("list", list);

        return "/community/selectlist";
    }

    // 커뮤니티 게시판글 보기
    @GetMapping(value = "selectone.do")
    public String selectoneGET(Model model, @RequestParam(name = "no") long no) {
        Community community = communityRepository.findByNo(no);

        model.addAttribute("community", community);
        return "/community/selectone";

    }

    @PostMapping(value = "updateone.do")
    public String updateonePOST(@RequestParam(name = "no") long no,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content,
            @AuthenticationPrincipal User user) {
        try {
           
            Community community = communityRepository.findById(no).orElse(null);
            community.setTitle(title);
            community.setContent(content);

          

            communityRepository.save(community);
            return "redirect:/community/selectlist.do";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home.do";
        }
    }

    @PostMapping(value = "/delete.do")
    public String deletePOST( @AuthenticationPrincipal User user,
    Model model ,@RequestParam(name = "no")long no){
        try {
            
            communityRepository.deleteByNo(no);
            return "redirect:/community/selectlist.do";
        } catch (Exception e) {
          e.printStackTrace();
          return"redirect:/home.do";
        }
    }
}
