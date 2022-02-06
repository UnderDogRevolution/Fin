<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<<<<<<< HEAD
<link rel="stylesheet" href="${contextPath}/resources/css/search/search.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/feed.css">
=======
<link rel="stylesheet"
	href="${contextPath}/resources/css/search/search.css">
>>>>>>> e5c444e66e99b14ca76ccc964c39b93bbb1a6620
<title>search</title>
</head>
<body>

	<div class="mainContainer">
<<<<<<< HEAD
        <main class="mainwrap">
            <nav class="searchnav">
                <div id="feed_"><a href="">피드</a></div>
                <div id="mv_">영화</div>
                <div id="recent_">최신</div>
                <div id="peple_">인물</div>
            </nav>
            <div class="main-search">
                <div class="search-result">
                    <!-- 검색 결과 화면 -->
                    <!-- 영화 영역 -->
                     <div class="searchboard-mv">
                        <a href="">
                            <!-- 회원아이디 -->
                            <div class="mvuserName">
                                <div>
                                    <div class="userImg_">
                                        <img src="img/user.png" alt="">
                                    </div>
                                    <div class="userName_">
                                        유동훈
                                    </div>
                                </div>
                            </div>
                            <!-- 영화 제목 영화 개봉일 감독 -->
                            <div class="mvTitle">
                                <div>
                                    <div class="mvTitle_">
                                        가나다라마바사
            
                                    </div>
                                    <div class="mvCreate">
                                        2016년|유동훈감독
            
            
                                    </div>
                                </div>
                            </div>
            
                            <!-- 영화 줄거리 -->
                            <div class="mvContent">
                                <div>
                                    <div class="mvContent_">
                                        마틴 스콜세지의 21세기 최고작. 위대한 영화인들이 모여 기대를 제대로 충족한다
                                    </div>
                                    <div class="ContentStar">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                    </div>
                                </div>
            
                            </div>
                            <!-- 이미지 부분 -->
                            <div class="mvImgwrap">
                                <div class="imgput">
                                    <div class="img_">
                                        <img src="img/라라랜드.jpg" alt="">
            
            
                                    </div>
                                </div>
                            </div>
                            <!-- 댓글 좋아요 -->
                            <div class="reply-like">
                                <div>
                                    <div class="reply_"></div>
                                    <div class="like_"></div>
                                    <div class="none"></div>
                                    <div class="what"></div>
                                </div>
                            </div>
                            
                            
                            
                            
                        </a>
                     </div>
                   
                    
                </div>
            </div>
        </main>
    </div>
=======
		<main class="mainwrap">
			<nav class="searchnav">
				<div id="feed_">
					<a href="">피드</a>
				</div>
				<div id="mv_">영화</div>
				<div id="recent_">최신</div>
				<div id="peple_">인물</div>
			</nav>
			<div class="container-post">
				<div class="search-result">
					<!-- 검색 결과 화면 -->
					<!-- 영화 영역 -->
					<div class="post">
						<!-- 회원아이디 -->
						<div class="post-header">
							<div>
								<div class="userImg_">
									<img src="../resources/images/member/20220204214408_22069.jpg"
										alt="">
								</div>
								<div class="userName_">유동훈</div>
								<div class="headerbeen"></div>
								<div class=create>2022-02-06</div>
								<div class="drop">
									<div class="dropdown me-1 header-dropdown">
										<img id="dropdownMenuOffset" data-bs-toggle="dropdown"
											aria-expanded="false" data-bs-offset="-40,-10"
											src="${contextPath}/resources/images/temp/dots.png">
										<ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
											<li><a class="dropdown-item">링크복사</a></li>
											<c:if test="${loginMember != null}">
												<li><a class="dropdown-item">신고하기</a></li>
											</c:if>
											<c:if test="${loginMember.memberNo == post.memberNo}">
												<li><a class="dropdown-item" onclick="deletePost(this)">삭제</a></li>
											</c:if>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<!-- 영화 제목 영화 개봉일 감독 -->
						<div class="mvTitle">
							<div class="mvTitle_">
								가나다라마바사dk <span>(개봉날짜)장르</span>
							</div>
						</div>

						<div class="post-rating">
							<i class="fa fa-star rating-star" aria-hidden="true"
								style="color: yellow"></i> <span>1</span>
						</div>
						<!-- 영화 줄거리 -->
						<div class="mvContent">
							<div>
								<div class="textarea-box">아아아아아</div>
							</div>

						</div>
						<!-- 이미지 부분 -->
						<div class="mvImgwrap">
							<div class="imgput">
								<div class="img_">
									<img src="" alt="">


								</div>
							</div>
						</div>
						<!-- 댓글 좋아요 -->
						<div class="reply-like">
							<div>
								<div class="reply_"></div>
								<div class="like_"></div>
								<div class="none"></div>
								<div class="what"></div>
							</div>
						</div>




					</div>


				</div>
			</div>


		</main>
	</div>


	<script type="text/javascript">
		const search = "${search}";
		const memberNo = "${loginMember.memberNo}";
		const memberNickName = "${loginMember.memberNickName}";
		const memberName = "${loginMember.memberName}";
		const contextPath = "${contextPath}";
		const myImgPath = "${contextPath}${loginMember.profileImage.imgPath}${loginMember.profileImage.imgName}";
	</script>
>>>>>>> e5c444e66e99b14ca76ccc964c39b93bbb1a6620
	<jsp:include page="../main/crud-post.jsp"></jsp:include>
	
	<script src="${contextPath}/resources/js/search/search.js"></script>
	
	
	
</body>
</html>