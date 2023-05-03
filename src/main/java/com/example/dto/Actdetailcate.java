package com.example.dto;

import lombok.Data;

@Data
public class Actdetailcate {

    // 101,102,103
    private long code;
    // 하위 카테고리 명칭
    private String actcate;
    // 1, 2, 3
    private long actcode;

}
