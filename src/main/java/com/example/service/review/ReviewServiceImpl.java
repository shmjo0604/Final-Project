package com.example.service.review;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Apply;
import com.example.entity.Review;
import com.example.entity.Reviewview;
import com.example.repository.ApplyRepository;
import com.example.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    final ReviewRepository r1Repository;
    final ApplyRepository applyRepository;

    @Override
    public int insertReview(Review obj) {

        try {
            long no = obj.getNo();

            Apply ret = applyRepository.findById(no).orElse(null);

            obj.setApply(ret);

            r1Repository.save(obj);
            
            return 1;
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int countReview(String id) {
        try {
            return (int) r1Repository.countByNoContaining(id);
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Reviewview> selectListReview(String id,Pageable pageable) {
        try {
           return r1Repository.findByIdIgnoreCaseContainingOrderByNoDesc(id,pageable);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

