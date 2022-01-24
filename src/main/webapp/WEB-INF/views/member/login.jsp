<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link rel="stylesheet" href="${contextPath}/resources/css/member/memberPage.css">

</head>
<body>

  <div class="a-jun-page">

    <!-- 메인으로 갈 수 있도록 로고 있는 내비게이션바 만들기 -->
    <nav class="a-nav-menu">
      <a class="a-main-logo" href="${contextPath}">Montage</a>
    </nav>
    
    <!-- 배경 이미지 -->
    <div src="${contextPath}/resources/images/common/background/loginBackground.jpg" class="loginBackground">
  
      <!-- 로그인 창 -->
      <main class="a-input-area a-login-area">
  
        <div style="font-size: 30px; font-weight: bold; margin: 20px 0;">
          로그인
        </div>
  
        <div class="a-login-form-area">
          <!-- 로그인 폼 -->
          <form action="login" id="login-form" method="post">
            
            <div>

              <!-- 이메일 입력 영역 -->
              
              <svg width="20" height="20" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M6.99992 6.99998C8.28908 6.99998 9.33325 5.95581 9.33325 4.66665C9.33325 3.37748 8.28908 2.33331 6.99992 2.33331C5.71075 2.33331 4.66658 3.37748 4.66658 4.66665C4.66658 5.95581 5.71075 6.99998 6.99992 6.99998ZM6.99992 8.16665C5.44242 8.16665 2.33325 8.94831 2.33325 10.5V11.6666H11.6666V10.5C11.6666 8.94831 8.55742 8.16665 6.99992 8.16665Z" fill="#787878"/>
                </svg>
                  
              <input type="email" id="memberEmail" name="memberEmail" placeholder="이메일을 입력해주세요." autocomplete="off" autofocus>

              <!-- 이메일 검사 아이콘 영역 -->
              <div class="checkInput"></div>
  
            </div>
            
            <div>

              <!-- 비밀번호 입력 영역 -->
              <svg width="20" height="20" viewBox="0 0 14 14" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M6.99992 9.91665C7.64158 9.91665 8.16658 9.39165 8.16658 8.74998C8.16658 8.10831 7.64158 7.58331 6.99992 7.58331C6.35825 7.58331 5.83325 8.10831 5.83325 8.74998C5.83325 9.39165 6.35825 9.91665 6.99992 9.91665ZM10.4999 4.66665H9.91658V3.49998C9.91658 1.88998 8.60992 0.583313 6.99992 0.583313C5.38992 0.583313 4.08325 1.88998 4.08325 3.49998H5.19158C5.19158 2.50248 6.00242 1.69165 6.99992 1.69165C7.99742 1.69165 8.80825 2.50248 8.80825 3.49998V4.66665H3.49992C2.85825 4.66665 2.33325 5.19165 2.33325 5.83331V11.6666C2.33325 12.3083 2.85825 12.8333 3.49992 12.8333H10.4999C11.1416 12.8333 11.6666 12.3083 11.6666 11.6666V5.83331C11.6666 5.19165 11.1416 4.66665 10.4999 4.66665ZM10.4999 11.6666H3.49992V5.83331H10.4999V11.6666Z" fill="#787878"/>
                </svg>
              <input type="password" id="memberPw" name="memberPw" placeholder="비밀번호를 입력해주세요.">

              <!-- 비밀번호 검사 아이콘 영역 -->
              <div class="checkInput"></div>
  
            </div>

            <section style="display: flex; align-items: center; justify-content: space-between; height: 30px;">

              <section class="save-chk">
                <input type="checkbox" id="saveId" name="saveId" style="display: none;"> 
                <label for="saveId" class="save-icon"></label>
                <label for="saveId">아이디저장</label>
              </section>

              <section class="login-fail">
                <span></span>
              </section>

            </section>
            
  
            <button id="login-btn" class="a-btn" disabled>로그인</button>
  
          </form>
  
        </div>
  
        <div class="a-login-footer">
          <span onclick="location.href='signUp.html'">회원가입</span>
          <span onclick="location.href='changePw.html'">비밀번호 찾기</span>
        </div>
  
      </main>
  
    </div>

  </div>





<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/member/login.js"></script>

</body>
</html>