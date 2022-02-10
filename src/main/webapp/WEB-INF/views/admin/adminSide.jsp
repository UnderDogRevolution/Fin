<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<div class="adminSide">
		
		
		
		<div class="main-side" onclick ="location.href='${contextPath}/admin/main'">메인페이지</div>
		<div class="member-side" onclick ="location.href='${contextPath}/admin/member/list'">회원관리</div>
		<div class="en-side" onclick ="location.href='${contextPath}/admin/ask'">바라는 점</div>
		<div class="board-side" onclick ="location.href='${contextPath}/admin/post'">게시판관리</div>
		<div class="board-side" onclick ="location.href='${contextPath}/admin/reply'">댓글관리</div>
		<div class="report-side">신고내역확인</div>
		<!-- <div class="statistics-side">통계</div> -->
		<div class="logout-side"onclick ="location.href='${contextPath}/admin/logout'">로그아웃</div>
	
	</div>