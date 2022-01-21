
// 아이콘 전역 변수 선언

// 성공 아이콘
const validIcon = '<svg width="15" height="15" viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M7.5 1.25C4.05 1.25 1.25 4.05 1.25 7.5C1.25 10.95 4.05 13.75 7.5 13.75C10.95 13.75 13.75 10.95 13.75 7.5C13.75 4.05 10.95 1.25 7.5 1.25ZM6.25 10.625L3.125 7.5L4.00625 6.61875L6.25 8.85625L10.9937 4.1125L11.875 5L6.25 10.625Z" fill="#44DE1D"/> </svg>';

// 실패 아이콘
const invalidIcon = '<svg width="15" height="15" viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M7.5 1.25C4.04375 1.25 1.25 4.04375 1.25 7.5C1.25 10.9563 4.04375 13.75 7.5 13.75C10.9563 13.75 13.75 10.9563 13.75 7.5C13.75 4.04375 10.9563 1.25 7.5 1.25ZM10.625 9.74375L9.74375 10.625L7.5 8.38125L5.25625 10.625L4.375 9.74375L6.61875 7.5L4.375 5.25625L5.25625 4.375L7.5 6.61875L9.74375 4.375L10.625 5.25625L8.38125 7.5L10.625 9.74375Z" fill="#F82F2F"/> </svg>';

const findPwCheckObj = { "email" : false };


// 확인버튼 누르면 이메일 보내기
// 이메일로 링크 보낸 뒤 클릭하면 비밀번호 변경 페이지 보여주기
// 이메일 조회 결과가 없으면 findPwNotice 함수 실행
// userEmail jsp에 변수로 지정해놓기


// 비밀번호 찾기

// 이메일 유효성 검사
$("#userEmail").on("input", function(){

  const userEmail = $(this).val();
  const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
  const checkInput = $(this).next();

  // 값이 없는 경우
  if(userEmail.length == 0){
    checkInput.html("");
    findPwCheckObj.email = false;
  }
  else if(regExp.test(userEmail)){

    checkInput.html(validIcon);
    findPwCheckObj.email = true;

  }
  // 유효성 조건 불만족
  else{
    checkInput.html(invalidIcon);
    findPwCheckObj.email = false;
  }

  findPwValidate();

});

// 비밀번호 찾기 확인 버튼 활성화/비활성화
function findPwValidate(){

  if(findPwCheckObj.email == true){
    $("#findPw-btn").removeAttr("disabled");
    console.log("실행");
  }else{
    $("#findPw-btn").attr("disabled", true);
  }

};


// 가입하지 않은 이메일인 경우
function findPwNotice(userEmail){

  const findPwNotice = $(".findPw-notice > span");

  findPwNotice.html("");
  findPwNotice.html(userEmail + "은 <br>가입되지 않은 이메일입니다.");

}