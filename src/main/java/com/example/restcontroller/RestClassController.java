package com.example.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ActDetailCate;
import com.example.dto.ClassUnitView;
import com.example.dto.LocalCate;
import com.example.service.classproduct.ClassSelectService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/class")
@Slf4j
public class RestClassController {
    
    @Autowired ClassSelectService cService;

    final String format = "RestClassSelectCateController => {}";

    @GetMapping(value = "/selectcatelist.json")
    public Map<String, Object> selectcatelistGET(
        @RequestParam(name = "chk") String chk, 
        @RequestParam(name = "refcode") int refcode
        ) {
        
        log.info(format, chk);
        log.info(format, refcode);

        Map<String, Object> retmap = new HashMap<>();

        if(chk.equals("classcate")) {
			
			List<ActDetailCate> list = cService.selectActDetailCateList(refcode);
			
            //log.info(format, list.toString());

			retmap.put("list", list);
			
		}
		
		else if(chk.equals("citycate")) {
			
			List<LocalCate> list = cService.selectLocalCateList(refcode);

            //log.info(format, list.toString());

			retmap.put("list", list);
		
		}

        return retmap;

    }

    @GetMapping(value = "selectclasslist.json")
    public Map<String, Object> selectclassGET(@RequestParam Map<String, Object> map) {

        log.info(format, map.toString());

        Map<String, Object> retMap = new HashMap<>();

        List<ClassUnitView> list = cService.selectClassUnitViewList(map);

        log.info(format, list.toString());

        retMap.put("list", list);

        return retMap;

    }

}
