<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- contextPath 설정 (헤더에도 설정해놓기) --%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시 메인페이지</title>
</head>
<body>


<a href="${contextPath}/member/login"> 로그인 화면 </a>


<br><br><br><br>
<%-- a태그 만들어서 각자 만든 컨트롤러랑 연결하고 테스트 해보세요!! --%>

<a href="#"> 이름 바꿔서 컨트롤러랑 연결해서 테스트해보세요! </a>




</body>
</html>