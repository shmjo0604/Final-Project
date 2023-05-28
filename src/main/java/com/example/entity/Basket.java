package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "BASKET")
@Entity
@SequenceGenerator(name = "SEQ_BASKET_NO", sequenceName = "SEQ_BASKET_NO", initialValue = 1, allocationSize = 1)
public class Basket {

  // 장바구니 번호(시퀀스)
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BASKET_NO")
  private long no;

  // 신청 인원
  private int cnt;

  // 회원 테이블
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "memberid", referencedColumnName = "ID")
  private Member member;

  // 클래스 유닛(일정) 테이블
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "unitno", referencedColumnName = "NO")
  private ClassUnit classunit;
}
