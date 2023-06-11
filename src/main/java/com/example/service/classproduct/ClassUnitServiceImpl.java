package com.example.service.classproduct;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ClassUnit;
import com.example.dto.ClassUnitView;
import com.example.mapper.ClassUnitMapper;
import com.example.repository.ClassUnitRepository;

@Service
public class ClassUnitServiceImpl implements ClassUnitService {

    @Autowired ClassUnitMapper cMapper;

    @Override
    public int insertUnitOne(ClassUnit obj) {
        try {
            return cMapper.insertUnitOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public long selectPriceOne(long classcode) {
        try {
            return cMapper.selectPriceOne(classcode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<ClassUnit> selectUnitList(long classcode) {
        try {
            return cMapper.selectUnitList(classcode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ClassUnit selectUnitOne(ClassUnit obj) {
        try {
            return cMapper.selectUnitOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateUnitOne(ClassUnit obj) {
        try {
            return cMapper.updateUnitOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateUnitOneInactive(long no) {
        try {
            return cMapper.updateUnitOneInactive(no);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateUnitBatchInactive(Map<String, Object> map) {
        try {
            return cMapper.updateUnitBatchInactive(map);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ClassUnitView selectClassUnitViewOne(long unitno) {
        try {
            return cMapper.selectClassUnitViewOne(unitno);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ClassUnit> selectUnitListToCal(long classcode) {
        try {
            return cMapper.selectUnitListToCal(classcode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
