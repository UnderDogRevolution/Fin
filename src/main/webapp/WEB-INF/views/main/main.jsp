<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>main</title>
<link rel="stylesheet" href="${contextPath}/resources/css/main/main.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/side.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/feed.css">
<link rel="stylesheet" href="${contextPath}/resources/css/main/crud-post.css">
	<style>
		#main-container{
			display: flex;
			justify-content: center;
			flex-direction: row;
			width: 100%;
			height: 96%;
			padding-top: 129px;
			align-items: flex-start;
		}
		/* margin-top을 주면 body가 주저 앉는다. 그래서 padding-top을 줘야 한다. */
	</style>
	
</head>
<body >
	<div id="main-container">
		<jsp:include page="feed.jsp"></jsp:include>
		<div style="flex-basis: 18%; flex-grow: 1; display: flex; flex-direction: column; align-items: flex-start; margin-right: 23%;">
			<jsp:include page="side.jsp"></jsp:include>
			<div style="font-weight: bold; margin-left: 9%; margin-top: 5%;">
				<span onclick="recentPost();" style="cursor: pointer;">최신</span><span> / </span ><span onclick="onlyFollowPost()" style="cursor: pointer;">팔로우</span>
			</div>
		</div>
	</div>
	
	<jsp:include page="crud-post.jsp"></jsp:include>
	
	<script src= "${contextPath}/resources/js/post/rankMovie.js"></script>
</body>
</html>