package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.Administrator;

@Mapper
public interface AdministratorMapper {

    // 1. 관리자 등록
    public int insertAdminOne(Administrator obj);

    
}
