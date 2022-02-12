findAsk();

// 문의글 상세 조회 함수
function showAskDetail(askNo){
  
  // 모달 내용 지우기
  $(".askAskNo").text("");
  $(".askTitle").text("");
  $(".askContent").text("");
  $(".askMemberName").text("");
  $(".askDate").text("");

  $.ajax({

    url : "selectAskDetail",
    type : "get",
    data : {"askNo" : askNo},
    dataType : "JSON",

    success : function(AdminAsk){
		
      if(AdminAsk != null){
        
        console.log("문의글 상세 조회 성공");

        // 요소에 값 추가하기
        $(".askAskNo").text(AdminAsk.askNo);
        $(".askTitle").text(AdminAsk.askTitle);
        $(".askContent").text(AdminAsk.askContent);
        $(".askMemberName").text(AdminAsk.memberName);
        $(".askDate").text(AdminAsk.askDate);

        console.log(AdminAsk);

        $("#askDetail").modal('show');

      }else{
        console.log("문의글 상세 조회 실패");
        console.log(AdminAsk);
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



// 문의 리스트 검색하기
function findAsk(){

  const sk = $("#sk").val();
  const sv = $("#sv").val();

  console.log("검색 분류:" +sk);
  console.log("검색 값: "+sv);

  $.ajax({

    url : "askList",
    type : "get",
    data : {"sk" : sk , "sv" : sv},
    dataType : "JSON",

    success : function(askList){

      console.log(askList);
      
    },

    error : function(request, status, error){
          
      // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
      if( request.status == 404 ){
        console.log("ajax 요청 주소가 올바르지 않습니다.");

      } else if( request.status == 500){
          console.log("서버 내부 에러 발생");
      }
   
    },

    complete : function(){

    }

  });


}