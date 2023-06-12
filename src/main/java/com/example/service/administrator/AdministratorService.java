package com.example.service.administrator;

import org.springframework.stereotype.Service;

import com.example.dto.Administrator;

@Service
public interface AdministratorService {
    
    // 관리자 등록
    public int insertAdminOne(Administrator obj);
}
