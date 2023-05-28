package com.example.service.apply;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Apply;
import com.example.dto.ApplyStatus;
import com.example.dto.ApplyView;
import com.example.mapper.ApplyMapper;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired ApplyMapper aMapper;

    @Override
    public int insertApplyBatch(List<Apply> list) {
        try {
            return aMapper.insertApplyBatch(list);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int insertApplyStatusBatch(List<ApplyStatus> list) {
        try {
            return aMapper.insertApplyStatusBatch(list);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateApplyCancel(Apply obj) {
        try {
            return aMapper.updateApplyCancel(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateApplyComplete(List<Apply> list) {
        try {
            return aMapper.updateApplyComplete(list);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateClassUnitApplySuccess(List<Apply> list) {
        try {
            return aMapper.updateClassUnitApplySuccess(list);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateClassUnitApplyCancel(Apply obj) {
        try {
            return aMapper.updateClassUnitApplyCancel(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<ApplyView> selectApplyListById(Map<String, Object> map) {
        try {
            return aMapper.selectApplyListById(map);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

}
