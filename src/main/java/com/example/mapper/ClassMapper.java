package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.ActDetailCate;
import com.example.dto.ActivityCate;
import com.example.dto.CityCate;
import com.example.dto.ClassImage;
import com.example.dto.ClassProduct;
import com.example.dto.LocalCate;

@Mapper
public interface ClassMapper {

    /* 클래스 관리 - (1) 클래스 등록 관련 기능 */    

    // 1. 클래스 등록
    public int insertClassOne(ClassProduct obj);

    // 2. 지역 상위 카테고리 조회
    public List<CityCate> selectCityCateList();

    // 3. 지역 하위 카테고리 조회 -> 상위 카테고리 코드 외래키로 전달 받아서
    public List<LocalCate> selectLocalCateList(int citycode);

    // 4. 클래스 상위 카테고리 조회
    public List<ActivityCate> selectActivityCateList();

    // 5. 클래스 하위 카테고리 조회 -> 상위 카테고리 코드 외래키로 전달 받아서
    public List<ActDetailCate> selectActDetailCateList(int actcode);

    // 6. 클래스 이미지 등록
    public int insertClassImage(ClassImage obj);


    /* 클래스 관리 - (2) 클래스 관리 관련 기능 */  

    // 1. 내 클래스 전체 조회
    public List<ClassProduct> selectMyClassList(String id);

    // 2. 클래스 1개 조회
    public ClassProduct selectClassOne(long classcode);

    // 3. 클래스 삭제 -> delete 사용 불가
    public int updateClassInactive(ClassProduct obj);

    // 4. 클래스 내용 수정
    public int updateClassOne(ClassProduct obj);

    // 5. 클래스 이미지 번호 리스트 조회
    public List<Long> selectClassImageNoList(long classcode);

    // 6. 클래스 이미지 1개 불러오기
    public ClassImage selectClassImageOne(long no);

    // 7. 클래스 이미지 수정
    public int updateClassImageOne(ClassImage obj);

    // 8. 클래스 이미지 삭제
    public int deleteClassImageOne(long no);

}
