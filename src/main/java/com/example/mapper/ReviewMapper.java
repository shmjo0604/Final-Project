package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.Review;

@Mapper
public interface ReviewMapper {

    // (1) 리뷰 등록
	public int insertReviewOne(Review obj);

    // (2) 리뷰 삭제
	public int deleteReviewOne(long no);
    
}
