// 현재 페이지
// const currentPage = $(".currentPage").text();

// 페이지 로드 시 회원 리스트를 조회하는 함수 실행
findMember();

// 검색창에 회원번호에 숫자만 들어오도록
$("#sk").on("change", function() {
	
  const sk = $("#sk").val(); // 검색분류 값

	$("#sv").val(""); // 검색값 초기화

  switch(sk){
    case 'number' : $("#sv").attr('type', 'number'); break;
    case 'name2' : $("#sv").attr('type', 'text'); break;
    case 'nickName' : $("#sv").attr('type', 'text'); break;
    case 'email' : $("#sv").attr('type', 'text'); break;
  }

});


// 회원의 기존 상태 (전역변수)
let memberPrevStatus;

// 이전 상태값을 저장하는 함수
function getPrevStatus(status){
  memberPrevStatus = status;
}

// ========================================= 회원 상태 변경 ===================================================

// checkbox 전체선택 시
$("#all").on("change", function () {
  const all = $("#all").prop("checked"); // t/f

  if (all == true) { // 전체가 체크가된 경우
      $(".chk").prop("checked", true);
      $(".setBtn").removeAttr("disabled");
  }
  
  else {// 전체가 체크 해제된 경우
      $(".chk").prop("checked", false);
      $(".setBtn").attr("disabled", true);
  }
  
});

function chkChange(){
  if( !$(this).prop("chceked") ){

    $("#all").prop("checked", false); // 전체 체크 해제
  }

  // .chk이 모두 체크된 경우
  if( $(".chk:checked").length == $(".chk").length ){
      $("#all").prop("checked", true);
  }

  if( $(".chk:checked").length == 0 ){
    $(".setBtn").attr("disabled", true);
  }

  if( $(".chk:checked").length > 0 ){
    $(".setBtn").removeAttr("disabled");
  }
};


// 체크된 회원의 상태를 특정 값으로 일괄 변경하기
// + 변경 후 조회 수행
// 현재 페이지 얻어오기

function changeCheckbox(statusCode){

  // 현재 페이지
  const currentPage = $(".currentPage").text();

  Swal.fire({
    title: '회원 상태를 변경하시겠습니까?',
    showCancelButton: true,
    confirmButtonText: '변경',
    confirmButtonColor: '#F05454',
  }).then((result) => {

    if (result.isConfirmed) {

      // 체크된 박스 요소 찾기
      const checkedMember = $("input:checkbox[name='selectOne']:checked");
    
      // 체크된 박스에 있는 memberNo 얻어오기(배열)
      let checkedMemberNo = [];
    
      checkedMember.each(function(i){
        checkedMemberNo.push(checkedMember[i].parentElement.nextElementSibling.innerText);
      })
    
      // ajax 수행하기
      $.ajax({
    
        url : "multiChangeStatus",
        traditional: true,
        type : "get",
        data : {"checkedMemberNo" : checkedMemberNo ,"statusValue" : statusCode},
    
        success : function(result){
    
          if(result > 0){

            // 변경 성공
            // 리스트 다시 조회
            findMember(currentPage);

            // 체크박스 체크 해제하기
            $('.chk').removeAttr("checked");

            // 버튼 비활성화
            $(".setBtn").attr("disabled", true);

            const Toast = Swal.mixin({
              toast: true,
              position: 'top-end',
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
              title: '상태 변경 성공'
            })
    
            
            
    
          }else{
            
            // 변경 실패
            console.log("변경 실패");
            const Toast = Swal.mixin({
              toast: true,
              position: 'top-end',
              showConfirmButton: true,
              confirmButtonText: '확인',
              confirmButtonColor: '#F05454',
              timer: 5000,
              timerProgressBar: true,
              didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer)
                toast.addEventListener('mouseleave', Swal.resumeTimer)
              }
            })
            
            Toast.fire({
              icon: 'error',
              title: '상태 변경 실패'
            })
    
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

  });

}

// 상태 변경시키기
function changeStatus(statusCode, memberNo, e){

  const currentPage = $(".currentPage").text();

  Swal.fire({
    title: '회원 상태를 변경하시겠습니까?',
    showCancelButton: true,
    confirmButtonText: '변경',
    confirmButtonColor: '#F05454',
  }).then((result) => {

    if (result.isConfirmed) {

      $.ajax({
    
        url : "changeStatus",
        type : "get",
        data : {"memberNo" : memberNo, "memberStatusCode":statusCode},
    
        success : function(result){
    
          if(result > 0){

            // 변경 성공
            // 리스트 조회
            findMember(currentPage);
            
            const Toast = Swal.mixin({
              toast: true,
              position: 'top-end',
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
              title: '상태 변경 성공'
            })
    
    
          }else{
            // 변경 실패
            console.log("변경 실패");
            const Toast = Swal.mixin({
              toast: true,
              position: 'top-end',
              showConfirmButton: true,
              confirmButtonText: '확인',
              confirmButtonColor: '#F05454',
              timer: 5000,
              timerProgressBar: true,
              didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer)
                toast.addEventListener('mouseleave', Swal.resumeTimer)
              }
            })
            
            Toast.fire({
              icon: 'error',
              title: '상태 변경 실패'
            })
    
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

    }else{
      // 취소를 누른 경우
      e.target.value = memberPrevStatus;
    }

  });

}


// ======================================= 회원 정보 조회 ====================================================



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
      }
   
    },

    complete : function(){

    }

  });
  
  
};

// =============================================== 회원 리스트 조회 ===============================================================

// 회원 리스트 검색하기
// 매개변수로 pagination , 정렬 조건 담기

// sortColumn : 정렬할 컬럼
// sortMethod : 오름차순/내림차순
// statusValue : 회원 상태 값

function findMember(cp, sortColumn, sortMethod, statusValue){

  // 전체선택 버튼 지우기
  $("#all").prop("checked", false);

  if (cp == undefined) {
		cp = 1;
	}

  const sk = $("#sk").val();
  const sv = $("#sv").val();

  console.log(sk);

  $.ajax({

    url : "selectMemberList2",
    type : "get",
    data : {"sk" : sk , "sv" : sv , "cp" : cp , "sortColumn": sortColumn, "sortMethod": sortMethod , "statusValue" : statusValue },
    dataType : "JSON",

    success : function(memberMap){

      const body = $(".tbody");
      body.html("");
      $(".pagination").html("");

      // 조회 성공 시
      if(memberMap.memberList.length != 0){

        // 체크박스 비활성화 해제
        $("#all").removeAttr("disabled");

        // 화면 만들기
        $.each(memberMap.memberList, function(index, member){

          // 행
          const tr = $("<tr>");
          
          // 체크박스
          const td1 = $('<td style="line-height: 22px;"><input onchange="chkChange();" class="form-check-input chk" type="checkbox" name="selectOne"></td>');
          
          // 회원 번호
          const td2 = $('<td>'+ member.memberNo +'</td>');

          // 이름
          const td3 = $('<td><span style="cursor:pointer;" onclick="showMemberDetail('+ member.memberNo +');">'+ member.memberName +'</span></td>');
          
          // 닉네임
          const td4 = $('<td><a style="text-decoration: none; color: white;"	href="' + contextPath + '/board1/myBoard/'+ member.memberNo +'">'+ member.memberNickName +'</a></td>');
          
          // 이메일
          const td5 = $('<td>'+ member.memberEmail +'</td>');
          
          // 가입일
          const td6 = $('<td>'+ member.enrollDate +'</td>');
          
          // 회원 상태
          const td7 = $("<td>");

          const select = $('<select class="memberStatusSelect" onclick="getPrevStatus('+member.memberStatusCode+')" onchange="changeStatus(this.value, '+ member.memberNo + ', event);">');

          for(let code = 200; code < 203; code++){
            const option = $("<option>");
            option.val(code);

            if(code == member.memberStatusCode){
              option.attr("selected", true);
            }

            switch(code){
              case 200 : option.text("일반"); break;
              case 201 : option.text("탈퇴"); break;
              case 202 : option.text("정지"); break;
            }
            
            select.append(option);

          }

          td7.append(select);

          tr.append(td1)
          tr.append(td2)
          tr.append(td3)
          tr.append(td4)
          tr.append(td5)
          tr.append(td6)
          tr.append(td7)

          body.append(tr);

        });


      }else{

        // 검색 결과가 없는 경우
        $(".tbody").html("<tr><td colspan='7'>검색 결과가 존재하지 않습니다.</td></tr>");

        // 체크박스 비활성화
        $("#all").attr("disabled",true);

      }

      // 페이지내이션
      const pagination = memberMap.pagination;

      if (memberMap.pagination.startPage != 1) {

        const li1 = $('<li class="page-link" onclick = "findMember(1)">&lt;&lt;</li>')
        const li2 = $('<li class="page-link" onclick = "findMember('+memberMap.pagination.prevPage+')">&lt;</li>');

        $(".pagination").append(li1);
        $(".pagination").append(li2);
      }

      for (let i = memberMap.pagination.startPage; i <= memberMap.pagination.endPage; i++) {

        if (i == memberMap.pagination.currentPage) {
          li = $('<li class="page-link currentPage" style="color: black; font-weight: bold;"> ' + i + '</li>');
          $(".pagination").append(li);
        } else {
          li = $('<li class="page-link" onclick = findMember(' + i + ')>' + i + '</li>');
          $(".pagination").append(li);
        }

      };

      if (memberMap.pagination.endPage != memberMap.pagination.maxPage) {

        const li1 = $('<li  onclick = "findMember('+memberMap.pagination.nextPage+')" class="page-link" >&gt;</li>');
        const li2 = $('<li onclick = "findMember('+memberMap.pagination.maxPage+')" class="page-link">&gt;&gt;</li>');
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

  });

}


// ===================================== 정렬 하기 ========================================================

// 회원번호로 정렬하기
$("#memberNoSort").on("click",function(){

  // 오름차순인 경우
  if($(this).hasClass("asc")){

    $(this).removeClass("asc");
    $(this).addClass("desc");
    $("#memberNoSort > span").text("회원번호 ▼");
    sortList('memberNumber', 'desc');
    
  }else{
    
    $(this).removeClass("desc");
    $(this).addClass("asc");
    $("#memberNoSort > span").text("회원번호 ▲");
    sortList('memberNumber', 'asc');

  }

});

$("#enrollDtSort").on("click", function(){

  // 오름차순인 경우
  if($(this).hasClass("asc")){

    $(this).removeClass("asc");
    $(this).addClass("desc");
    $("#enrollDtSort > span").text("가입일 ▼");
    sortList('enrollDate', 'desc');
    
  }else{
    
    $(this).removeClass("desc");
    $(this).addClass("asc");
    $("#enrollDtSort > span").text("가입일 ▲");
    sortList('enrollDate', 'asc');
  }

});



function sortList(sortColumn, sortMethod){

  // 현재 페이지
  const currentPage = $(".currentPage").text();

  findMember(currentPage, sortColumn, sortMethod);


}





