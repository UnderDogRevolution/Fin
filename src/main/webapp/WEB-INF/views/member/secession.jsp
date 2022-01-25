<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="css/common.css" />

  <link rel="stylesheet" type="text/css" href="css/header.css" />

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
  <script src="https://kit.fontawesome.com/2622b235cb.js" crossorigin="anonymous"></script>
  <title>회원탈퇴</title>

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
      background-color: #000000;
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
</head>

<body>

  <nav class="navbar">
      <div class="header">

          <div class="logo">
              <a href="">Montage</a>

          </div>
          <div></div>
          <div>

              <ul class="menu">
                  <li>
                      <form action="">

                          <div class="search">

                              <div class="searchwrap">

                                  <input type="text">
                              
                                  <div>
  
                                      <a href="" style="display: inline-block; margin-top: 4px;">
                                          <svg class="bi d-block" xmlns="http://www.w3.org/2000/svg" width="17"
                                              height="17" viewBox="0 0 24 24">
                                              <path
                                                  d="M23.809 21.646l-6.205-6.205c1.167-1.605 1.857-3.579 1.857-5.711 0-5.365-4.365-9.73-9.731-9.73-5.365 0-9.73 4.365-9.73 9.73 0 5.366 4.365 9.73 9.73 9.73 2.034 0 3.923-.627 5.487-1.698l6.238 6.238 2.354-2.354zm-20.955-11.916c0-3.792 3.085-6.877 6.877-6.877s6.877 3.085 6.877 6.877-3.085 6.877-6.877 6.877c-3.793 0-6.877-3.085-6.877-6.877z margin-top: 5px;" />
                                          </svg>
                                      </a>
                                  </div>
                              </div>

                      </form>

                  </li>
                  <li><a href=""> <i class="fas fa-home" style="padding-top: 5px;"></i></a></li>
                  <li>

                      <i class="fas fa-bell noticewrap" style="padding-top: 5px;">
                          <div class="notice-num">
                          </div>

                          <div class="notice_box">
                              <!-- 알림영역 -->

                          </div>
                      </i>

                  </li>
                  <li><a href=""><i class="far fa-comment-dots" style="padding-top: 5px;"></i></li>
                  <li><a href=""><i class="far fa-edit" style="padding-top: 5px;"></i></a></li>
                  <li><i class="namewrap">
                          <img class="myImg" src="img/user.png" alt=""
                              style="width: 15px; padding-top: 5px; margin-right: 7px;">
                          <div class="myclick">
                              <!-- 내영역 -->
                              <ul>

                                  <li>
                                      <a href="">
                                          <div class="myclick-li">
                                              <img src="img/user.png" alt="">
                                              프로필
                                          </div>
                                      </a>
                                  </li>
                                  <li>
                                      <a href="">
                                          <div class="myclick-li">
                                              <img src="img/user.png" alt="">
                                              저장
                                          </div>
                                      </a>
                                  </li>
                                  <li>
                                      <a href="">
                                          <div class="myclick-li">
                                              <img src="img/user.png" alt="">
                                              설정
                                          </div>
                                      </a>
                                  </li>
                                  <li>
                                      <a href="">
                                          <div class="myclick-li">
                                              <img src="img/user.png" alt="">
                                              로그아웃
                                          </div>
                                      </a>
                                  </li>

                              </ul>
                          </div>
                      </i>


                  </li>

              </ul>
          </div>


      </div>

  </nav>



  <!-- 부트스트랩 -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"></script>
  <!--jquery  -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script>

      /*    window.onclick = function (event) {
             if (!event.target.matches('.noticewrap')) {
 
                 if (!event.target.matches('.notice_box')) {
                     $(".notice_box").slideUp(200);
                 }
             } else {
 
                 if ($(".notice_box").css("display") == "none") {
 
                     $(".notice_box").slideDown(200);
                 } else {
 
                     $(".notice_box").slideUp(200);
                 }
        
             }
       
         } */

      $(".noticewrap").on("click", function (e) {

          if ($('.notice_box').hasClass("show")) {

              $('.notice_box').slideUp(200);
              $('.notice_box').removeClass("show");

          } else {

              $(".notice_box").slideDown(200);
              $(".notice_box").addClass("show");

          }
      });
      $(".namewrap").on("click", function (e) {

          if ($('.myclick').hasClass("show")) {

              $('.myclick').slideUp(200);
              $('.myclick').removeClass("show");

          } else {

              $(".myclick").slideDown(200);
              $(".myclick").addClass("show");

          }
      });

      window.onclick = function (event) {
          if (!(event.target.matches('.noticewrap') || event.target.matches('.notice_box'))) {

              $('.notice_box').slideUp(200);
              $('.notice_box').removeClass("show");
          }
          if (!(event.target.matches('.namewrap') || event.target.matches('.myclick')||event.target.matches('.myImg'))) {
              $('.myclick').slideUp(200);
              $('.myclick').removeClass("show");
          }




      }


  </script>

  <div id="wrap">
    <div class="header"></div>
    <div class="side">
      <a class="btn btn-danger btn-lg" a href="myPage" role="button">개인정보 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="updatePw" role="button">비밀번호 수정</a><br>
      <a class="btn btn-danger btn-lg" a href="secession" role="button">회원탈퇴</a>
    </div>

    <form method="POST" action="secession" onsubmit="">
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
          <input type="password" class="inputform" id="currentPw">
        </div>
        <br>

        <button type="submit" class="btnsub btn-danger btn-lg">탈퇴하기</button>
      </div>
  </div>
  </form>
  
   <script>
		// 비밀번호 입력 + 약관 동의가 체크 되었을 때에만 탈퇴 진행
		function secessionValidate(){

			// 1) 비밀번호가 입력되어 있지 않으면 false 리턴
			const currentPw = document.getElementById("currentPw");
			
			if(currentPw.value.trim().length == 0){
				alert("비밀번호를 입력해주세요");
				currentPw.focus();
				return false;
			}
			
			// 2) confirm을 이용하여 정말 탈퇴할 것인지 물어보기
			
			return confirm("정말로 탈퇴 하시겠습니까???");
			
		}
	</script>
</body>

</html>