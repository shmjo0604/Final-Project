package com.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.Apply;
import com.example.dto.ApplyStatus;
import com.example.dto.ApplyView;

@Mapper
public interface ApplyMapper {

    // 1. 클래스 신청 (chk -> (default) 1)
    public int insertApplyBatch(List<Apply> list);

    // 2. 클래스 신청 -> 기록
    public int insertApplyStatusBatch(List<ApplyStatus> list);

    // 3. 클래스 신청 취소 (chk -> 2)
    public int updateApplyCancel(Apply obj);

    // 4. 클래스 참여 완료 (chk -> 3)
    public int updateApplyComplete(List<Apply> list);

    // 5. 클래스 신청 성공 시, 인원수 변경
    public int updateClassUnitApplySuccess(List<Apply> list);

    // 6. 클래스 신청 취소 시 인원수 변경
    public int updateClassUnitApplyCancel(Apply obj);

    // 7. 클래스 신청 내역 조회 -> 페이징 처리(id, first, last)
    public List<ApplyView> selectApplyListById(Map<String, Object> map);

    // 8.전체 개수(페이지네이션용)
    public long countApplyList(String id);

    // 9. 클래스 신청 번호 조회
    public List<Long> selectInsertedApplyNoList(Map<String, Object> map);

    // 9. 신청 전체 개수 조회(chk=1)
    public long countApplyListOne(String id);

    // 10. 신청 전체 개수 조회(chk=2)
    public long countApplyListTwo(String id);

    // 11. 신청 전체 개수 조회(chk=3)
    public long countApplyListThree(String id);

    // 12. 신청 취소(chk: 1 => 2)
    public long updateChk2(Map<String, Object> map);

    // 13. 참여 완료(chk: 1 => 3)
    public long updateChk3(Map<String, Object> map);
}
