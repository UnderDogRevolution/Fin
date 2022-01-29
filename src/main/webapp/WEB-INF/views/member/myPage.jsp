<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
  <title>myPage</title>

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
      margin-bottom: 2%;
    }
    
   
    
  </style>
</head>


  <div id="wrap">
    <div class="header"></div>
    <div class="side">
      <a class="btn btn-danger btn-lg" a href="myPage" role="button">개인정보 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="updatePw" role="button">비밀번호 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="ask" role="button">바라는 점</a><br>
      <a class="btn btn-danger btn-lg" a href="secession" role="button">회원탈퇴</a>

    </div>

    <form method="POST" action="update" enctype="multipart/form-data" onsubmit="return memberUpdateValidate();">
      <div class="contents"><br>

        <div class="row-mb-3">
          <label for="exampleFormControlInput1" class="form-label"
            style="font-weight: bolder; font-size:1.5rem; margin-bottom: 4%;">개인정보
            수정</label>
        </div>


			<%-- imgList에 존재하는 이미지의 레벨에 따라 변수 선언
				<c:forEach items="${member.imgList}" var="img">
					<c:choose>
						
						<c:when test="${img.imgLevel == 0 }">
							<c:set var="img0" value="${contextPath}${img.imgPath}${img.imgName}"/>
						</c:when>
						
					</c:choose>
				</c:forEach>

			<!-- 이미지 출력 -->
				<div class="form-inline mb-2">
					<div class="img-thumbnail">
						<img src="${img0}">
					</div>
				</div> --%>



		<!-- 프로필 사진 업로드 -->
        <div class="input-group mb-3">
        <img src="${img0}" class="img-thumbnail" id="inputGroupFile01" style="border-radius:50%" onerror="this.onerror=null; 
        this.src='../resources/images/member/user.png'"><br>
        </div>
        <br>

		<div class="input-group mb-3">
          <input type="file" class="imgform-control" id="inputGroupFile02" name="profile">
          <label class="input-file-text" for="inputGroupFile02">사진 등록</label>
        </div><br>

        <fieldset disabled>
          <div class="row-mb-3-con">
            <label for="currentName" class="col-form-label text-end">이름</label>
            <input type="text" id="currentName" class="col-inputform" placeholder="${loginMember.memberName}" required>
          </div>
        </fieldset><br>

        <div class="row-mb-3-con">
          <label for="nickInput" class="col-form-label text-end">닉네임</label>
          <input type="input" class="col-inputform" id="nickInput" value="${loginMember.memberNickName}">
        </div>

        <br>
        <div class="row-mb-3-con">
          <label for="currentEmail" class="col-form-label text-end">이메일</label>
          <input type="email" class="col-inputform" id="currentEmail" name="currentEmail" value="${loginMember.memberEmail}">
        </div>
        <br>

        <div class="row-mb-3-con">
          <label for="currentBirth" class="col-form-label text-end">생일</label>
          <input type="date" class="col-inputform" id="currentBirth" name="currentBirth" value="${loginMember.memberBirth}">
        </div>

        <button type="submit" class="btnsub btn-danger btn-lg">저장하기</button>
      </div>
  </form>
  </div>
  
  
  <script src="${contextPath}/resources/js/member/memberUpdate.js"></script>
  
</body>

</html>