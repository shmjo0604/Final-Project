package com.example.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Administrator;
import com.example.mapper.AdministratorMapper;

@Service
public class AdminServiceImpl implements AdminService {
    
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
