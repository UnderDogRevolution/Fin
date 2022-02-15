<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>ask</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/member/myPage.css">
	<link rel="stylesheet"
	href="${contextPath}/resources/css/main/crud-post.css">
</head>


<div id="wrap">
	<div class="myPageContainer">

		<div class="side">
			<a class="btn "  href="myPage" role="button">개인정보 수정</a><br>
			<a class="btn"  href="updatePw" role="button">비밀번호 수정</a><br>
			<a style="background-color:#bb2d3b;" class="btn"  href="ask" role="button">바라는 점</a><br> <a
				class="btn "  href="secession" role="button">회원탈퇴</a>

		</div>

		<form method="POST" action="ask" onsubmit="return askValidate();"
			class="formwrap">
			<div class="contents">
				<br>

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label"
						style="font-weight: bolder; font-size: 2rem;">바라는 점</label>
				</div>

				<div class="ask_titlewrap"
					style="font-weight: bolder; font-size: 1.25rem;">
					<p style="font-size: 20px; margin-top: 50px;">관리자에게 건의사항이나 바라는
						점, 아쉬운 점 등이 있으시면, 아래에 텍스트를 작성해 제출해주세요.</p>
				</div>

				<div class="askTitlewrap">
					<label for="exampleFormControlInput1" class="askTitleLavel">제목</label>
					<input type="text" class="inputform" id="askTitle" name="askTitle"
						placeholder="제목을 입력하세요">
				</div>

				<div class="asktext" style="font-weight: bolder; font-size: 1rem;">
					<label for="exampleFormControlInput1" class="asklabel">내용</label>
					<textarea class="textareaask" name="askContent" maxlength="300"
						placeholder="300자 이내로 내용을 적어주세요." class="col-inputform"
						id="askContent" style="resize: none;"></textarea>
				</div>
				<br>

				<button type="submit" class="sudmit_btn"">보내기</button>
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
</c:if>

<script>
	function askValidate() {

		const askTitle = document.getElementById("askTitle");
		const askContent = document.getElementById("askContent");

		if (askTitle.value.trim().length == 0
				|| askContent.value.trim().length == 0) {
			alert("빈칸인 부분을 입력해주세요");
			return false;
		}
		return confirm("정말 제출하시겠습니까?");
	}
</script>

<script>
	const memberNo = loginMemberNo;
	const contextPath = "${contextPath}"
</script>
<jsp:include page="../main/crud-post.jsp"></jsp:include>
</body>

</html>