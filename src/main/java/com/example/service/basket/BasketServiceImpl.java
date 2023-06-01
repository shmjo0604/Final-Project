package com.example.service.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Basket;
import com.example.repository.BasketRepository;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired BasketRepository bRepository;

    @Override
    public int insertBasketOne(Basket obj) {
        
        try {
            bRepository.save(obj);
            return 1;
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
        

    }
    
}
