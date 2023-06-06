package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Reply;
import com.example.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/reply")
@RequiredArgsConstructor
public class ReplyController {
    final String format ="ReplyController => {}";
    final ReplyRepository replyRepository;
 

    @GetMapping(value ="/insert.do")
    public String insertGET(@RequestParam(name = "no") long no,
        @AuthenticationPrincipal User user, Model model
    ){ 
        // Community community = CommunityRepository.findById(no);
    if(user != null) {
        model.addAttribute("user", user);
        System.out.println(user.toString());
    }

    // model.addAttribute("community", community );
    return "redirect:/community/selectone";
   
}
    @PostMapping(value = "/insert.do")
    public String insertPOST(@ModelAttribute Reply reply,
                             @AuthenticationPrincipal User user, Model model) {
        log.info(reply.toString());
        
        if (user != null) {
            reply.setContent(reply.getContent());
            Reply savedReply = replyRepository.save(reply);
            System.out.println(savedReply);
        }
    
        return "redirect:/community/selectone.do?no=" + reply.getCommunity().getNo();
    }
    
}
