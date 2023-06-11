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

        // 1. 리뷰 목록 조회(페이지네이션) => 쿼리문오류 작동x(limit문제)
        List<Reviewview> findByIdIgnoreCaseOrderByRegdateDesc(String id, Pageable pageable);

        List<Reviewview> findById(String id);

        // 2. 리뷰테이블 개수 카운트
        int countByIdContaining(String id);

        // 데이터 받아오는 테이블이 Review -> Reviewview로 바뀌면서 save 메소드가 없다는 오류가 떠서 빠른해결 클릭 (아마
        // review기본 타입에는 save가 있는데 reviewview에는 업어서 그런듯)
        void save(Review obj);

        // 3. 리뷰목록조회 (nativequery사용, 최신순)
        @Query(value = "SELECT * FROM ( SELECT r.*, ROW_NUMBER() OVER (ORDER BY regdate DESC) rown FROM REVIEWVIEW r WHERE r.id =:id) WHERE rown BETWEEN :start AND :end ORDER BY regdate DESC", nativeQuery = true)
        public List<Reviewview> selectReviewByIdPagenation(@Param("id") String id, @Param("start") int start,
                        @Param("end") int end);

        // 4. 리뷰하나 조회(applyno에 해당하는 리뷰)
        public Reviewview findByIdAndNo(String id, long no);

        // 5. 리뷰 평균 값
        @Query(value = "SELECT ROUND( avg(rating),2)FROM REVIEWVIEW r WHERE id =:id", nativeQuery = true)
        public int avgReview(@Param("id") String id);

        // 5. 리뷰목록조회 (nativequery사용, 오래된순)
        @Query(value = "SELECT * FROM ( SELECT r.*, ROW_NUMBER() OVER (ORDER BY regdate ASC) rown FROM REVIEWVIEW r WHERE r.id =:id) WHERE rown BETWEEN :start AND :end ORDER BY regdate ASC", nativeQuery = true)
        public List<Reviewview> selectReviewByIdPagenationAsc(@Param("id") String id, @Param("start") int start,
                        @Param("end") int end);

}
