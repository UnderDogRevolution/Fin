

function getParam(key) {
	return new URLSearchParams(location.search).get(key)
}


let li;
let blind;
let path;







$(".selectPostsend").on("change", function() {
	const searchPost = $(".selectPostsend").val(); // select 값
	$("#searchPost").val("");
	if (searchPost == "memberNo") {
		$("#searchPost").attr('type', 'number');
	} else if (searchPost == "postNo") {
		$("#searchPost").attr('type', 'number');

	} else if (searchPost == "memberNm") {
		$("#searchPost").attr('type', 'text');

	} else if (searchPost == "status") {
		$("#searchPost").attr('type', 'text');

	}
	 else if (searchPost == "memberNick") {
		$("#searchPost").attr('type', 'text');

	}


})



function selectPostList(cp) {//검색

	if (cp == undefined) {
		cp = 1;
	}

	const searchPost = $(".selectPostsend").val(); // select 값
	const inputResult = $("#searchPost").val(); //input 값

	console.log(inputResult)

	$.ajax({
		url: contextPath + "/admin/searchPost",
		data: { "searchPost": searchPost, "inputResult": inputResult, "cp": cp },
		dataType: "JSON",

		success: function(map) {

			$(".tbody").html("");
			$(".pagination").html("");

			console.log(map.List);
			if (map.List.length == 0) {
				$(".tbody").html("<tr><td colspan='9'>등록된게시글이 존재하지 않습니다.</td></tr>")

			};


			$.each(map.List, function(index, post) {
				const body = $(".tbody");
				const tr = $("<tr>");
				const td1 = $('<td class="postModalShow" onclick= "postModal(' + post.postNo + ')">');
				const td2 = $('<td class ="MemberView" onclick = "showMemberDetail('+post.memberNo+')">');
				const td3 = $("<td>");
				const td4 = $("<td>");
				const td5 = $("<td class = 'postContent'>");
				const td6 = $("<td>");
				const td7 = $("<td>");
				const td8 = $("<td>");
				const td9 = $("<td>");
				const a2 = $('<a style="text-decoration: none; color: white;"'
					+ 'href="' + contextPath + '/board1/myBoard/' + post.memberNo + '">' + post.memberNm + '</a>')
				const a = $('<a style="text-decoration: none; color: white;"'
					+ 'href="' + contextPath + '/post/view/' + post.postNo + '">' + post.postContent + '</a>')
				const select = $('<select  name="statusCd"  class="select"></select>');
				select.attr("onchange", "changeStatus(event," + post.postNo + ")");
				console.log(select);
				for (let i = 500; i < 505; i++) {
					const option = $("<option>");
					option.val(i);

					if (i == post.status) {
						option.attr("selected", "selected")
					}
					if (i == 500) {
						option.text("일반")
					} else if (i == 501) {
						option.text("유저삭제")
					} else if (i == 502) {
						option.text("블라인드")
					} else if (i == 503) {
						option.text("비공개")
					} else if (i == 504) {
						option.text("팔로워 공유")
					}

					select.append(option)
				}

				$(select).on('focus', function() {
					path = this.value;
					console.log(path);
				});


				$(td1).text(post.postNo);
				$(td2).text(post.memberNo);
				$(td3).append(a2);
				$(td4).text(post.memberNick);
				$(td5).append(a);
				$(td6).append(post.likeCount)
				$(td7).text(post.createDt);
				$(td8).text(post.modifyDt);
				
				$(td9).append(select);

				tr.append(td1)
				tr.append(td2)
				tr.append(td3)
				tr.append(td4)
				tr.append(td5)
				tr.append(td6)
				tr.append(td7)
				tr.append(td8)
				tr.append(td9)
				body.append(tr);
			});
			const pagination = map.pagination;

			if (pagination.startPage != 1) {

				const li1 = $('<li class="page-link" onclick = "selectPostList(1)">&lt;&lt;</li>')
				const li2 = $('<li class="page-link" onclick = "selectPostList('+pagination.prevPage+')">&lt;</li>');

				$(".pagination").append(li1);
				$(".pagination").append(li2);
			}
			for (let i = pagination.startPage; i <= pagination.endPage; i++) {

				if (i == pagination.currentPage) {
					li = $('<li class="page-link" style="color: black; font-weight: bold;"> ' + i + '</li>');
					$(".pagination").append(li);
				} else {
					li = $('<li class="page-link" onclick = selectPostList(' + i + ')>' + i + '</li>');
					$(".pagination").append(li);
				}

			};

			if (pagination.endPage != pagination.maxPage) {

				const li1 = $('<li  onclick = "selectPostList('+pagination.nextPage+')" class="page-link" >&gt;</li>');
				const li2 = $('<li onclick = "selectPostList('+pagination.maxPage+')" class="page-link">&gt;&gt;</li>');
				//li1.addClass("page-link");
				//li2.addClass("page-link");
				$(".pagination").append(li1);
				$(".pagination").append(li2);
			}


		},
		error: function() {


		}





	});

}

function postModal(postNo) {
	$("#postModal").modal("show");
	$(".postListContent").html("");

	$.ajax({
		url: contextPath + "/admin/postView",
		data: { "postNo": postNo },
		dataType: "JSON",
		

		success: function(post) {
			
			console.log(post.blind);
			const a2 = $('<a style="text-decoration: none; color: white;"'
				+ 'href="' + contextPath + '/board1/myBoard/' + post.memberNo + '">' + post.memberNm + '</a>')
			const a = $('<a style="text-decoration: none; color: white;"'
				+ 'href="' + contextPath + '/post/view/' + post.postNo + '">' + post.postContent + '</a>')
			const select = $('<select  name="statusCd"  class="select"></select>');
			select.attr("onchange", "changeStatus(event," + post.postNo + ")");
			for (let i = 500; i < 505; i++) {
				const option = $("<option>");
				option.val(i);
				if (i == post.status) {
					option.attr("selected", "selected")
				}
				if (i == 500) {
					option.text("일반")
					option.val("500");
				} else if (i == 501) {
					option.text("유저삭제")
					option.val("501");
				} else if (i == 502) {
					option.text("블라인드")
					option.val("502");
				} else if (i == 503) {
					option.text("비공개")
					option.val("503");
				} else if (i == 504) {
					option.text("팔로워 공유")
					option.val("504");
				}
				select.append(option);
			}
			select.on('focus', function() {
				path = this.value;
				console.log(path);
			})

			$($(".postListContent")[0]).html(post.postNo);
			$($(".postListContent")[1]).html(post.memberNo);
			$($(".postListContent")[2]).append(a2);
			$($(".postListContent")[3]).html(post.memberNick);
			$($(".postListContent")[4]).append(a);
			$($(".postListContent")[5]).html(post.likeCount);
			$($(".postListContent")[6]).html(post.createDt);
			$($(".postListContent")[7]).html(post.modifyDt);
			$($(".postListContent")[8]).append(select);
			$($(".postListContent")[9]).html(post.blind);








		},
		error: function() {


		}


	});


}

/*$(document).on('change','.select',function(){
	}) 
*/

$(".select").on('focus', function() {
	path = this.value;
	console.log(path);
})



function changeStatus(event, postNo) {

	const status = $(event.target).val();

	console.log(postNo, status);
	const e = $(event.target);
	if (status == 502) {
		blind = prompt("사유를 입력해주세요");
		if (blind == null) {
			$(event.target).val(path).prop("selected", true);
			return false;
		} else if (blind.trim().length == 0) {
			alert("블라인드 사유를 입력해주세요")
			$(event.target).val(path).prop("selected", true);
			return false;
		}
		;
	} else if (status == path) {
		return false;
	}

	$.ajax({

		url: contextPath + "/admin/changeStatus",
		data: { "postNo": postNo, "status": status, "blind": blind },

		success: function() {
			alert("변경되었습니다.")
			$($(".postListContent")[9]).html("");
			if (blind != null) {
				console.log(blind);
				$($(".postListContent")[9]).html(blind);



			}

		},



	});

};

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

    url : contextPath +"/admin/member/selectMemberDetail",
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
      }
   
    },

    complete : function(){

    }

  });
  
  
};


// ----------------------------------- 연준 작업 시작점 -------------------------------


// ----------------------------------- 체크박스 관련 -------------------------------
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





