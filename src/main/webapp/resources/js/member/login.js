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
$("#userEmail").on("input", function(){

  const userEmail = $(this).val();
  const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
  const checkInput = $(this).next();

  if(userEmail.length == 0){
    checkInput.html("");
    loginCheckObj.email = false;
  }
  else if(regExp.test(userEmail)){
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
$("#userPw").on("input",function(){

  const userPw = $(this).val();
  // 영문, 숫자, 특수문자 6~20 글자
  const regExp = /^[a-zA-Z\d$`~!@$!%*#^?&\\(\\)\-_=+]{6,20}$/;
  const checkInput = $(this).next();

  if(userPw.length == 0){
    checkInput.html("");
    loginCheckObj.password = false;
  }
  else if(regExp.test(userPw)){
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


// 로그인 수행 (ajax 이용)
// Controller에서 ResponseBody로 값만 얻어오고 
// 스크립트에서 화면 처리하면 될듯
// 못만들거같으면 기존 방식대로

/*

$("#login-form").on("submit", function(){

  $.ajax({

    url : "login",
    data : {"userEmail" : userEmail, "userPw" : userPw, "saveId" : saveId},
    type : "POST",

    success : function(result){

      if(result > 0){ // 로그인 성공

        

      }else{  // 로그인 실패
        
        $(".login-fail > span").text("이메일 주소 또는 비밀번호를 확인해주세요");

      }

    },

    error : function(){
      alert("알 수 없는 오류가 발생했습니다. \n 잠시 후 다시 시도해주세요.");
      location.href="/";
    }

  });

})

*/
