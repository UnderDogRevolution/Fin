<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>main</title>
<link rel="stylesheet" href="${contextPath}/resources/css/main/main.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/side.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/feed.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/crud-post.css">
</head>
<body>

	<c:if test="${post.postStatusCode == 501}">
		<script>
			alert("삭제된 게시글 입니다.")
			window.history.back();
		</script>
	</c:if>
    <%--<jsp:include page="../main/feed.jsp"></jsp:include>--%>
	
	<jsp:include page="../main/side.jsp"></jsp:include>
	<jsp:include page="../main/crud-post.jsp"></jsp:include>

	<div id="container-post" style="padding-top: 70px; padding-right: 30%; padding-bottom: 13px;">
		<c:choose>
			<c:when test="${post.postStatusCode == 500}">
					<div class="post">
						<div class="post-header">
							<div>
								<c:choose>
									<c:when test="${post.listProfile[0] != null}">
										<img class="profile-img" src="${contextPath}${post.listProfile[0].imgPath}${post.listProfile[0].imgName}">
									</c:when>
									<c:otherwise>
										<img class="profile-img" src="${contextPath}/resources/images/common/defaultProfileImage.png">
									</c:otherwise>
								</c:choose>
							</div>
							<span>${post.memberName}</span><span>${post.createDate}</span>
							<div class="dropdown me-1 header-dropdown"><img id="dropdownMenuOffset" data-bs-toggle="dropdown"
									aria-expanded="false" data-bs-offset="-40,-10" src="${contextPath}/resources/images/temp/dots.png">
								<ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
									<li><a class="dropdown-item">링크복사</a></li>
									<c:if test="${loginMember != null}">
										<li><a class="dropdown-item" onclick="report(0, ${post.postNo})">신고하기</a></li>
									</c:if>
									<c:if test="${loginMember.memberNo == post.memberNo}">
										<li><a class="dropdown-item" onclick="deletePost(this)">삭제</a></li>
									</c:if>
								</ul>
							</div>
						</div>
						<div class="post-content">
							<c:if test="${post.movieTitle != null}">
								<div class="review-title">${post.movieTitle} <span>(${post.movieDate}) ${post.movieGenre}</span></div>
							</c:if>
							<div class="textarea-box">${post.postContent}</div>
							<c:if test="${post.rating > 0}">
								<div class="post-rating">
								<c:forEach var="i" begin="1" end="${post.rating*2}">
									<i class="fa fa-star rating-star" aria-hidden="true" style="color: yellow"></i>
								</c:forEach>
								<c:forEach var="i" begin="1" end="${10 - (post.rating*2)}">
									<i class="fa fa-star rating-star" aria-hidden="true" style="color: white"></i>
								</c:forEach>
										<span>${post.rating}</span>
								</div>
							</c:if>
							<c:choose>
								<c:when test="${post.checkUsePoster == 1}">
									<div class="container-img">
										<img src="${post.poster}">
									</div>
								</c:when>
								<c:when test="${post.listPostImage[0] != null }">
									<div class="container-img">
										<img src="${contextPath}${post.listPostImage[0].postImagePath}${post.listPostImage[0].postImageName}">
									</div>
								</c:when>
							</c:choose>
						</div>
						<div class="post-footer">
							<div class="container-like">
								<c:choose>
									<c:when test="${post.checkLike != 1}">
										<img class="vivid-popcorn" src="${contextPath}/resources/images/temp/new vivid popcorn2.png" style="width: 100%; display:none;">
										<img class="white-popcorn" src="/fin/resources/images/temp/new white popcorn.png" style="width: 100%;">
									</c:when>
									<c:otherwise>
										<img class="vivid-popcorn" src="${contextPath}/resources/images/temp/new vivid popcorn2.png" style="width: 100%;">
										<img class="white-popcorn" src="/fin/resources/images/temp/new white popcorn.png" style="width: 100%;  display:none;">
									</c:otherwise>
								</c:choose>
								<span style="display:none;">${post.postNo}</span><span>${post.likeCount}</span></div>
							<div class="container-reply">
								<img src="${contextPath}/resources/images/temp/reply.png" style="width: 100%;">
								<span>${post.replyCount}</span></div>
						</div>
						<div class="input-content-reply">
							<div onclick="reformReply()">댓글</div>
							<div><input type="text" placeholder="댓글을 달아주세요!"></div>
							<div><img src="${contextPath}/resources/images/temp//comment.png" onclick="insertReply(this)"></div>
						</div>
			</c:when>
		</c:choose>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		const contextPath = "${contextPath}";
		<c:if test="${loginMember.memberNo != null}">
			const memberNo = ${loginMember.memberNo }
		</c:if>
		const postContent = "${post.postContent}";
		const postNo = ${post.postNo};
	</script>
	<!-- <script src="${contextPath}/resources/js/post/post.js"></script> -->
	<script src="${contextPath}/resources/js/post/postView.js"></script>
	<script src= "${contextPath}/resources/js/post/rankMovie.js"></script>
</body>
</html>