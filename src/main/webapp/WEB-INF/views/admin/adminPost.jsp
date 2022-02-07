<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글관리</title>

<link rel="stylesheet"
	href="${contextPath}/resources/css/admin/adminMember.css">

<style type="text/css">
select {
	border-radius: 0; /* 아이폰 사파리 보더 없애기 */
	-webkit-appearance: none; /* 화살표 없애기 for chrome*/
	-moz-appearance: none; /* 화살표 없애기 for firefox*/
	appearance: none /* 화살표 없애기 공통*/
}

select:focus {
	outline: none;
}

#postContent {
	overflow: auto;;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
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
					<div class="adminHeader">게시글관리</div>
					<div class="adminBoardMain">
						<div class="adminSearch">
							<form action="" class="adminSearchForm">
								<select name="" id="" class="select">
									<option value="">게시글번호</option>
									<option value="">회원번호</option>
									<option value="">게시글상태</option>

								</select> <input type="text">
								<button>검색</button>
							</form>


						</div>

						<div class="adminBoardtable">
							<div class="table">
								<table class="table table-hover table-striped my-5"
									id="list-table">

									<thead>
										<tr>
											<th style="width: 100px;">게시글번호</th>
											<th style="width: 140px;">작성자</th>
											<th style="width: 200px;">내용</th>
											<th>조회수</th>
											<th>좋아요</th>
											<th>작성일</th>
											<th>상태</th>
										</tr>

									</thead>
									<tbody>
										<c:choose>

											<c:when test="${empty post}">
												<tr>
													<td colspan="6">등록된게시글이 존재하지 않습니다.</td>
												</tr>


											</c:when>
											<c:otherwise>
												<c:forEach items="${post}" var="post">
													<tr>
														<td style="width: 70px;">${post.postNo}</td>

														<td style="width: 140px;">${post.memberNm}</td>

														<td id='postContent' style="width: 370px;"><a
															style="text-decoration: none; color: white;"
															href="${contextPath}+/post/+${post.postNo}">${post.postContent}<a></td>

														<td style="width: 100px;">${post.createDt}</td>

														<td>${post.readCount}</td>
														<td>${post.likeCount}</td>

														<td style="width: 100px;"><select name="postStatus"
															id="" class="select"
															style="background-color: #3a3939; border: none; color: white;">
																<option value="${post.postNo},500">일반</option>
																<option value="${post.postNo},501">유저삭제</option>
																<option value="${post.postNo},502">블라인드</option>
																<option value="${post.postNo},503">비공개글</option>
																<option value="${post.postNo},504">팔로워 공유</option>

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
				</div>
				<div class="my-5">
					<ul class="pagination">


						<c:if test="${pagination.startPage != 1 }">
							<li><a class="page-link" href="list?cp=1" ${s}>&lt;&lt;</a></li>
							<li><a class="page-link"
								href="list?cp=${pagination.prevPage}${c}${s}">&lt;</a></li>
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
									<li><a class="page-link" href="list?cp=${i}${c}${s}">${i}</a></li>
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
		</main>
	</div>



</body>
</html>