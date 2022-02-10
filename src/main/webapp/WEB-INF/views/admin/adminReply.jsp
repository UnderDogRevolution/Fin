<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글관리</title>
<script type="text/javascript">
	const contextPath = "${contextPath}";
	const c = "${c}";
	const s = "${s}";
	
	
	</script>
<link rel="stylesheet"
	href="${contextPath}/resources/css/admin/adminMember.css">

<style type="text/css">
.xbtn {
	color: white !important;
}
.replyModalShow{
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
					<div class="adminHeader">댓글관리</div>
					<div class="adminBoardMain">
						<div class="adminSearch">
							<select name="searchPost" id="" class="selectPostsend">
								<option value="replyNo">댓글번호</option>
								<option value="postNo">게시글 번호</option>
								<option value="memberNo">회원번호</option>
								<option value="memberNm">회원이름</option>
								<option value="status">댓글상태</option>
							</select> <input type="number" name="inputResult" id="searchPost"
								oninput="selectReplyList();">


						</div>

						<div class="adminBoardtable">
							<div class="table">
								<table class="table" id="list-table">

									<thead>
										<tr>
											<th>댓글번호</th>
											<th>게시글 번호</th>
											<th>회원번호</th>
											<th>작성자</th>
											<th>내용</th>
											<th>좋아요</th>
											<th>작성일</th>
											<th>상태</th>
										</tr>

									</thead>
									<tbody class="tbody">
										<c:choose>

											<c:when test="${empty reply}">
												<tr>
													<td colspan="8">등록된게시글이 존재하지 않습니다.</td>
												</tr>


											</c:when>
											<c:otherwise>
												<c:forEach items="${reply}" var="reply">
													<tr>
														<td class="replyModalShow"
															onclick="postModal(${reply.replyNo})">${reply.replyNo}</td>
														<td>${reply.postNo}</td>
														<td>${reply.memberNo}</td>
														<td><a style="text-decoration: none; color: white;"
															href="${contextPath}/board1/myBoard/${reply.memberNo}">${reply.memberNm}</a></td>

														<td class='replyContent'><a
															style="text-decoration: none; color: white;"
															href="${contextPath}/post/view/${reply.postNo}">${reply.replyContent}<a></td>

														<td>${reply.likeCount}</td>
														<td>${reply.createDt}</td>
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


	<div class="modal fade" id="postModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div style="width: 400px;"
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content postModal-content">
				<div class="modal-header postModal-header">
					<h2 class="modal-title" id="exampleModalLabel">댓글 상세정보</h2>
					<button type="button" class="btn-close xbtn"
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>

				<div class="modal-body">


					<div class="modalContentwrap">
						<div class="postListTitle">댓글 번호</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">게시글 번호</div>
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
						<div class="postListTitle">좋아요</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">작성일</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">상태</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">블라인드사유</div>
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


	<script src="${contextPath}/resources/js/admin/adminReply.js"></script>


</body>
</html>