
// 아이콘 전역 변수 선언

// 성공 아이콘
const validIcon = '<svg width="15" height="15" viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M7.5 1.25C4.05 1.25 1.25 4.05 1.25 7.5C1.25 10.95 4.05 13.75 7.5 13.75C10.95 13.75 13.75 10.95 13.75 7.5C13.75 4.05 10.95 1.25 7.5 1.25ZM6.25 10.625L3.125 7.5L4.00625 6.61875L6.25 8.85625L10.9937 4.1125L11.875 5L6.25 10.625Z" fill="#44DE1D"/> </svg>';

// 실패 아이콘
const invalidIcon = '<svg width="15" height="15" viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M7.5 1.25C4.04375 1.25 1.25 4.04375 1.25 7.5C1.25 10.9563 4.04375 13.75 7.5 13.75C10.9563 13.75 13.75 10.9563 13.75 7.5C13.75 4.04375 10.9563 1.25 7.5 1.25ZM10.625 9.74375L9.74375 10.625L7.5 8.38125L5.25625 10.625L4.375 9.74375L6.61875 7.5L4.375 5.25625L5.25625 4.375L7.5 6.61875L9.74375 4.375L10.625 5.25625L8.38125 7.5L10.625 9.74375Z" fill="#F82F2F"/> </svg>';




// 회원가입 창 입력값 검사용 객체
const signUpCheckObj = {

  "email" : false,
  "emailCode" : false,    // 이메일 인증번호
  "password" : false,     // 비밀번호
  "password2" : false,    // 비밀번호 확인
  "nickName" : false,
  "userName" : false,
  "terms1" : false,          // 약관
  "terms2" : false,          // 약관

}


// 회원 가입 검사 (회원 가입 버튼 활성화/비활성화)
function signUpValidate(){

  const signUpBtn = $("#signUp-btn");

  // 이걸 쉽게 쓰는 방법은??
  if(
    signUpCheckObj.email == true &&
    // signUpCheckObj.emailCode == true &&
    signUpCheckObj.password == true &&
    signUpCheckObj.password2 == true &&
    signUpCheckObj.nickName == true &&
    signUpCheckObj.userName == true &&
    signUpCheckObj.terms1 == true &&
    signUpCheckObj.terms2 == true
  ){
    signUpBtn.removeAttr("disabled");
  }

  else{
    signUpBtn.attr("disabled", true);
  }

}



// 전역변수로 빼주고 clearInterval 수행해야함
let isStop = false;
let countInterval;

// 인증번호 카운트다운
function paddedFormat(num) {
  return num < 10 ? "0" + num : num; 
}

function startCountDown(duration, element) {

  let secondsRemaining = duration;
  let min = 0;
  let sec = 0;

  countInterval = setInterval(function () {

    if(!isStop){  
         
      min = parseInt(secondsRemaining / 60);
      sec = parseInt(secondsRemaining % 60);

      element.textContent = `${paddedFormat(min)}:${paddedFormat(sec)}`;

      secondsRemaining = secondsRemaining - 1;
      // 타이머가 만료되면
      if (secondsRemaining < 0) { 
        
        clearInterval(countInterval); 
        $(".auth-submit-btn").attr("disabled", true);
        // $(".auth-submit-btn").removeAttr("disabled");

        const authResult = $(".auth-result");
        const div = $('<div class="failMsg">');
        const resendBtn = $('<button type="button" class="btn auth-resend-btn" onclick="resendAuth();">');
        
        $(".auth-result").empty();
        div.text("인증 시간이 만료되었습니다.");
        resendBtn.text("인증번호 재발급");

        authResult.append(div);
        div.after(resendBtn);


      };

    }else{

      clearInterval(countInterval);

    }

  }, 1000);
}

// 타이머 멈추기
function stopTimer(){
  isStop = true;
  clearInterval(countInterval);
}

// 타이머 시작하기
function startTimer() {
  let time_minutes = 3; // Value in minutes
  let time_seconds = 0; // Value in seconds

  let duration = time_minutes * 60 + time_seconds;

  element = document.querySelector('#count-down-timer');
  element.textContent = `${paddedFormat(time_minutes)}:${paddedFormat(time_seconds)}`;

  isStop = false;

  startCountDown(--duration, element);
};



// 이메일 인증버튼 클릭 시 모달창 열기
$("#emailCheck-btn").on("click",function(){

  // 버튼에 비활성화를 해제
  $(".auth-submit-btn").removeAttr("disabled");

  $("#emailAuthModalLabel").text("해당 이메일로 인증번호를 발송했습니다.");
  $("#emailAuthCode").val("");
  $(".auth-result").empty();

  $("#emailAuthModal").modal('show');
  
  stopTimer();
  startTimer();
  authEmail();

});


// 이메일 인증번호 생성 및 삽입 + 이메일 전송
function authEmail(){

  const memberEmail = $("#memberEmail").val();

  if(memberEmail.trim().length == 0){

    $(".auth-result").text("인증 코드를 입력해주세요").css("color","#F05454");

  }else{

    $.ajax({

      url : "emailAuth",
      type : "post",
      data : {"memberEmail" : memberEmail},
  
      success : function(result){
  
        if(result == 1){
          console.log("인증번호 삽입 + 메일 전송 성공");
        }else{
          console.log("예외 발생");
        }
  
      },
  
      error : function(request, status, error){
            
        // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
        if( request.status == 404 ){
          console.log("ajax 요청 주소가 올바르지 않습니다.");
  
        } else if( request.status == 500){
            console.log("서버 내부 에러 발생");
            console.log(request.responseText);
        }
     
      }
  
    });

  }

}


// 이메일 인증번호 체크 함수
function checkAuth(){

  const memberEmail = $("#memberEmail").val();
  const authCode = $("#emailAuthCode").val();

  const authResult = $(".auth-result");

  // 이메일 인증번호 비교 후 결과 반환받기
  $.ajax({

    url : "emailAuthCheck",
    type : "post",
    data : {"memberEmail" : memberEmail, "authCode" : authCode},

    success : function(result){

      if(result > 0){
        console.log("인증 성공");
        $("#emailCheck-btn").next().html(validIcon);
        
        // 이메일 입력창 읽기전용으로 변경
        $("#memberEmail").attr("readonly", true);

        $("#emailCheck-btn").text("인증 완료");
        $("#emailCheck-btn").attr("disabled", true);

        $("#emailAuthModal").modal('hide');

        successAuth();

        // 인증 완료 후 관련 정보 DB에서 삭제하기 만들 예정
        // deleteAuth();

        signUpCheckObj.emailCode = true;


      }else{
        console.log("인증번호 불일치");
        $("#emailCheck-btn").next().html(invalidIcon);

        // 실패 및 재전송 관련 요소 생성하기
        authResult.empty();

        const div = $('<div class="failMsg">');
        const resendBtn = $('<button type="button" class="btn auth-resend-btn" onclick="resendAuth();">');
        
        div.text("인증번호가 일치하지 않습니다.");
        resendBtn.text("인증번호 재발급");

        authResult.append(div);
        div.after(resendBtn);

        signUpCheckObj.emailCode = false;

      }

    },

    error : function(request, status, error){
          
      // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
      if( request.status == 404 ){
        console.log("ajax 요청 주소가 올바르지 않습니다.");

      } else if( request.status == 500){
          console.log("서버 내부 에러 발생");
          console.log(request.responseText);
      }
   
    },

    complete : function(){

      signUpValidate();

    }

  });

}


// 인증 성공 sweetalert
function successAuth(){

  Swal.fire({
    
    title : "이메일 인증 성공!",
    icon : "success",
    showConfirmButton: true,
    timer: 5000,
    timerProgressBar: true,
    confirmButtonText: '확인',
    confirmButtonColor: '#F05454'

  })

}


// 인증번호 재전송 클릭 시 동작
function resendAuth(){

  // 이메일 보내기 + 타이머 재시작
  stopTimer();
  startTimer();
  authEmail();

  // 버튼에 비활성화를 해제
  $(".auth-submit-btn").removeAttr("disabled");
  
  $("#emailAuthModalLabel").text("인증번호를 다시 전송했습니다.").css("color", "#F05454");
 
  const Toast = Swal.mixin({
    toast: true,
    position: 'top',
    showConfirmButton: true,
    confirmButtonText: '확인',
    confirmButtonColor: '#F05454',
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
      toast.addEventListener('mouseenter', Swal.stopTimer)
      toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
  })
  
  Toast.fire({
    icon: 'success',
    title: '인증번호 재전송 완료'
  })

};


// 인증 완료 후 코드 삭제하기
function deleteAuth(){

  

}





// ******************** 회원가입 ********************


// 이메일 유효성 검사 + 중복 확인
// 이메일 유효성 검사
$("#memberEmail").on("input", function(){

  const memberEmail = $(this).val();
  const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
  const checkInput = $(this).next();
  const inputEmail = $(this);

  // 값이 없는 경우
  if(memberEmail.length == 0){
    checkInput.html("");
    $(this).removeAttr("class", "unique");
    $(this).removeAttr("class", "duplication");
    $("#emailCheck-btn").attr("disabled", true);
    signUpCheckObj.email = false;
  }
  else if(regExp.test(memberEmail)){

    checkInput.html(validIcon);

    $.ajax({ 

      url : "emailDupCheck",                         
      data : {"memberEmail" : memberEmail},               
      type : "GET",
      async: false,                             

      success : function(result){

        console.log(result);

        if(result  ==  0){ // 이메일 사용 가능

          inputEmail.removeAttr("class", "duplication");
          inputEmail.addClass("unique");
          $("#emailCheck-btn").removeAttr("disabled");
          signUpCheckObj.email = true;
      
        }else{ // 이메일 중복인

          inputEmail.removeAttr("class", "unique");
          inputEmail.addClass("duplication");
          $("#emailCheck-btn").attr("disabled", true);
          signUpCheckObj.email = false;

        }

      },

      error : function(request, status, error){
          
        // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
        if( request.status == 404 ){
          console.log("ajax 요청 주소가 올바르지 않습니다.");

        } else if( request.status == 500){
            console.log("서버 내부 에러 발생");
            console.log(request.responseText);
        }
     
      }

    });

    

  }
  // 유효성 조건 불만족
  else{
    checkInput.html(invalidIcon);
    $("#emailCheck-btn").attr("disabled", true);
    signUpCheckObj.email = false;
  }

  signUpValidate();

});


// 이메일 인증번호 검사(ajax)




// -------------------------------------------------------------------------
// 비밀번호 유효성 검사
$("#memberPw").on("input",function(){

  const memberPw = $("#memberPw").val();
  // 영문, 숫자, 특수문자 6~20 글자
  const regExp = /^[a-zA-Z\d$`~!@$!%*#^?&\\(\\)\-_=+]{6,20}$/;
  const checkPw1 = $("#memberPw").next();

  if(memberPw.length == 0){
    checkPw1.html("");
    signUpCheckObj.password = false;
  }
  else if( regExp.test( memberPw ) ){
    checkPw1.html(validIcon);
    signUpCheckObj.password = true;
  }
  else{
    checkPw1.html(invalidIcon);
    signUpCheckObj.password = false;
  }

  signUpValidate();

});

// 비밀번호 확인 검사
$("#memberPw, #memberPw2").on("input",function(){

  const memberPw = $("#memberPw").val();
  const memberPw2 = $("#memberPw2").val();
  const checkPw2 = $("#memberPw2").next();

  if(memberPw2.trim().length == 0){
    checkPw2.html("");
    signUpCheckObj.password2 = false;
  }
  else if( memberPw == memberPw2 ){
    checkPw2.html(validIcon);
    signUpCheckObj.password2 = true;
  }
  else{
    checkPw2.html(invalidIcon);
    signUpCheckObj.password2 = false;
  }

  signUpValidate();

});

// -------------------------------------------------------------------------
// 닉네임 유효성 검사 ( + 중복 확인 )
$("#memberNickName").on("input", function(){

  const memberNickName = $(this).val(); // 입력 받은 이름
  const regExp = /^[a-zA-Z가-힣\d]{2,20}$/;
  const checkNickName = $(this).next();
  const inputNickName = $(this);

  if( memberNickName.length == 0 ){ // 빈칸
    $(this).removeAttr("class", "unique");
    $(this).removeAttr("class", "duplication");
    checkNickName.html("");
    signUpCheckObj.nickName = false;

  }else if(regExp.test(memberNickName)){ 

    // 유효한 경우 중복 검사
    $.ajax({ 

      url : "nickNameDupCheck",                         
      data : {"memberNickName" : memberNickName},               
      type : "GET",                             

      success : function(result){

        console.log(result);

        if(result  ==  0){ // 닉네임 사용 가능

          inputNickName.removeAttr("class", "duplication");
          inputNickName.addClass("unique");
          checkNickName.html(validIcon);
          signUpCheckObj.nickName = true;
      
        }else{ // 닉네임 중복

          inputNickName.removeAttr("class", "unique");
          inputNickName.addClass("duplication");
          checkNickName.html(invalidIcon);
          signUpCheckObj.nickName = false;

        }

      },

      error : function(request, status, error){
          
        // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
        if( request.status == 404 ){
          console.log("ajax 요청 주소가 올바르지 않습니다.");

        } else if( request.status == 500){
            console.log("서버 내부 에러 발생");
            console.log(request.responseText);
        }
     
      }

    });

    

  }else{ // 유효하지 않은 경우
    checkNickName.html(invalidIcon);
    signUpCheckObj.nickName = false;
  }

  signUpValidate();

});



// -------------------------------------------------------------------------
// 이름 유효성 검사
$("#memberName").on("input", function(){

  const inputName = $(this).val(); // 입력 받은 이름
  const regExp = /^[a-zA-Z가-힣]{2,20}$/;
  const checkName = $(this).next();

  if( inputName.length == 0 ){ // 빈칸
    checkName.html("");
    signUpCheckObj.userName = false;

  }else if(regExp.test(inputName)){ // 유효한 경우
    checkName.html(validIcon);
    signUpCheckObj.userName = true;

  }else{ // 유효하지 않은 경우
    checkName.html(invalidIcon);
    signUpCheckObj.userName = false;
  }

  signUpValidate();

});


// -------------------------------------------------------------------------
// 약관 체크 검사하기

$("#terms1, #terms2").on("change", function(){

  let getId = $(this).attr("id");

  if($(this).is(":checked")){
    console.log("checked");
    console.log($(this).attr("id"));
    signUpCheckObj[getId] = true;
  }else{
    console.log("unchecked");
    signUpCheckObj[getId] = false;
  }
  
  signUpValidate();

});








