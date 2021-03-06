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
	
	
	</script>
<link rel="stylesheet"
	href="${contextPath}/resources/css/admin/adminMember.css">

<style type="text/css">

/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

/* Firefox */
input[type=number] {
	-moz-appearance: textfield;
}
td{cursor: default;}
.MemberView{
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

.modalContentwrap {
	display: flex;
	width: 100%;
	height: 40px;
	justify-content: center;
}

.postListContent {
	font-size: 15px;
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

.postModalShow {
	cursor: pointer;
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

.modal-img{
	height: 300px;

}

.modal-body::-webkit-scrollbar {
	display: none;
}
</style>

</head>



<body>
	<jsp:include page="adminHeader.jsp" />

	<%-- <c:if test="${!empty post.searchPost}">
		<c:set var="s" value="&sk=${param.searchPost}&sv=${param.inputResult}" />
	</c:if>
 --%>

	<div class="mainController">
		<main>

			<div class=" adminBoardwraper">

				<jsp:include page="adminSide.jsp" />


				<div class="adminBoard">
					<div class="adminHeader">게시글관리</div>
					<div class="adminBoardMain">
						<div class="adminSearch">
							<select name="searchPost" id="" class="selectPostsend">
								<option value="memberNo">회원번호</option>
								<option value="memberNm">회원이름</option>
								<option value="memberNick">회원닉네임</option>
								<option value="postNo">게시글번호</option>
								<option value="status">게시글상태</option>
							</select> <input type="number" name="inputResult" id="searchPost"
								oninput="findPost();">


						</div>

						<div class="adminBoardtable">
							<div class="table">
								<table class="table" id="list-table" style="table-layout:fixed;">

									<thead>
										<tr>
											<!-- 체크박스 -->
											<th style="width: 30px; line-height: 22px;">
												<input class="form-check-input" type="checkbox" id="all">
											</th>

											<!-- 정렬  -->
											<th width="100">게시글번호</th>
											<th width="80">회원번호</th>
											<th width="80">작성자</th>
											<th width="100">닉네임</th>
											<th width="150">내용</th>
											<th width="80">좋아요</th>
											<th width="150" id="createDtSort" class="desc">작성일 ▽</th>
											<th width="150" id="modifyDtSort" class="desc">수정일 ▽</th>
											<th>
												<select style="text-align: center;" id="statusValue" class="selectStatusMenu">
													<option value="all">전체</option>
													
													<c:forEach items="${cd}" var="s">
														<option value="${s.statusCd}">${s.statusNm}</option>
													</c:forEach>
												</select>
											</th>
										</tr>

									</thead>

									<!-- 리스트 영역 -->
									<tbody class="tbody">
										
										<!-- <c:choose>

											<c:when test="${empty post}">
												<tr>
													<td colspan="10">등록된게시글이 존재하지 않습니다.</td>
												</tr>


											</c:when>
											<c:otherwise>
												<c:forEach items="${post}" var="post">
													<tr>

														<td style="line-height: 22px;"><input onchange="chkChange();" class="form-check-input chk" type="checkbox" name="selectOne"></td>

														<td class="postModalShow"
															onclick="postModal(${post.postNo})">${post.postNo}</td>

														<td class="MemberView"
															onclick=" showMemberDetail(${post.memberNo})">${post.memberNo}</td>

														<td class="shortText"><a style="text-decoration: none; color: white;"
															href="${contextPath}/board1/myBoard/${post.memberNo}">${post.memberNm}</a></td>

														<td class="shortText">${post.memberNick}</td>

														<td style="padding-left:20px;" class='postContent'><a
															style="text-decoration: none; color: white;"
															href="${contextPath}/post/view/${post.postNo}">${post.postContent}<a></td>



														<td>${post.likeCount}</td>
														<td>${post.createDt}</td>
														<td>${post.modifyDt}</td>
														<td><select name="statusCd" id="" class="select"
															onchange="changeStatus(event,${post.postNo})">
																<c:forEach items="${cd}" var="c">
																	<c:if test="${post.statusNm == c.statusNm}">
																		<option value="${c.statusCd}" selected>${c.statusNm}</option>
																	</c:if>

																	<c:if test="${post.statusNm != c.statusNm}">
																		<option value="${c.statusCd}">${c.statusNm}</option>
																	</c:if>

																</c:forEach>
														</select></td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose> -->

									</tbody>

								</table>
							</div>

						</div>

						<button class="setBtn" disabled onclick="changeCheckbox(500);">일반</button>

					</div>


					<!-- pagination -->
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
		<div style="width: 500px;"
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content postModal-content">
				<div class="modal-header postModal-header">
					<h2 class="modal-title" id="exampleModalLabel">게시글 상세정보</h2>
					<button type="button" class="btn-close btn-close-white xbtn"
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>

				<div class="modal-body">


					<div class="modalContentwrap modal-img">
						<img class = "modal-imgtag" alt="">
						
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
						<div class="postListTitle">닉네임</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">게시글 내용</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">좋아요 수</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">게시글 작성일</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">게시글 수정일</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">게시글 상태</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">블라인드사유</div>
						<div class="postListContent"></div>
					</div>
					<div class="modalContentwrap">
						<div class="postListTitle">신고 수</div>
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
	<div class="modal fade" id="memberDetail" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content memberModal">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"
						style="font-size: 25px; font-weight: bold;">회원 상세 정보</h5>
					<button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"
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






				<script type="text/javascript">
	
	const gt = '&gt;';
	</script>
				<script src="${contextPath}/resources/js/admin/adminPost.js"></script>
</body>
</html>