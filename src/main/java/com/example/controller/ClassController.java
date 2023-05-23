package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.config.KakaoLocalAPI;
import com.example.dto.ActivityCate;
import com.example.dto.CityCate;
import com.example.dto.ClassImage;
import com.example.dto.ClassProduct;
import com.example.service.classproduct.ClassInsertService;
import com.example.service.classproduct.ClassSelectService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/class")
@Slf4j
public class ClassController {

    final String format = "ClassController => {}";

    @Autowired
    ClassSelectService cService;
    @Autowired
    ClassInsertService iService;

    @GetMapping(value = "/select.do")
    public String selectGET(@RequestParam(name = "search", defaultValue = "", required = false) String search,
            Model model) {

        if (search.equals("")) {
            return "redirect:/class/select.do?search=list";
        }

        List<ActivityCate> list1 = cService.selectActivityCateList();
        List<CityCate> list2 = cService.selectCityCateList();
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);

        return "/class/select";
    }

    @GetMapping(value = "/selectone.do")
    public String selectoneGET(@RequestParam(name = "classcode", defaultValue = "0") long classcode) {

        if (classcode == 0) {
            return "redirect:/class/select.do?search=list";
        }

        return "class/selectone";
    }

    @GetMapping(value = "/insert.do")
    public String insertGET(Model model) {

        model.addAttribute("actlist", cService.selectActivityCateList());
        model.addAttribute("citylist", cService.selectCityCateList());

        return "/class/insert";
    }

    @PostMapping(value = "/insert.do")
    public String insertPOST(
            @ModelAttribute ClassProduct obj,
            @AuthenticationPrincipal User user,
            @RequestParam(name = "profile", required = false) MultipartFile profileImg,
            @RequestParam(name = "classimg", required = false) List<MultipartFile> classSubImg,
            @RequestParam(name = "thumbnail", required = false) MultipartFile classMainImg)
            throws IOException {

        //log.info(format, profileImg);

        // 1.Rest API 호출 -> 주소 기반 위도, 경도 값 반환(Map)

        Map<String, String> map = KakaoLocalAPI.getCoordinate(obj.getAddress1());

        // 2. ClassProduct 객체 obj에 위도, 경도, 사용자 ID SET
        obj.setLatitude(map.get("x"));
        obj.setLongitude(map.get("y"));
        obj.setMemberid(user.getUsername()); // security session에 저장된 ID 정보를 호출

        // 3. 결과 확인
        log.info(format, obj.toString());

        // 4. ClassImage 리스트 객체 생성

        List<ClassImage> list = new ArrayList<>();

        ClassImage profile = new ClassImage();

        profile.setFilename(profileImg.getOriginalFilename());
        profile.setFilesize(profileImg.getSize());
        profile.setFiletype(profileImg.getContentType());
        profile.setFiledata(profileImg.getBytes());
        profile.setTypechk(1);
        list.add(profile);

        if (classSubImg != null) {
            for (MultipartFile file : classSubImg) {

                ClassImage classSub = new ClassImage();
                classSub.setFilename(file.getOriginalFilename());
                classSub.setFilesize(file.getSize());
                classSub.setFiletype(file.getContentType());
                classSub.setFiledata(file.getBytes());
                classSub.setTypechk(3);
                list.add(classSub);

            }
        }

        if (classMainImg != null) {
            ClassImage classMain = new ClassImage();

            classMain.setFilename(classMainImg.getOriginalFilename());
            classMain.setFilesize(classMainImg.getSize());
            classMain.setFiletype(classMainImg.getContentType());
            classMain.setFiledata(classMainImg.getBytes());
            classMain.setTypechk(2);
            list.add(classMain);
        }

        int ret = iService.insertClassOne(obj, list);

        log.info(format, ret);

        if (ret == 1) {
            return "redirect:/member/mypage.do?menu=";
        } else {
            return "redirect:/class/insert.do";
        }

    }

    @GetMapping(value = "/unit.do")
    public String unitGET() {

        return "/class/unit";
    }

    @GetMapping(value = "/apply.do")
    public String applyGET() {

        return "/apply/insert";
    }

    @PostMapping(value = "/apply.do")
    public String applyPOST() {

        return "redirect:/home.do";
    }

}
