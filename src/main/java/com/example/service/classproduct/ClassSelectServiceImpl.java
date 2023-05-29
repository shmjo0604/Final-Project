package com.example.service.classproduct;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ActDetailCate;
import com.example.dto.ActivityCate;
import com.example.dto.CityCate;
import com.example.dto.ClassProduct;
import com.example.dto.ClassUnitView;
import com.example.dto.LocalCate;
import com.example.mapper.ClassManageMapper;
import com.example.mapper.ClassSelectMapper;

@Service
public class ClassSelectServiceImpl implements ClassSelectService {

    @Autowired ClassSelectMapper cMapper;
    @Autowired ClassManageMapper manageMapper;

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

    @Override
    public List<LocalCate> selectLocalCateList(int citycode) {
        try {
            return cMapper.selectLocalCateList(citycode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ActDetailCate> selectActDetailCateList(int actcode) {
        try {
            return cMapper.selectActDetailCateList(actcode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ClassUnitView> selectClassUnitViewList(Map<String, Object> map) {
        try {

            List<ClassUnitView> list = cMapper.selectClassUnitViewList(map);
            
            for(ClassUnitView obj : list) {

                long mainImgNo = manageMapper.selectClassMainImageNo(obj.getClasscode());
                obj.setMainImg(mainImgNo);

            }

            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public long selectClassCountTotal(Map<String, Object> map) {
        try {
            return cMapper.selectClassCountTotal(map);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ClassProduct selectClassProductOne(long classcode) {
        try {
            return cMapper.selectClassProductOne(classcode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ClassProduct> selectClassProductViewList(Map<String, Object> map) {
        try {

            List<ClassProduct> list = cMapper.selectClassProductViewList(map);

            for(ClassProduct obj : list) {

                long mainImgNo = manageMapper.selectClassMainImageNo(obj.getClasscode());
                obj.setMainImg(mainImgNo);
                
            }

            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public long selectClassCountTotalV2(Map<String, Object> map) {
        try {
            return cMapper.selectClassCountTotalV2(map);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

   
    
}
