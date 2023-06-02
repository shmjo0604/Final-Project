package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ApplyView;
import com.example.dto.ClassImage;
import com.example.dto.ClassProduct;
import com.example.dto.Member;
import com.example.entity.ClassInquiryView;
import com.example.repository.ClassInquiryViewRepository;
import com.example.service.apply.ApplyService;
import com.example.service.classproduct.ClassManageService;
import com.example.service.classproduct.ClassSelectService;
import com.example.service.member.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

    final String format = "MemberController => {}";
    final ClassInquiryViewRepository civRepository;

    @Autowired MemberService mService;
    @Autowired ClassManageService cService; 
    @Autowired ClassSelectService c1Service;
    @Autowired ApplyService aService;


    BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();

    @GetMapping(value = "/join.do")
    public String joinGET(@AuthenticationPrincipal User user, Model model) {

        model.addAttribute("user", user);
        
        return "/member/join";

    }

    @PostMapping(value = "/join.do")
    public String joinPOST(@ModelAttribute Member obj, HttpSession httpSession) {

        log.info(format, obj.getPassword());

        obj.setPassword(bcpe.encode(obj.getPassword()));

        int ret = mService.insertMemberOne(obj);

        log.info(format, ret);

        if(ret == 1) {
            // httpSession.setAttribute("alertMessage", "회원 가입 완료했습니다.");
            // httpSession.setAttribute("alertUrl", "/home.do");
            return "redirect:joinsuccess.do";
        }
        else {
            return "redirect:/member/join.do";
        }

    }

    @GetMapping(value = "/joinsuccess.do")
    public String joinsuccessGET() {

        return "/member/joinsuccess";
    }

    @GetMapping(value = "/mypage.do")
    public String mypageGET(
        @RequestParam(name = "menu", defaultValue = "0") int menu,
        @AuthenticationPrincipal User user,
        Model model) {

        // String id = user.getUsername();
        Map<String,Object> map = new HashMap<String,Object>();
        List<ApplyView> list = new ArrayList<>();
        String id =user.getUsername();
       

        if(menu == 0) {
            return "redirect:/member/mypage.do?menu=1";
        }

        if(menu == 1) {
            map.put("id",user.getUsername());
            map.put("first",1);
            map.put("last",10);
            list = aService.selectApplyListById(map);
            
            // return "redirect:/member/mypage.do?menu=1";
        }

        else if(menu == 2) {

        }

        else if(menu == 3) {

        }

        else if(menu == 4) {
            Member obj = mService.selectMemberOne(id);
            //slog.info(format, obj.toString());
            model.addAttribute("obj", obj);
        }

        log.info(format,list.toString());
        System.out.println("--------------------------------------------------------------------------------");
        log.info(format,list.get(0).toString());
        model.addAttribute("list", list);
        model.addAttribute("user", user);

        return "/member/mypage/mypage";

    }

    @PostMapping(value = "/mypage.do")
    public String mypagePOST(
        @RequestParam(name = "menu", defaultValue = "0", required = false) int menu
    ) {

        return "redirect:/mypage.do?menu="+menu;
        
    }


    @GetMapping(value = "/myclass.do")
    public String myclassGET(
        @RequestParam(name = "menu", defaultValue = "0") int menu,
        @RequestParam(name = "classcode", defaultValue = "0", required = false) long classcode,
        @RequestParam(name = "no", defaultValue = "0", required = false) long no,
        @RequestParam(name="page", required = false) Integer page, @RequestParam(name="size", required = false) Integer size,
        @AuthenticationPrincipal User user,
        Model model
    ) {
        String owner = user.getUsername();
        String id = user.getUsername();

        if(menu == 0) {
            // return "member/myclass_menu1";
            return "redirect:/member/myclass.do?menu=1";
        }

        if(menu == 1) {
            List<ClassProduct> list = cService.selectMyClassList(id);
            model.addAttribute("list", list);
            
            log.info("myclass selectlist => {}", list.toString());
        }

        else if(menu == 2) {
            // PageRequest pageRequest = PageRequest.of(page, size);
            
            List<ClassInquiryView> list = cService.selectClassInquiryList(owner);
            // System.out.println("test용=>", list.toString());
            
            ClassInquiryView obj2 = cService.selectClassInquiryOne(no);

            model.addAttribute("list", list);
            model.addAttribute("obj2", obj2 );

            log.info("myclass inquiry selectlist => {}", list.toString());
        }

        model.addAttribute("user", user);
        return "/member/myclass";
    }

    @PostMapping(value = "/myclass.do")
    public String myclassPOST(
        @RequestParam(name = "menu", defaultValue = "0", required = false) int menu
    ){
        return "redirect:/myclass.do?menu="+menu;
    }

    //이미지 뛰우기 
    @GetMapping(value = "/image")
    public ResponseEntity<byte[]> image(@RequestParam(name = "no", defaultValue = "0") long no)
    throws IOException {
        System.out.println(no);
        ClassImage obj = manageService.selectClassImageOne(no);
        System.out.println(obj);
  
        HttpHeaders headers = new HttpHeaders(); //import org.springframework....
    
        if (obj != null) { // 이미지가 존재하는지 확인
            if (obj.getFilesize() > 0) {
                headers.setContentType(MediaType.parseMediaType(obj.getFiletype()));
                return new ResponseEntity<>(obj.getFiledata(), headers, HttpStatus.OK);
            }
        }

        // 이미지가 없을경우
        InputStream is = resourceLoader.getResource(defaultImg).getInputStream(); // exception발생됨
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(is.readAllBytes(),headers,HttpStatus.OK);
    }
    // @PostMapping(value = "/myclass/inquiry.do")
    // public String myClassInquiryPOST(
    //     @ModelAttribute ClassInquiryView obj,
    //     Model model
    // ){

    //     return "/member/myclass";
    // }


}
