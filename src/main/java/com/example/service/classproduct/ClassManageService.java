package com.example.service.classproduct;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dto.ClassImage;
import com.example.dto.ClassProduct;
import com.example.entity.ClassInquiry;
import com.example.entity.ClassInquiryView;

@Service
public interface ClassManageService {
    
    /* 클래스 관리 관련 기능 */  

    // 1. 내 클래스 전체 조회
    public List<ClassProduct> selectMyClassList(String id);

    // 2. 클래스 1개 조회
    public ClassProduct selectClassOne(long classcode);

    // 3. 클래스 삭제 -> delete 사용 불가
    public int updateClassInactive(ClassProduct obj);

    // 3_2. 클래스 비활성화
    public int updateClassNonactive(ClassProduct obj);

    // 3_3. 클래스 활성화
    public int updateClassActive(ClassProduct obj);

    // 4. 클래스 내용 수정
    public int updateClassOne(ClassProduct obj);

    // 5-1. 클래스 강사 프로필 이미지 번호 조회
    public long selectClassProfileImageNo(long classcode);

    // 5-2. 클래스 메인 이미지 번호 조회
    public long selectClassMainImageNo(long classcode);

    // 5-3. 클래스 이미지 번호 리스트 조회
    public List<Long> selectClassSubImageNoList(long classcode);

    // 6. 클래스 이미지 1개 불러오기
    public ClassImage selectClassImageOne(long no);

    // 7. 클래스 이미지 수정
    public int updateClassImageOne(List<com.example.entity.ClassImage> subImg, com.example.entity.ClassImage profileImg, 
        com.example.entity.ClassImage mainImg, long classcode);

    // 8. 클래스 이미지 삭제
    public int deleteClassImageOne(long no);

    // 9. 클래스 문의 전체 조회 (pagination)
    public List<ClassInquiryView> selectClassInquiryList(String owner, Pageable pagealbe);

    // 10. 클래스 문의 1개 조회
    public ClassInquiryView selectClassInquiryOne(long no);

    // 11. 클래스 문의 답변 등록
    public int insertClassInquiryAnswerOne(ClassInquiryView obj);

    // 12. 클래스 문의 답변완료(chk=1)
    public int updateClassAnswer(ClassInquiry obj);

    // 13. 클래스 문의 전체 개수
    public long selectClassInquiryListCount(String owner);
    
}
