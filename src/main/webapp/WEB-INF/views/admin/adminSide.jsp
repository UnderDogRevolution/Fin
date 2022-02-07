<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<div class="adminSide">
		<div class="member-side" onclick ="location.href='${contextPath}/admin/member'">회원관리</div>
		<div class="en-side">바라는점</div>
		<div class="board-side">게시판관리</div>
		<div class="report-side">신고내역확인</div>
		<div class="statistics-side">통계</div>
		<div class="logout-side"onclick ="location.href='${contextPath}/admin/logout'">로그아웃</div>
	
	</div>