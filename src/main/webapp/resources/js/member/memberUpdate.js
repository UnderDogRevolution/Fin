//강의 복붙

// 모든 요소에 유효한 값이 작성 되어있는지 확인하는 용도의 객체
const updateCheckObj = {
	profile: false,
    nickName : false,
    email : false,
    birth : false,
}
// -> 회원 가입 시 이미 유효한 값으로만 데이터가 저장되어 있기 때문에
//    내 정보 페이지에 작성된 모든 값은 유효한 상태이다!



// 이메일 유효성 검사 + 중복 확인
// 이메일 유효성 검사
$("#userEmail").on("input", function(){

  const userEmail = $(this).val();
  const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
  const checkInput = $(this).next();

  // 값이 없는 경우
  if(userEmail.length == 0){
    checkInput.html("");
    $(this).removeAttr("class", "unique");
    $(this).removeAttr("class", "duplication");
    $("#emailCheck-btn").attr("disabled", true);
    signUpCheckObj.email = false;
  }
  else if(regExp.test(userEmail)){

    checkInput.html(validIcon);

     // ************* ajax 만들면 지울 부분 ******************
    $(this).removeAttr("class", "duplication");
    $(this).addClass("unique");
    $("#emailCheck-btn").removeAttr("disabled");
    signUpCheckObj.email = true;

    /*

    $.ajax({ 

      url : "emailDupCheck",                         
      data : {"userEmail" : userEmail},               
      type : "GET",                             

      success : function(result){

        //console.log(result);

        if(result  ==  0){ // 이메일 사용 가능

          $(this).removeAttr("class", "duplication");
          $(this).addClass("unique");
          signUpCheckObj.email = true;
      
        }else{ // 이메일 중복인

          $(this).removeAttr("class", "unique");
          $(this).addClass("duplication");
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

    */

  }
  // 유효성 조건 불만족
  else{
    checkInput.html(invalidIcon);
    $("#emailCheck-btn").attr("disabled", true);
    signUpCheckObj.email = false;
  }

  signUpValidate();

});


// 닉네임 유효성 검사 ( + 중복 확인 )
$("#userNickName").on("input", function(){

  const userNickName = $(this).val(); // 입력 받은 이름
  const regExp = /^[a-zA-Z가-힣\d]{2,20}$/;
  const checkNickName = $(this).next();

  if( userNickName.length == 0 ){ // 빈칸
    checkNickName.html("");
    signUpCheckObj.nickName = false;

  }else if(regExp.test(userNickName)){ 
    
    // ************* ajax 만들면 지울 부분 ******************
    $(this).removeAttr("class", "duplication");
    $(this).addClass("unique");
    checkNickName.html(validIcon);
    signUpCheckObj.nickName = true;


    /* 

    // 유효한 경우 중복 검사
    $.ajax({ 

      url : "nickNameDupCheck",                         
      data : {"userNickName" : userNickName},               
      type : "GET",                             

      success : function(result){

        //console.log(result);

        if(result  ==  0){ // 닉네임 사용 가능

          $(this).removeAttr("class", "duplication");
          $(this).addClass("unique");
          checkNickName.html(validIcon);
          signUpCheckObj.nickName = true;
      
        }else{ // 닉네임 중복

          $(this).removeAttr("class", "unique");
          $(this).addClass("duplication");
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

    */

  }else{ // 유효하지 않은 경우
    checkNickName.html(invalidIcon);
    signUpCheckObj.nickName = false;
  }

  signUpValidate();

});


//프사
//그냥 사진일뿐인데 유효성검사가






//생일
//클릭이고 유효하지 않을수 잇














// 수정 버튼 클릭 시 모든 값이 유효하지 않으면 submit 이벤트 제거
function memberUpdateValidate(){

    for( key in updateCheckObj ){

        if(!updateCheckObj[key]){
            // updateCheckObj에 저장된 value중 false가 있는 경우

            let message;

            switch(key){
            case "phone3" : message = "전화번호가 유효하지 않습니다.";   break;
            case "email"  : message = "이메일이 유효하지 않습니다.";  break;
            }

            alert(message);

            // 유효하지 않은 input요소로 포커스 이동
            document.getElementById(key).focus(); 

            return false; // submit 이벤트 제거

        }
    }

    // input type="hidden" 태그 생성 및 추가
    const phone = document.getElementsByName("phone");
    const address = document.getElementsByName("address");

    const input1 = document.createElement("input");
    input1.setAttribute("type", "hidden");
    input1.setAttribute("name", "updatePhone");
    input1.value = phone[0].value + "-" + phone[1].value + "-" + phone[2].value;
    document.updateForm.append(input1);

    // 우편번호가 작성되어 있을 때에만 주소 input 태그 추가
    if(address[0].value.trim().length > 0){
        const input2 = document.createElement("input");
        input2.setAttribute("type", "hidden");
        input2.setAttribute("name", "updateAddress");
        input2.value = address[0].value + ",," + address[1].value + ",," + address[2].value;
        document.updateForm.append(input2);
    }

} // memberUpdateValidate end



