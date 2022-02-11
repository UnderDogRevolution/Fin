<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인페이지</title>

<link rel="stylesheet" href="${contextPath}/resources/css/admin/admin-main.css">

</head>
<body>

	
<nav class="header">
    <div>
        관리자 페이지
    </div>
</nav>
<div class="mainController">
    <main>

        <div class=" adminBoardwraper">

          <jsp:include page="adminSide.jsp"/>

            <div class="adminBoard">
                <div>
                    <div onclick ="location.href='${contextPath}/admin/member/list'" class="memberNum">총회원 수 명
                            
                    </div>
                    <div></div>
                    <div onclick ="location.href='${contextPath}/admin/post'"  class="boardNum">
                        총 게시글 수<p>${postCount}</p>개
                    </div>
                </div>
                <div>
                    <div></div>
                    <div class="reportNum">총 신고수 100개</div>
                    <div></div>
                </div>
                <div>
                    <div onclick ="location.href='${contextPath}/admin/ask'" class="enNum">바라는 점 100개</div>
                    <div></div>
                    <div  onclick ="location.href='${contextPath}/admin/reply'" class="replyNum">총 댓글 100개</div>
                </div>
               

            	</div>
            </div>
        </main>
    </div>
</body>
</html>