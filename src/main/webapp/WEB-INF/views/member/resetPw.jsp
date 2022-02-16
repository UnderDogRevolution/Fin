<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- contextPath 설정 (헤더에도 설정해놓기) --%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>

<!-- BootStrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet" href="${contextPath}/resources/css/member/memberPage.css">
<link rel="stylesheet"
href="${contextPath}/resources/css/main/crud-post.css">
</head>
<body>

  <div class="a-jun-page">

    <!-- 메인으로 갈 수 있도록 로고 있는 내비게이션바 만들기 -->
    <nav class="a-nav-menu">
      <div class="a-main-logo" onclick='location.href="${contextPath}"'>
        <img class="a-logo-img" src="${contextPath}/resources/images/common/Montage-logo.png">
      </div>
    </nav>
    
    <!-- 배경 이미지 -->
    <div class="resetPwBackground" style="height: 100vh; background-color: #272727;">
  
      <!-- 비밀번호 찾기 창 -->
      <main class="a-input-area a-changePw-area">
  
        <div style="font-size: 30px; font-weight: bold; margin: 20px 0;">
          새 비밀번호 설정
        </div>
  
        <div class="a-changePw-form-area">

          <form action="resetPw?djsejehr=${encEmail}" id="changePw-form" method="post">
            
            <div>

              <!-- 비밀번호 입력 영역 -->
              <svg width="20" height="20" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M6.99992 9.91665C7.64158 9.91665 8.16658 9.39165 8.16658 8.74998C8.16658 8.10831 7.64158 7.58331 6.99992 7.58331C6.35825 7.58331 5.83325 8.10831 5.83325 8.74998C5.83325 9.39165 6.35825 9.91665 6.99992 9.91665ZM10.4999 4.66665H9.91658V3.49998C9.91658 1.88998 8.60992 0.583313 6.99992 0.583313C5.38992 0.583313 4.08325 1.88998 4.08325 3.49998H5.19158C5.19158 2.50248 6.00242 1.69165 6.99992 1.69165C7.99742 1.69165 8.80825 2.50248 8.80825 3.49998V4.66665H3.49992C2.85825 4.66665 2.33325 5.19165 2.33325 5.83331V11.6666C2.33325 12.3083 2.85825 12.8333 3.49992 12.8333H10.4999C11.1416 12.8333 11.6666 12.3083 11.6666 11.6666V5.83331C11.6666 5.19165 11.1416 4.66665 10.4999 4.66665ZM10.4999 11.6666H3.49992V5.83331H10.4999V11.6666Z" fill="#787878"/>
                </svg>
              <input type="password" id="memberPw" name="memberPw" class="a-input" placeholder="새로운 비밀번호를 입력해주세요.">

              <!-- 비밀번호 검사 아이콘 영역 -->
              <div class="checkInput"></div>
  
            </div>


            <!-- 가입하지 않은 아이디일 경우 경고 메시지 출력하기 -->
            <div class="findPw-notice">
              <span></span>
            </div>
            
            <div class="a-changePw-notice">
				영문,숫자,특수문자 6~20 글자로 <br><br> 
				새로운 비밀번호를 설정해주세요.  
            </div>

            <button id="resetPw-btn" class="a-btn" disabled>확인</button>
  
          </form>
  
        </div>
  
      </main>
  
    </div>

  </div>



<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!-- BootStrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- sweetalert2 JS -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script src="${contextPath}/resources/js/member/findPw.js"></script>

<%-- request에 message 속성이 존재하는 경우 alert창으로 해당 내용을 출력 --%>
<c:if test="${ !empty requestScope.message }">
	<script>
		$(function(){ // ready() 함수로 페이지 로딩 완료 후 alert 출력
			alert("${message}");
		})
			// EL 작성 시 scope를 지정하지 않으면
			// page -> request -> session -> application 순서로 검색하여
			// 일치하는 속성이 있으면 출력
	</script>
</c:if>

<%-- request scope에 "title"이라는 키값이 존재하는 경우 --%>
<c:if test="${!empty requestScope.title}">
	<script>
	swal.fire({
    title : "${title}",
			html  : "${text}",
			icon  : "${icon}",
      showConfirmButton: true,
      confirmButtonText: '확인',
      confirmButtonColor: '#F05454'
		})
	</script>
</c:if>
<script>
	const memberNo = loginMemberNo;
	const contextPath = "${contextPath}"
</script>
<jsp:include page="../main/crud-post.jsp"></jsp:include>
</body>
</html>