package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Basket;

@Mapper
public interface BasketMapper {

    // 1. 값 넣기
    public int insertBasketOne(Basket obj);

    // 2. 상품 정보 수정
    public int updateBasketOne(Basket obj);

    // 3. 선택 상품 삭제
    public int deleteBasketOne(Basket obj);
    
}
