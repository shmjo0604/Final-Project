package com.example.service.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Administrator;
import com.example.mapper.AdministratorMapper;

@Service
public class AdministratorServiceImpl implements AdministratorService{

    @Autowired AdministratorMapper adMapper;

    @Override
    public int insertAdminOne(Administrator obj) {
        try {
            return adMapper.insertAdminOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        } 
    }
    
}
