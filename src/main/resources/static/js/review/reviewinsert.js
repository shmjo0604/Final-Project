// Initialize Quill editor 
const toolbarOptions = [['bold', 'italic', 'underline', 'strike'], // toggled buttons
['blockquote', 'code-block'], [{
    'header': 1
}, {
    'header': 2
}], // custom button values
[{
    'list': 'ordered'
}, {
    'list': 'bullet'
}], [{
    'script': 'sub'
}, {
    'script': 'super'
}], // superscript/subscript
[{
    'indent': '-1'
}, {
    'indent': '+1'
}], // outdent/indent
[{
    'direction': 'rtl'
}], // text direction[ {'size' : [ 'small', false, 'large', 'huge' ]} ], // custom dropdown
[{
    'header': [1, 2, 3, 4, 5, 6, false]
}], [{
    'color': []
}, {
    'background': []
}], // dropdown with defaults from theme
[{
    'font': []
}], [{
    'align': []
}],];

// 위쪽에 있는 태그중에서 id가 editor인것을 찾아서 toolbar는 toolbarOptions 값으로 대체하고 테마를 snow로 해서 변경
const quill = new Quill('#editor', {
    modules: {
        toolbar: toolbarOptions
    },
    theme: 'snow'
});

// 리뷰이미지 함수(1234)

function preview1() {
    document.getElementById("click_reviewimage1").click();
}
function readURL1(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('insert_reviewimage1').src = e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
    } else {
        document.getElementById('insert_reviewimage1').src = "";
    }
}

function preview2() {
    document.getElementById("click_reviewimage2").click();
}
function readURL2(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('insert_reviewimage2').src = e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
    } else {
        document.getElementById('insert_reviewimage2').src = "";
    }
}

function preview3() {
    document.getElementById("click_reviewimage3").click();
}
function readURL3(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('insert_reviewimage3').src = e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
    } else {
        document.getElementById('insert_reviewimage3').src = "";
    }
}

function preview4() {
    document.getElementById("click_reviewimage4").click();
}
function readURL4(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('insert_reviewimage4').src = e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
    } else {
        document.getElementById('insert_reviewimage4').src = "";
    }
}

// 에디터 내용 전달

function getEditorContent() {

    const content = quill.root.innerHTML; //위쪽의 editor객체를 통해서 가져오기
    const form = document.getElementById("myform");

    console.log(content.value);

    var input = document.createElement("input");
    input.type = "text";
    input.name = "content";
    input.id= "contentstyle"
    input.value = content;
    form.appendChild(input);

    form.submit();
}

// 신청번호 받아서 프로덕트유닛 내용 불러오기

function modalAction(no,title,classdate,classstart,classlevel,price,cnt){
    const modal = new bootstrap.Modal(document.getElementById("exampleModal"),{});

    console.log(cnt)
    console.log(price)    

        const no1 = document.getElementById("no");
        const title1 = document.getElementById("title");
		const classdate1 = document.getElementById("classdate");
		const classstart1 = document.getElementById("classstart");
		const classlevel1 = document.getElementById("classlevel");
		const price1 = document.getElementById("price");
		// const cnt1 = document.getElementById("cnt");


        no1.value=no
        title1.value=title
        classdate1.value=classdate
        classstart1.value=classstart
        classlevel1.value=classlevel
        price1.value=price
        // cnt1.value=cnt
        
		modal.show(); 
}