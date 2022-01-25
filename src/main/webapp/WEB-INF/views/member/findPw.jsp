<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- contextPath 설정 (헤더에도 설정해놓기) --%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<!-- BootStrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet" href="${contextPath}/resources/css/member/memberPage.css">

</head>
<body>

  <div class="a-jun-page">

    <!-- 메인으로 갈 수 있도록 로고 있는 내비게이션바 만들기 -->
    <nav class="a-nav-menu">
      <div class="a-main-logo" onclick='location.href="${contextPath}"'>
        Montage
      </div>
    </nav>
    
    <!-- 배경 이미지 -->
    <div src="${contextPath}/resources/images/backgrounds/changePwBackground.jpg" class="changePwBackground">
  
      <!-- 비밀번호 찾기 창 -->
      <main class="a-input-area a-changePw-area">
  
        <div style="font-size: 30px; font-weight: bold; margin: 20px 0;">
          비밀번호 찾기
        </div>
  
        <div class="a-changePw-form-area">

          <form action="changePw" id="changePw-form" method="post">
            
            <div>

              <!-- 이메일 입력 영역 -->
              
              <svg width="20" height="20" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M6.99992 6.99998C8.28908 6.99998 9.33325 5.95581 9.33325 4.66665C9.33325 3.37748 8.28908 2.33331 6.99992 2.33331C5.71075 2.33331 4.66658 3.37748 4.66658 4.66665C4.66658 5.95581 5.71075 6.99998 6.99992 6.99998ZM6.99992 8.16665C5.44242 8.16665 2.33325 8.94831 2.33325 10.5V11.6666H11.6666V10.5C11.6666 8.94831 8.55742 8.16665 6.99992 8.16665Z" fill="#787878"/>
                </svg>
                  
              <input type="email" id="memberEmail" name="memberEmail" class="a-input" placeholder="이메일을 입력해주세요." autocomplete="off" autofocus>

              <!-- 이메일 검사 아이콘 영역 -->
              <div class="checkInput"></div>
  
            </div>


            <!-- 가입하지 않은 아이디일 경우 경고 메시지 출력하기 -->
            <div class="findPw-notice">
              <span></span>
            </div>
            
            <div class="a-changePw-notice">
              <!-- 느낌표 아이콘 -->
              <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 24 24"><path d="M12 2c5.514 0 10 4.486 10 10s-4.486 10-10 10-10-4.486-10-10 4.486-10 10-10zm0-2c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1.31 7.526c-.099-.807.528-1.526 1.348-1.526.771 0 1.377.676 1.28 1.451l-.757 6.053c-.035.283-.276.496-.561.496s-.526-.213-.562-.496l-.748-5.978zm1.31 10.724c-.69 0-1.25-.56-1.25-1.25s.56-1.25 1.25-1.25 1.25.56 1.25 1.25-.56 1.25-1.25 1.25z" fill="#FDFDFD"/></svg>
              기존에 가입하신 이메일을 입력해주세요. <br><br>
              이메일로 비밀번호 변경 링크를 발송해드립니다.
  
            </div>

            <button id="findPw-btn" class="a-btn" disabled>확인</button>
  
          </form>
  
        </div>
  
        <div class="a-login-footer">
          <span onclick="location.href='login'">로그인</span>
          <span onclick="location.href='signUp'">회원가입</span>
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

</body>
</html>