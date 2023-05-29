package com.example.service.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Basket;
import com.example.mapper.BasketMapper;

@Service
public class BasketServiceImpl implements BasketService{

    @Autowired BasketMapper bMapper;

    @Override
    public int insertBasketOne(Basket obj) {
        try {
            return bMapper.insertBasketOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

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

    @Override
    public int deleteBasketOne(Basket obj) {
            try{
                return bMapper.deleteBasketOne(obj);
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
    }

    
}
