<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>search</title>
<link rel="stylesheet" href="${contextPath}/resources/css/search/search.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/feed.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/crud-post.css">
</head>
<body>

	<div class="mainContainer">
        <main class="mainwrap">
            <nav class="searchnav">
                <div id="recent_" onclick="searchKey('searchPost')">최신</div>
                <div id="popular_" onclick="searchKey('popularPost')">인기</div>
                <div id="mv_" onclick="searchKey('searchMovie')">영화</div>
                <div id="peple_">인물</div>
            </nav>
            <div class="main-search">
                <!-- <div class="search-result">
                </div> -->
            </div>
        </main>
    </div>
    <div id="container-post" >
    </div>
	<jsp:include page="../main/crud-post.jsp"></jsp:include>
    <script>
		const contextPath = "${contextPath}";
		<c:if test="${loginMember.memberNo != null}">
			const memberNo = ${loginMember.memberNo }
		</c:if>
	</script>
	<script src= "${contextPath}/resources/js/search/search.js"></script>
	<script src= "${contextPath}/resources/js/search/search2.js"></script>
</body>
</html>