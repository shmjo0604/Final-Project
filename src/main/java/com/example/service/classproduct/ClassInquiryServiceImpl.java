package com.example.service.classproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ClassInquiry;
import com.example.entity.ClassInquiryView;
import com.example.repository.ClassInquiryRepository;
import com.example.repository.ClassInquiryViewRepository;

@Service
public class ClassInquiryServiceImpl implements ClassInquiryService {

    @Autowired ClassInquiryRepository cInquiryRepository;
    @Autowired ClassInquiryViewRepository cInquiryViewRepository;

    @Override
    public int insertClassInquiryOne(ClassInquiry obj) {
        try {
            cInquiryRepository.save(obj);
            return 1;
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<ClassInquiry> selectClassInquiryList(long classcode) {
        try {
            return cInquiryRepository.findByClassproduct_classcodeOrderByNoDesc(classcode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public long selectCountClassInquiryList(long classcode) {
        try {
            return cInquiryRepository.countByClassproduct_classcode(classcode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ClassInquiryView selectClassInquiryViewOne(long no) {
        try {
            return cInquiryViewRepository.findByNo(no);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    
}
