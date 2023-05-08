package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.ActivityCate;
import com.example.dto.CityCate;

@Service
public interface ClassSelectService {
    
    // 지역 상위 분류 호출
    public List<CityCate> selectCityCateList();

    // 클래스 상위 분류 호출
    public List<ActivityCate> selectActivityCateList();

}
