package com.example.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Member;
import com.example.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired MemberMapper mMapper;

    @Override
    public int insertMemberOne(Member obj) {
        try {
            return mMapper.insertMemberOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        } 
    }

    @Override
    public int selectMemberIDCheck(String id) {
        try {
            return mMapper.selectMemberIDCheck(id);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Member selectMemberLogin(Member obj) {
        try {
            return mMapper.selectMemberLogin(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Member selectMemberOne(String id) {
        try {
            return mMapper.selectMemberOne(id);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Member selectFindMemberId(Member obj) {
        try {
            return mMapper.selectFindMemberId(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateMemberOne(Member obj) {
        try {
            return mMapper.updateMemberOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateMemberPassword(Member obj) {
        try {
            return mMapper.updateMemberPassword(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int deleteMemberOne(Member obj) {
        try {
            return mMapper.deleteMemberOne(obj);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
}
