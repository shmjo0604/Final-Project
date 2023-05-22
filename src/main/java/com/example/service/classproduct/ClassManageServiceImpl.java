package com.example.service.classproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ClassImage;
import com.example.dto.ClassProduct;
import com.example.mapper.ClassManageMapper;

@Service
public class ClassManageServiceImpl implements ClassManageService {

    @Autowired ClassManageMapper cMapper;

    @Override
    public List<ClassProduct> selectMyClassList(String id) {
        try {
            return cMapper.selectMyClassList(id);
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
    public List<Long> selectClassImageNoList(long classcode) {
        try {
            return cMapper.selectClassImageNoList(classcode);
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
    
}
