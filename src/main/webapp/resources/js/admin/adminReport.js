function getParam(key) {
	return new URLSearchParams(location.search).get(key)
}


let li;
let blind;
let path;



$(".selectPostsend").on("change", function() {
	const searchPost = $(".selectPostsend").val(); // select 값
	$("#searchPost").val("");

	if (searchPost == "reportNo") {
		$("#searchPost").attr('type', 'number');
	} else if (searchPost == "memberNo") {
		$("#searchPost").attr('type', 'number');

	} else if (searchPost == "memberNm") {
		$("#searchPost").attr('type', 'text');

	} else if (searchPost == "status") {
		$("#searchPost").attr('type', 'text');

	}

})



function selectReplyList(cp) {//검색

	if (cp == undefined) {
		cp = 1;
	}

	const searchPost = $(".selectPostsend").val(); // select 값
	const inputResult = $("#searchPost").val(); //input 값

	// console.log(inputResult)

	$.ajax({
		url: contextPath + "/admin/searchReport",
		data: { "searchPost": searchPost, "inputResult": inputResult, "cp": cp },
		dataType: "JSON",

		success: function(map) {

			$(".tbody").html("");
			$(".pagination").html("");

			// console.log(map.List);
			if (map.List.length == 0) {
				$(".tbody").html("<tr><td colspan='6'>등록된게시글이 존재하지 않습니다.</td></tr>")

			};


			$.each(map.List, function(index, report) {
				const body = $(".tbody");
				const tr = $("<tr>");
				const td1 = $('<td class="postModalShow" onclick= "reportModal(' + report.replyNo + ')">');
				const td2 = $("<td  onclick = 'showMemberDetail(" + report.memberNo + ")'>");
				const td3 = $("<td class ='MemberView'>");
				const td4 = $("<td class = 'reportContent'>");
				const td5 = $("<td>");
				const td6 = $("<td>");
				const a2 = $('<a style="text-decoration: none; color: white;"'
					+ 'href="' + contextPath + '/board1/myBoard/' + report.memberNo + '">' + report.memberNm + '</a>')





				$(td1).text(report.reportNo);
				$(td2).text(report.memberNo);
				$(td3).append(a2);
				$(td4).text(report.reportContent);
				$(td5).text(report.createDt);
				$(td6).text(report.typeNm)
				tr.append(td1)
				tr.append(td2)
				tr.append(td3)
				tr.append(td4)
				tr.append(td5)
				tr.append(td6)
				body.append(tr);
			});
			const pagination = map.pagination;

			if (pagination.startPage != 1) {

				const li1 = $('<li class="page-link" onclick = "selectReplyList(1)">&lt;&lt;</li>')
				const li2 = $('<li class="page-link" onclick = "selectReplyList(' + pagination.prevPage + ')">&lt;</li>');

				$(".pagination").append(li1);
				$(".pagination").append(li2);
			}
			for (let i = pagination.startPage; i <= pagination.endPage; i++) {

				if (i == pagination.currentPage) {
					li = $('<li class="page-link" style="color: black; font-weight: bold;"> ' + i + '</li>');
					$(".pagination").append(li);
				} else {
					li = $('<li class="page-link" onclick = selectReplyList(' + i + ')>' + i + '</li>');
					$(".pagination").append(li);
				}

			};

			if (pagination.endPage != pagination.maxPage) {

				const li1 = $('<li  onclick = "selectReplyList(' + pagination.nextPage + ')" class="page-link" >&gt;</li>');
				const li2 = $('<li onclick = "selectReplyList(' + pagination.maxPage + ')" class="page-link">&gt;&gt;</li>');
				//li1.addClass("page-link");
				//li2.addClass("page-link");
				$(".pagination").append(li1);
				$(".pagination").append(li2);
			};
		},
		error: function() {


		}





	});

}

function reportModal(reportNo) {
	$("#reportModal").modal("show");
	$(".postListContent").html("");

	$.ajax({
		url: contextPath + "/admin/reportView",
		data: { "reportNo": reportNo },
		dataType: "JSON",


		success: function(result) {
			// console.log(result);
			const a2 = $('<a style="text-decoration: none; color: white;"'
				+ 'href="' + contextPath + '/board1/myBoard/' + result.memberNo + '">' + result.memberNo + '</a>')

			$($(".postListContent")[0]).html(result.reportNo);
			$($(".postListContent")[1]).append(a2);
			$($(".postListContent")[2]).html(result.memberNm);
			$($(".postListContent")[3]).append(result.reportContent);
			$($(".postListContent")[4]).append(result.createDt);
			$($(".postListContent")[5]).html(result.typeNm);



		},
		error: function() {


		}


	});


}


$(".select").on('focus', function() {
	path = this.value;
	// console.log(path);
})



// 회원 정보 상세 조회 함수
function showMemberDetail(memberNo) {

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

		url: contextPath + "/admin/member/selectMemberDetail",
		type: "get",
		data: { "memberNo": memberNo },
		dataType: "JSON",

		success: function(member) {

			if (member != null) {

				// console.log("정보 조회 성공");

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

				// console.log(member);
				// console.log(contextPath);

				$("#memberDetail").modal('show');

			} else {
				console.log("정보 조회 실패");
			}

		},

		error: function(request, status, error) {

			// 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
			if (request.status == 404) {
				console.log("ajax 요청 주소가 올바르지 않습니다.");

			} else if (request.status == 500) {
				console.log("서버 내부 에러 발생");
			}

		},

		complete: function() {

		}

	});


};




