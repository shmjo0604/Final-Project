package com.example.service.apply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Apply;
import com.example.dto.ApplyStatus;
import com.example.dto.ApplyView;
import com.example.mapper.ApplyMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    ApplyMapper aMapper;

    final String format = "ApplyServiceImpl => {}";

    @Override
    public int insertApplyBatch(List<Apply> list) {
        try {
            int ret = aMapper.insertApplyBatch(list);

            if (ret == list.size()) {

                int ret2 = aMapper.updateClassUnitApplySuccess(list);

                if( ret2 == list.size()) {
                    Apply apply1 = list.get(0);

                    Map<String, Object> map = new HashMap<>();
                    map.put("id", apply1.getMemberid());
                    map.put("count", list.size());
    
                    List<Long> list1 = aMapper.selectInsertedApplyNoList(map);
    
                    log.info(format, list1.toString());
    
                    List<ApplyStatus> list2 = new ArrayList<>();
    
                    for (long a : list1) {
    
                        ApplyStatus applyStatus = new ApplyStatus();
                        applyStatus.setApplyno(a);
                        applyStatus.setChk(1);
    
                        list2.add(applyStatus);
    
                    }
    
                    int result = aMapper.insertApplyStatusBatch(list2);
    
                    if(result == list2.size()) {
    
                        return 1;
                    }
                }
                
                return 0;
            }

            else {

                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int insertApplyStatusBatch(List<ApplyStatus> list) {
        try {
            return aMapper.insertApplyStatusBatch(list);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateApplyCancel(Apply obj) {
        try {
            return aMapper.updateApplyCancel(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateApplyComplete(List<Apply> list) {
        try {
            return aMapper.updateApplyComplete(list);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateClassUnitApplySuccess(List<Apply> list) {
        try {
            return aMapper.updateClassUnitApplySuccess(list);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateClassUnitApplyCancel(Apply obj) {
        try {
            return aMapper.updateClassUnitApplyCancel(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<ApplyView> selectApplyListById(Map<String, Object> map) {
        try {
            return aMapper.selectApplyListById(map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public long countApplyList(String id) {
       try {
        return aMapper.countApplyList(id);
       } catch (Exception e) {
        e.printStackTrace();
        return -1;
       }
    }
}
