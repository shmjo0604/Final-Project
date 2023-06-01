package com.example.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ClassUnit;
import com.example.service.classproduct.ClassUnitService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/classunit")
public class RestClassUnitController {

    final String format = "RestClassUnit => {}";
    @Autowired ClassUnitService cuService;

    @PostMapping(value = "/insert.json")
    public Map<String, Integer> insertPOST(@RequestBody ClassUnit classunit){
        
        log.info(format, classunit.getMaximum());


        // ClassUnit obj = new ClassUnit();
        // obj.setClasscode(157);
        // obj.setMaximum(classunit.getMaximum());
        // obj.setClassdate(classunit.getClassdate());

        // int ret = cuService.insertUnitOne(classunit);

        Map<String, Integer> retMap = new HashMap<>();

        // retMap.put("result", ret);
        return retMap;
    }
    
}
