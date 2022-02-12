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
<script type="text/javascript">
	const contextPath = "${contextPath}";

</script>
</head>
<body>

	
<jsp:include page="adminHeader.jsp" />
<div class="mainController">
    <main>
        <div class=" adminBoardwraper">

          <jsp:include page="adminSide.jsp"/>

            <div class="adminBoard">
                <div>
                    <div onclick ="location.href='${contextPath}/admin/member/list'" class="memberNum">총회원 수 <p class="count">${memberCount}</p> 명
                            
                    </div>
                    <div></div>
                    <div onclick ="location.href='${contextPath}/admin/post'"  class="boardNum">
                        총 게시글 수 <p class = "count">${postCount}</p> 개
                    </div>
                </div>
                <div>
                    <div></div>
                    <div class="reportNum">총 신고수 <p class = "count">${reportCount}</p> 개</div>
                    <div></div>
                </div>
                <div>
                    <div onclick ="location.href='${contextPath}/admin/ask'" class="enNum">바라는 점 <p class = "count">${askCount}</p> 개</div>
                    <div></div>
                    <div  onclick ="location.href='${contextPath}/admin/reply'" class="replyNum">총 댓글 <p class = "count">${replyCount}</p> 개</div>
                </div>
               

            	</div>
            </div>
        </main>
    </div>
    
    
    
    <script src="${contextPath}/resources/js/admin/adminPost.js"></script>
    
    <script type="text/javascript">
    
    setInterval(function(){
    	mainRefresh(); 
    	
    },5000);
    
    
    function mainRefresh() {
    		$(".count").html("");
    	$.ajax({

    		url: contextPath + "/admin/mainRefresh",
    		success: function(map) {
    				console.log(map);
    				$($(".count")[0]).html(map.memberCount);				
    				$($(".count")[1]).text(map.postCount);				
    				$($(".count")[2]).text(map.reportCount);				
    				$($(".count")[3]).text(map.askCount);				
    				$($(".count")[4]).text(map.replyCount);			
    				
    				
    				
    			}




    	});

    };

    


	
	
	</script>

    
    
    
    </script>
</body>
</html>