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
	padding: 5px;
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
.sudmit_btn:hover{
	background-color: #bb2d3b;
	color: white;
}
.subwrap{

margin-left: 0 !important;

}
</style>
</head>


<div id="wrap">
	<div class="myPageContainer">
		
		<jsp:include page="sideMenu.jsp"/>
		
		<form method="POST" action="update" enctype="multipart/form-data"
			onsubmit="return memberUpdateValidate();" role="form"
			class="formwrap">
			<div class="contents">
				<br>

				<div class="row-mb-3">
					<label for="exampleFormControlInput1" class="form-label"
						style="font-weight: bolder; font-size: 1.5rem; margin-bottom: 4%;">개인정보
						수정</label>
				</div>

				<div class="form-inline mb-2">
					<div class="memberImg">
						<img id="img"
							src="${contextPath}${loginMember.profileImage.imgPath}${loginMember.profileImage.imgName}"
							onerror="this.onerror=null; 
       					 this.src='../resources/images/common/defaultProfileImage.png'"
							name="img"
							style="border-radius: 30%; cursor: pointer; width: 180px; height: 180px;">
						<br>
					</div>
				</div>

				<!-- 파일 업로드 (이미지를 누르면 프로필 사진 첨부)-->
				<div id="fileArea" style="display: none">
					<input type="file" name="images" onchange="loadImg(this,0)">
					<input type="hidden" name="deleteCheck"> <label
						class="imgform-control" for="inputGroupFile02">사진 등록</label>
				</div>

				<div class="btn2">
					<button class="deleteImg btns" type="button" id="deleteImg"
						style="cursor: pointer; margin: 0%;">프로필사진 삭제</button>
				</div>
				<br>

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
					<label for="nickInput" class="col-form-label text-end">닉네임</label>
					<input type="text" class="col-inputform" id="nickInput"
						name="nickInput" value="${loginMember.memberNickName}"
						placeholder="닉네임을 입력하세요">
				</div>

				<div class="row-mb-3-con">
					<label for="currentBirth" class="col-form-label text-end">생일</label>
					<input type="date" class="col-inputform" id="birthInput"
						name="birthInput" value="${loginMember.memberBirth}">
				</div>
				<div class="row-mb-3-con subwrap">
					<button type="submit" class="sudmit_btn"">저장하기</button>
				</div>


			</div>

			<input type="hidden" name="memberNo" value="${loginMember.memberNo}">

		</form>
	</div>
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