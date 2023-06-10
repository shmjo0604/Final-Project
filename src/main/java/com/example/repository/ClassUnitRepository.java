package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ClassUnit;

@Repository
public interface ClassUnitRepository extends JpaRepository<ClassUnit, Long> {

    // classcode(ClassUnit의 외래키)에 해당하는 ClassUnit 전체 조회
    List<ClassUnit> findByClassproduct_classcodeOrderByClassdate(long classcode);

    ClassUnit findByClassproduct_classcodeAndNo(long classcode, long no);


    
    
}
