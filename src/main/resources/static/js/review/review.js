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

  // let content1 = content.substring(4, 10);


  var input = document.createElement("input");
  input.type = "text";
  input.name = "content";
  input.id = "contentstyle";
  input.value = content;

  form.appendChild(input);

  form.submit();
}

function reviewNone() {
  const button1 = document.getElementById("button1");
  if (button1.style.display !== 'none') {
    button1.style.display = 'none';
    console.log('ok');
  }
  else {
    button1.style.display = 'block';
  }
}



// 신청번호 받아서 프로덕트유닛 내용 불러오기

function modalAction(no, classcode, title, classdate, classstart, classlevel, price, person, classend) {
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

  img.src = "/specialday/member/image?classcode=" + classcode;
  no1.value = no;
  title1.value = "이름 : " + title;
  classdate1.value = classdate;
  classstart1.value = classstart + "~" + classend;
  classlevel1.value = classlevel;
  price1.value = price;

  modal.show();
}

async function modalAction1(no) {
  const modal = new bootstrap.Modal(
    document.getElementById("exampleModal1"),
    {}
  );

  const url = '/specialday/api/member/selectstatuslist.json?no=' + no;
  const headers = { "Content-Type": "application/json" };
  const { data } = await axios.get(url, { headers });

  console.log(data);

  let chk = 0;
  let classlevel = 0;
  let classcode = 0;
  let classstart = "";
  let classend = "";
  let classdate = "";
  let person = 0;
  let price = 0;
  let title = "";
  let payment = "";
  // let no = 0;

  let cancle = document.getElementById('cancle');
  let confirmdate1 = "";
  let confirmdate2 = "";
  let confirmdate3 = "";
  let regdate = ""

  let levelname = "입문자";
  let paymentchk = "";



  for (let tmp of data.list) {

    console.log(tmp.statuschk)

    if (tmp.statuschk == 1) { // 결제완료
      confirmdate1 = tmp.confirmdate + "";
    }
    else if (tmp.statuschk == 2) {// 결제취소
      confirmdate2 = tmp.confirmdate + "";
    }
    else if (tmp.statuschk = 3) { // 참여완료
      confirmdate3 = tmp.confirmdate + "";
    }

    chk = tmp.chk;
    classlevel = tmp.classlevel
    classcode = tmp.classcode
    // classcode = tmp.classcode;
    classstart = tmp.classstart;
    classend = tmp.classend;
    classdate = tmp.classdate;
    payment = tmp.payment;
    person = tmp.person;
    price = tmp.price;
    title = tmp.title;
    // no = tmp.no;
    regdate = tmp.regdate + "";
  }




  confirmdate1 = confirmdate1.substring(0, 10);
  confirmdate2 = confirmdate2.substring(0, 10);
  confirmdate3 = confirmdate3.substring(0, 10);
  regdate = regdate.substring(0, 10);

  console.log(confirmdate1);
  console.log(confirmdate2);
  console.log(confirmdate3);

  // 결제정보, 클래스정보
  const applyregdate2 = document.getElementById("applyregdate1");
  const mainimage3 = document.getElementById("mainimage2");
  const title2 = document.getElementById("title1");
  const classdate3 = document.getElementById("classdate2");
  const classstart2 = document.getElementById("classstart1");
  const classlevel2 = document.getElementById("classlevel1");
  const price2 = document.getElementById("price1");
  const applyregdate3 = document.getElementById("applyregdate2");
  const price3 = document.getElementById("price2");
  const person2 = document.getElementById("person1");
  const payment2 = document.getElementById("payment1");
  let chk2 = document.getElementById("chk1");

  // 취소일자
  const cancledate2 = document.getElementById("cancledate1");
  const price4 = document.getElementById("price3");
  const person3 = document.getElementById("person2");
  const payment3 = document.getElementById("payment2");

  // 신청번호
  const no2 = document.getElementById("no1");

  // 결제완료 color
  if (chk == 1) {
    cancle.style.display = 'none';
    paymentchk = "결제완료";
    chk2.style.color = "#0067a3";
  }
  else if (chk == 2) {
    cancle.style.display = 'block';
    paymentchk = "결제취소";
    chk2.style.color = "#ff0000";
  }
  else if (chk == 3) {
    cancle.style.display = 'none';
    paymentchk = "참여완료";
    chk2.style.color = "#0067a3";
  }

  if (classlevel === 1) {
    levelname = "입문자";
  }
  if (classlevel === 2) {
    levelname = "경험자";
  }
  if (classlevel === 3) {
    levelname = "숙련자";
  }

  console.log(levelname)


  mainimage3.src = "/specialday/member/image?classcode=" + classcode;
  // no2.value = no;
  title2.value = "이름: " + title;
  classdate3.value = classdate;
  classstart2.value = classstart + "~" + classend;
  classlevel2.value = levelname;
  chk2.value = paymentchk;
  person2.value = person + "명";
  person3.value = person + "명";
  price2.value = price + "원";
  price3.value = price + "원";
  price4.value = price + "원";
  payment2.value = payment + "원";
  payment3.value = "-" + payment + "원";
  applyregdate2.value = regdate;
  cancledate2.value = confirmdate2;
  applyregdate3.value = confirmdate1;

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
