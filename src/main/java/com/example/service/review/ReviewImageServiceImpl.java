package com.example.service.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.ReviewImage;
import com.example.repository.ReviewImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewImageServiceImpl implements ReviewImageService {

    final ReviewImageRepository reviewImageRepository;

    @Override
    public int insertReviewImage(List<ReviewImage> obj) {

        try {
            reviewImageRepository.saveAll(obj);
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;

        }
    }
}
