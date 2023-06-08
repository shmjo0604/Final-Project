// Initialize Quill editor
const toolbarOptions = [
  ["bold", "italic", "underline", "strike"], // toggled buttons
  ["blockquote", "code-block"],
  [
    {
      header: 1,
    },
    {
      header: 2,
    },
  ], // custom button values
  [
    {
      list: "ordered",
    },
    {
      list: "bullet",
    },
  ],
  [
    {
      script: "sub",
    },
    {
      script: "super",
    },
  ], // superscript/subscript
  [
    {
      indent: "-1",
    },
    {
      indent: "+1",
    },
  ], // outdent/indent
  [
    {
      direction: "rtl",
    },
  ], // text direction[ {'size' : [ 'small', false, 'large', 'huge' ]} ], // custom dropdown
  [
    {
      header: [1, 2, 3, 4, 5, 6, false],
    },
  ],
  [
    {
      color: [],
    },
    {
      background: [],
    },
  ], // dropdown with defaults from theme
  [
    {
      font: [],
    },
  ],
  [
    {
      align: [],
    },
  ],
];

// 위쪽에 있는 태그중에서 id가 editor인것을 찾아서 toolbar는 toolbarOptions 값으로 대체하고 테마를 snow로 해서 변경
const quill = new Quill("#editor", {
  modules: {
    toolbar: toolbarOptions,
  },
  theme: "snow",
});

// 리뷰이미지 함수(1234)

function preview1() {
  document.getElementById("click_reviewimage1").click();
}
function readURL1(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function (e) {
      document.getElementById("insert_reviewimage1").src = e.target.result;
    };
    reader.readAsDataURL(input.files[0]);
  } else {
    document.getElementById("insert_reviewimage1").src = "";
  }
}

function preview2() {
  document.getElementById("click_reviewimage2").click();
}
function readURL2(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function (e) {
      document.getElementById("insert_reviewimage2").src = e.target.result;
    };
    reader.readAsDataURL(input.files[0]);
  } else {
    document.getElementById("insert_reviewimage2").src = "";
  }
}

function preview3() {
  document.getElementById("click_reviewimage3").click();
}
function readURL3(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function (e) {
      document.getElementById("insert_reviewimage3").src = e.target.result;
    };
    reader.readAsDataURL(input.files[0]);
  } else {
    document.getElementById("insert_reviewimage3").src = "";
  }
}

function preview4() {
  document.getElementById("click_reviewimage4").click();
}
function readURL4(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function (e) {
      document.getElementById("insert_reviewimage4").src = e.target.result;
    };
    reader.readAsDataURL(input.files[0]);
  } else {
    document.getElementById("insert_reviewimage4").src = "";
  }
}

// 에디터 내용 전달

function getEditorContent() {
  const content = quill.root.innerHTML; //위쪽의 editor객체를 통해서 가져오기
  const form = document.getElementById("myform");

  var input = document.createElement("input");
  input.type = "text";
  input.name = "content";
  input.id = "contentstyle";
  input.value = content;
  form.appendChild(input);

  form.submit();
}

// 신청번호 받아서 프로덕트유닛 내용 불러오기

function modalAction(no, classcode, price, title, classdate, classlevel, classstart, classend) {
  const modal = new bootstrap.Modal(
    document.getElementById("exampleModal"),
    {}
  );

  const img = document.getElementById("mainimage1");
  const no1 = document.getElementById("no");
  const title1 = document.getElementById("title");
  const classdate1 = document.getElementById("classdate");
  const classstart1 = document.getElementById("classstart");
  const classlevel1 = document.getElementById("classlevel");
  const price1 = document.getElementById("price");

  img.src = "http://127.0.0.1:8080/specialday/member/image?classcode=" + classcode;
  no1.value = no;
  title1.value = "이름 :" + title;
  classdate1.value = classdate;
  classstart1.value = classstart + "~" + classend;
  classlevel1.value = classlevel;
  price1.value = price;

  modal.show();
}

async function modalAction1(chk, person, totalprice, no, classcode, price, title, classdate, classlevel, classstart, classend, applyregdate, cancledate) {
  const modal = new bootstrap.Modal(
    document.getElementById("exampleModal1"),
    {}
  );

  const url = '/specialday/api/member/selectstatuslist.json?no=' + no;
  const headers = { "Content-Type": "application/json" };
  const { data } = await axios.get(url, { headers });

  console.log(data);
  console.log();

  let nono = new Array();//배열선언
  let confirmdate1 = "";
  let confirmdate2 = "";
  let regdate1 = "";

  for (let tmp of data.list) {
    if (tmp.statuschk == 1) { // 결제완료
      confirmdate1 = tmp.confirmdate;
    }
    if (tmp.statuschk == 2) { // 결제취소
      confirmdate2 = tmp.confirmdate;
    }
    if (tmp.statuschk == 3) { // 참여완료
      confirmdate1 = tmp.confirmdate;
    }
    regdate1 = tmp.regdate;
  }

  let confirmdate11 = "";
  let confirmdate22 = "";
  let regdate11 = "";

  confirmdate11 = confirmdate1.substring(0, 10);
  confirmdate22 = confirmdate2.substring(0, 10);
  regdate11 = regdate1.substring(0, 10);

  console.log(confirmdate11);
  console.log(confirmdate22);
  console.log(regdate11);

  var result = applyregdate.substring(0, 10)
  var result1 = result.replace("-", "/");
  var result2 = result1.replace("-", "/");

  var result = cancledate.substring(0, 10)
  var result11 = result.replace("-", "/");
  var result22 = result11.replace("-", "/");

  const img2 = document.getElementById("mainimage2");
  const no2 = document.getElementById("no1");
  const title2 = document.getElementById("title1");
  const cancledate1 = document.getElementById("cancledate");
  const classdate2 = document.getElementById("classdate2");
  const classstart2 = document.getElementById("classstart1");
  const classlevel2 = document.getElementById("classlevel1");
  const price2 = document.getElementById("price1");
  const price3 = document.getElementById("price2");
  const price4 = document.getElementById("price3");
  const person2 = document.getElementById("person1");
  const person3 = document.getElementById("person2");
  let chk2 = document.getElementById("chk1");
  const totalprice2 = document.getElementById("totalprice1");
  const totalprice4 = document.getElementById("totalprice3");
  const applyregdate2 = document.getElementById("applyregdate1");
  const applyregdate3 = document.getElementById("applyregdate2");

  let chkname = "처리중";

  // 결제완료 color
  if (chk === 1) {
    cancle.style.display = 'none';
    chkname = "결제완료";
    chk2.style.color = "#0067a3";
  }
  else if (chk === 2) {
    cancle.style.display = 'block';
    chkname = "결제취소";
    chk2.style.color = "#ff0000";
  }
  else if (chk === 3) {
    cancle.style.display = 'none';
    chkname = "참여완료";
    chk2.style.color = "#0067a3";
  }


  let levelname = "입문자";
  if (classlevel === 2) {
    levelname = "경험자";
  }
  if (classlevel === 3) {
    levelname = "숙련자";
  }


  img2.src = "http://127.0.0.1:8080/specialday/member/image?classcode=" + classcode;
  no2.value = no;
  title2.value = "이름: " + title;
  classdate2.value = classdate;
  classstart2.value = classstart + "~" + classend;
  classlevel2.value = levelname;
  chk2.value = chkname;
  person2.value = person + "명";
  person3.value = person + "명";
  price2.value = price + "원";
  price3.value = price + "원";
  price4.value = price + "원";
  totalprice2.value = totalprice + "원";
  totalprice4.value = "- " + totalprice + "원";
  applyregdate2.value = regdate11;
  cancledate1.value = confirmdate22;
  applyregdate3.value = confirmdate11;

  modal.show();
}


function formaction(no) {
  const form = document.getElementById("form1")


  form.action = "http://192.168.219.103:8080/specialday/member/updatechk1.do";
  form.style.display = "none";
  form.method = "get";

  const input = document.createElement("input");
  input.type = "hidden";
  input.name = "no";
  input.value = no;

  form.appendChild(input);

  form.submit();
}
