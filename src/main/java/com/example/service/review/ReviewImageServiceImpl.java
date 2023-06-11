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

    @Override
    public ReviewImage selectReviewImage(long no) {
        try {
            return reviewImageRepository.findByNo(no);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Long> reviewImagelistNo(long no) {
        try {
            return reviewImageRepository.reviewImagelistNo(no);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
