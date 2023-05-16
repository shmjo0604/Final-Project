package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.Apply;
import com.example.dto.ApplyStatus;

@Mapper
public interface ApplyMapper {

    // 1. 신청 등록 (chk -> 1)
    public int insertApplyOne(Apply obj);

    // 2. 신청 취소 (chk -> 2)
    public int updateApplyCancel(long no);

    // 3. 참여 완료 (chk -> 3)
    public int updateApplyComplete(long no);

    // 4. 신청 상태 등록(chk -> 1 or 2 or 3)
    public int insertApplyStatusOne(ApplyStatus obj);

    // 7. 신청 시 기본 정보 조회(ApplyView) 

    // 8. 신청 내역 조회(List<ApplyView> -> paging)

    
    
}
