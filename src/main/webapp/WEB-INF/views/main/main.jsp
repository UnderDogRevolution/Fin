<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>main</title>
<link rel="stylesheet" href="${contextPath}/resources/css/main/main.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/side.css">
</head>
<body>
	     <div class="mainContainer">
        <main class="mainwrap">
            <div class="mainboard">
                <div class="main-result">
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
                                        마틴 스콜세지의 21세기 최고작. 위대한 영화인들이 모여 기대를 제대로 충족한다
                                        마틴 스콜세지의 21세기 최고작. 위대한 영화인들이 모여 기대를 제대로 충족한다
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

	
	<jsp:include page="side.jsp"></jsp:include>
	
</body>
</html>