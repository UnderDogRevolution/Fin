// 문의글 상세 조회 함수
function showAskDetail(memberNo){
  
  // 모달 내용 지우기
  $(".askMemberNo").text("");
  $(".askTitle").text("");
  $(".askContent").text("");
  $(".askMemberName").text("");
  $(".askDate").text("");

  $.ajax({

    url : "selectAskDetail",
    type : "get",
    data : {"askNo" : askNo},
    dataType : "JSON",

    success : function(ask){
		
      if(ask != null){
        
        console.log("문의글 상세 조회 성공");

        // 요소에 값 추가하기
        $(".askMemberNo").text(ask.askNo);
        $(".askTitle").text(ask.askTitle);
        $(".askContent").text(ask.askContent);
        $(".askMemberName").text(ask.memberName);
        $(".askDate").text(ask.askDate);

        console.log(ask);
        console.log(contextPath);

        $("#askDetail").modal('show');

      }else{
        console.log("문의글 상세 조회 실패");
        console.log(ask);
      }

    },

    error : function(request, status, error){
          
      // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
      if( request.status == 404 ){
        console.log("ajax 요청 주소가 올바르지 않습니다.");
		console.log(ask);
      } else if( request.status == 500){
		  console.log(ask);
          console.log("서버 내부 에러 발생");
          console.log(request.responseText);
      }
   
    },

    complete : function(){

    }

  });
  
  
};
