package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Basket;

@Mapper
public interface BasketMapper {

    // 1. 장바구니 추가
    public int insertBasketOne(Basket obj);

    // 2. 상품 정보 수정
    public int updateBasketOne(Basket obj);

    // 3. 선택 상품 삭제
    public int deleteBasketOne(int obj);

    // 4. 카트 목록
    public List<Basket> BasketList(String member);

    // 5. 카트 확인
    public Basket checBasket(Basket obj);
    
}
