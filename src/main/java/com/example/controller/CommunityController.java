package com.example.controller;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

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

    //dddd
    final String format = "CommunityController => {}";
    final CommunityRepository communityRepository;
    final HttpSession hSession;

    // 커뮤니티 글작성
    @GetMapping(value = "/insert.do")
    public String insertGET(
            @AuthenticationPrincipal User user,
            Model model) {

        if (user != null) {
            model.addAttribute("user", user);
            System.out.println(user.toString());
        }

        return "/community/insert";
    }

    @PostMapping(value = "/insert.do")
    public String insertPOST(
            @ModelAttribute Community community,
            @AuthenticationPrincipal User user, Model model) throws IOException {

        if (user != null) {

            community.getCate();
            community.getTitle();
            community.getContent();

            Community ret = communityRepository.save(community);
            System.out.println(ret);

        }
        return "redirect:/community/selectlist.do";
    }

    // 커뮤니티 게시판 보기
    @GetMapping(value = "/selectlist.do")
    public String selectlistGET(Model model, @AuthenticationPrincipal User user) {

        List<Community> list = communityRepository.findAllByOrderByNoDesc();

        if (user != null) {
            model.addAttribute("user", user);
            System.out.println(user.toString());
        }

        for (Community obj : list) {
            log.info(format, obj.toString());
        }

        model.addAttribute("list", list);

        return "/community/selectlist";
    }

    // 커뮤니티 게시판글 보기
    @GetMapping(value = "/selectone.do")
    public String selectoneGET(Model model, @RequestParam(name = "no") long no, @AuthenticationPrincipal User user) {
        Community community = communityRepository.findByNo(no);



        if (user != null) {
            model.addAttribute("user", user);
            System.out.println(user.toString());
        }

        model.addAttribute("community", community);
        return "/community/selectone";

    }

    @PostMapping(value = "/delete.do")
    public String deletePOST(@AuthenticationPrincipal User user, @ModelAttribute Community obj,
            Model model) {
        try {
            log.info(format, obj.toString());

            communityRepository.deleteById(obj.getNo());

            return "redirect:/community/selectlist.do";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home.do";
        }
    }
    
    @GetMapping(value = "/update.do")
    public String updateGET(@AuthenticationPrincipal User user,
                            @ModelAttribute Community community,
                            @RequestParam(name = "no") long no,
                            Model model) {

        Community com = communityRepository.findById(no).orElse(null);
        log.info(format, com.toString());
   

        if (user != null) {
            model.addAttribute("user", user);
            System.out.println(user.toString());
        }

        model.addAttribute("community", com);
        return "community/update";
    }

    @PostMapping(value = "/update.do")
    public String updatePOST(@AuthenticationPrincipal User user, @ModelAttribute Community community,
                            @RequestParam(name = "no",defaultValue = "0",required = false) long no )
                            throws IOException {

        try {

            log.info("nocheck => {}",no);

            if(no != 0 ) {
                Optional<Community> updateCom = communityRepository.findById(no);
               
                if(updateCom.isPresent()){
                    Community obj = updateCom.get();
                    obj.setCate(community.getCate());
                    obj.setTitle(community.getTitle());
                    obj.setContent(community.getContent());

                    communityRepository.save(obj);
                }
                return "redirect:/community/update.do?no="+no;    
            }
            return "redirect:/community/update.do";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/community/selectlist.do";
        }
       
    } 

}
