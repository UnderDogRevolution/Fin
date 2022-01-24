<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>myboard</title>
<link rel="stylesheet" href="${contextPath}/resources/css/board/myboard.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	
  <main>
        <div class="container">
            <div class="profile">
                <div class="myinfo">
                    <div class="picture1">
                        <div class="picture2"></div>
                    </div>
                    <div class="introduce">
                        <div class="nickname">
                            <span>user01</span>
                            <a href="#self">프로필변경</a>
                        </div>
                        <div class="boardCount">

                            <div class="Count">
                                <span>게시글</span>

                                <span>111</span>

                            </div>
                            <div class="Count" data-bs-toggle="modal" data-bs-target="#followerList">
                                <span>팔로워</span>

                                <span>111</span>
                            </div>
                            <div class="Count" data-bs-toggle="modal" data-bs-target="#followerList2">
                                <span>팔로잉</span>

                                <span>111</span>
                            </div>

                        </div>
                    </div>
                </div>





            </div>
            <div id="board-list">
                <ul class="save">
                    <li class="active">게시글</li>
                    <li>저장됨</li>

                </ul>
                <div class="board-show">
                    <div class="show"></div>
                    <div class="show"></div>
                    <div class="show"></div>
    
                    <div class="show"></div>
                    <div class="show"></div>
                    <div class="show"></div>
                    <div class="show"></div>
                    <div class="show"></div>
                    <div class="show"></div>
                </div>
            </div>



            

    <!-- Modal -->

        <!-- follwerList 팔로워 목록 -->
        <div class="modal fade" id="followerList" tabindex="-1" aria-labelledby="followerListLabel" aria-hidden="true">
            <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="followerListLabel">팔로워 목록</h5>
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


    <!-- Modal -->

        <!-- follwerList 팔로워 목록 -->
        <div class="modal fade" id="followerList2" tabindex="-1" aria-labelledby="followerList2Label" aria-hidden="true">
            <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="followerListLabel">팔로우 목록</h5>
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
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
                            </div>
                        </div>
                        <div class="list-item">
                            <div class="img"></div>
                            <div class="info">
                                <span>user01</span>
                                <span>이상원</span>
                            </div>
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
                            </div>
                        </div>
                        <div class="list-item">
                            <div class="img"></div>
                            <div class="info">
                                <span>user01</span>
                                <span>이상원</span>
                            </div>
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
                            </div>
                        </div>
                        <div class="list-item">
                            <div class="img"></div>
                            <div class="info">
                                <span>user01</span>
                                <span>이상원</span>
                            </div>
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
                            </div>
                        </div>
                        <div class="list-item">
                            <div class="img"></div>
                            <div class="info">
                                <span>user01</span>
                                <span>이상원</span>
                            </div>
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
                            </div>
                        </div>
                        <div class="list-item">
                            <div class="img"></div>
                            <div class="info">
                                <span>user01</span>
                                <span>이상원</span>
                            </div>
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
                            </div>
                        </div>
                        <div class="list-item">
                            <div class="img"></div>
                            <div class="info">
                                <span>user01</span>
                                <span>이상원</span>
                            </div>
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
                            </div>
                        </div>
                        <div class="list-item">
                            <div class="img"></div>
                            <div class="info">
                                <span>user01</span>
                                <span>이상원</span>
                            </div>
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
                            </div>
                        </div>
                        <div class="list-item">
                            <div class="img"></div>
                            <div class="info">
                                <span>user01</span>
                                <span>이상원</span>
                            </div>
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
                            </div>
                        </div>
                        <div class="list-item">
                            <div class="img"></div>
                            <div class="info">
                                <span>user01</span>
                                <span>이상원</span>
                            </div>
                            <div class="del-button-wrap">
                                <a href="#self">팔로우 취소</a>
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
        <!-- follwerList 팔로잉 목록:e -->


    </main>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>