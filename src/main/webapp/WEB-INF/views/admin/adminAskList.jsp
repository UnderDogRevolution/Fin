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
								<table class="table table-hover table-striped my-5"
									id="list-table">

									<thead>
										<tr>
											<th style="width: 100px;">문의 글번호</th>
											<th style="width: 140px;">제목</th>
											<th style="width: 200px;">내용</th>
											<th>이름</th>
											<th>작성일</th>
										</tr>

									</thead>
									<c:forEach items="${askList}" var="AdminAsk">
										<tbody>
											<tr>
												<td style="width: 70px;">${AdminAsk.askNo}</td>
												<td style="width: 140px;">${AdminAsk.askTitle}</td>
												<td style="width: 300px;">${AdminAsk.askContent}</td>
												<td style="width: 100px;">${AdminAsk.memberName}</td>
												<td style="width: 100px;">${AdminAsk.askDate}</td>
											</tr>

										</tbody>
									</c:forEach>

										<tfoot>
										</tfoot>
								</table>
							</div>
						</div>
						
						<%---------------------- Pagination ----------------------%>
		
		<div class="my-5">
			<ul class="pagination">
				
				
				<c:if test="${pagination.startPage != 1 }">
					<li><a class="page-link" href="list?cp=1${c}${s}">&lt;&lt;</a></li>
					<li><a class="page-link" href="list?cp=${pagination.prevPage}${c}${s}">&lt;</a></li>
				</c:if>
				
				<%-- 페이지네이션 번호 목록 --%>
				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1"  var="i">
					<c:choose>
						<c:when test="${i == pagination.currentPage}">
							<li><a class="page-link" style="color:black; font-weight:bold;">${i}</a></li>   
						</c:when>
						
						<c:otherwise>
							<li><a class="page-link" href="list?cp=${i}${c}${s}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:if test="${pagination.endPage != pagination.maxPage }">
					<li><a class="page-link" href="list?cp=${pagination.nextPage}${c}${s}">&gt;</a></li>
					<li><a class="page-link" href="list?cp=${pagination.maxPage}${c}${s}">&gt;&gt;</a></li>
				</c:if>
			</ul>
		</div>
						
						
						
					</div>
				</div>

			</div>
		</main>
	</div>

</body>
</html>