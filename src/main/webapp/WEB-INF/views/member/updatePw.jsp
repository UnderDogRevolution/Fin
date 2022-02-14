<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>myPage</title>

<style type="text/css">
html, body {
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
	width: 15%;
	height: 94%;
	line-height: 100%;
	background-color: #0D0D0D;
	position: absolute;
	left: 100px;
}

.col-form-label {
	margin-left: -30px;
	width: 100px;
	margin-bottom: 0.5rem;
	font-weight: bold;
	font-size: 1.5rem;
}

.contents {
	width: 60%;
	height: 94%;
	line-height: 50%;
	background-color: #ffffff;
	border-radius: 1rem;
	line-height: normal;
	margin-left: 20px;
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
}

.btn {
	margin: 5% 0 0 0;
	width: 150px;
	color: white;
}

.btn:hover {
	color: white;
	background-color: #bb2d3b;
}

.img-thumbnail {
	padding: 0.25rem;
	background-color: #fff;
	border: 0;
	max-width: 15%;
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
	display: none;
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

fieldset {
	height: 50px;
}

.col-inputform {
	width: 30%;
	padding: 0;
	margin: 0 0 0 15px;
	font-size: 1.0rem;
	font-weight: 400;
	line-height: 1.5;
	color: #212529;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	appearance: none;
	border-radius: 5px;
	height: 50px;
	outline: none;
	cursor: pointer;
}

.inputform {
	outline: none;
	width: 230px;
	height: 30px;
	border-radius: 5;
}

.btnsub {
	margin: 5% 0 5% 0;
	font-size: 15px;
}

.row-mb-3-con {
	display: flex;
	width: 100%;
	flex-flow: row nowrap;
	justify-content: center;
	margin-left: -36px;
	margin-bottom: 60px;
}

.myPageContainer {
	display: flex;
	width: 100%;
	position: relative;
	justify-content: center;
}

.formwrap {
	width: 100%;
	display: flex;
	justify-content: center;
	margin-left: 35px;
	height: 800px;
	padding-top: 15px;
}

.memberImg {
	display: flex;
	justify-content: center;
}

.deleteImg {
	color: black;
	border: none;
	background-color: white;
}

.deleteImg:hover {
	color: #bb2d3b;
}

.sudmit_btn {
	border: none;
	border-radius: 5px;
	color: black;
	background-color: white;
	width: 100px;
	height: 30px;
	margin-left: 0 !important;
	margin-top: 15px;
	font-weight: 700;
}

.sudmit_btn:hover {
	background-color: #bb2d3b;
	color: white;
}

.subwrap {
	margin-left: 0 !important;
}

.form-label {
	width: 150px;
	margin-top: 2px;
	font-weight: 700;
}

.titlewrap {
	margin-bottom: 100px;
}

.sudmit_btn {
	border: none;
	border-radius: 5px;
	color: black;
	background-color: white;
	width: 100px;
	height: 30px;
	margin-left: 0 !important;
	font-weight: 700;
}

.sudmit_btn:hover {
	background-color: #bb2d3b;
	color: white;
}
.inputform{
	padding: 5px;
}
</style>
</head>


<div id="wrap">
	<div class="myPageContainer">

		<jsp:include page="sideMenu.jsp" />
		<form method="POST" action="updatePw"
			onsubmit="return updatePwValidate();" class="formwrap">
			<div class="contents">
				<br>

				<div class="titlewrap">
					<label for="exampleFormControlInput1" class="updatePw-title"
						style="font-weight: bolder; font-size: 2rem;">비밀번호 수정</label>
				</div>

				<div class="row-mb-3-con">
					<label for="currentPw" class="form-label">비밀번호 수정</label> <input
						type="password" class="inputform" id="currentPw" name="currentPw">
				</div>

				<div class="row-mb-3-con">
					<label for="newPw1" class="form-label">새 비밀번호</label> <input
						type="password" class="inputform" id="newPw1" name="newPw1">
				</div>

				<div class="row-mb-3-con">
					<label for="newPw2" class="form-label">새 비밀번호 확인</label> <input
						type="password" class="inputform" id="newPw2" name="newPw2">
				</div>

				<div class="mb-3" style="font-weight: bold;">
					<br>
					<h1>
						6~16자의 영문 대/소문자, 숫자, 특수기호 조합 사용할 수 있습니다.<br> 이전에 사용했던 비밀번호나 타
						사이트와 다른 비밀번호를 사용하고 비밀번호는 주기적으로 변경해 주세요.
					</h1>
				</div>

				<button type="submit" class="sudmit_btn">저장하기</button>
			</div>
	</div>
	</form>
</div>
</div>

<script src="${contextPath}/resources/js/member/memberUpdate.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<c:if test="${ !empty requestScope.title }">


  <div id="wrap">
    <div class="side">
      <a class="btn btn-danger btn-lg" a href="myPage" role="button">개인정보 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="updatePw" role="button">비밀번호 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="ask" role="button">바라는 점</a><br>
      <a class="btn btn-danger btn-lg" a href="secession" role="button">회원탈퇴</a>
    </div>

    <form method="POST" action="updatePw" onsubmit="return updatePwValidate();">
      <div class="contents"><br>

        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label" style="font-weight: bolder; font-size:2rem;">비밀번호 수정</label>
        </div>

        <div class="row-mb-3-con">
          <label for="currentPw" class="form-label" >현재 비밀번호</label>
          <input type="password" class="inputform" id="currentPw" name="currentPw">
        </div>

        <div class="row-mb-3-con">
          <label for="newPw1" class="form-label">새 비밀번호</label>
          <input type="password" class="inputform" id="newPw1" name="newPw1">
        </div>

        <div class="row-mb-3-con">
          <label for="newPw2" class="form-label">새 비밀번호 확인</label>
          <input type="password" class="inputform" id="newPw2" name="newPw2">
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
  
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <c:if test="${ !empty requestScope.title }">
	<script>
		swal({
			title : "${title}",
			text : "${text}",
			icon : "${icon}"
		});
	</script>

	<script>
		// 비밀번호 유효성 검사
		function updatePwValidate() {

			// 새 비밀번호/확인에 작성된 값을 변수에 저장
			const newPw1 = document.getElementById("newPw1").value;
			const newPw2 = document.getElementById("newPw2").value;

			// 1) 새 비밀번호가 정규식에 맞지 않은 경우
			const regExp = /^[a-zA-Z\d\!\@\#\-\_]{6,20}$/;

			if (!regExp.test(newPw1)) {
				alert("새 비밀번호가 유효하지 않습니다.");
				return false;
			}

			// 2) 새 비밀번호/확인 같지 않은 경우
			if (newPw1 != newPw2) {
				alert("새 비밀번호가 일치하지 않습니다.");
				return false;
			}

		}
	</script>
</c:if>

</body>

</html>