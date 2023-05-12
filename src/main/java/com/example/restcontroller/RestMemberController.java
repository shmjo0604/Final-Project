package com.example.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Member;
import com.example.service.member.MemberService;

@RestController
@RequestMapping(value = "/api/member")
public class RestMemberController {

    @Autowired MemberService mService;

    @GetMapping(value = "/idcheck.json")
    public Map<String, Integer> idcheckGET(@RequestParam(name = "id") String id) {

        //System.out.println(id);

        Map<String, Integer> retMap = new HashMap<>();

        int ret = mService.selectMemberIDCheck(id);
        
        retMap.put("ret", ret);

        return retMap;
    }

    @GetMapping(value = "/findId.json")
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
    
}
