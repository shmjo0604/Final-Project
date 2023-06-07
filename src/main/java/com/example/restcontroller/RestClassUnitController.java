package com.example.restcontroller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    
    // 일정 등록
    @PostMapping(value = "/insert.json")
    public Map<String, Object> insertPOST(
        @RequestBody ClassUnit classunit){
        log.info(format,"ddd");
        log.info(format, classunit.toString());
        Map<String, Object> retMap = new HashMap<>();
    
        try {
            cuRepository.save(classunit);
            retMap.put("status", 200);

        } catch (Exception e) {
            e.printStackTrace();
            retMap.put("status",-1);
            retMap.put("error",e.getMessage());
        }
        return retMap;
    }
    

    // 일정 리스트 조회
    @GetMapping(value = "/selectunitlist.json")
    public Map<String,Object> selectunitlistGET(
        @RequestParam(name = "classcode", defaultValue = "0") long classcode){
    
            // log.info(format, classcode);
            Map<String,Object> retmap = new HashMap<>();

            List<ClassUnit> list = cuRepository.findByClassproduct_classcode(classcode);
            // log.info(format, list.toString());
        
            retmap.put("list", list);
            return retmap;
    }

    // 한개의 일정 조회
    @GetMapping(value = "/selectunitone.json")
    public Map<String,Object> selectunitoneGET(
        @RequestParam(name = "classcode", defaultValue = "0") long classcode,
        @RequestParam(name = "no", defaultValue = "0") long no){
        // log.info(format, classcode);
        // log.info(format, no);

        ClassUnit obj = cuRepository.findByClassproduct_classcodeAndNo(classcode, no);
        log.info(format, obj);

        Map<String, Object> retmap = new HashMap<>();
        retmap.put("obj", obj);
        return retmap;
    }   

    // 선택한 일정 삭제(update로 처리)
    @PutMapping(value = "/deleteone.json")
    public Map<String, Integer> deleteonePUT(
        @RequestParam(name = "classcode", defaultValue = "0") long classcode,
        @RequestParam(name = "no", defaultValue = "0") long no) {
        Map<String, Integer> retMap = new HashMap<>();

        log.info(format, classcode);
        log.info(format, no);
        
        cuRepository.updateChkByClasscodeAndNo(classcode, no);
        retMap.put("status", 200);
        
        return retMap;
    }

    // 일정 전체 삭제(update로 처리)
    // @PutMapping(value = "/deleteall.json")
    // public Map<String, Integer> deleteallPUT() {
    //     Map<String, Integer> retMap = new HashMap<>();

    //     // retMap.put("result", ret);
    //     return retMap;
    // }
    
}
