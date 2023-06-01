package com.example.service.review;

import org.springframework.stereotype.Service;

import com.example.entity.Review;



@Service
public interface ReviewService {
    
    // 1. 리뷰등록 
    public int insertReview(Review obj);
}
   
