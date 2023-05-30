package com.example.service.review;

import org.springframework.stereotype.Service;

import com.example.entity.ReviewImage;

@Service
public interface ReviewImageService {

    // 1. 리뷰이미지등록 
    public int insertReviewImage(ReviewImage obj);
    
}
