<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<html>
<head>
<meta charset="UTF-8">

<title>myboard</title>
<link rel="stylesheet" href="${contextPath}/resources/css/board/myboard.css">

</head>
<body>

	
   <main>
        <div class="container">
            <div class="profile">
                <div class="myinfo">
                    <div class="picture1">
                        <div class="picture2"></div>
                    </div>
                    <div class="introduce">
                        <div class="nickname">
                            <c:choose>
                            <c:when test="${loginMember.memberNo} == ${memberNo}">
                            	
                            	<span>${loginMember.memberName}</span>
                                <a href="${contextPath}/member/myPage">프로필변경</a>
                                 <img src="${contextPath}/resources/images/myBoard/png" data-bs-toggle="modal" data-bs-target="#followerList3">
                            </c:when>
                            <c:otherwise> 
                            	<span>${memberName}</span>                          
                            	<a>팔로우</a>
                            	<a>메세지 보내기</a>
                            </c:otherwise>
                        </c:choose>
                            

                           

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
                                <span>팔로우</span>

                                <span>111</span>
                            </div>



                        </div>
                    </div>
                </div>





            </div>
            <div id="board-list">
                <ul class="save">
                    <li class="active pre-board">게시글</li>
                    <li class="save-board">저장됨</li>

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


            <!-- $("#board-list ul li").on("click", function(){

                

            }); -->


            <!-- Modal -->

            <!-- follwerList 팔로워 목록 -->
            <div class="modal fade" id="followerList" tabindex="-1" aria-labelledby="followerListLabel"
                aria-hidden="true">
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
            <div class="modal fade" id="followerList2" tabindex="-1" aria-labelledby="followerList2Label"
                aria-hidden="true">
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


            <!-- 설정 모달 -->
            <div class="modal fade" id="followerList3" tabindex="-1" aria-labelledby="followerList3Label"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content sexyboy">

                        <div class="setting-modal-body">
                            <div class="setting-list-wrap">
                                <div class="setting-list-item">

                                    <div class="setting-update" >
                                        <a href="${contextPath}/member/updatePw">비밀번호 변경</a>
                                    </div>
                                    <div class="setting-update">
                                        <a href="${contextPath}/member/ask">바라는 점</a>
                                    </div>
                                    <div class="setting-update" data-bs-toggle="modal" data-bs-target="#followerList">
                                        팔로워
                                    </div>
                                    <div class="setting-update" data-bs-toggle="modal" data-bs-target="#followerList2">
                                        팔로우
                                    </div>
                                    <div class="setting-update">
                                        차단 관리
                                    </div>

                                    <div class="setting-update">
                                        로그 아웃
                                    </div>
                                   







                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>

    </main>
	
	
<script>
$(".save li").on("click", function(){
         
	
	
	
        $(".save li").removeClass("active");
        
        
        $(this).addClass("active");
        
        
        
        
});

$(".active").on("click", function(){
	
    $.ajax({

        url : contextPath + "board1/myBoard/{memberNo}",
        type : "get",
        data : {"postNo" : postNo},
    
        success : function(pList){
    
          
    
        },
    
        error : function(request, status, error){
              
          // 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
          if( request.status == 404 ){
            console.log("ajax 요청 주소가 올바르지 않습니다.");
    
          } else if( request.status == 500){
              console.log("서버 내부 에러 발생");
              console.log(request.responseText);
          }
       
        }
    
      });
	
	
	
	
});



</script>

</body>
</html>