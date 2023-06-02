package com.example.service.classproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ClassImage;
import com.example.dto.ClassProduct;
import com.example.entity.ClassInquiryView;
import com.example.mapper.ClassManageMapper;
import com.example.repository.ClassInquiryViewRepository;
import com.example.repository.MainRepository;

@Service
public class ClassManageServiceImpl implements ClassManageService {

    @Autowired ClassManageMapper cMapper;
    @Autowired ClassInquiryViewRepository cRepository;
    @Autowired MainRepository mRepository;

    @Override
    public List<ClassProduct> selectMyClassList(String id) {
        try {
            List<ClassProduct> list = cMapper.selectMyClassList(id);
            if(list != null ){
                for (ClassProduct classProduct : list) {
                    long classcode = classProduct.getClasscode();
                    long mainImg = cMapper.selectClassMainImageNo(classcode);
                    classProduct.setMainImg(mainImg);
                }
            }
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ClassProduct selectClassOne(long classcode) {
        try {
            return cMapper.selectClassOne(classcode);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateClassInactive(ClassProduct obj) {
        try {
            return cMapper.updateClassInactive(obj);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateClassOne(ClassProduct obj) {
        try {

            
            return cMapper.updateClassOne(obj);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public long selectClassProfileImageNo(long classcode) {
        try {
            return cMapper.selectClassProfileImageNo(classcode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public long selectClassMainImageNo(long classcode) {
        try {
            return cMapper.selectClassMainImageNo(classcode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Long> selectClassSubImageNoList(long classcode) {
        try {
            return cMapper.selectClassSubImageNoList(classcode);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ClassImage selectClassImageOne(long no) {
        try {
            return cMapper.selectClassImageOne(no);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateClassImageOne(ClassImage obj) {
        try {
            return cMapper.updateClassImageOne(obj);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int deleteClassImageOne(long no) {
        try {
            return cMapper.deleteClassImageOne(no);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<ClassInquiryView> selectClassInquiryList( String owner ) {
        try {
            return cRepository.findByOwnerOrderByNoDesc(owner);
         }
         catch (Exception e) {
             e.printStackTrace();
             return null;
         }
    }

    @Override
    public int updateClassNonactive(ClassProduct obj) {
        try {
            return cMapper.updateClassNonactive(obj);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ClassInquiryView selectClassInquiryOne(long no) {
       try {
            return cRepository.findByNo(no);
       } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    }

    @Override
    public int updateClassActive(ClassProduct obj) {
        try {
            return cMapper.updateClassActive(obj);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
}
