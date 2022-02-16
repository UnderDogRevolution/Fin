<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>바라는 점 게시판</title>

<link rel="stylesheet"
	href="${contextPath}/resources/css/admin/adminMember.css">
<style type="text/css">
select {
	border-radius: 0; /* 아이폰 사파리 보더 없애기 */
	-webkit-appearance: none; /* 화살표 없애기 for chrome*/
	-moz-appearance: none; /* 화살표 없애기 for firefox*/
	appearance: none; /* 화살표 없애기 공통*/
	border-radius: 5px;
	cursor: pointer;
	background-color: #3a3939;
	border: none;
	color: white;
}

.xbtn {
	color: white !important;
}

select:focus {
	outline: none;
}

#askDetailContent * {
	color: #323232;
}

.askDetail-body * {
	font-size: 15px;
}

.table {
	table-layout: fixed;
}

.table td {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
	outline: none;
	border-color: #323232;
}
</style>
</head>
<jsp:include page="adminHeader.jsp" />
<body>
	<div class="mainController">
		<main>
			<div class=" adminBoardwraper">
				<jsp:include page="adminSide.jsp" />

				<div class="adminBoard">

					<%-- 파라미터 중 sv가 있다면 변수 생성 --%>
					<c:if test="${!empty param.sv}">
						<c:set var="s" value="&sk=${param.sk}&sv=${param.sv}" />
					</c:if>


					<div class="adminHeader">문의글 리스트</div>
					<div class="adminBoardMain">

						<div class="adminSearch">
							<select name="sk" class="select" id="sk">
								<option value="askTitle">제목</option>
								<option value="askContent">내용</option>
								<option value="memberName">이름</option>

							</select> <input autocomplete="off" name="sv" type="text" id="sv" oninput="findAsk();">
						</div>

						<div class="adminBoardtable">
							<div class="table">
								<table class="table my-5" id="list-table">

									<thead>
										<tr>
											<th>글번호</th>
											<th>제목</th>
											<th>내용</th>
											<th>이름</th>
											<th>작성일</th>
											<th>삭제하기</th>
										</tr>

									</thead>
									<tbody class="tbody">
									
									</tbody>
									<tfoot>
									</tfoot>
								</table>
							</div>
						</div>


					</div>
					
					<%---------------------- Pagination ----------------------%>
					<div class="my-5">
						<div>
							<ul class="pagination">


								<c:if test="${pagination.startPage != 1 }">
									<li><a class="page-link" href="ask?cp=1" ${s}>&lt;&lt;</a></li>
									<li><a class="page-link"
										href="ask?cp=${pagination.prevPage}${c}${s}">&lt;</a></li>
								</c:if>

								<%-- 페이지네이션 번호 목록 --%>
								<c:forEach begin="${pagination.startPage}"
									end="${pagination.endPage}" step="1" var="i">
									<c:choose>
										<c:when test="${i == pagination.currentPage}">
											<li><a class="page-link"
												style="color: black; font-weight: bold;">${i}</a></li>
										</c:when>

										<c:otherwise>
											<li><a class="page-link" href="ask?cp=${i}${c}${s}">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>

								<c:if test="${pagination.endPage != pagination.maxPage }">
									<li><a class="page-link"
										href="list?cp=${pagination.nextPage}${c}${s}">&gt;</a></li>
									<li><a class="page-link"
										href="list?cp=${pagination.maxPage }${c}${s}">&gt;&gt;</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>


			</div>
		</main>
	</div>


	<!-- 문의 글 상세조회 모달 -->
	<div class="modal fade" id="askDetail" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content askModal-content"
				style="color: #ffffff; background-color: #323232;">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"
						style="text-align: center; width: 100%; font-size: 1.5rem; font-weight: bold;">문의
						글 상세 조회</h5>
					<button type="button" class="btn-close xbtn"
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>

				<div class="modal-body" id="askDetailContent">
					<div class="askDetail-header">
						<div class="askDetail-body">
							<table
								style="text-align: center; width: 100%; border-color: #323232">

								<tr>
									<td style="width: 30%">회원번호 :</td>
									<td class="askAskNo"></td>
								</tr>

								<tr>
									<td>이름 :</td>
									<td class="askMemberName"></td>
								</tr>

								<tr>
									<td>작성일 :</td>
									<td class="askDate"></td>
								</tr>

								<tr>
									<td>제목 :</td>
									<td class="askTitle"></td>
								</tr>

								<tr>
									<td>내용 :</td>
									<td class="askContent" rowspan="5"></td>
								</tr>

							</table>

						</div>

					</div>

					<!-- <div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary">저장</button>
				</div> -->
				</div>
			</div>
		</div>
	</div>

	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>

	<!--  sweetalert2 -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script>
		const contextPath = "${contextPath}";
	</script>

	<!-- 전역 변수 -->
	<script>
		const contextPath = "${contextPath}";
		
		// 쿼리스트링에서 파라미터를 얻어와 반환하는 함수
		function getParam(key){
			return new URLSearchParams(location.search).get(key)
		}
		
		// 1) name 속성값이 sk인 select의 자식 option 태그 모두 얻어오기
		const skOptions = document.querySelectorAll("select[name='sk'] > option")

		// 2) 향상된 for문을 이용해서 option 하나씩 접근
		for(let option of skOptions){

			// 3) 현재 접근한 option의 value와 쿼리스트링 sk값이 같다면
			if( option.value == getParam("sk")){
				
				// 4) 일치하는 option 태그에 selected 속성 추가
				option.setAttribute("selected", true)
			}
		}
		
		// 검색 input 세팅하기
		document.querySelector("input[name='sv']").value = getParam("sv")
	</script>


	<script src="${contextPath}/resources/js/admin/adminAskController.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<script>
		function askDelete(event, askNo){
			
			const deleteRow = $(event.target);
			
			Swal.fire({
				  title: '정말 삭제하시겠습니까?',
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '삭제',
				  cancelButtonText: '취소'
				}).then((result) => {
				  if (result.isConfirmed) {
				    
					  $.ajax({
							
							url : "askDelete",
							type : "get",
							dataType : "JSON",
							data: {"askNo" : askNo},
							
							success : function(result) {			
				
								if(result > 0){
									findAsk(1);				
								}else{
									console.log("삭제에 실패하였습니다.");
								}
								
							},
				
							error : function(request, status, error) {
				
								if (request.status == 404) {
									console.log("ajax 요청 주소가 올바르지 않습니다.");
				
								} else if (request.status == 500) {
									console.log("서버 내부 에러 발생");
								}
							}
						});
				    
				  }
				})
		}
	</script>
</body>
</html>