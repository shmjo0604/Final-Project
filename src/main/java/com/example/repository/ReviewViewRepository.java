package com.example.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Review;
import com.example.entity.ReviewView;

@Repository
public interface ReviewViewRepository extends JpaRepository<ReviewView, Long> {

    List<ReviewView> findByIdIgnoreCaseOrderByRegdateDesc(String id, Pageable pageable);

    List<ReviewView> findById(String id);

    int countByIdContaining(String id);

    void save(Review obj);

    // native query 사용하기
    @Query(value = "SELECT * FROM ( SELECT r.*, ROW_NUMBER() OVER (ORDER BY regdate DESC) rown FROM REVIEWVIEW r WHERE r.id =:id) WHERE rown BETWEEN :start AND :end ORDER BY regdate DESC", nativeQuery = true)
    public List<ReviewView> selectReviewByIdPagenation(@Param("id") String id, @Param("start") int start,
            @Param("end") int end);

    // ReviewView 목록 조회 (by classcode)
    @Query(value = "SELECT * FROM ( SELECT r.*, ROW_NUMBER() OVER (ORDER BY r.no DESC) rown FROM REVIEWVIEW r WHERE r.classcode =:classcode ) r WHERE rown BETWEEN :first AND :last ORDER BY r.rown ASC", nativeQuery = true)
    public List<ReviewView> selectByClasscode(@Param("classcode") long classcode, @Param("first") int first, @Param("last") int last);

    // ReviewView 목록 개수 (by classcode)
    long countByClasscode(long classcode);

    interface ReviewViewVo {

        long getNo();

        int getRating();

        Date getRegdate();

        int getHit();

        String getId();

        long getClasscode();

        String getTitle();

        long getRown();

        Clob getContent();

    }
}
