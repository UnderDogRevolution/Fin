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
	padding : 10px;
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
.selectPostsend{
    width: 100px;
    text-align: center;
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
							<select name="selectPost" id="" class="selectPostsend">
								<option value="memberNo">회원번호</option>
								<option value="memberNm">회원이름</option>
								<option value="postNo">게시글번호</option>
								<option value="status">게시글상태</option>

							</select> <input type="text" name="postSearch" id="searchPost">
							<button id="searchbtn" onclick="selectPostList();">검색</button>


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
											<th>작성</th>
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
												<c:forEach items="${askList}" var="AdminAsk">
													<tr>
														<td>${AdminAsk.askNo}</td>
														<td>${AdminAsk.askTitle}</td>
														<td>${AdminAsk.askContent}</td>
														<td>${AdminAsk.memberName}</td>
														<td>${AdminAsk.askDate}</td>
														
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


	<script src="${contextPath}/resources/js/admin/adminPost.js"></script>

	<script type="text/javascript">
	const contextPath = "${contextPath}";
	</script>
</body>
</html>