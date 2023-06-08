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

    // 2. 리뷰목록조회(1)
    public List<Reviewview> selectlistReviewview(String id);

    // 3. 리뷰개수카운트
    public int countReview(String id);

    // 4. 네이티브쿼리 리뷰목록 조회
    public List<Reviewview> selectReviewByIdPagenation(String id, int start, int end);
}
