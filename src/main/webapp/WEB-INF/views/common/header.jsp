<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	  
	  <link rel="stylesheet" href="${contextPath}/resources/css/common/header.css">
	   <script src="https://kit.fontawesome.com/2622b235cb.js" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar">
		<div class="header">

			<div class="logo">
				<a href="${contextPath}/main">Montage</a>

			</div>
			<div></div>
			<div>

				<ul class="menu">
					<li>
						<form action="${contextPath}/search/" method="get">

							<div class="search">

								<div class="searchwrap">

									<input type="text" name = "searchResult" id = "searchResult">

									<div>

											<button>
											<svg class="bi d-block" xmlns="http://www.w3.org/2000/svg"
												viewBox="0 0 24 24">
                                                <path
													d="M23.809 21.646l-6.205-6.205c1.167-1.605 1.857-3.579 1.857-5.711 0-5.365-4.365-9.73-9.731-9.73-5.365 0-9.73 4.365-9.73 9.73 0 5.366 4.365 9.73 9.73 9.73 2.034 0 3.923-.627 5.487-1.698l6.238 6.238 2.354-2.354zm-20.955-11.916c0-3.792 3.085-6.877 6.877-6.877s6.877 3.085 6.877 6.877-3.085 6.877-6.877 6.877c-3.793 0-6.877-3.085-6.877-6.877z margin-top: 5px;" />
                                            </svg>
											</button>
										
									</div>
								</div>
						</form>

					</li>
					<li><a href="${contextPath}"> <i class="fas fa-home"
							style="padding-top: 5px;"></i></a></li>
					<li><i class="fas fa-bell noticewrap"
						style="padding-top: 5px;">
							<div class="notice-num"></div>

							<div class="notify-wrap">
                            <div class="notice_box">
                                <!-- 알림영역 -->
                                <div class="noticeList frends-request" data-bs-toggle="modal" data-bs-target="#followerList5">
                                    <div class="img-profile"></div>
                                    <div class="fol-request">
                                        <span>팔로우 요청</span> 
                                        <span>sangwon 외 32명</span>
                                    </div>
                                
                                    
                                   
                                </div>
                                <div class="noticeList">
                                    <div class="img-profile"></div>
                                    
                                    <div class="reply-comment-wrap">
                                        <span>이상원님이 댓글을 남기셨습니다.ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇ</span>
                                    </div>
                                    
                                </div>
                                <div class="noticeList">
                                    <div class="img-profile"></div>
                                    <div>
                                        <span>이상원님이 댓글을 남기셨습니다.</span>
                                    </div>
                                    
                                </div>
                                <div class="noticeList">
                                    <div class="img-profile"></div>
                                    <div>
                                        <span>이상원님이 댓글을 남기셨습니다.</span>
                                    </div>
                                    
                                </div>
                                <div class="noticeList">
                                    <div class="img-profile"></div>
                                    <div>
                                        <span>이상원님이 댓글을 남기셨습니다.</span>
                                    </div>
                                    
                                </div>
                                <div class="noticeList">
                                    <div class="img-profile"></div>
                                    <div>
                                        <span>이상원님이 댓글을 남기셨습니다.</span>
                                    </div>
                                    
                                </div>
                                <div class="noticeList">
                                    <div class="img-profile"></div>
                                    <div>
                                        <span>이상원님이 댓글을 남기셨습니다.</span>
                                    </div>
                                    
                                </div>
                                <div class="noticeList">
                                    <div class="img-profile"></div>
                                    <div>
                                        <span>이상원님이 댓글을 남기셨습니다.</span>
                                    </div>
                                    
                                </div>
                                






                            </div>
                            </div>
					</i></li>
					<li><a href="${contextPath}/chat/myChat"><i class="far fa-comment-dots"
							style="padding-top: 5px;"></i></a></li>



					<li><i class="far fa-edit boardwrap" style="padding-top: 5px;">
							<div class="boardMenu">

								<div data-bs-toggle="modal" data-bs-target="#postModal" onclick="Write()">
									<a href="" onclick="return false;" > 피드 </a>
								</div>
								<div data-bs-toggle="modal" data-bs-target="#postModal" onclick="Review()">
									<a href="" onclick="return false;" > 리뷰 </a>
								</div>

							</div>




					</i></li>



					<li><i class="namewrap"> <img class="myImg"
							src="${contextPath}${loginMember.profileImage.imgPath}${loginMember.profileImage.imgName}" alt="">
							<div class="myclick">
								<!-- 내영역 -->
								<ul>

									<li><a href="">
											<div class="myclick-li">프로필</div>
									</a></li>
									<li><a href="">
											<div class="myclick-li">저장</div>
									</a></li>
									<li><a href="${contextPath}/member/myPage">
											<div class="myclick-li">설정</div>
									</a></li>
									<li><a href="${contextPath}/member/logout">
											<div class="myclick-li">로그아웃</div>
									</a></li>

								</ul>
							</div>
					</i></li>

				</ul>
			</div>


		</div>

	</nav>
	
	 <!--  팔로우 요청 목록 -->
     <div class="modal fade" id="followerList5" tabindex="-1" aria-labelledby="followerListLabel"
     aria-hidden="true">
     <div class="modal-dialog">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title" id="followerListLabel">팔로워 요청</h5>
                 <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
             </div>
             <div class="modal-body">
                 <div class="list-wrap">
                     <div class="list-item">
                         <div class="img"></div>
                         <div class="info">
                             <span>user01</span>
                             <span>이상원</span>
                         </div>
                         <div class="del-button-wrap" style="margin-right: 5px;">
                             <a href="#self">확인</a>
                         </div>
                         <div class="del-button-wrap">
                             <a href="#self">삭제</a>
                         </div>
                     </div>
                     <div class="list-item">
                         <div class="img"></div>
                         <div class="info">
                             <span>user01</span>
                             <span>이상원</span>
                         </div>
                         <div class="del-button-wrap" style="margin-right: 5px;">
                             <a href="#self">확인</a>
                         </div>
                         <div class="del-button-wrap">
                             <a href="#self">삭제</a>
                         </div>
                     </div>
                     <div class="list-item">
                        <div class="img"></div>
                        <div class="info">
                            <span>user01</span>
                            <span>이상원</span>
                        </div>
                        <div class="del-button-wrap" style="margin-right: 5px;">
                            <a href="#self">확인</a>
                        </div>
                        <div class="del-button-wrap">
                            <a href="#self">삭제</a>
                        </div>
                    </div>
                     <div class="list-item">
                        <div class="img"></div>
                        <div class="info">
                            <span>user01</span>
                            <span>이상원</span>
                        </div>
                        <div class="del-button-wrap" style="margin-right: 5px;">
                            <a href="#self">확인</a>
                        </div>
                        <div class="del-button-wrap">
                            <a href="#self">삭제</a>
                        </div>
                    </div>
                     <div class="list-item">
                        <div class="img"></div>
                        <div class="info">
                            <span>user01</span>
                            <span>이상원</span>
                        </div>
                        <div class="del-button-wrap" style="margin-right: 5px;">
                            <a href="#self">확인</a>
                        </div>
                        <div class="del-button-wrap">
                            <a href="#self">삭제</a>
                        </div>
                    </div>
                     <div class="list-item">
                        <div class="img"></div>
                        <div class="info">
                            <span>user01</span>
                            <span>이상원</span>
                        </div>
                        <div class="del-button-wrap" style="margin-right: 5px;">
                            <a href="#self">확인</a>
                        </div>
                        <div class="del-button-wrap">
                            <a href="#self">삭제</a>
                        </div>
                    </div>
                     <div class="list-item">
                        <div class="img"></div>
                        <div class="info">
                            <span>user01</span>
                            <span>이상원</span>
                        </div>
                        <div class="del-button-wrap" style="margin-right: 5px;">
                            <a href="#self">확인</a>
                        </div>
                        <div class="del-button-wrap">
                            <a href="#self">삭제</a>
                        </div>
                    </div>
                     <div class="list-item">
                        <div class="img"></div>
                        <div class="info">
                            <span>user01</span>
                            <span>이상원</span>
                        </div>
                        <div class="del-button-wrap" style="margin-right: 5px;">
                            <a href="#self">확인</a>
                        </div>
                        <div class="del-button-wrap">
                            <a href="#self">삭제</a>
                        </div>
                    </div>
                     
                     
                 </div>
             </div>
             <div class="modal-footer">
                 <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>

             </div>
         </div>
     </div>
 </div>
 <!-- follwerList 팔로워 목록:e -->

	<jsp:include page="footer.jsp"></jsp:include>

