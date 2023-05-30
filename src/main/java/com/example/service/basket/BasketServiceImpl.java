package com.example.service.basket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Basket;
import com.example.mapper.BasketMapper;

@Service
public class BasketServiceImpl implements BasketService{

    @Autowired BasketMapper bMapper;


     //1. 장바구니 추가
    @Override
    public int insertBasketOne( Basket obj) {
        
        // 장바구니 데이터 체크
        Basket basket = bMapper.checBasket(obj);

        if(basket != null) {
            return 2;
        }

        // 장바구니 등록 & 에러 시  0 반환
        try {
            return bMapper.insertBasketOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 2. 카트 목록
    @Override
    public List<Basket> BasketList(String member) {

        // 장바구니 데이터 체크
        List<Basket> basket = bMapper.BasketList(member);

        try{
            return bMapper.BasketList(member);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 3. 상품 정보 수정
    @Override
    public int updateBasketOne(Basket obj) {
        try{
            return bMapper.updateBasketOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 4. 선택 상품 삭제
    @Override
    public int deleteBasketOne(int obj) {
            try{
                return bMapper.deleteBasketOne(obj);
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
    }

    

    // 5. 카트 확인
    @Override
    public Basket checBasket(Basket obj) {
        try{
            return bMapper.checBasket(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
