package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ActDetailCate;
import com.example.dto.ActivityCate;
import com.example.dto.CityCate;
import com.example.dto.ClassImage;
import com.example.dto.ClassProduct;
import com.example.dto.LocalCate;
import com.example.mapper.ClassManageMapper;

@Service
public class ClassManageServiceImpl implements ClassManageService {

    @Autowired ClassManageMapper cMapper;

    @Override
    public int insertClassOne(ClassProduct obj) {
        try {
            return cMapper.insertClassOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

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
    public List<LocalCate> selectLocalCateList(int citycode) {
        try {
            return cMapper.selectLocalCateList(citycode);
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
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ActDetailCate> selectActDetailCateList(int actcode) {
        try {
            return cMapper.selectActDetailCateList(actcode);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int insertClassImage(ClassImage obj) {
        try {
            return cMapper.insertClassImage(obj);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

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
