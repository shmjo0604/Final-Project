package com.example.dto;

import lombok.Data;

@Data
public class Apply {
    
    // 신청 번호(sequence) (PK)
	private long no;
	// 신청 참여 인원
	private int person;
	// 회원 아이디(구매자) (FK)
	private String memberid;
	// 유닛 번호 (FK)
	private long unitno;
}
