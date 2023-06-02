package com.example.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ClassUnit;
import com.example.repository.ClassUnitRepository;
import com.example.service.classproduct.ClassUnitService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/classunit")
@RequiredArgsConstructor
public class RestClassUnitController {

    final String format = "RestClassUnit => {}";
    final ClassUnitRepository cuRepository;

    @Autowired ClassUnitService cuService;
    
    @PostMapping(value = "/insert.json")
    public Map<String, Integer> insertPOST(
        @RequestBody ClassUnit classunit){
        
        log.info(format, classunit.toString());
        cuRepository.save(classunit);

        Map<String, Integer> retMap = new HashMap<>();
  
        // retMap.put("result", ret);
        return retMap;
    }
    
}
