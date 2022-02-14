
// 화면 로드 시 리스트 조회
findPost();


function getParam(key) {
	return new URLSearchParams(location.search).get(key)
}


let li;
let blind;
let path;






// 검색어 창의 입력값 제어하기
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


/*

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

*/



// 게시글 상세 정보 모달
function postModal(postNo) {
	$("#postModal").modal("show");
	$(".postListContent").html("");
	$(".modal-img").removeAttr("src");
	$.ajax({
		url: contextPath + "/admin/postView",
		data: { "postNo": postNo },
		dataType: "JSON",


		success: function(post) {
			console.log(post);
			const a2 = $('<a style="text-decoration: none; color: white;"'
				+ 'href="' + contextPath + '/board1/myBoard/' + post.memberNo + '">' + post.memberNm + '</a>')
			const a = $('<a style="text-decoration: none; color: white;"'
				+ 'href="' + contextPath + '/post/view/' + post.postNo + '">' + post.postContent + '</a>')
			const select = $('<select  name="statusCd"  class="select"></select>');
			select.attr("onchange", "changeStatus(event," + post.postNo + ")");
			$(".modal-img").html("");
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

			if (post.imgPath != null) {

				$(".modal-img").css("display", "flex");

				const img = $("<img class = 'modal-imgtag'>").attr("src", contextPath + post.imgPath + post.imgNm);
				$(".modal-img").append(img)
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
				$($(".postListContent")[10]).html(post.CNT);
			} else if (post.poster != null) {
				$(".modal-img").css("display", "flex");
				const img = $("<img class = 'modal-imgtag'>").attr("src", post.poster);
				$(".modal-img").append(img)
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
				$($(".postListContent")[10]).html(post.CNT);


			} else if (post.youtube_path != null) {

				console.log(post.youtube_path);
				$(".modal-img").css("display", "flex");
				$(".modal-img").html(post.youtube_path)
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
				$($(".postListContent")[10]).html(post.CNT);



			} else {

				$(".modal-img").css("display", "none");
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
				$($(".postListContent")[10]).html(post.CNT);



			}

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


// 단일 상태 변경
function changeStatus(event, postNo) {

	const status = $(event.target).val();

	const currentPage = $(".currentPage").text();
	// 변경 처리 후에도 화면을 유지하기 위한 변수
	const statusValue = $("#statusValue option:selected").val();

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
		};
	} else if (status == path) {
		return false;
	}

	$.ajax({

		url: contextPath + "/admin/changeStatus",
		data: { "postNo": postNo, "status": status, "blind": blind },

		success: function() {

			// 변경 성공
			// 리스트 다시 조회
			findPost(currentPage, statusValue);

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

			$($(".postListContent")[9]).html("");
			if (blind != null) {
				console.log(blind);
				$($(".postListContent")[9]).html(blind);

			}

		},



	});

};

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


// ------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------
// ----------------------------------- 연준 작업 시작점 -------------------------------
// ------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------


// ----------------------------------- 체크박스 관련 -------------------------------
// checkbox 전체선택 시
$("#all").on("change", function() {
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

function chkChange() {
	if (!$(this).prop("chceked")) {

		$("#all").prop("checked", false); // 전체 체크 해제
	}

	// .chk이 모두 체크된 경우
	if ($(".chk:checked").length == $(".chk").length) {
		$("#all").prop("checked", true);
	}

	if ($(".chk:checked").length == 0) {
		$(".setBtn").attr("disabled", true);
	}

	if ($(".chk:checked").length > 0) {
		$(".setBtn").removeAttr("disabled");
	}
};


// -------------------------------------- 게시글 상태 변경 --------------------------------

// 게시글 일괄 복구 시키기
function changeCheckbox(statusCode) {

	// 현재 페이지
	const currentPage = $(".currentPage").text();

	// 변경 처리 후에도 화면을 유지하기 위한 변수
	const statusValue = $("#statusValue option:selected").val();

	Swal.fire({
		title: '게시글 상태를 변경하시겠습니까?',
		showCancelButton: true,
		confirmButtonText: '변경',
		confirmButtonColor: '#F05454',
	}).then((result) => {

		if (result.isConfirmed) {

			// 체크된 박스 요소 찾기
			const checkedPost = $("input:checkbox[name='selectOne']:checked");

			// 체크된 박스에 있는 memberNo 얻어오기(배열)
			let checkedPostNo = [];

			checkedPost.each(function(i) {
				checkedPostNo.push(checkedPost[i].parentElement.nextElementSibling.innerText);
			})

			// ajax 수행하기
			$.ajax({

				url: "multiChangePostStatus",
				traditional: true,
				type: "get",
				data: { "checkedPostNo": checkedPostNo, "statusValue": statusCode },

				success: function(result) {

					if (result > 0) {

						// 변경 성공
						// 리스트 다시 조회
						findPost(currentPage, statusValue);

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

					} else {

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

		}

	});

}


// ================================= 게시글 리스트 조회 ===============================

function findPost(cp, statusValue, sortColumn, sortMethod) {

	// 전체선택 버튼 지우기
	$("#all").prop("checked", false);

	if (cp == undefined) {
		cp = 1;
	}

	const sk = $(".selectPostsend").val();
	const sv = $("#searchPost").val();

	$.ajax({

		url: contextPath + "/admin/searchPost",
		type: "get",
		data: {
			"searchPost": sk, "inputResult": sv, "cp": cp,
			"sortColumn": sortColumn, "sortMethod": sortMethod, "statusValue": statusValue
		},
		dataType: "JSON",

		success: function(map) {

			const body = $(".tbody");
			body.html("");
			$(".pagination").html("");

			// 조회 성공 시
			if (map.List.length != 0) {

				// 체크박스 비활성화 해제
				$("#all").removeAttr("disabled");

				// 화면 만들기
				$.each(map.List, function(index, post) {

					// 행
					const tr = $("<tr>");

					// 체크박스
					const td0 = $('<td style="line-height: 22px;"><input onchange="chkChange();" class="form-check-input chk" type="checkbox" name="selectOne"></td>');

					// 게시글 번호
					const td1 = $('<td class="postModalShow" onclick= "postModal(' + post.postNo + ')">');

					// 회원 번호
					const td2 = $('<td class ="MemberView" onclick = "showMemberDetail(' + post.memberNo + ')">');

					// 작성자
					const td3 = $('<td class="shortText">');

					// 닉네임
					const td4 = $('<td class="shortText">');

					// 게시글 내용
					const td5 = $("<td style='padding-left:20px;' class = 'postContent'>");

					// 게시글 좋아요
					const td6 = $("<td>");

					// 작성일
					const td7 = $("<td>");

					// 수정일
					const td8 = $("<td>");

					// 게시글 상태
					const td9 = $("<td>");

					// 회원 프로필 페이지로 이동하는 태그
					const a2 = $('<a style="text-decoration: none; color: white;"'
						+ 'href="' + contextPath + '/board1/myBoard/' + post.memberNo + '">' + post.memberNm + '</a>');

					// 게시글 상세조회로 이동하는 태그
					const a = $('<a style="text-decoration: none; color: white;"'
						+ 'href="' + contextPath + '/post/view/' + post.postNo + '">' + post.postContent + '</a>');

					const select = $('<select  name="statusCd"  class="select"></select>');
					select.attr("onchange", "changeStatus(event," + post.postNo + ")");

					// console.log(select);

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

						select.append(option);
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

					tr.append(td0);
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);
					tr.append(td6);
					tr.append(td7);
					tr.append(td8);
					tr.append(td9);
					body.append(tr);

				});


			} else {

				// 검색 결과가 없는 경우
				$(".tbody").html("<tr><td colspan='10'>등록된게시글이 존재하지 않습니다.</td></tr>")

				// 전체 체크박스 비활성화
				$("#all").attr("disabled", true);

			}

			// 페이지내이션
			const pagination = map.pagination;

			if (pagination.startPage != 1) {

				const li1 = $('<li class="page-link" onclick = "findPost(1)">&lt;&lt;</li>')
				const li2 = $('<li class="page-link" onclick = "findPost(' + pagination.prevPage + ')">&lt;</li>');

				$(".pagination").append(li1);
				$(".pagination").append(li2);
			}

			for (let i = pagination.startPage; i <= pagination.endPage; i++) {

				if (i == pagination.currentPage) {
					li = $('<li class="page-link currentPage" style="color: black; font-weight: bold;"> ' + i + '</li>');
					$(".pagination").append(li);
				} else {

					// 정렬 컬럼과 방식을 정하는 변수 및 로직 
					let sort1 = 'all';
					let sort2 = 'all';

					if ($("#createDtSort").hasClass("createDate")) {

						sort1 = 'createDate';

						if ($("#createDtSort").hasClass("asc")) {
							sort2 = 'asc';
						} else {
							sort2 = 'desc';
						}

					} else {

						sort1 = 'modifyDate';

						if ($("#modifyDtSort").hasClass("asc")) {
							sort2 = 'asc';
						} else {
							sort2 = 'desc';
						}
					}

					li = $('<li class="page-link" onclick = findPost(' + i + ',' + $("#statusValue option:selected").val() + ',"' + sort1 + '","' + sort2 + '")>' + i + '</li>');
					$(".pagination").append(li);

				}

			};

			if (pagination.endPage != pagination.maxPage) {

				const li1 = $('<li  onclick = "findPost(' + pagination.nextPage + ')" class="page-link" >&gt;</li>');
				const li2 = $('<li onclick = "findPost(' + pagination.maxPage + ')" class="page-link">&gt;&gt;</li>');
				$(".pagination").append(li1);
				$(".pagination").append(li2);
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

	});

}


// ===================================== 정렬 하기 ========================================================

// 작성일로 정렬하기
$("#createDtSort").on("click", function() {

	const statusValue = $("#statusValue option:selected").val();

	// 오름차순인 경우
	if ($(this).hasClass("asc")) {

		$("#modifyDtSort").removeClass("modifyDate");
		$(this).removeClass("createDate");
		$(this).addClass("createDate");

		$(this).removeClass("asc");
		$(this).addClass("desc");
		$("#createDtSort").text("작성일 ▼");

		// 가입일 정렬 해제시키기
		$("#modifyDtSort").removeClass("asc");
		$("#modifyDtSort").addClass("desc");
		$("#modifyDtSort").text("수정일 ▽")

		sortList(statusValue, 'createDate', 'desc');

	} else {

		$("#modifyDtSort").removeClass("modifyDate");
		$(this).removeClass("createDate");
		$(this).addClass("createDate");

		$(this).removeClass("desc");
		$(this).addClass("asc");
		$("#createDtSort").text("작성일 ▲");

		// 가입일 정렬 해제시키기
		$("#modifyDtSort").removeClass("asc");
		$("#modifyDtSort").addClass("desc");
		$("#modifyDtSort").text("수정일 ▽")

		sortList(statusValue, 'createDate', 'asc');

	}

});

// 수정일로 정렬하기
$("#modifyDtSort").on("click", function() {

	const statusValue = $("#statusValue option:selected").val();

	// 오름차순인 경우
	if ($(this).hasClass("asc")) {

		$("#createDtSort").removeClass("createDate");
		$(this).removeClass("modifyDate");
		$(this).addClass("modifyDate");

		$(this).removeClass("asc");
		$(this).addClass("desc");
		$("#modifyDtSort").text("수정일 ▼");

		// 작성일 정렬 해제시키기
		$("#createDtSort").removeClass("asc");
		$("#createDtSort").addClass("desc");
		$("#createDtSort").text("작성일 ▽")

		sortList(statusValue, 'modifyDate', 'desc');

	} else {

		$("#createDtSort").removeClass("createDate");
		$(this).removeClass("modifyDate");
		$(this).addClass("modifyDate");

		$(this).removeClass("desc");
		$(this).addClass("asc");
		$("#modifyDtSort").text("수정일 ▲");

		// 회원번호 정렬 해제시키기
		$("#createDtSort").removeClass("asc");
		$("#createDtSort").addClass("desc");
		$("#createDtSort").text("작성일 ▽")

		sortList(statusValue, 'modifyDate', 'asc');

	}

});


function sortList(statusValue, sortColumn, sortMethod) {

	// 현재 페이지
	const currentPage = $(".currentPage").text();

	findPost(currentPage, statusValue, sortColumn, sortMethod);


};


// 상태값으로 찾을 때 
$("#statusValue").on("change", function() {

	// 현재 페이지
	// const currentPage = $(".currentPage").text();
	const statusValue = $("#statusValue option:selected").val();
	let sortColumn = 'all';
	let sortMethod = 'all';

	if ($("#createDtSort").hasClass("createDate")) {

		sortColumn = 'createDate';

		if ($("#createDtSort").hasClass("asc")) {
			sortMethod = 'asc';
		} else {
			sortMethod = 'desc';
		}

	} else {

		sortColumn = 'modifyDate';

		if ($("#modifyDtSort").hasClass("asc")) {
			sortMethod = 'asc';
		} else {
			sortMethod = 'desc';
		}
	}

	findPost(1, statusValue, sortColumn, sortMethod);

});
