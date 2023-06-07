package com.example.service.review;

import org.springframework.stereotype.Service;

import com.example.entity.Apply;
import com.example.entity.Review;
import com.example.repository.ApplyRepository;
import com.example.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    final ReviewRepository reviewRepository;
    final ApplyRepository applyRepository;

    @Override
    public int insertReview(Review obj) {

        try {
            long no = obj.getNo();

            Apply ret = applyRepository.findById(no).orElse(null);

            obj.setApply(ret);

            reviewRepository.save(obj);
            
            return 1;
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

