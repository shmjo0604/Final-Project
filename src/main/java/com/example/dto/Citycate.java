package com.example.dto;

import lombok.Data;

@Data
public class Citycate {

    // 지역 코드 (sequence)
    private int code;

    // 지역
    // 서울, 경기, 부산, 인천, 대구, 울산, 광주, 대전,
    // 경상남도, 경상북도, 전라남도, 전라북도, 충청남도, 충청북도, 강원도, 제주도, 세종
	private String cate;
    
}
