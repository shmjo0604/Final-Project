package com.example.service.classproduct;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.ClassInquiry;
import com.example.entity.ClassInquiryView;

@Service
public interface ClassInquiryService {

    // 1. 클래스 문의 등록
    public int insertClassInquiryOne(ClassInquiry obj);

    // 2. 클래스 문의 조회 (paging)
    public List<ClassInquiry> selectClassInquiryList(long classcode);

    // 3. 클래스 문의 조회 총 개수
    public long selectCountClassInquiryList(long classcode);

    // 4. 클래스 문의 하나 조회
    public ClassInquiryView selectClassInquiryViewOne(long no);


}
