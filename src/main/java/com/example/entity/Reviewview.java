package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

import lombok.Data;

@Data
@Immutable
@Entity
@Table(name = "REVIEWVIEW")
public class Reviewview {

    @Id
    @Column(name = "NO")
    private long no;

    @Lob
    @Column(name = "CONTENT")
    private String content;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "REGDATE")
    private Date regdate;

    @Column(name = "HIT")
    private int hit;

    // 임의 추가
    @Column(name = "ID")
    private String id;

    @Column(name = "CLASSCODE")
    private long classcode;

    @Column(name = "TITLE")
    private String title;

}
