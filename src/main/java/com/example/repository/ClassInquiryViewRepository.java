package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ClassInquiryView;

@Repository
public interface ClassInquiryViewRepository extends JpaRepository<ClassInquiryView, Long>{
  
    ClassInquiryView findByNo(Long no);
    
    List<ClassInquiryView> findByOwnerOrderByNoDesc( String owner );

}
