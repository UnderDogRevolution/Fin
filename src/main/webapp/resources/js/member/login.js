// 아이콘 전역 변수 선언

// 성공 아이콘
const validIcon = '<svg width="15" height="15" viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M7.5 1.25C4.05 1.25 1.25 4.05 1.25 7.5C1.25 10.95 4.05 13.75 7.5 13.75C10.95 13.75 13.75 10.95 13.75 7.5C13.75 4.05 10.95 1.25 7.5 1.25ZM6.25 10.625L3.125 7.5L4.00625 6.61875L6.25 8.85625L10.9937 4.1125L11.875 5L6.25 10.625Z" fill="#44DE1D"/> </svg>';

// 실패 아이콘
const invalidIcon = '<svg width="15" height="15" viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M7.5 1.25C4.04375 1.25 1.25 4.04375 1.25 7.5C1.25 10.9563 4.04375 13.75 7.5 13.75C10.9563 13.75 13.75 10.9563 13.75 7.5C13.75 4.04375 10.9563 1.25 7.5 1.25ZM10.625 9.74375L9.74375 10.625L7.5 8.38125L5.25625 10.625L4.375 9.74375L6.61875 7.5L4.375 5.25625L5.25625 4.375L7.5 6.61875L9.74375 4.375L10.625 5.25625L8.38125 7.5L10.625 9.74375Z" fill="#F82F2F"/> </svg>';

// 로그인 창 입력값 검사용 객체
const loginCheckObj = {

  "email" : false,
  "password" : false

};


// ******************** 로그인 ********************


// 이메일 유효성 검사

// 아이디 저장했을 경우 로딩되면 검사 실행
$(function(){
	const emailExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
	const emailCheckInput = $("#memberEmail").next();
	
	if( emailExp.test( $("#memberEmail").val() )){
		emailCheckInput.html(validIcon);
    	loginCheckObj.email = true;
	}
	
});

$("#memberEmail").on("input", function(){

  const memberEmail = $(this).val();
  const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
  const checkInput = $(this).next();

  if(memberEmail.length == 0){
    checkInput.html("");
    loginCheckObj.email = false;
  }
  else if(regExp.test(memberEmail)){
    checkInput.html(validIcon);
    loginCheckObj.email = true;
  }
  else{
    checkInput.html(invalidIcon);
    loginCheckObj.email = false;
  }

  loginValidate();

});



// 비밀번호 유효성 검사
$("#memberPw").on("input",function(){

  const memberPw = $(this).val();
  // 영문, 숫자, 특수문자 6~20 글자
  const regExp = /^[a-zA-Z\d$`~!@$!%*#^?&\\(\\)\-_=+]{6,20}$/;
  const checkInput = $(this).next();

  if(memberPw.length == 0){
    checkInput.html("");
    loginCheckObj.password = false;
  }
  else if(regExp.test(memberPw)){
    checkInput.html(validIcon);
    loginCheckObj.password = true;
  }
  else{
    checkInput.html(invalidIcon);
    loginCheckObj.password = false;
  }

  loginValidate();

});

// 로그인 버튼 비활성화 함수
function loginValidate(){

  if(loginCheckObj.email == true && loginCheckObj.password == true){
    $("#login-btn").removeAttr("disabled");
  }else{
    $("#login-btn").attr("disabled", true);
  }

};

