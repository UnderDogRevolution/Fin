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
    <jsp:include page="feed.jsp"></jsp:include>
	
	<jsp:include page="side.jsp"></jsp:include>
	<jsp:include page="crud-post.jsp"></jsp:include>
	
	
	<script src= "${contextPath}/resources/js/post/rankMovie.js"></script>
</body>
</html>