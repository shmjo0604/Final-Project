package com.example.service.review;

import org.springframework.stereotype.Service;

import com.example.entity.Review;
import com.example.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    final ReviewRepository reviewRepository;

    @Override
    public int insertReview(Review obj) {

        try {
            reviewRepository.save(obj);
            return 1;
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

