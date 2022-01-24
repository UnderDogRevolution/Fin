<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- contextPath 설정 (헤더에도 설정해놓기) --%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Montage</title>

<!-- BootStrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet" href="${contextPath}/resources/css/member/memberPage.css">

</head>
<body>


	<div class="startPage">

	    <nav class="a-nav-menu">
	      <div class="a-main-logo" onclick='location.href="startPage.html"'>
	        Montage
	      </div>
	    </nav>
	    
	    <!-- 메인 소개 문구 -->
	    <div class="startPage-content">
	
	      <!-- user-select:none 텍스트 선택 막기 -->
	      <span class="welcome-msg">
	        감상평을 기록하고 <br>
	        친구와 소통하세요
	      </span>
	
	      <button id="start-btn" class="a-btn" onclick="location.href='member/login'">시작하기</button>
	
	    </div>

  	</div>



<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!-- BootStrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- sweetalert2 JS -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<!-- backstretch -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-backstretch/2.1.18/jquery.backstretch.min.js" integrity="sha512-bXc1hnpHIf7iKIkKlTX4x0A0zwTiD/FjGTy7rxUERPZIkHgznXrN/2qipZuKp/M3MIcVIdjF4siFugoIc2fL0A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<!-- 배경 슬라이드 변경 스크립트 -->
<!-- 만약 실제 배포하는 경우 이미지는 저작권 없는걸로 교체해야함 -->
<script>
  $.backstretch([
    "https://www.themoviedb.org/t/p/original/cI1RBfqXbWaITTjcKGYLhd9F083.jpg",
    "https://www.themoviedb.org/t/p/original/k0Cuybu9ECuc47ODlHcIP8TJCZi.jpg",
    "https://www.themoviedb.org/t/p/original/wA2t7nsO10swf2Snpd6XM5a6yLR.jpg" ], 
    {duration: 5000, fade: 750}
  );

  $(window).on('load', function () { $("#load").hide(); });
</script>

</body>
</html>