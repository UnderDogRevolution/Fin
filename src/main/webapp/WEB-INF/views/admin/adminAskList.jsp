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

select:focus {
	outline: none;
}

.postContent {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	display: block;
	height: 30px;
	width: 150px;
	text-align: left;
	padding-left: 15px;
}

.adminSearch {
	padding-left: 20px;
}

#searchPost {
	margin-left: 10px;
	margin-right: 10px;
	outline: none;
	width: 200px;
	height: 30px;
	border-radius: 5px;
	padding: 10px;
}

#searchbtn {
	width: 50px;
	font-size: 15px;
	height: 31px;
	border: none;
	border-radius: 5px;
	background-color: #942d2d;
	color: white;
}

.selectPostsend {
	width: 100px;
	text-align: center;
}

#askDetailContent * {
	color: #323232;
}

.askDetail-body td {
	font-size: 15px;
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
					<div class="adminHeader">문의글 리스트</div>
					<div class="adminBoardMain">

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
										</tr>

									</thead>
									<tbody>
										<c:choose>

											<c:when test="${empty askList}">
												<tr>
													<td colspan="6">등록된 문의글이 존재하지 않습니다.</td>
												</tr>

											</c:when>
											<c:otherwise>
												<c:forEach items="${askList}" var="ask">
													<tr style="cursor: pointer;" onclick="showAskDetail(${ask.askNo});">
														<td>${ask.askNo}</td>
														<td>${ask.askTitle}</td>
														<td>${ask.askContent}</td>
														<td>${ask.memberName}</td>
														<td>${ask.askDate}</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</tbody>
									<tfoot>
									</tfoot>
								</table>
							</div>
						</div>


					</div>
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
			<div class="modal-content" style="color: #323232;">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">문의 글 상세 조회</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body" id="askDetailContent">

					<div class="askDetail-header">

						<div class="askDetail-body">
							<table>

								<tr>
									<td>회원번호 :</td>
									<td class="askMemberNo"></td>
								</tr>

								<tr>
									<td>제목 :</td>
									<td class="askTitle"></td>
								</tr>

								<tr>
									<td>내용 :</td>
									<td class="askContent"></td>
								</tr>

								<tr>
									<td>이름 :</td>
									<td class="askMemberName"></td>
								</tr>

								<tr>
									<td>작성일 :</td>
									<td class="askDate"></td>
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
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="		crossorigin="anonymous"></script>


	<script>
		const contextPath = "${contextPath}";
	</script>

	<script src="${contextPath}/resources/js/admin/adminAskController.js"></script>
</body>
</html>