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

.btnsub {
	margin: 5% 0 5% 0;
	font-size: 15px;
}

.row-mb-3-con {
	display: flex;
	width: 100%;
	flex-flow: row nowrap;
	justify-content: center;
	margin-bottom: 2%;
	margin-left: -30px;
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
	font-weight: 700;
}

.sudmit_btn:hover {
	background-color: #bb2d3b;
	color: white;
}

.subwrap {
	margin-left: 0 !important;
}
</style>
</head>


<div id="wrap">
	<div class="myPageContainer">

		<jsp:include page="sideMenu.jsp" />
		
		 <form method="POST" action="secession" onsubmit="return secessionValidate();">
      <div class="contents"><br>

        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label" style="font-weight: bolder; font-size:2rem;">회원탈퇴</label>
        </div>

        <div class="mb-3" style="font-weight: bolder; font-size:1rem;">
          <h1>탈퇴를 하시면 회원정보, 가입하신 그룹, 작성한 피드, 문의 내용이 초기화되며 복구하실 수 없습니다.<br>
            정말로 탈퇴를 원하신다면 아래에 비밀번호를 입력하시고 탈퇴 버튼을 눌러주세요.</h1>
        </div>

        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label">비밀번호 확인</label>
          <input type="password" class="inputform" id="currentPw"  name="currentPw">
        </div>
        <br>

        <button type="submit" class="btnsub btn-danger btn-lg">탈퇴하기</button>
      </div>
  </div>
  </form>


	</div>
</div>

<script src="${contextPath}/resources/js/member/memberUpdate.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- sweetalert2 JS -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<c:if test="${ !empty requestScope.title }">
	  <script>
		function secessionValidate(){

			const currentPw = document.getElementById("currentPw");
			
			if(currentPw.value.trim().length == 0){
				alert("비밀번호를 입력해주세요");
				currentPw.focus();
				return false;
			}
			
			return confirm("정말로 탈퇴 하시겠습니까?");
		}
	</script>
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



</body>

</html>