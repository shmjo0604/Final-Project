package com.example.service.basket;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Basket;
import com.example.repository.BasketRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService{

    final BasketRepository bRepository;



     //1. 장바구니 추가
    @Override
    public int insertBasketOne( Basket obj) {
        
        // 장바구니 추가
       

        // 장바구니 등록 & 에러 시  0 반환
        try {
            return 1;
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 2. 카트 목록
    @Override
    public List<Basket> basketList(String memberid) {
        try{
            return bRepository.findByMember_idOrderByNoDesc(memberid);
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
            return 1;
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
                return 1;
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
            return null;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
