package com.example.restcontroller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Member;
import com.example.service.member.MailService;
import com.example.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/api/member")
public class RestMemberController {

    @Autowired MemberService mService;
    @Autowired MailService mailService;

    final String format = "RestMemberController => {}";

    @GetMapping(value = "/idcheck.json")
    public Map<String, Integer> idcheckGET(@RequestParam(name = "id") String id) {

        //System.out.println(id);

        Map<String, Integer> retMap = new HashMap<>();

        int ret = mService.selectMemberIDCheck(id);
        
        retMap.put("ret", ret);

        return retMap;
    }

    @GetMapping(value = "/findid.json")
    public Map<String, String> findIdGET(@ModelAttribute Member obj) {

        //System.out.println(obj.toString());

        Map<String, String> retMap = new HashMap<>();

        Member ret = mService.selectFindMemberId(obj);

        //System.out.println(ret.getId());

        if(ret != null) {
            retMap.put("ret", ret.getId());
        }
        else {
            retMap.put("ret", "not");
        }

        return retMap;
    }

    @PostMapping(value = "/findpw.json")
    public Map<String, Object> findPwPOST(@RequestBody Member obj) throws MessagingException, UnsupportedEncodingException {

        log.info(format, obj.getEmail());

        Map<String, Object> retMap = new HashMap<>();

        String code = mailService.sendEmail(obj.getEmail());

        retMap.put("code", code);

        return retMap;

    }

    
}
