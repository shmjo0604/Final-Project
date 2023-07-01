
# PORTFOLIO
# :clipboard: 목차

- :books: <a href="#outline">개요</a>
- :wrench: <a href="#tech">기술스택</a>
- :family: <a href="#team">팀원소개</a>
- :bookmark_tabs: <a href="#function">기능구현</a>
  - 회원가입
  - 비밀번호 찾기(인증)
  - 클래스 등록
  - 일정등록/조회
  - 클래스 검색/조회
  - 클래스 신청(장바구니)
  - 신청/리뷰내역 조회
  - 신청/문의 알람
  - 결제
  - 커뮤니티
  - 로그인-아이디찾기
- :bulb: <a href="#result">결론</a>
- :mag_right: <a href="#fullfill">보완할점</a>
- :bookmark: <a href="#url">배포</a><br/>


# :books: <a name="outline">개요</a>
<br/>
<img src="https://github.com/pknu05/Final-Project/assets/123917210/6e677789-5a8b-4b94-a395-8923180659e2.png">

<img src="https://raw.githubusercontent.com/pknu05/Final-Project/main/src/main/resources/static/image/비밀번호 찾기.gif?token=GHSAT0AAAAAACEIXGGXGQ3S4RMCNNCYLKPKZE4JGMA">

>**프로젝트**: 원데이클래스 사이트
>
>**기획 및 제작** : 스페셜데이
>
>**분류**: 팀프로젝트
>
>**제작 기간**: 2023.05.19 ~ 2023.06.13
>
>**프로젝트 주제**: 바쁜 일상속에서 자신에게 특별한 하루를 선물해줄 수 있는 원데이클래스 사이트 제작 

<br/>

# :wrench: <a name="tech">기술스택</a>
<h4>데이터베이스</h4>
<div align="left">
   <img src="https://img.shields.io/badge/ORACLE-F80000?style=for-the-badge&logo=oracle&logoColor=white" />
   <img src="https://img.shields.io/badge/H2-232F3E?style=for-the-badge&logo=h2&logoColor=white" />
   <img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white" />
</div> 
<h4>백엔드</h4>
<div align="left">
    <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=Java&logoColor=white"/>
     <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
    <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white" />
     <img src="https://img.shields.io/badge/JPA-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />
    <img src="https://img.shields.io/badge/MyBatis-232F3E?style=for-the-badge&logo=mybatis&logoColor=white" />
</div>
</div> 
<h4>프론트엔드</h4>
<div align="left">
   <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"/>
   <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white"/>
     <img src="https://img.shields.io/badge/JAVASCRIPT-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"/>
   <img src="https://img.shields.io/badge/jquery-000000?style=for-the-badge&logo=jquery&logoColor=white" />
   <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white" />
   <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white" />
     <img src="https://img.shields.io/badge/Axios-5A29E4?style=for-the-badge&logo=axios&logoColor=white">
</div>
<h4>배포</h4>
<div align="left">
   <img src="https://img.shields.io/badge/AWS-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white" />
   <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" />
</div>
<h4>협업도구</h4>
<div align="left">
   <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white" />
   <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white" />
   <img src="https://img.shields.io/badge/FIGMA-F24E1E?style=for-the-badge&logo=figma&logoColor=white" />
</div>

# :family: <a name="team">팀원 역할 및 소개</a>
<div><br/>
	
<h3>● 서명호</h3>

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Back-end : 회원정보수정, 클래스 검색(조회), 신청/문의 알람, 이메일 인증, 클래스 신청, 결제
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front-end : 메인페이지(header), 클래스검색 페이지, 클래스상세 페이지

<h3>● 김은정</h3>

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Back-end :  클래스 등록, 클래스 수정, 클래스 목록조회, 문의내역 조회(판매자), 
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front-end : 메인페이지, 클래스등록 페이지, 클래스관리 페이지, 문의내역(판매자)

<h3>● 이성희</h3>

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Back-end : 클래스 승인, 클래스 활성/비활성, 일정등록, 일정조회 및 수정, 클래스 참여승인 	
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front-end : 마이페이지, 일정관리 페이지, 신청관리 페이지

<h3>● 박성주</h3>

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Back-end : 로그인, 아이디/비번번호 찾기, 회원탈퇴, 커뮤니티 관리, 댓글등록
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front-end : 로그인 페이지, 아이디/비밀번호 찾기페이지, 커뮤니티 페이지 

<h3>● 천현빈</h3>

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Back-end : 장바구니 추가, 장바구니 수정 및 삭제, 장바구니 조회, 결제정보 조회
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front-end : 장바구니 페이지, 결제확인 페이지, 결제완료 페이지

<h3>● 이재호</h3>

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Back-end : 신청 내역조회, 결제 상세정보, 리뷰내역 조회, 리뷰 상세보기, 리뷰추천
##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front-end : 마이페이지, 신청목록 페이지, 리뷰목록 페이지, 결제상세 페이지, 리뷰상세 페이지

</div><br/>

# :bookmark_tabs: <a name="function">기능구현(최종 배포파일)</a>
<br/>


**1. 비밀번호 찾기(인증)**

<img src="https://github.com/pknu05/Final-Project/assets/123917210/dcbc2f02-b024-4701-acf4-1578e9f7f045"><br/><br/>

<예시>
- SimpleMailMessage 클래스를 이용하여 메일 내용 설정
- JavaMailSender를 이용하여 Gmail로 고객에게 인증번호 전송
- 전송된 인증번호를 입력하여 인증확인
<br/>

**2. 클래스 등록**

<img src="https://github.com/pknu05/Final-Project/assets/123917210/98266ef9-db63-4943-8d4a-180023c9cbf9"> <br/><br/>

- KakaoLocalAPI를 이용하여 주소 기반 위도, 경도 값 반환(Map)하여 등록
- ClassController를  이용하여 DB에 값 등록
<br/>

**3. 일정등록/조회**

<img src="https://github.com/pknu05/Final-Project/assets/123917210/4ab8e4e6-09e3-4f48-b3b7-a616f7fa5a2a"> <br/><br/>

- 모달을 통하여 일정을 DB에 등록
- 추가된 클래스를 전체일정이라는 사이드바 페이지를 이용해 클래스 수정 및 삭제

<br/>

**4. 클래스 검색/조회**

<img src="https://github.com/pknu05/Final-Project/assets/123910896/0b57b0f5-1818-4c37-a131-933872858fef"> <br/><br/>

- 검색 옵션 ( 지역 분류, 클래스 분류, 날짜, 난이도, 가격 ) 선택 후, 해당 조건에 맞는 클래스 목록 검색
- 지역 및 날짜 선택 시, 지도 범위 내에 해당 조건에 맞는 클래스 장소 마커 표시 ( 카카오 맵 API 활용 → 오버레이 활용, 각 클래스 대표 이미지를 마커로 사용, 복수 마커 )
<br/>

**5. 클래스 신청(장바구니)**

<img src="https://github.com/pknu05/Final-Project/assets/123910896/8b682cf6-86a1-422b-9642-5b2946c5dd8d"> <br/><br/>

- 주문한 클래스를 장바구니에 저장했을 때 장바구니 페이지에서 주문한 목록을 출력
- checkbox로 체크되어있는 목록은 신청인원과 자동으로 계산이 되어 결제 금액에 총 금액이 출력
- 선택된 checkbox 값을 통하여 BasketController를 통하여 삭제 기능 구현을 구현
- 결제 화면버튼을 이용하여 결제 페이지로 이동
<br/>

**6. 신청/리뷰내역 조회**

<img src="https://github.com/pknu05/Final-Project/assets/123910896/cef7e83e-60ca-40c4-b821-969321412ffd"> <br/><br/>

- 리뷰 내용 작성 ( 참여 완료 상태일 때만 가능)
- 평점 입력 (1~5), 내용 입력(editor 사용), 이미지 첨부(개수 제한)
- 내가 작성한 리뷰 내역 전체 조회 ( Pagination )
- 리뷰 작성 내역 상세 확인 ( RestController )
- 해당 클래스 리뷰 내역 확인(RestController, Pagination)
<br/>

**7. 신청/문의 알람**

<img src=""> <br/><br/>

- 해당 클래스 문의 등록(문의하기 Modal) ⇒ 로그인 상태가 아닐 시, 로그인 페이지 이동
- 내 클래스 문의 내역 확인 및 처리 상태 확인
- 답변 대기 상태 시, 문의 답변 가능
- 문의 답변 (Modal)
<br/>

**8. 결제**

<img src="https://github.com/pknu05/Final-Project/assets/123910896/a7b3d7c8-6bfd-490b-88a6-f07a8fd1f1ae"> <br/><br/>

- 
- 
- 
<br/>

**9. 커뮤니티**

<img src="https://github.com/pknu05/Final-Project/assets/123910896/fd403bf2-7428-46a8-b5d2-a1d5068c537c"> <br/><br/>

- CommunityController를 이용하여 DB에 등록
- 페이지네이션 활성화
- 로그인이 되었을 때만 댓글 작성가능 (로그인이 되어있지 않은 상태에서 댓글입력시 로그인화면으로 이동)
<br/>

**10. 회원가입**

<img src=""> <br/><br/>

- MemberController로 DB에 저장
- 중복된 아이디에 대해서는 사용불가 알림
  (탈퇴된 아이디도 재사용 불가능)
- 회원가입시 조건 충족되지 않을시 회원가입 안됨
<br/> 

**11. 아이디찾기(인증)**

<img src=""> <br/><br/>

- 이름 이메일 전화번호 하나라도 저장된 정보와 다르면 아이디 정보 제공되지 않음
- 아이디 찾기로 아이디 정보가 뜰경우에만 비밀번호 재설정 버튼 활성화

<br/> 
**12. 비밀번호교체 회원탈퇴**

<img src="https://github.com/pknu05/Final-Project/assets/123910896/9a66befd-5ac0-4b21-825e-1b9af54a22e7"> <br/><br/>

- 사용하는 ID와 현재 비밀번호, 새 비밀번호 입력해야 비밀번호 변경 가능능
- 비밀번호를 입력한뒤 탈퇴 동의서 체크해야 회원탈퇴 가능

<br/> 

# :bulb: <a name="result">결론(수정필요)</a>

웹 개발 프로젝트를 진행하면서 주제 선정, ERD 설계, 기능 정의, 프로토타입 설정, 사전 조사의 중요성을 알게 되었습니다. 이러한 단계를 통해 프로젝트를 시작하기 전 팀원들과 함께 체계적인 사전 설계를 하였고, 그 결과 프로젝트의 원활한 진행과 프로젝트의 목표에 부합하는 사이트를 제작할 수 있었습니다.

프로젝트에서 백엔드와 프론트엔드 역할을 구분하지 않고, 팀원들이 두 가지 역할을 모두 수행하면서 프로젝트의 요구사항과 개발 환경에 맞게 MyBatis와 JPA를 활용하여  데이터베이스와의 상호작용을 구현했습니다. 또한 HTML5, CSS, JavaScript를 활용하여 화면을 구성하였고 이를 통해 웹 사이트 전반적인 개발 과정을 이해할 수 있었으며 백엔드와 프론트엔드의 중요성을 인지했습니다.

프로젝트의 협업을 위해 Notion이나 GitHub와 같은 도구를 적극적으로 활용하여 팀원들과의 의사소통, 작업 일정 관리, 코드 버전 관리 등을 효과적으로 진행했습니다. 또한 구글 캘린더나 다음 주소와 같은 외부 API를 활용하여 사이트에 다양한 기능을 추가해 필요한 기능을 구현하고 사용자의 편의성을 증대시키는 것도 중요하다는 점을 알았습니다.

마지막으로, 개발자 입장에서 좋은 사이트를 만드는 것도 중요하지만 사용자 입장에서 편리하고 유용한 사이트를 만드는 것이 더욱 중요하다는 점, 사용자의 니즈와 요구사항을 고려하여 사용자 경험을 최적화하는 노력이 필요하다는 것을 인지했습니다.<br/><br/>

# :mag_right: <a name="fullfill">보완할점(수정필요)</a>

- ERD 설계시 테이블 사이의 관계를 명확하게 설계하지 못했던 점
- 테이블 view 생성시 여러번 번복하여 작업시간이 길이진 점
- DTO/Entity 설계시 네이밍 규칙이 미흡했던 점
- 프로젝트 진행 도중 중간점검을 하지 않고, 최종 병합시 오류를 수정한 점
- 반응형 웹을 이용하여 사이즈에 따른 페이지 깨짐이 없었어야한 점
- 스크립트와 css의 버전 혹은 위치가 달라 페이지의 기능과 스타일 정상적으로 수행이 되지 않았던 점 

# :bookmark: <a name="url">배포</a>
<a href="http://13.125.14.162:8080/ROOT2/orca/home.do">Orca Web Page</a>
- AWS를 이용한 배포
