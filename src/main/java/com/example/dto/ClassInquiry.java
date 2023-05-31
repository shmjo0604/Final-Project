package com.example.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ClassInquiry {

    //클래스 문의 번호 
	private long no;
    //클래스 문의 제목
	private String title;
    //클래스 문의 내용
	private String content;
    //클래스 문의 처리상태
	private int chk;
    //클래스 문의 날짜
	private Date regdate;
    //클래스 코드(FK)
	private long classcode;
    //멤버 아이디(FK)
	private String memberid;
    
}
