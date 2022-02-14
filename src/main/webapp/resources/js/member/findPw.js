
// 아이콘 전역 변수 선언

// 성공 아이콘
const validIcon = '<svg width="15" height="15" viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M7.5 1.25C4.05 1.25 1.25 4.05 1.25 7.5C1.25 10.95 4.05 13.75 7.5 13.75C10.95 13.75 13.75 10.95 13.75 7.5C13.75 4.05 10.95 1.25 7.5 1.25ZM6.25 10.625L3.125 7.5L4.00625 6.61875L6.25 8.85625L10.9937 4.1125L11.875 5L6.25 10.625Z" fill="#44DE1D"/> </svg>';

// 실패 아이콘
const invalidIcon = '<svg width="15" height="15" viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M7.5 1.25C4.04375 1.25 1.25 4.04375 1.25 7.5C1.25 10.9563 4.04375 13.75 7.5 13.75C10.9563 13.75 13.75 10.9563 13.75 7.5C13.75 4.04375 10.9563 1.25 7.5 1.25ZM10.625 9.74375L9.74375 10.625L7.5 8.38125L5.25625 10.625L4.375 9.74375L6.61875 7.5L4.375 5.25625L5.25625 4.375L7.5 6.61875L9.74375 4.375L10.625 5.25625L8.38125 7.5L10.625 9.74375Z" fill="#F82F2F"/> </svg>';

const findPwCheckObj = { "email" : false };
const resetPwCheckObj = { "password" : false };




// 확인버튼 누르면 이메일 보내기
// 이메일로 링크 보낸 뒤 클릭하면 비밀번호 변경 페이지 보여주기
// 이메일 조회 결과가 없으면 findPwNotice 함수 실행
// memberEmail jsp에 변수로 지정해놓기


// 비밀번호 찾기

// 이메일 유효성 검사
$("#memberEmail").on("input", function(){

  const memberEmail = $(this).val();
  const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
  const checkInput = $(this).next();

  // 값이 없는 경우
  if(memberEmail.length == 0){
    checkInput.html("");
    findPwCheckObj.email = false;
  }
  else if(regExp.test(memberEmail)){

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
  }else{
    $("#findPw-btn").attr("disabled", true);
  }

};



// 비밀번호 재설정


// 비밀번호 유효성 검사
$("#memberPw").on("input",function(){

  const memberPw = $("#memberPw").val();
  // 영문, 숫자, 특수문자 6~20 글자
  const regExp = /^[a-zA-Z\d$`~!@$!%*#^?&\\(\\)\-_=+]{6,20}$/;
  const checkPw1 = $("#memberPw").next();

  if(memberPw.length == 0){
    checkPw1.html("");
    resetPwCheckObj.password = false;
  }
  else if( regExp.test( memberPw ) ){
    checkPw1.html(validIcon);
    resetPwCheckObj.password = true;
  }
  else{
    checkPw1.html(invalidIcon);
    resetPwCheckObj.password = false;
  }

  resetPwValidate();

});

// 비밀번호 재설정 버튼 활성화/비활성화
function resetPwValidate(){

  if(resetPwCheckObj.password == true){
    $("#resetPw-btn").removeAttr("disabled");
    console.log("실행");
  }else{
    $("#resetPw-btn").attr("disabled", true);
  }

};


// 비밀번호 재설정 이메일 보내기
function sendResetLink(){

  const memberEmail = $("#memberEmail").val();
  const errorText = $(".findPw-notice");
  const checkInput = $("#memberEmail").next();

  // 중복 체크 ajax
  $.ajax({ 

    url : "emailDupCheck",                         
    data : {"memberEmail" : memberEmail},               
    type : "GET",
    async: false,                             

    success : function(result){

      console.log(result + " : 이메일 중복체크 결과");

      if(result  ==  0){ // 가입하지 않은 이메일

        $("#memberEmail").val("");
        errorText.html(memberEmail + "은 <br> 가입하지 않은 이메일입니다.");
        checkInput.html("");
        findPwCheckObj.email = false;
        findPwValidate();
    
      }else{ // 가입한 이메일 -> 링크 전송 가능

        $("#memberEmail").val("");
        errorText.text("");
        checkInput.html("");
        findPwCheckObj.email = false;
        findPwValidate();
        
        // 일단 전송 완료 메시지 생성하기
        Swal.fire({
    
          title : "변경 링크 발송 성공!",
          html : memberEmail + "로 변경 링크를 보냈습니다.",
          icon : "success",
          showConfirmButton: true,
          timer: 3000,
          timerProgressBar: true,
          confirmButtonText: '확인',
          confirmButtonColor: '#F05454'
      
        });

        // 메일 전송 ajax
        $.ajax({ 

          url : "findPw",                         
          data : {"memberEmail" : memberEmail},               
          type : "POST",
      
          success : function(result){
      
            if(result > 0){   // 발송 성공
              
              console.log("메일 발송 성공!");
          
            }else{ // 발송 실패
      
              console.log("메일 발송 실패!");

              $("#memberEmail").val("");
              errorText.text("");
              checkInput.html("");
              findPwCheckObj.email = false;
              findPwValidate();
      
              Swal.fire({
          
                title : "링크 발송 중 문제가 발생했습니다.",
                html : "다시 시도해주세요 <br> 문제가 지속될 시 관리자에게 문의해주세요.",
                icon : "error",
                showConfirmButton: true,
                timer: 5000,
                timerProgressBar: true,
                confirmButtonText: '확인',
                confirmButtonColor: '#F05454'
            
              });
            }
      
          },
      
          error : function(request, status, error){
              
            // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
            if( request.status == 404 ){
              console.log("[메일 전송] ajax 요청 주소가 올바르지 않습니다.");
      
            } else if( request.status == 500){
                console.log("[메일 전송] 서버 내부 에러 발생");
                console.log(request.responseText);
            }
         
          }
      
        });

      }

    },

    error : function(request, status, error){
        
      // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
      if( request.status == 404 ){
        console.log("[이메일 중복체크] ajax 요청 주소가 올바르지 않습니다.");

      } else if( request.status == 500){
          console.log("[이메일 중복체크] 서버 내부 에러 발생");
          console.log(request.responseText);
      }
   
    }

  });

}










