<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
  <title>바라는 점</title>

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
      height: 100%;
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
      background-color: #0D0D0D;
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
      margin: 0 0 0 5%;
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

    .mb-3{
      padding-bottom: 5%;
    }
  </style>


   <div id="wrap">
    <div class="header"></div>
    <div class="side">
      <a class="btn btn-danger btn-lg" a href="myPage" role="button">개인정보 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="updatePw" role="button">비밀번호 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="ask" role="button">바라는 점</a><br>
      <a class="btn btn-danger btn-lg" a href="secession" role="button">회원탈퇴</a>
    </div>

    <form method="POST" action="ask" onsubmit="return askValidate();">
      <div class="contents"><br>

        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label" style="font-weight: bolder; font-size:2rem;">바라는 점</label>
        </div>

        <div class="mb-3" style="font-weight: bolder; font-size:1rem;">
          <h1>관리자에게 건의사항이나 바라는 점, 아쉬운 점 등이 있으시면, 아래에 텍스트를 작성해 제출해주세요.</h1>
        </div>

        <div class="mb-3" style="font-weight: bolder; font-size:1rem;">
        <form>
          <textarea name="ask" rows="10" cols="80" maxlength="300" placeholder="300자 이내로 내용을 적어주세요." 
          id="currentAsk" style="resize: none;"></textarea>
        </form>
        </div>
<!-- XSS 처리도 해야함 -->
        <br>

        <button type="submit" class="btnsub btn-danger btn-lg">제출하기</button>
      </div>
  </div>
  </form>

  <script>
		function askValidate(){

			// 1) 내용이 입력되어 있지 않으면 false 리턴
			const currentAsk = document.getElementById("currentAsk");
			
			if(currentAsk.value.trim().length == 0){
				alert("바라는 점을 입력해주세요");
				currentAsk.focus();
				return false;
			}
			
			return confirm("바라는 점을 제출 하시겠습니까?");
		}
	</script>


</body>

</html>