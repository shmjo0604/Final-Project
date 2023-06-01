package com.example.service.community;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Community;

import io.lettuce.core.dynamic.annotation.Param;


@Service
public interface CommunityService {
    //커뮤니티 게시글 작성
    // public int insertcommnuityOne(@Param("obj") Community obj);

    //커뮤니티 게시글 전체조회
    public List<Community> selectCommunityList();

    //커뮤니티 게시글 1개 조회
    public Community findByNo(long no);
    


    // //게시글 삭제
    // public int deleteByNo(long no);
}
