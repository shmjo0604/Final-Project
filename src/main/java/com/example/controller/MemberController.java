package com.example.controller;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.example.dto.ApplyStatusView;
import com.example.dto.ApplyView;
import com.example.dto.ClassImage;
import com.example.dto.ClassProduct;
import com.example.dto.Member;
import com.example.entity.ClassInquiryView;
import com.example.entity.Reviewview;
import com.example.repository.ClassInquiryViewRepository;
import com.example.service.apply.ApplyService;
import com.example.service.classproduct.ClassManageService;
import com.example.service.classproduct.ClassSelectService;
import com.example.service.member.MemberService;
import com.example.service.review.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

    final String format = "MemberController => {}";
    final ClassInquiryViewRepository civRepository;

    @Autowired
    MemberService mService;
    @Autowired
    ClassManageService cService;
    @Autowired
    ClassSelectService c1Service;
    @Autowired
    ApplyService aService;
    @Autowired
    ClassManageService manageService;

    @Autowired
    ReviewService r1Service;

    @Autowired
    ResourceLoader resourceLoader;
    @Value("${default.image}")
    String defaultImg;

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

        if (ret == 1) {
            // httpSession.setAttribute("alertMessage", "회원 가입 완료했습니다.");
            // httpSession.setAttribute("alertUrl", "/home.do");
            return "redirect:joinsuccess.do";
        } else {
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
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "no", defaultValue = "0") int no,
            @RequestParam(name = "chk", defaultValue = "0") int chk,
            @AuthenticationPrincipal User user,
            Model model) {

        log.info(format, "chk=" + chk);

        // String id = user.getUsername();
        Map<String, Object> map = new HashMap<String, Object>();
        List<ApplyView> list = new ArrayList<>();
        List<Reviewview> list1 = new ArrayList<>();
        // List<ApplyStatusView> listOne = new ArrayList<>();

        int first = page * 5 - 4;
        int last = page * 5;

        String id = user.getUsername();

        long chk1 = 0;
        long chk2 = 0;
        long chk3 = 0;

        long pages = 0;
        long cnt = aService.countApplyList(id);
        // long cntOne =

        if (menu == 0) {
            // map.put("id", user.getUsername());
            // map.put("first", first);
            // map.put("last", last);
            // list = aService.selectApplyListById(map);

            // chk1 = aService.countApplyListOne(id);
            // chk2 = aService.countApplyListTwo(id);
            // chk3 = aService.countApplyListThree(id);

            // model.addAttribute("list", list);
            // model.addAttribute("pages", (cnt - 1) / 5 + 1);

            // model.addAttribute("chk1", chk1);
            // model.addAttribute("chk2", chk2);
            // model.addAttribute("chk3", chk3);

            return "redirect:/member/mypage.do?menu=1&page=1";
        }

        if (menu == 1) {
            if (chk == 1) {

                map.put("id", user.getUsername());
                map.put("first", first);
                map.put("last", last);
                list = aService.selectApplyListByIdOne(map);

                pages = aService.countApplyListOne(id);

                chk1 = aService.countApplyListOne(id);
                chk2 = aService.countApplyListTwo(id);
                chk3 = aService.countApplyListThree(id);

                model.addAttribute("list", list);
                model.addAttribute("pages", (cnt - 1) / 5 + 1);

                model.addAttribute("chk1", chk1);
                model.addAttribute("chk2", chk2);
                model.addAttribute("chk3", chk3);

                // log.info(format, "cntOne=" + cntOne);
                log.info(format, "list=" + list);
                log.info(format, "chk1=" + chk1);
                log.info(format, "chk2=" + chk2);
                log.info(format, "chk3=" + chk3);
                model.addAttribute("pages", (pages - 1) / 5 + 1); // 페이지 수

            }
            if (chk == 2) {

                map.put("id", user.getUsername());
                map.put("first", first);
                map.put("last", last);
                list = aService.selectApplyListByIdTwo(map);

                pages = aService.countApplyListTwo(id);

                chk1 = aService.countApplyListOne(id);
                chk2 = aService.countApplyListTwo(id);
                chk3 = aService.countApplyListThree(id);

                model.addAttribute("list", list);
                model.addAttribute("pages", (cnt - 1) / 5 + 1);

                model.addAttribute("chk1", chk1);
                model.addAttribute("chk2", chk2);
                model.addAttribute("chk3", chk3);

                // log.info(format, "cntOne=" + cntOne);
                log.info(format, "list=" + list);
                model.addAttribute("pages", (pages - 1) / 5 + 1); // 페이지 수

            }
            if (chk == 3) {

                map.put("id", user.getUsername());
                map.put("first", first);
                map.put("last", last);
                list = aService.selectApplyListByIdThree(map);

                pages = aService.countApplyListThree(id);

                chk1 = aService.countApplyListOne(id);
                chk2 = aService.countApplyListTwo(id);
                chk3 = aService.countApplyListThree(id);

                model.addAttribute("list", list);
                model.addAttribute("pages", (cnt - 1) / 5 + 1);

                model.addAttribute("chk1", chk1);
                model.addAttribute("chk2", chk2);
                model.addAttribute("chk3", chk3);

                // log.info(format, "cntOne=" + cntOne);
                log.info(format, "list=" + list);
                model.addAttribute("pages", (pages - 1) / 5 + 1); // 페이지 수

            }

        }

        else if (menu == 2)

        {
            // 페이지 네이션은 => 페이지 번호가 0부터
            // PageRequest pageRequest = PageRequest.of((page - 1), 1);
            // Pageable pageable = PageRequest.of(pageIndex, 10, Sort.by(Direction.DESC,
            // "testValue"));
            // list1 = r1Service.selectListReview(id, pageRequest);
            // list1 = r1Service.selectlistReviewview(id);
            int total = r1Service.countReview(id);
            list1 = r1Service.selectReviewByIdPagenation(id, (page * 5) - 4, page * 5);
            // log.info(format, "page=" + page);
            // log.info(format, "pageRequest=" + pageRequest);
            log.info(format, "list1=" + list1);
            log.info(format, "total=" + total);

            model.addAttribute("list1", list1);
            model.addAttribute("pages1", (total - 1) / 5 + 1); // 페이지 수

        }

        else if (menu == 3) {

        }

        else if (menu == 4) {
            Member obj = mService.selectMemberOne(id);
            // slog.info(format, obj.toString());
            model.addAttribute("obj", obj);
        }

        model.addAttribute("user", user);

        return "/member/mypage/mypage";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(value = "/mypage.do")
    public String mypagePOST(
            @RequestParam(name = "menu", defaultValue = "0", required = false) int menu) {

        return "redirect:/mypage.do?menu=" + menu;

    }

    @GetMapping(value = "/myclass.do")
    public String myclassGET(
            @RequestParam(name = "menu", defaultValue = "0") int menu,
            @RequestParam(name = "no", defaultValue = "0", required = false) long no,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size,
            @AuthenticationPrincipal User user,
            Model model) {
        String owner = user.getUsername();
        String id = user.getUsername();

        if (menu == 0) {
            // return "member/myclass_menu1";
            return "redirect:/member/myclass.do?menu=1";
        }

        if (menu == 1) {
            List<ClassProduct> list = cService.selectMyClassList(id);
            model.addAttribute("list", list);

            log.info("myclass selectlist => {}", list.toString());
        }

        else if (menu == 2) {
            // PageRequest pageRequest = PageRequest.of(page, size);

            List<ClassInquiryView> list = cService.selectClassInquiryList(owner);
            // System.out.println("test용=>", list.toString());

            ClassInquiryView obj2 = cService.selectClassInquiryOne(no);

            model.addAttribute("list", list);
            // model.addAttribute("obj2", obj2 );

            log.info("myclass inquiry selectlist => {}", list.toString());
        }

        model.addAttribute("user", user);
        return "/member/myclass";
    }

    @PostMapping(value = "/myclass.do")
    public String myclassPOST(@AuthenticationPrincipal User user,
            @RequestParam(name = "classcode", defaultValue = "0", required = false) long classcode,
            @RequestParam(name = "menu", defaultValue = "0", required = false) int menu,
            @ModelAttribute ClassProduct obj,
            Model model) {

        int chk = obj.getChk();

        log.info(format, menu);
        log.info(format, classcode);
        if (menu == 1) {
            if (chk == 0 || chk == 1) {
                int ret = cService.updateClassNonactive(obj);

                log.info(" nonactive => {}", obj.toString());
                if (ret == 1) {
                    return "redirect:/member/myclass.do?menu=1";
                }

            } else if (chk == 3) {
                int ret = cService.updateClassActive(obj);

                log.info(" active => {}", obj.toString());
                if (ret == 1) {
                    return "redirect:/member/myclass.do?menu=1";
                }
            }

        }

        return "redirect:/myclass.do?menu=" + menu;
    }

    // 이미지 뛰우기
    @GetMapping(value = "/image")
    public ResponseEntity<byte[]> image(
            @RequestParam(name = "classcode", defaultValue = "0") long classcode)
            throws IOException {

        long classMainNo = manageService.selectClassMainImageNo(classcode);
        ClassImage obj = manageService.selectClassImageOne(classMainNo);

        HttpHeaders headers = new HttpHeaders(); // import org.springframework....

        if (obj != null) { // 이미지가 존재하는지 확인
            if (obj.getFilesize() > 0) {
                headers.setContentType(MediaType.parseMediaType(obj.getFiletype()));
                return new ResponseEntity<>(obj.getFiledata(), headers, HttpStatus.OK);
            }
        }
        // 이미지가 없을경우
        InputStream is = resourceLoader.getResource(defaultImg).getInputStream(); // exception발생됨
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(is.readAllBytes(), headers, HttpStatus.OK);
    }

    @PostMapping(value = "/myclass/inquiry.do")
    public String myClassInquiryPOST(
            @ModelAttribute ClassInquiryView obj,
            Model model) {

        return "/member/myclass";
    }

}
