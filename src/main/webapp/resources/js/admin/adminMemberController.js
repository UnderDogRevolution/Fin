// 회원 정보 상세 조회 함수
function showMemberDetail(memberNo){
  
  // 모달 내용 지우기
  $(".inputMemberProfileImage").removeAttr("src");
  $(".inputMemberEmail").text("");
  $(".inputMemberName").text("");
  $(".inputMemberNickName").text("");
  $(".inputMemberNo").text("");
  $(".inputMemberBirth").text("");
  $(".inputMemberEnrollDate").text("");
  $(".inputMemberStatusName").text("");
  $(".inputViolationCount").text("");

  $.ajax({

    url : "selectMemberDetail",
    type : "get",
    data : {"memberNo" : memberNo},
    dataType : "JSON",

    success : function(member){

      if(member != null){
        
        console.log("정보 조회 성공");

        // 요소에 값 추가하기
        $(".inputMemberProfileImage").attr("src", contextPath + member.profileImage.imgPath + member.profileImage.imgName);
        $(".inputMemberEmail").text(member.memberEmail);
        $(".inputMemberName").text(member.memberName);
        $(".inputMemberNickName").text(member.memberNickName);
        $(".inputMemberNo").text(member.memberNo);
        $(".inputMemberBirth").text(member.memberBirth);
        $(".inputMemberEnrollDate").text(member.enrollDate);
        $(".inputMemberStatusName").text(member.memberStatusName);
        $(".inputViolationCount").text(member.violationCount);

        console.log(member);
        console.log(contextPath);

        $("#memberDetail").modal('show');

      }else{
        console.log("정보 조회 실패");
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

    }

  });
  
  
};



// 회원 리스트 조회하기
function findMember(){

  const sk = $("#sk").val();
  const sv = $("#sv").val();

  console.log("검색 분류:" +sk);
  console.log("검색 값: "+sv);

  $.ajax({

    url : "selectMemberList2",
    type : "get",
    data : {"sk" : sk , "sv" : sv},
    dataType : "JSON",

    success : function(memberList){

      console.log(memberList);
      
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

    }

  });



}