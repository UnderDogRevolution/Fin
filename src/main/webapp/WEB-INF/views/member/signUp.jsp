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
    <div src="${contextPath}/resources/images/backgrounds/signUpBackground.jpg" class="signUpBackground">
  
      <!-- 회원가입 창 -->
      <main class="a-input-area a-signUp-area">
  
        <div style="font-size: 30px; font-weight: bold; margin: 20px 0;">
          회원가입
        </div>
  
        <div class="a-signUp-form-area">
          <!-- 회원가입 폼 -->
          <form action="signUp" id="signUp-form" method="post">
            
            <ul style="list-style: none; margin: 10px 0; padding: 0; width: 350px; background-color: #FDFDFD; border-radius: 10px; padding: 10px;">

              <!-- 이메일 + 이메일 인증 -->
              <li>

                <div>
                  <input type="email" class="jun" id="memberEmail" name="memberEmail" class="a-input" placeholder="이메일 (example@gmail.com)" autocomplete="off" autofocus>

                  <!-- 이메일 유효성 결과 -->
                  <div class="checkInput"></div>
                </div>

                <div>

                  <div style="margin-top: 10px; width: 285px; display: flex; align-items: center; justify-content: space-between;">

                    <button class="a-btn" id="emailCheck-btn" onclick=sendEmail(); type="button" style="width:100%" disabled>
                      이메일 인증
                    </button>

                    <!-- <div id="emailCheck-btn" onclick=emailCheckPage();>이메일 인증</div>

                    <div style="display: flex; width: 170px; justify-content: space-around; align-items: center;">

                      <input type="text" id="emailCheck-code" name="emailCheck-code" placeholder="번호 입력" maxlength="6" autocomplete="off">
  
                      <div class="checkEmailTime">
                        <span>00:00</span>
                      </div>

                    </div> -->

                    <!-- 이메일 인증 결과 -->
                    <div class="checkInput"></div>

                  </div>

                </div>

              </li>
              
              <!-- 비밀번호 -->
              <li>
                <div>
                  <input type="password" class="jun" id="memberPw" name="memberPw" class="a-input" placeholder="비밀번호 (문자,숫자,특수 6 ~ 20 글자)">

                  <!-- 비밀번호 유효성 결과 -->
                  <div class="checkInput"></div>
                </div>
              </li>
              
              <!-- 비밀번호 확인 -->
              <li>
                <div>
                  <input type="password" class="jun" id="memberPw2" name="memberPw2" class="a-input" placeholder="비밀번호 확인">

                  <!-- 비밀번호 확인 유효성 결과 -->
                  <div class="checkInput"></div>
                </div>
              </li>
              
              <!-- 닉네임 -->
              <li>
                <div>
                  <input type="text" class="jun" id="memberNickName" name="memberNickName" class="a-input" placeholder="닉네임 (한글, 영어, 숫자 2 ~ 20 글자)" autocomplete="off" maxlength="20">

                  <!-- 닉네임 유효성(중복) 결과 -->
                  <div class="checkInput"></div>
                </div>
              </li>
              
              <!-- 이름 -->
              <li>
                <div> 
                  <input type="text" class="jun" id="memberName" name="memberName" class="a-input" placeholder="이름 (한글, 영어 2 ~ 20 글자)" autocomplete="off" maxlength="20">

                  <!-- 이름 유효성 결과 -->
                  <div class="checkInput"></div>
                </div>
              </li>


              <!-- 약관 영역 -->
              <li class="termsArea">

                <div style="width: 285px;">
                  <div>

                    <input type="checkbox" id="terms1" style="display: none;">
                    
                    <label for="terms1" class="save-icon" style="border: 1px solid black;"></label>
                    <div>
                      <u style="cursor: pointer;" data-bs-toggle="modal" data-bs-target="#a-modal1">
                        개인정보 처리 약관
                      </u>
                      에 동의합니다.
                      <strong style="font-weight: 600; color: #ff6c6c;">(필수)</strong>
                    </div>
  
                  </div>
  
                  <div>

                    <input type="checkbox" id="terms2" style="display: none;">
                    
                    <label for="terms2" class="save-icon" style="border: 1px solid black;"></label>
                    <div>
                      <u style="cursor: pointer;" data-bs-toggle="modal" data-bs-target="#a-modal2">
                        사이트 이용 약관
                      </u>
                      에 동의합니다.
                      <strong style="font-weight: 600; color: #ff6c6c;">(필수)</strong>
                    </div>
  
                  </div>
                
                </div>
              </li>

            </ul>
  
            <button id="signUp-btn" class="a-btn" disabled>회원가입</button>
  
          </form>
  
        </div>
  
        <div class="a-login-footer">
          <span onclick="location.href='login'">로그인</span>
          <span onclick="location.href='findPw'">비밀번호 찾기</span>
        </div>
  
      </main>
  
    </div>

  </div>


  <!-- 약관 1 -->
  <div class="modal fade a-modal" id="a-modal1" tabindex="-1" aria-labelledby="a-modal1-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered">
      <div class="modal-content">

        <div class="modal-header">
          <h5 class="modal-title" id="a-modal1-label">개인정보 처리 약관</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>

        <div class="modal-body">
          <div id="a-terms-area1">
          </div>
        </div>

      </div>
    </div>
  </div>

  <!-- 약관 2 -->
  <div class="modal fade a-modal" id="a-modal2" tabindex="-1" aria-labelledby="a-modal2-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered">
      <div class="modal-content">

        <div class="modal-header">
          <h5 class="modal-title" id="a-modal2-label">사이트 이용 약관</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>

        <div class="modal-body">
          <div id="a-terms-area2">
          </div>
        </div>

      </div>
    </div>
  </div>
  
  <%-- 약관 include --%>
  <jsp:include page="terms.jsp"></jsp:include>
  
  <form action="../email/sendEmail" method="post" id="sendEmailForm">
  	<input type="hidden" id="signUpEmail" name="signUpEmail">
  </form>



<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!-- BootStrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- sweetalert2 JS -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script src="${contextPath}/resources/js/member/signUp.js"></script>

<script>

	$(document).ready( function() {
	  $("#a-terms-area1").append($("#info-terms")); 
	  $("#a-terms-area2").append($("#site-terms")); 
	});
	
</script>

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


</body>
</html>