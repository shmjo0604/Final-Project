package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Review;
import com.example.entity.Reviewview;

@Repository
public interface ReviewRepository extends JpaRepository<Reviewview, Long> {

    List<Reviewview> findByIdIgnoreCaseOrderByRegdateDesc(String id, Pageable pageable);

    List<Reviewview> findById(String id);

    int countByIdContaining(String id);

    void save(Review obj);

    // nativequery사용하기
    @Query(value = "SELECT * FROM ( SELECT r.*, ROW_NUMBER() OVER (ORDER BY regdate DESC) rown FROM REVIEWVIEW r WHERE r.id =:id) WHERE rown BETWEEN :start AND :end ORDER BY regdate DESC", nativeQuery = true)
    public List<Reviewview> selectReviewByIdPagenation(@Param("id") String id, @Param("start") int start,
            @Param("end") int end);
}
