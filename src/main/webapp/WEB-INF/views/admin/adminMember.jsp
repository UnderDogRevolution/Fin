<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>

<link rel="stylesheet"
	href="${contextPath}/resources/css/admin/adminMember.css">



</head>

<jsp:include page="adminHeader.jsp"/>


<body>
	<div class="mainController">
		<main>

			<div class=" adminBoardwraper">

				<jsp:include page="adminSide.jsp" />
				
				
				<div class="adminBoard">
					<div class="adminHeader">회원관리</div>
					<div class="adminBoardMain">
						<div class="adminSearch">
							<form action="" class="adminSearchForm">
								<select name="" id="" class="select">
									<option value="">회원번호</option>
									<option value="">회원이름</option>

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
											<th style="width: 100px;">회원번호</th>
											<th style="width: 140px;">이름</th>
											<th style="width: 200px;">이메일</th>
											<th>회원상태</th>
											<th>가입일</th>
											<th>신고</th>
										</tr>

									</thead>
									
									<tbody>
										<c:choose>
											<c:when test="${empty memberList}"> 
												<%-- 조회된 회원 목록이 없을 때 --%>
												<tr>
													<td colspan="6">게시글이 존재하지 않습니다.</td>
												</tr>
											</c:when>
											
											<c:otherwise>
												<c:forEach items="${memberList}" var="member">
										
													<tr>
														<td style="width: 70px;">${member.memberNo}</td>
														<td style="width: 140px;">${member.memberNo}</td>
														<td style="width: 300px;">${member.memberNo}</td>
														<td style="width: 100px;">${member.memberNo}</td>
														<td>${member.memberNo}</td>
														<td>${member.memberNo}</td>
													</tr>
													
												</c:forEach>
											</c:otherwise>
										</c:choose>
									
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
										</tr>
									</tbody>

									<tfoot>

									</tfoot>

								</table>

							</div>

						</div>


					</div>

				</div>



			</div>
		</main>
	</div>

	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

	<!-- 전역 변수 -->
	<script>
		const contextPath = "${contextPath}";
	</script>

	<script src="${contextPath}/resources/js/admin/adminMemberController.js"></script>


</body>
</html>