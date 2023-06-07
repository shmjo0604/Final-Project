package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 1.리뷰 목록 조회
    // List<ClassInquiry> findByClassproduct_classcodeOrderByNoDesc(long classcode);

    // 2. 리뷰 목록 개수 조회
    // long countByClassproduct_classcode(long classcode);

}
