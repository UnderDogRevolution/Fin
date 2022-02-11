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

<style>
	#memberDetailContent *{
		color: #323232 !important;
	}
	.memberDetail-body td{
		font-size: 15px;
	}

</style>

</head>

<jsp:include page="adminHeader.jsp"/>


<body>
	<div class="mainController">
		<main>

			<div class=" adminBoardwraper">

				<jsp:include page="adminSide.jsp" />
				
				
				<div class="adminBoard">
				
				<%-- 파라미터 중 sv가 있다면 변수 생성 --%>
				<c:if test="${!empty param.sv}">
					<c:set var="s" value="&sk=${param.sk}&sv=${param.sv}"/>
				</c:if>
				
					<div class="adminHeader">회원관리</div>
					<div class="adminBoardMain">
					
						<div class="adminSearch">
								<select name="sk" class="select" id="sk">
									<option value="number">회원번호</option>
									<option value="name">이름</option>
									<option value="nickName">닉네임</option>
									<option value="email">이메일</option>

								</select> <input name="sv" type="text" id="sv">
								<button onclick="findMember();">검색</button>
						</div>
						

						<div class="adminBoardtable">

							<div class="table table-hover table-dark align-middle">
								
								<table class="table my-5"
									id="list-table">

									<thead>
										<tr>
											<th style="width: 50px; line-height: 22px;">
												<input class="form-check-input" type="checkbox" id="all">
											</th>
											<th style="width: 100px;"><span>회원번호 ▼</span></th>
											<th style="width: 140px;">이름</th>
											<th style="width: 200px;">닉네임</th>
											<th>이메일</th>
											<th><span>가입일 ▼</span></th>
											<th>
												회원상태
												<select name="" id="" class="" 
												style="
												width: 80px;
												text-align: center;
												background-color: #3a3939;
												border: none;
												color: white;
												outline: none;">
													<option value="">전체</option>
													
													<c:forEach items="${statusList}" var="s">
														<option value="${s.statusCode}">${s.statusName}</option>
													</c:forEach>
												</select>
											</th>
										</tr>

									</thead>
									
									<tbody>
										<c:choose>
											<c:when test="${empty memberList}"> 
												<%-- 조회한 회원 목록이 없을 때 --%>
												<tr>
													<td colspan="7">조회 결과가 존재하지 않습니다.</td>
												</tr>
											</c:when>
											
											<c:otherwise>
												<c:forEach items="${memberList}" var="member">
										
													<tr>
														<td style="line-height: 22px;"><input class="form-check-input chk" type="checkbox" name="selectOne"></td>
														<td>${member.memberNo}</td>

														<td><span style="cursor:pointer;" onclick="showMemberDetail(${member.memberNo});">${member.memberName}</span></td>
														<td>${member.memberNickName}</td>
														<td>${member.memberEmail}</td>

														<td>${member.enrollDate}</td>
														<td>
														
															<select onchange="changeStatus(this.value, ${member.memberNo}, event);" style="width: 80px; text-align: center;
																	background-color: #3a3939; border: none;
																	color: white; outline: none;">
																<c:forEach items="${statusList}" var="s">
																	<option <c:if test="${s.statusCode == member.memberStatusCode}">selected</c:if> value="${s.statusCode}">${s.statusName}</option>
																</c:forEach>
															</select>
															
														</td>
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
					
					
					<%---------------------- Pagination ----------------------%>
					<button onclick="changeCheckbox(202);">정지</button>
					<button onclick="changeCheckbox(200);">일반</button>
					<button onclick="changeCheckbox(201);">탈퇴</button>
					
					<div class="my-5">
						<div>
							<ul class="pagination">
								
								
								<c:if test="${pagination.startPage != 1 }">
									<li><a class="page-link" href="list?cp=1"${s}>&lt;&lt;</a></li>
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
									<li><a class="page-link" href="list?cp=${pagination.maxPage }${c}${s}">&gt;&gt;</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>



			</div>
		</main>
	</div>

	<!-- 회원 정보 상세 조회 모달 -->
	<div class="modal fade" id="memberDetail" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content" style="color: #323232;">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel" style="font-size: 25px; font-weight: bold;">회원 상세 정보</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>

				<div class="modal-body" id="memberDetailContent">
				
					<div class="memberDetail-header">

						<div class="memberProfile" style="width: 150px; height: 150px; border-radius: 50%; overflow: hidden; margin: auto; margin-bottom: 10px;">
						    <img class="inputMemberProfileImage" src="${contextPath}/resources/images/common/defaultProfileImage.png" style="width: 150px; height: 150px; object-fit: cover; ">
						  </div>
						  <div class="inputMemberEmail" style="text-align: center;font-size: 25px;font-weight: bold;margin: 20px;">
						    
						  </div>
						  
						</div>

						<div class="memberDetail-body">
						  <table style="margin: auto;" style="color: #323232 !important;">
						    
						    <tr>
						      <td>이름 : </td>
						      <td class="inputMemberName"></td>
						    </tr>
						
						    <tr>
						      <td>닉네임 :</td>
						      <td class="inputMemberNickName"></td>
						    </tr>
						
						    <tr>
						      <td>회원번호 : </td>
						      <td class="inputMemberNo"></td>
						    </tr>
						
						    <tr>
						      <td>생일 : </td>
						      <td class="inputMemberBirth"></td>
						    </tr>
						
						    <tr>
						      <td>가입일 : </td>
						      <td class="inputMemberEnrollDate"></td>
						    </tr>
						
						    <tr>
						      <td>회원 상태 : </td>
						      <td class="inputMemberStatusName"></td>
						    </tr>
						
						    <tr>
						      <td>경고 횟수 : </td>
						      <td class="inputViolationCount"></td>
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




	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

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

	<script src="${contextPath}/resources/js/admin/adminMemberController.js"></script>
	

</body>
</html>

