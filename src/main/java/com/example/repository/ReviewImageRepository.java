package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.ReviewImage;

@Repository
public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long> {

    // 2. 리뷰 이미지 조회
    public ReviewImage findByNo(long no);

    // 3. 리뷰이미지 번호 조회
    @Query(value = " SELECT r.no FROM REVIEWIMAGE r WHERE r.REVIEWNO  = :no", nativeQuery = true)
    public List<Long> reviewImagelistNo(@Param("no") long no);

}
