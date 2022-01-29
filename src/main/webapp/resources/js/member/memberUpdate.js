const updateCheckObj = {
	email: false,
	nickName: false,
}


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

      success : function(result){

        console.log(result);

        if(result  ==  0){ // 이메일 사용 가능

          inputEmail.removeAttr("class", "duplication");
          inputEmail.addClass("unique");
          $("#emailCheck-btn").removeAttr("disabled");
          signUpCheckObj.email = true;
      
        }else{ // 이메일 중복인 경우

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


// 닉네임 유효성 검사
// - 한글,영어,숫자 2자 ~ 20자
$("#memberNickName").on("input", function(){

    const inputNickName = $(this).val(); // 입력 받은 닉네임
    const regExp = /^[a-zA-Z가-힣\d]{2,20}$/;

    if( inputNickName.length == 0 ){ // 빈칸
        $("#checkNickName").text("");

        signUpCheckObj.nickName = false;

    }else if(regExp.test(inputNickName)){ // 유효한 경우
        $("#checkNickName").text("유효한 닉네임 입니다.").css("color", "green");
        
        signUpCheckObj.nickName = true;

    }else{ // 유효하지 않은 경우
        $("#checkNickName").text("유효하지 않은 닉네임 입니다.").css("color", "red");

        signUpCheckObj.memberNickName = false;
    }
});



// 수정 버튼 클릭 시 모든 값이 유효하지 않으면 submit 이벤트 제거
function memberUpdateValidate() {

	for (key in updateCheckObj) {

		if (!updateCheckObj[key]) {

			let message;

			switch (key) {
				case "nickName": message = "닉네임이 유효하지 않습니다."; break;
				case "email": message = "이메일이 유효하지 않습니다."; break;
			}

			alert(message);

			// 유효하지 않은 input요소로 포커스 이동
			document.getElementById(key).focus();

			return false; // submit 이벤트 제거

		}
	}

} 