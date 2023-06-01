package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    // Basket findByMemberIdAndUnitNo(String memberid, Long unitno);

    // WHERE member1.id=? ORDER BY no DESC  => member1은 객체이기 때문에 _ 를 이용해서 id값
    List<Basket> findByMember_idOrderByNoDesc(String id);

    // select * from o테이블명 order by no asc
    List<Basket> findAllByOrderByNoAsc();
    
}
