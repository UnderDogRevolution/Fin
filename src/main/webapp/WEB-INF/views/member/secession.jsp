<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>secession</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/member/myPage.css">
	<link rel="stylesheet"
	href="${contextPath}/resources/css/main/crud-post.css">
</head>


<div id="wrap">
	<div class="myPageContainer">

		<div class="side">
			<a class="btn " href="myPage" role="button">개인정보 수정</a><br>
			<a class="btn" href="updatePw" role="button">비밀번호 수정</a><br>
			<a class="btn" href="ask"
				role="button">바라는 점</a><br> 
			<a class="btn"  style="background-color: #bb2d3b;" href="secession" role="button">회원탈퇴</a>

		</div>

		<form method="POST" action="secession"
			onsubmit="return secessionValidate();" class="formwrap">
			<div class="contents">
				<br>

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label"
						style="font-weight: bolder; font-size: 2rem; color: #bb2d3b;">회원탈퇴</label>
				</div>


				<div class="secession">
					<!-- <p style="display: inline-block; color: #bb2d3b;">회원탈퇴</p> 약관] -->
					<textarea class="secessionForm" id="" cols="65" rows="6.5" readonly>
	
	회원탈퇴 신청 전 안내 사항을 확인 해 주세요.
	회원탈퇴를 신청하시면 현재 로그인 된 아이디는 사용하실 수 없습니다.
	회원탈퇴를 하더라도, 서비스 약관 및 개인정보 취급방침 동의하에 따라 일정 기간동안 회원 개인정보를 보관합니다.
	            </textarea>
				</div>
				<div class="mb-3" style="font-weight: bolder; font-size: 1rem;">


					<p style="margin-bottom: 10px; color: red; font-weight: 700;">주의!</p>
					<h1>
						탈퇴를 하시면 회원정보, 가입하신 그룹, 작성한 피드, 문의 내용이 초기화되며 복구하실 수 없습니다.<br>
						정말로 탈퇴를 원하신다면 아래에 비밀번호를 입력하시고 탈퇴 버튼을 눌러주세요.
					</h1>
				</div>
				<div class="mb-3 comitbtnwrpa">
					<label style="font-weight: 700; margin-right: 20px;"
						for="exampleFormControlInput1" class="form-label">비밀번호 확인</label>
					<input type="password" class="inputform" id="currentPw"
						name="currentPw">
				</div>
				<br>

				<button type="submit" class="sudmit_btn"">탈퇴하기</button>
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
		function secessionValidate() {

			const currentPw = document.getElementById("currentPw");

			if (currentPw.value.trim().length == 0) {
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


<script>
	const memberNo = loginMemberNo;
	const contextPath = "${contextPath}"
</script>
<jsp:include page="../main/crud-post.jsp"></jsp:include>
</body>

</html>