package com.example.service.basket;

import org.springframework.stereotype.Service;

import com.example.entity.Basket;

@Service
public interface BasketService {
    
    // 1. 장바구니 등록
    public int insertBasketOne(Basket obj);

}
