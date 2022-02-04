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
	float: left;
	width: 22%;
	height: 94%;
	line-height: 100%;
	background-color: #0D0D0D;
}

.col-form-label {
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
}

.btn {
	margin: 15% 0 10% 0;
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

.col-inputform {
	width: 50%;
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


.btnsub {
	margin: 5% 0 5% 0;
}

.row-mb-3-con {
	display: flex;
	flex-flow: row nowrap;
	justify-content: flex-end;
	margin-right: 30%;
	margin-bottom: 2%;
}
</style>
</head>


<div id="wrap">
	<div class="header"></div>
	<div class="side">
		<a class="btn btn-danger btn-lg" a href="myPage" role="button">개인정보
			수정</a><br> <a class="btn btn-danger btn-lg" a href="updatePw"
			role="button">비밀번호 수정</a><br> <a class="btn btn-danger btn-lg" a
			href="ask" role="button">바라는 점</a><br> <a
			class="btn btn-danger btn-lg" a href="secession" role="button">회원탈퇴</a>

	</div>

	<form method="POST" action="update" enctype="multipart/form-data"
		onsubmit="return memberUpdateValidate();" role="form">
		<div class="contents">
			<br>

			<div class="row-mb-3">
				<label for="exampleFormControlInput1" class="form-label"
					style="font-weight: bolder; font-size: 1.5rem; margin-bottom: 4%;">개인정보
					수정</label>
			</div>

			<!-- 이미지 레벨 0 지정 -->
			<c:forEach items="${member.imgList}" var="img">
					<c:if test="${img.imgLevel == 0 }">
						<c:set var="img0"
							value="${contextPath}${img.imgPath}${img.imgName}" />
					</c:if>
			</c:forEach>

			<div class="form-inline mb-2">
				
				<div class="memberImg">
					<img src="${contextPath}${loginMember.profileImage.imgPath}${loginMember.profileImage.imgName}" onerror="this.onerror=null; 
        this.src='../resources/images/member/defaultProfileImage.png'" 
        style="border-radius: 30%; cursor:pointer; width: 180px; height: 180px;"> 
	<br>
        <span class="deleteImg" style="cursor:pointer">사진 삭제</span>
				</div>
			</div>


			<!-- class="img-thumbnail" id="inputGroupFile01"
						name="inputGroupFile01" style="border-radius: 50%"
						onerror="this.onerror=null; 
        this.src='../resources/images/member/user.png'" -->


			<!-- 파일 업로드 부분 -->
			<div id="fileArea" style="display:none">
				<input type="file" name="images" onchange="loadImg(this,0)">
				<label class="imgform-control" for="inputGroupFile02">사진 등록</label>
			</div>






			<br>

			<!-- <div class="input-group mb-3">
				<input type="file" class="imgform-control" id="inputGroupFile02"
					name="profile"> <label class="input-file-text"
					for="inputGroupFile02">사진 등록</label>
			</div>
			<br>
 -->
			<fieldset disabled>
				<div class="row-mb-3-con">
					<label for="currentEmail" class="col-form-label text-end">이메일</label>
					<input type="text" class="col-inputform" id="currentEmail"
						placeholder="${loginMember.memberEmail}">
				</div>
			</fieldset>
			<br>

			<fieldset disabled>
				<div class="row-mb-3-con">
					<label for="currentName" class="col-form-label text-end">이름</label>
					<input type="text" class="col-inputform" id="currentName"
						placeholder="${loginMember.memberName}">
				</div>
			</fieldset>
			<br>

			<div class="row-mb-3-con">
				<label for="nickInput" class="col-form-label text-end">닉네임</label> <input
					type="text" class="col-inputform" id="nickInput" name="nickInput"
					value="${loginMember.memberNickName}"
					style="width: 50%; margin-left: 5%;" placeholder="닉네임을 입력하세요">
			</div>

			<br>

			<div class="row-mb-3-con">
				<label for="currentBirth" class="col-form-label text-end">생일</label>
				<input type="date" class="col-inputform" id="birthInput"
					name="birthInput" value="${loginMember.memberBirth}">
			</div>

			<button type="submit" class="btnsub btn-danger btn-lg">저장하기</button>
		</div>

		<!-- update용 파라미터 -->
		<input type="hidden" name="boardNo" value="${board.boardNo}">
		<input type="hidden" name="deleteImages" value="">



	</form>
</div>

<script src="${contextPath}/resources/js/member/memberUpdate.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<c:if test="${ !empty requestScope.title }">
	<script>
		swal({
			title : "${title}",
			text : "${text}",
			icon : "${icon}"
		});
	</script>
</c:if>

</body>

</html>