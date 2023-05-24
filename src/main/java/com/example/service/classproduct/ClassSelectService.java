package com.example.service.classproduct;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.dto.ActDetailCate;
import com.example.dto.ActivityCate;
import com.example.dto.CityCate;
import com.example.dto.ClassProduct;
import com.example.dto.ClassUnitView;
import com.example.dto.LocalCate;

@Service
public interface ClassSelectService {

    // 1. 클래스 조회
    public List<ClassUnitView> selectClassUnitViewList(Map<String, Object> map);

    // 3. 클래스 조회 (총 개수)
    public long selectClassCountTotal(Map<String, Object> map);
    
    // 4. 지역 상위 분류 호출
    public List<CityCate> selectCityCateList();

    // 5. 클래스 상위 분류 호출
    public List<ActivityCate> selectActivityCateList();

    // 6. 지역 하위 분류 호출
    public List<LocalCate> selectLocalCateList(int citycode);

    // 7. 클래스 하위 분류 호출
    public List<ActDetailCate> selectActDetailCateList(int actcode);

    // 8. 클래스 하나 정보 조회
	public ClassProduct selectClassProductOne(long classcode);


}
