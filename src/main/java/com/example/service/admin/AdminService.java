package com.example.service.admin;

import org.springframework.stereotype.Service;

import com.example.dto.Administrator;

@Service
public interface AdminService {
    
    // 관리자 등록
    public int insertAdminOne(Administrator obj);

}
