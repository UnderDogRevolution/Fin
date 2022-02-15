<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>update</title>
<link rel="stylesheet" href="${contextPath}/resources/css/member/myPage.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/main/crud-post.css">
</head>


<div id="wrap">
	<div class="myPageContainer">

		<div class="side">
			<a  class="btn"  href="myPage" role="button">개인정보 수정</a><br>
			<a  style="background-color: #bb2d3b;" class="btn"  href="updatePw" role="button">비밀번호 수정</a><br>
			<a class="btn"  href="ask" role="button">바라는 점</a><br> <a
				class="btn"  href="secession" role="button">회원탈퇴</a>

		</div>
		<form method="POST" action="updatePw"
			onsubmit="return updatePwValidate();" class="formwrap">
			<div class="contents">
				<br>

				<div class="titlewrap">
					<label for="exampleFormControlInput1" class="updatePw-title"
						style="font-weight: bolder; font-size: 2rem;">비밀번호 수정</label>
				</div>

				<div class="row-mb-3-con">
					<label for="currentPw" class="form-label">현재 비밀번호</label> <input
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
<!-- sweetalert2 JS -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>



<c:if test="${ !empty requestScope.title }">
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
<script>
	const memberNo = loginMemberNo;
	const contextPath = "${contextPath}"
</script>
<jsp:include page="../main/crud-post.jsp"></jsp:include>
</body>

</html>