package com.example.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Community;


@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    public List<Community> findAllByOrderByNoDesc();

    public Community findByNo(long no);

    public Community findByMember_id(String id);





   








   


   
    


}
