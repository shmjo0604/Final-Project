
$(function () {
    var totalpages = $("input[name=pages1]").val();
    let query = window.location.search;
    let param = new URLSearchParams(query);
    let startpage = param.get("page");
    let paramdate = param.get("date")

    $('#pagination-demo1').twbsPagination({

        totalPages: totalpages,
        visiblePages: 5,
        first: '≪',
        last: '≫',
        prev: '<',
        next: '>',
        initiateStartPageClick: false,
        startPage: startpage,
        nextClass: "page-item next",	// 이전 페이지 CSS class
        prevClass: "page-item prev",	// 다음 페이지 CSS class
        lastClass: "page-item last",	// 마지막 페이지 CSS calss
        firstClass: "page-item first",	// 첫 페이지 CSS class
        pageClass: "page-item",	// 페이지 버튼의 CSS class
        activeClass: "active",	// 클릭된 페이지 버튼의 CSS class
        disabledClass: "disabled",	// 클릭 안된 페이지 버튼의 CSS class
        anchorClass: "page-link",	//버튼 안의 앵커에 대한 CSS class	
        onPageClick: function (event, page, date) {
            if (paramdate != null) {
                window.location.href = "mypage.do?menu=2&page=" + page + "&date=" + paramdate;
            }
            else if (paramdate == null) {
                window.location.href = "mypage.do?menu=2&page=" + page;
            }

        }
    });

});

async function modalAction2(no) {
    const modal = new bootstrap.Modal(
        document.getElementById("exampleModal"),
        {}
    );

    const url = '/specialday/api/review/selectreviewOne.json?no=' + no;
    const headers = { "Content-Type": "application/json" };
    const { data } = await axios.get(url, { headers });

    console.log(data);

    let title = document.getElementById('title1');
    let classlevel = document.getElementById('classlevel1');
    let mainimage1 = document.getElementById('mainimage1');
    let classtime = document.getElementById('classtime1');
    let classdate = document.getElementById('classdate1');
    let price = document.getElementById('price1');
    let rating = document.getElementById('rating1');
    let content = document.getElementById('content1');

    // 리뷰이미지 슬라이드
    let rimage0 = document.getElementById('rimage0');
    let rimage1 = document.getElementById('rimage1');
    let rimage2 = document.getElementById('rimage2');
    let rimage3 = document.getElementById('rimage3');

    let ritem = document.getElementById('ritem');

    let levelname = "";
    let ratingif = "";

    // 문자 변환 <p> 태그 제거
    let contentreplace = data.review.content.replace('<p>', "");
    let contentreplace1 = contentreplace.replace('</p>', "");

    // 리뷰 이미지 번호 리스트
    let reviewNolist = [];
    reviewNolist = data.reviewNolist;


    // 클래스 난이도
    if (data.review.classlevel === 1) {
        levelname = "입문자";
    }
    if (data.review.classlevel === 2) {
        levelname = "경험자";
    }
    if (data.review.classlevel === 3) {
        levelname = "숙련자";
    }

    // 레이팅에 따른 별 표시
    if (data.review.rating === 1) {
        ratingif = "★★";
    }
    if (data.review.rating === 2) {
        ratingif = "★★";
    }
    if (data.review.rating === 3) {
        ratingif = "★★★";
    }
    if (data.review.rating === 4) {
        ratingif = "★★★★";
    }
    if (data.review.rating === 5) {
        ratingif = "★★★★★";
    }



    // 리뷰 이미지 조회
    mainimage1.src = "/specialday/member/image?classcode=" + data.review.classcode;
    rimage0.src = "/specialday/review/image?no=" + reviewNolist[0];
    rimage1.src = "/specialday/review/image?no=" + reviewNolist[1];
    rimage2.src = "/specialday/review/image?no=" + reviewNolist[2];
    rimage3.src = "/specialday/review/image?no=" + reviewNolist[3];

    title.value = "이름: " + data.review.title;
    classlevel.value = "난이도: " + levelname;
    classtime.value = "시간: " + data.review.classstart + "~" + data.review.classend;
    classdate.value = "날짜: " + data.review.classdate;
    price.value = "가격: " + data.review.price;
    rating.value = ratingif;
    content.value = contentreplace1;

    modal.show();
}



