package com.example.service.review;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Review;
import com.example.entity.Reviewview;

@Service
public interface ReviewService {

    // 1. 리뷰등록
    public int insertReview(Review obj);

    // 2. 리뷰목록조회
    public List<Reviewview> selectListReview(String id, Pageable pageable);

    // 3. 리뷰목록조회(1)
    public List<Reviewview> selectlistReviewview(String id);

    // 4. 리뷰개수카운트
    public int countReview(String id);

    // 5. 네이티브쿼리 리뷰목록 조회(최신순)
    public List<Reviewview> selectReviewByIdPagenation(String id, int start, int end);

    // 6. 리뷰 하나만 조회
    public Reviewview selectReviewOne(String id, long no);

    // 7. 리뷰 전체 평균값
    public int avgReview(String id);

    // 8. 네이티브쿼리 리뷰목록 조회(오래된순)
    public List<Reviewview> selectReviewByIdPagenationAsc(String id, int start, int end);
}
