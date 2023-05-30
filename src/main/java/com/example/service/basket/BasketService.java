package com.example.service.basket;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Basket;

@Service
public interface BasketService {

    //1. 값 넣기
    public int insertBasketOne(Basket obj);

    // 2. 상품 정보 수정
    public int updateBasketOne(Basket obj);

    // 3. 선택 상품 삭제
    public int deleteBasketOne(int obj);

    // 4. 카트 목록
    public List<Basket> BasketList(String member);

    // 5. 장바구니 데이터 체크
    public Basket checBasket(Basket obj);
    
}
