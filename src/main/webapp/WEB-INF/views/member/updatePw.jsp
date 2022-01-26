<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>

  <title>비밀번호 수정</title>

  <style type="text/css">
    html,
    body {
      background: #0D0D0D;
      color: #FDFDFD;
      height: 100%;
      padding: 0px;
      margin: 0px;
      font-family: "Noto Sans KR";
    }

    input {
      font-family: "Noto Sans KR";
    }

    #wrap {
      width: 80%;
      height: auto;
      margin: 5% auto 0 auto;
      font-size: 1rem;
      color: #000000;
      text-align: center;
    }

    .side {
      float: left;
      width: 22%;
      height: 94%;
      line-height: 100%;
      background-color: #000000;
    }

    .form-label {
      margin-bottom: 0.5rem;
      font-weight: bold;
      font-size: 1.5rem;
    }

    .contents {
      float: left;
      width: 78%;
      height: 94%;
      line-height: 50%;
      background-color: #ffffff;
      border-radius: 1rem;
      line-height: normal;
    }

    .input-file-text {
      display: flex;
      align-items: center;
      padding: 0.1rem 0.75rem;
      font-size: 1rem;
      font-weight: 400;
      line-height: 1.9;
      color: #212529;
      text-align: center;
      white-space: nowrap;
      background-color: #e9ecef;
      border: 1px solid #ced4da;
      border-radius: 0.25rem;
    }

    .btn {
      margin: 15% 0 10% 0;
    }

    .img-thumbnail {
      padding: 0.25rem;
      background-color: #fff;
      border: 0;
      max-width: 10%;
      height: auto;
    }

    .imgform-control {
      width: 30%;
      padding: 0.375rem 0.35rem;
      font-size: 1rem;
      font-weight: 400;
      line-height: 1;
      color: #212529;
      background-color: #fff;
      background-clip: padding-box;
      border: 1px solid #ced4da;
      border-radius: 0.25rem;
    }

    .input-group {
      position: relative;
      display: flex;
      justify-content: center;
      flex-wrap: wrap;
      align-items: center;
      width: 100%;
      text-align: center;
    }

    .inputform {
      width: 30%;
      padding: 0;
      margin: 0 0 5% 5%;
      font-size: 1.5rem;
      font-weight: 400;
      line-height: 1.5;
      color: #212529;
      background-color: #fff;
      background-clip: padding-box;
      border: 1px solid #ced4da;
      appearance: none;
      border-radius: 0.25rem;
    }

    .birthform {
      width: 60%;
      height: fit-content;
      font-size: 1rem;
      font-weight: 400;
      line-height: 1.5;
      color: #212529;
      background-color: #fff;
      background-clip: padding-box;
      border: 1px solid #ced4da;
      appearance: none;
      border-radius: 0.25rem;
    }

    .brithinput-group {
      position: relative;
      display: inline-flex;
      margin: 0 0 0 5%;
      flex-wrap: nowrap;
      align-items: stretch;
      width: 20%;
    }

    .btnsub {
      margin: 5% 0 5% 0;
    }

    .row-mb-3-con {
      display: flex;
      flex-flow: row nowrap;
      justify-content: flex-end;
      margin-right: 30%;
      margin-top: 5%;
    }
  </style>


  <div id="wrap">
    <div class="side">
      <a class="btn btn-danger btn-lg" a href="myPage" role="button">개인정보 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="updatePw" role="button">비밀번호 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="secession" role="button">회원탈퇴</a>
    </div>

    <form method="POST" action="secession" onsubmit="">
      <div class="contents"><br>

        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label" style="font-weight: bolder; font-size:2rem;">비밀번호 수정</label>
        </div>

        <div class="row-mb-3-con">
          <label for="currentPw" class="form-label" >비밀번호 수정</label>
          <input type="password" class="inputform" id="currentPw">
        </div>

        <div class="row-mb-3-con">
          <label for="newPw1" class="form-label">새 비밀번호</label>
          <input type="password" class="inputform" id="newPw1">
        </div>

        <div class="row-mb-3-con">
          <label for="newPw2" class="form-label">새 비밀번호 확인</label>
          <input type="password" class="inputform" id="newPw2">
        </div>

        <div class="mb-3" style="font-weight: bold;">
          <br>
          <h1>6~16자의 영문 대/소문자, 숫자, 특수기호 조합 사용할 수 있습니다.<br>
            이전에 사용했던 비밀번호나 타 사이트와 다른 비밀번호를 사용하고 비밀번호는 주기적으로 변경해 주세요.</h1>
        </div>

        <button type="submit" class="btnsub btn-danger btn-lg">저장하기</button>
      </div>
  </div>
  </form>
  
  
  
  <script>
		// 비밀번호 유효성 검사
		function updatePwValidate(){
			
			// 새 비밀번호/확인에 작성된 값을 변수에 저장
			const newPw1 = document.getElementById("newPw1").value;
			const newPw2 = document.getElementById("newPw2").value;
			
			// 1) 새 비밀번호가 정규식에 맞지 않은 경우
			const regExp = /^[a-zA-Z\d\!\@\#\-\_]{6,20}$/;
			
			if( !regExp.test(newPw1)  ){
				alert("새 비밀번호가 유효하지 않습니다.");
				return false;
			}
			
			// 2) 새 비밀번호/확인 같지 않은 경우
			if(newPw1 != newPw2){
				alert("새 비밀번호가 일치하지 않습니다.");
				return false;
			}
			
			
			
		}
	</script>
  
</body>

</html>