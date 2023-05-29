package com.example.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${classselect.page}") int pageEach;

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

        String pageStr = (String)map.get("page");
        int page = Integer.parseInt(pageStr);

        log.info(format, page);

        map.put("first", (page*pageEach)-(pageEach-1));
        map.put("last", page*pageEach);

        log.info(format, map.toString());

        List<ClassUnitView> list = cService.selectClassUnitViewList(map);
        long total = cService.selectClassCountTotal(map);

        log.info(format, list.toString());
        log.info(format, total);

        retMap.put("list", list);
        retMap.put("pages", ((total-1)/pageEach)+1);

        return retMap;

    }

}
