package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.ClassUnit;

@Repository
public interface ClassUnitRepository extends JpaRepository<ClassUnit, Long> {

    // classcode(ClassUnit의 외래키)에 해당하는 ClassUnit 전체 조회
    List<ClassUnit> findByClassproduct_classcode(long classcode);

    ClassUnit findByClassproduct_classcodeAndNo(long classcode, long no);

    @Modifying
    @Query("UPDATE ClassUnit cu SET cu.chk = 1 WHERE cu.classproduct.classcode = :classcode AND cu.no = :no")
    void updateChkByClasscodeAndNo(@Param("classcode") long classcode, @Param("no") long no);

    
    
}
