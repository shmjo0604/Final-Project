package com.example.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ClassProduct {

    // 클래스코드 (sequence) (PK)
	private long classcode;
	// 제목
	private String title;
	// 우편번호
	private String postcode;
	// 도로명주소, 지번주소
	private String address1;
	// 상세주소
	private String address2;
	// 참고항목
	private String address3;
	// 위도
	private String latitude;
	// 경도
	private String longitude;
	// 가격
	private long price;
	// 소개글
	private String intro;
	// 강사소개
	private String instructor;
	// 커리큘럼
	private String curriculum;
	// 조회수
	private long hit;
	// 등록일자
	private Date regdate;
	// 승인여부(0,1)
	private int chk;
	// 상세 지역 카테고리 (FK)
	private int localcode;
	// 상세 클래스 분류 카테고리 (FK)
	private int actdetailcode;
	// 회원 아이디 (FK)
	private String memberid;
    
}
