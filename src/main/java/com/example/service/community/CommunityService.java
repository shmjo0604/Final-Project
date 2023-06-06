package com.example.service.community;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Community;



@Service

public interface CommunityService {

  
    //커뮤니티 게시글 작성
    //public int insertcommnuityOne();

    //커뮤니티 게시글 전체조회
    public List<Community> selectCommunityList();

    //커뮤니티 게시글 1개 조회
    public Community findByNo(long no);
    


 

}
