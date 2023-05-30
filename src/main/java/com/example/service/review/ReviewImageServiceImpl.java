package com.example.service.review;

import org.springframework.stereotype.Service;

import com.example.entity.ReviewImage;
import com.example.repository.ReviewImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewImageServiceImpl implements ReviewImageService {

    final ReviewImageRepository reviewImageRepository;

    @Override
    public int insertReviewImage(ReviewImage obj) {

    reviewImageRepository.save(obj);
        return 1;
    }
}
