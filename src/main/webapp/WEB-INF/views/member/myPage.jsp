<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>myPage</title>

<link rel="stylesheet"
   href="${contextPath}/resources/css/member/myPage.css">


</head>


<div id="wrap">
   <div class="myPageContainer">

      <div class="side">
         <a style="background-color: #bb2d3b;" class="btn"  href="myPage" role="button">개인정보 수정</a><br>
         <a class="btn"  href="updatePw" role="button">비밀번호 수정</a><br>
         <a class="btn"  href="ask" role="button">바라는 점</a><br> <a
            class="btn "  href="secession" role="button">회원탈퇴</a>

      </div>

      <form method="POST" action="update" enctype="multipart/form-data"
         onsubmit="return memberUpdateValidate();" role="form"
         class="formwrap">
         <div class="contents">
            <br>

            <div class="row-mb-3">
               <label for="exampleFormControlInput1" class=" myupdate form-label"
                  style="font-weight: bolder;">개인정보
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

</body>

</html>