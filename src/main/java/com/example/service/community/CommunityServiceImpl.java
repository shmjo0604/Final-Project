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
    public CommunityRepository cRepository;

    @Override
    public int insertCommnuityOne(Community obj) {
        try {
            cRepository.save(obj);
            return 1;
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Community> selectCommunityList(int first, int last) {
        try {
            return cRepository.selectOrderByNoDescPaging(first, last);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public long countCommunityList() {
        try {
            return cRepository.countBy();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Community selectCommunityOne(long no) {
        try {
            return cRepository.findById(no).orElse(null);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    

}
