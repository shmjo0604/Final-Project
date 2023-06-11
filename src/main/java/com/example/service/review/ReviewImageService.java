package com.example.service.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.ReviewImage;

@Service
public interface ReviewImageService {

    // 1. 리뷰이미지등록
    public int insertReviewImage(List<ReviewImage> obj);

    // 2. 리뷰 이미지 조회
    public ReviewImage selectReviewImage(long no);

    // 3. 리뷰이미지 번호 조회
    public List<Long> reviewImagelistNo(long no);

}
