
$(function () {
    var totalpages = $("input[name=pages1]").val();
    let query = window.location.search;
    let param = new URLSearchParams(query);
    let startpage = param.get("page");

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
        onPageClick: function (event, page) {
            window.location.href = "mypage.do?menu=2&page=" + page;
        }
    });
});