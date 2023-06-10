package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ClassProduct;

@Repository
public interface ClassProductRepository extends JpaRepository<ClassProduct, Long> {
    
    List<ClassProduct> findAllTopSixByOrderByClasscodeDesc();

}
