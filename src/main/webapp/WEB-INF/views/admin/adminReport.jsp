<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 관리</title>
<script type="text/javascript">
	const contextPath = "${contextPath}";
	
	</script>
<link rel="stylesheet"
	href="${contextPath}/resources/css/admin/adminMember.css">

<style type="text/css">
tr > td:nth-child(2){
cursor: pointer;
}

.MemberView {
	cursor: pointer;
}

h5 {
	color: white;
}

.inputMemberEmail {
	color: white;
}

.memberModal {
	background-color: #3a3939 !important;
}

.xbtn {
	color: white !important;
}

.replyModalShow {
	cursor: pointer;
}

.modalContentwrap {
	display: flex;
	width: 100%;
	height: 40px;
}

.postListContent {
	font-size: 20px;
	display: flex;
	width: 220px;
	padding-left: 10px;
	align-items: center;
	justify-content: center;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	margin-left: 10px;
}

.postListTitle {
	display: flex;
	justify-content: flex-end;
	width: 30%;
	align-items: center;
}

.postModal-header {
	flex-direction: column-reverse !important;
	color: white;
}

.postModal-content {
	background-color: #3a3939 !important;
}

.page-link {
	cursor: pointer;
}

.postModalShow {
	cursor: pointer;
}

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

.replyContent {
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
</style>

</head>

<jsp:include page="adminHeader.jsp" />


<body>
	<%-- <c:if test="${!empty post.searchPost}">
		<c:set var="s" value="&sk=${param.searchPost}&sv=${param.inputResult}" />
	</c:if>
 --%>

	<div class="mainController">
		<main>

			<div class=" adminBoardwraper">

				<jsp:include page="adminSide.jsp" />


				<div class="adminBoard">
					<div class="adminHeader">신고관리</div>
					<div class="adminBoardMain">
						<div class="adminSearch">
							<select name="searchPost" id="" class="selectPostsend">
								<option value="reportNo">신고 번호</option>
								<option value="memberNo">회원번호</option>
								<option value="memberNm">회원이름</option>
								<option value="status">신고유형</option>
							</select> <input type="number" name="inputResult" id="searchPost"
								oninput="selectReplyList();">


						</div>

						<div class="adminBoardtable">
							<div class="table">
								<table class="table" id="list-table">

									<thead>
										<tr>
											<th>신고번호</th>
											<th>회원 번호</th>
											<th>작성자</th>
											<th>내용</th>
											<th>작성일</th>
											<th>신고 유형</th>
										</tr>

									</thead>
									<tbody class="tbody">
										<%-- <c:choose>
											
											<c:when test="${empty report}">
												<tr>
													<td colspan="6">등록된댓글이 존재하지 않습니다.</td>
												</tr>


											</c:when>
											<c:otherwise>
												<c:forEach items="${report}" var="report">
													<tr>
														<td class="replyModalShow"
															onclick="reportModal(${report.reportNo})">${report.reportNo}</td>
														<td onclick="showMemberDetail(${report.memberNo})">${report.memberNo}</td>
														
														<td><a style="text-decoration: none; color: white;"
															href="${contextPath}/board1/myBoard/${report.memberNo}">${report.memberNm}</a></td>
														<td class='replyContent'>${report.reportContent}</td>


														<td>${report.createDt}</td>
														<c:if test="${report.typeNo == 0}">
															<td>게시판</td>
														</c:if>
														<c:if test="${report.typeNo == 1}">
															<td>댓글</td>
														</c:if>
															
															<td class="MemberView"
															onclick="showMemberDetail(${report.memberNo})">${report.memberNm}</td>

														<td><select name="statusCd" id="" class="select"
															onchange="changeStatus(event,${reply.replyNo})">
																<c:forEach items="${cd}" var="c">
																	<c:if test="${reply.statusNm == c.statusNm}">
																		<option value="${c.statusCd}" selected>${c.statusNm}</option>
																	</c:if>

																	<c:if test="${reply.statusNm != c.statusNm}">
																		<option value="${c.statusCd}">${c.statusNm}</option>
																	</c:if>

																</c:forEach>



														</select></td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose> --%>
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
									<li><a class="page-link" href="?cp=1" ${s}>&lt;&lt;</a></li>
									<li><a class="page-link"
										href="?cp=${pagination.prevPage}${c}${s}">&lt;</a></li>
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
											<li><a class="page-link" href="?cp=${i}${c}${s}">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>

								<c:if test="${pagination.endPage != pagination.maxPage }">
									<li><a class="page-link"
										href="?cp=${pagination.nextPage}${c}${s}">&gt;</a></li>
									<li><a class="page-link"
										href="?cp=${pagination.maxPage }${c}${s}">&gt;&gt;</a></li>
								</c:if>
							</ul>
						</div>
					</div>



				</div>


			</div>
		</main>
	</div>


	<div class="modal fade" id="reportModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div style="width: 400px;"
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content postModal-content">
				<div class="modal-header postModal-header">
					<h2 class="modal-title" id="exampleModalLabel">신고 상세정보</h2>
					<button type="button" class="btn-close xbtn"
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>

				<div class="modal-body">


					<div class="modalContentwrap">
						<div class="postListTitle">신고 번호</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">회원 번호</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">작성자</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">내용</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">작성일</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">신고유형</div>
						<div class="postListContent"></div>
					</div>


				</div>

				<!-- <div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary">저장</button>
				</div> -->

			</div>
		</div>
	</div>

	<!-- 회원 정보 상세 조회 모달 -->
	<!-- 회원 정보 상세 조회 모달 -->
	<div class="modal fade" id="memberDetail" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content memberModal">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"
						style="font-size: 25px; font-weight: bold;">회원 상세 정보</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body" id="memberDetailContent">

					<div class="memberDetail-header">

						<div class="memberProfile"
							style="width: 150px; height: 150px; border-radius: 50%; overflow: hidden; margin: auto; margin-bottom: 10px;">
							<img class="inputMemberProfileImage"
								src="${contextPath}/resources/images/common/defaultProfileImage.png"
								style="width: 150px; height: 150px; object-fit: cover;">
						</div>
						<div class="inputMemberEmail"
							style="text-align: center; font-size: 25px; font-weight: bold; margin: 20px;">

						</div>

					</div>

					<div class="memberDetail-body">
						<table style="margin: auto;" style="color: #323232 !important;">

							<tr>
								<td>이름 :</td>
								<td class="inputMemberName"></td>
							</tr>

							<tr>
								<td>닉네임 :</td>
								<td class="inputMemberNickName"></td>
							</tr>

							<tr>
								<td>회원번호 :</td>
								<td class="inputMemberNo"></td>
							</tr>

							<tr>
								<td>생일 :</td>
								<td class="inputMemberBirth"></td>
							</tr>

							<tr>
								<td>가입일 :</td>
								<td class="inputMemberEnrollDate"></td>
							</tr>

							<tr>
								<td>회원 상태 :</td>
								<td class="inputMemberStatusName"></td>
							</tr>

							<tr>
								<td>경고 횟수 :</td>
								<td class="inputViolationCount"></td>
							</tr>

						</table>

					</div>

				</div>






				<script src="${contextPath}/resources/js/admin/adminReport.js"></script>
</body>
</html>