package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ActivityCate;
import com.example.dto.CityCate;
import com.example.mapper.ClassSelectMapper;

@Service
public class ClassSelectServiceImpl implements ClassSelectService {

    @Autowired ClassSelectMapper cMapper;

    @Override
    public List<CityCate> selectCityCateList() {
        try {
            return cMapper.selectCityCateList();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ActivityCate> selectActivityCateList() {
        try {
            return cMapper.selectActivityCateList();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
