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

        // console.log(AdminAsk);

        $("#askDetail").modal('show');

      }else{
        console.log("문의글 상세 조회 실패");
        // console.log(AdminAsk);
      }

    },

    error : function(request, status, error){
          
      // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
      if( request.status == 404 ){
        console.log("ajax 요청 주소가 올바르지 않습니다.");
      
      } else if( request.status == 500){
          console.log("서버 내부 에러 발생");
          // console.log(request.responseText);
      }
    },

    complete : function(){
    }
  });
};



// 문의 리스트 검색하기
function findAsk(cp){

if (cp == undefined) {
		cp = 1;
	}
	
  const sk = $("#sk").val();
  const sv = $("#sv").val();

  // console.log(sk);

  $.ajax({

    url : "askList",
    type : "get",
    data : {"sk" : sk , "sv" : sv, "cp" : cp},
    dataType : "JSON",

    success : function(askMap){

      const body = $(".tbody");
      body.html("");
      $(".pagination").html("");
      
       // 조회 성공 시
      if(askMap.askList.length != 0){

        // 화면 만들기
        $.each(askMap.askList, function(index, ask){

          // 행
          const tr = $("<tr>");
          
          // 글 번호
          const td1 = $('<td>'+ ask.askNo +'</td>');
          
          //제목
          const td2 = $('<td><span style="cursor:pointer;" onclick="showAskDetail('+ ask.askNo +');">'+ ask.askTitle +'</span></td>');

          //내용
          const td3 = $('<td><span style="cursor:pointer;" onclick="showAskDetail('+ ask.askNo +');">'+ ask.askContent +'</span></td>');

          //이름
          const td4 = $('<td>'+ ask.memberName +'</td>');

          //작성일
          const td5 = $('<td>'+ ask.askDate +'</td>');
          
          //삭제하기
          const td6 = $('<td><p class="deleteBtn" id="deleteBtn" style="cursor: pointer;" onclick="askDelete(event,'+ask.askNo+');">'+'삭제'+'</p></td>');
          
          tr.append(td1)
          tr.append(td2)
          tr.append(td3)
          tr.append(td4)
          tr.append(td5)
          tr.append(td6)

		  body.append(tr);
        });


      }else{

        // 검색 결과가 없는 경우
        $(".tbody").html("<tr><td colspan='6'>검색 결과가 존재하지 않습니다.</td></tr>");

      }

      // 페이지내이션
      const pagination = askMap.pagination;

      if (askMap.pagination.startPage != 1) {

        const li1 = $('<li class="page-link" onclick = "findAsk(1)">&lt;&lt;</li>')
        const li2 = $('<li class="page-link" onclick = "findAsk('+askMap.pagination.prevPage+')">&lt;</li>');

        $(".pagination").append(li1);
        $(".pagination").append(li2);
      }

      for (let i = askMap.pagination.startPage; i <= askMap.pagination.endPage; i++) {

        if (i == askMap.pagination.currentPage) {
          li = $('<li class="page-link currentPage" style="color: black; font-weight: bold;"> ' + i + '</li>');
          $(".pagination").append(li);
        } else {
          li = $('<li class="page-link" onclick = findAsk(' + i + ')>' + i + '</li>');
          $(".pagination").append(li);
        }

      };

      if (askMap.pagination.endPage != askMap.pagination.maxPage) {

        const li1 = $('<li  onclick = "findAsk('+askMap.pagination.nextPage+')" class="page-link" >&gt;</li>');
        const li2 = $('<li onclick = "findAsk('+askMap.pagination.maxPage+')" class="page-link">&gt;&gt;</li>');
        $(".pagination").append(li1);
        $(".pagination").append(li2);
      }
      
      
      
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