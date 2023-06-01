package com.example.service.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Community;
import com.example.repository.CommunityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
    
    @Autowired
    CommunityRepository cRepository;

    // 게시글 작성
    // @Override
    // public int insertcommnuityOne(Community obj) {
    // try {
    // return cRepository.save();
    // } catch (Exception e) {

    // throw new UnsupportedOperationException("Unimplemented method
    // 'insertcommnuityOne'");
    // }
    // }
    // 게시글 전체 조회
    @Override
    public List<Community> selectCommunityList() {
        try {
            return cRepository.findAllByOrderByNoDesc();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // 게시글 1개조회
    @Override
    public Community findByNo(long no) {
        try {
            return cRepository.findByNo(no);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}