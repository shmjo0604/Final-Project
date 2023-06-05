package com.example.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return retMap;
    }

    @GetMapping(value = "/selectunitlist.json")
    public Map<String,Object> selectunitlistGET(
        @RequestParam(name = "classcode", defaultValue = "0") long classcode){
    
            log.info(format, classcode);

            List<ClassUnit> list = cuRepository.findByClassproduct_classcode(classcode);
            // log.info(format, list.toString());

            Map<String, Object> retmap = new HashMap<>();
            retmap.put("list", list);
            return retmap;
    }

    @DeleteMapping(value = "/deleteunit.json")
    public Map<String, Integer> deleteunitDELETE() {
        Map<String, Integer> retMap = new HashMap<>();
        // retMap.put("result", ret);
        return retMap;
    }
    
}
