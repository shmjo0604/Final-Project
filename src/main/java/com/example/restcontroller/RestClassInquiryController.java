package com.example.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ClassInquiryView;
import com.example.service.classproduct.ClassManageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController  
@RequestMapping(value = "/api/member")
@Slf4j
@RequiredArgsConstructor
public class RestClassInquiryController {
    
    @Autowired ClassManageService cService;

    final String format = "RestClassInquiryController => {}";

    @GetMapping(value = "/selectinquiry.json")
    public Map<String, Object> selectinquiryGET(
        @RequestParam(name = "no") long no
    ){
        Map<String, Object> retMap = new HashMap<>();
        
        log.info(format, no);

        ClassInquiryView obj = cService.selectClassInquiryOne(no);

        retMap.put("ret", 0);

        if(obj!=null){
            log.info(format, obj.toString());
            retMap.put("ret", 1);
            retMap.put("obj", obj);

        }
        return retMap;


    }


}
