<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<html>
<head>
<meta charset="UTF-8">

<title>myboard</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/board/myboard.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/main/crud-post.css">
	<style type="text/css">
	.sexyboy{
	
	background-color: #404142 !important;
	}
	.postBox{
		cursor: pointer;
	}
	.postBox:hover{
    transform: scale( 1.1 );
    transition-duration: 1s;
}
.img > img{
	width: 100%;
    height: 100%;
    border-radius: 49%;
}
.pro-a:hover{
	color: black;
}
.follow-modal{

background-color: #404142 !important;
}

.info{
	color: white !important;
}

.modal-header{
color:white !important;
}
.follow-delete{
    border-radius: 5px;
    width: 100px;
    height: 28px;
    font-weight: 500;
    background-color: #545454;
    color: white;
   	border: none;
}
.follow-delete:hover{
	background-color: #942d2d;
}
.modal-body::-webkit-scrollbar {
	display: none;
}

.setting-update:hover{
background-color: #942d2d;

}
.setting-update > a:hover{
	color: white;
}

	</style>
	
	
</head>
<body>


	<main>
		<div class="container">
			<div class="profile">
				<div class="myinfo">
					<div class="picture1">
						<div class="picture2"
							style="background-image: url('${contextPath}${member.profileImage.imgPath}${member.profileImage.imgName}')"></div>
					</div>
					<div class="introduce">
						<div class="nickname">
							<c:choose>
								<c:when test="${loginMember.memberNo == memberNo}">

									<span>${loginMember.memberName}</span>
									<a class="pro-a" href="${contextPath}/member/myPage">프로필변경</a>
									<img src="${contextPath}/resources/images/myBoard/png"
										data-bs-toggle="modal" data-bs-target="#followerList3">
								</c:when>
								<%-- <c:when test="${!loginMember.memberNo">
									<span>${member.memberName}</span>
								</c:when> --%>
								<c:otherwise>
									<span>${member.memberName}</span>
										
									<c:choose>
										<c:when test="${follow eq 0}">
											<a class="follow">팔로우</a>

										</c:when>
										<c:otherwise>
											<a class="follower">팔로잉</a>
										</c:otherwise>
									</c:choose>
									<a>메세지 보내기</a>
								</c:otherwise>
							</c:choose>




						</div>
						<div class="boardCount">

							<div class="Count post_count">
								<span>게시글</span> <span>${postCount}</span>

							</div>
							<div class="Count follower_count" data-bs-toggle="modal"
								data-bs-target="#followerList">
								<span>팔로워</span> <span>${followerCount}</span>
							</div>
							<div class="Count follow_count" data-bs-toggle="modal"
								data-bs-target="#followerList2">
								<span>팔로잉</span> <span>${followCount}</span>
							</div>



						</div>
					</div>
				</div>





			</div>
			<div id="board-list">
				<ul class="save">
					<li class="active pre-board" data-mode="post">게시글</li>
					<li class="save-board" data-mode="save">저장됨</li>

				</ul>
				<div class="board-show">
					<!-- 					<div class="show"></div>
					<div class="show"></div>
					<div class="show"></div>

					<div class="show"></div>
					<div class="show"></div>
					<div class="show"></div>
					<div class="show"></div>
					<div class="show"></div>
					<div class="show"></div> -->
				</div>
			</div>


			<!-- $("#board-list ul li").on("click", function(){

                

            }); -->


			<!-- Modal -->

			<!-- follwerList 팔로워 목록 -->
			<div class="modal fade" id="followerList" tabindex="-1"
				aria-labelledby="followerListLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content follow-modal">
						<div class="modal-header">
							<h5 class="modal-title" id="followerListLabel">팔로워 목록</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<div class="list-wrap">
								 <!-- <div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">삭제</a>
									</div>
								</div>  -->
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">닫기</button>

						</div>
					</div>
				</div>
			</div>
			<!-- follwerList 팔로워 목록:e -->


			<!-- Modal -->

			<!-- follwerList 팔로워 목록 -->
			<div class="modal fade" id="followerList2" tabindex="-1"
				aria-labelledby="followerList2Label" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content  follow-modal">
						<div class="modal-header">
							<h5 class="modal-title" id="followerListLabel">팔로우 목록</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<div class="list-wrap">
								<!-- <div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div>
								<div class="list-item">
									<div class="img"></div>
									<div class="info">
										<span>user01</span> <span>이상원</span>
									</div>
									<div class="del-button-wrap">
										<a href="#self">팔로우 취소</a>
									</div>
								</div> -->
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">닫기</button>

						</div>
					</div>
				</div>
			</div>
			<!-- follwerList 팔로잉 목록:e -->


			<!-- 설정 모달 -->
			<div class="modal fade" id="followerList3" tabindex="-1"
				aria-labelledby="followerList3Label" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content sexyboy">

						<div class="setting-modal-body">
							<div class="setting-list-wrap">
								<div class="setting-list-item">

									<div class="setting-update">
										<a href="${contextPath}/member/updatePw">비밀번호 변경</a>
									</div>
									<div class="setting-update">
										<a href="${contextPath}/member/ask">바라는 점</a>
									</div>
									<div class="setting-update" data-bs-toggle="modal"
										data-bs-target="#followerList">팔로워</div>
									<div class="setting-update" data-bs-toggle="modal"
										data-bs-target="#followerList2">팔로우</div>


									<div class="setting-update"><a href = "${contextPath}/member/logout">로그 아웃</a></div>








								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
	</main>


	<script>
	
	
	
	
	const memberNo = "${loginMember.memberNo}";
	const memberNickName = "${loginMember.memberNickName}";
	const memberName = "${loginMember.memberName}";
	const contextPath = "${contextPath}";
	const myImgPath = "${contextPath}${loginMember.profileImage.imgPath}${loginMember.profileImage.imgName}";
	const alramNo = "${memberNo}";
	
	function memberView(member){
		location.href = contextPath + "/board1/myBoard/"+member		
	
	}
	
 	function postSubmit1(postNo){
		 location.href = contextPath + "/post/view/"+postNo
	} 
	
	
	
		var thisMemberNo = window.location.href.split("/")[6];

		getPostList('post');

		$(".save li").on("click", function() {

			$(".save li").removeClass("active");

			$(this).addClass("active");

			var mode = $(this).data('mode');

			// 게시물 - mode : post
			// 저장됨 - mode : save

			getPostList(mode);

		});

		function getPostList(mode) {

			if (!mode) {
				mode = 'post';
			}

			var html = [];
			var board_show = $(".board-show");

			$.ajax({

						url : contextPath + "/board1/myBoard/" + thisMemberNo + "/post",
						type : "get",
						dataType : "JSON",
						data : {
							mode : mode
						},
						success : function(list) {
							
							if (list.length > 0) {

								for (var i = 0; i < list.length; i++) {

									if (list[i].poster !== undefined
											& list[i].postContent !== undefined) {
										html.push('<div  onclick = "postSubmit1('+list[i].postNo+');" class="show postBox" style="background: url('
														+ list[i].poster
														+ ') no-repeat center center; background-size: cover;"></div>');
									} else if (list[i].poster === undefined
											&& list[i].postContent !== undefined) {

										if (list[i].listPostImage[0] === undefined) {
											html.push('<div onclick = "postSubmit1('+list[i].postNo+');" class="show postBox"><span>'
															+ list[i].postContent
															+ '</span></div>');
										} else {
											console
													.log(list[i].listPostImage[0].postImagePath);
											html
													.push('<div onclick = "postSubmit1('+list[i].postNo+');" class="show postBox" style="background: url(/fin'
															+ list[i].listPostImage[0].postImagePath
															+ list[i].listPostImage[0].postImageName
															+ ') no-repeat center center; background-size: cover;"></div>');
										}

									} else {
										html.push('<div onclick = "postSubmit1('+list[i].postNo+');" class="show postBox"></div>');
									}

								}

								board_show.html(html.join(''));

							}

						},

						error : function(request, status, error) {

							// 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
							if (request.status == 404) {
								console.log("ajax 요청 주소가 올바르지 않습니다.");

							} else if (request.status == 500) {
								console.log("서버 내부 에러 발생");
								console.log(request.responseText);
							}

						}

					});

		}

		$(document).on("click", '.follow', function() {
					
			var html = [];
					
			var _this = $(this);

					// var mode = $(this).data('mode');

					$.ajax({

						url : contextPath + "/board1/myBoard/" + thisMemberNo + "/insertFollow",
						type : "get",
						dataType : "JSON",
						
						success : function(result) {
/* 
							html.push('<a class="follower">팔로잉</a>');

							$('.nickname .follow-wrap').html(html.join('')); */
							
							  _this.removeClass('follow').addClass('follower');
							_this.text('팔로잉');
							var follower_count = parseInt($('.follower_count span').eq(1).text());
							$('.follower_count span').eq(1).text(follower_count + 1);  
							

							const alramObj = {};
							
							alramObj.alramTakeMemberNo = alramNo;
							alramObj.alramContent = loginMemberName + "님이 팔로우를 했습니다.";
							alramObj.alramUrl = contextPath + "/board1/myBoard/" + loginMemberNo;
							alramObj.alramGiveNo = memberNo;
							
							
							
							alramSock.send(JSON.stringify(alramObj));
							
							
						
							
							
						},

						error : function(request, status, error) {

							// 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
							if (request.status == 404) {
								console.log("ajax 요청 주소가 올바르지 않습니다.");

							} else if (request.status == 500) {
								console.log("서버 내부 에러 발생");
								console.log(request.responseText);
							}

						}

					});

				});

		$(document).on("click", '.follower', function() {

			var html = [];	
			
			var _this = $(this);
			
					$.ajax({

						url : contextPath + "/board1/myBoard/" + thisMemberNo + "/deleteFollow",
						type : "get",
						dataType : "JSON",
						
						success : function(result) {			
							

							 _this.removeClass('follower').addClass('follow');
							_this.text('팔로우');
							var follower_count =  parseInt($('.follower_count span').eq(1).text());
							$('.follower_count span').eq(1).text(follower_count - 1);
 

							
						},

						error : function(request, status, error) {

							// 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
							if (request.status == 404) {
								console.log("ajax 요청 주소가 올바르지 않습니다.");

							} else if (request.status == 500) {
								console.log("서버 내부 에러 발생");
								console.log(request.responseText);
							}

						}

					});

				});
		
		// 해당 페이지 멤버 팔로우 조회
		$('#followerList').on('shown.bs.modal', function () {
			  var html = [];  
			const follow = $(".list-wrap");
			follow.empty();
			
			$.ajax({

				url: contextPath + "/board1/myBoard/" + thisMemberNo + "/followFriend",
				dataType: "JSON",
				type: "GET",
				success: function(list) {
					console.log(list)
					
					  if(list.length > 0){
						for(var i = 0; i < list.length; i++){
							
						html.push(
								'<div class="list-item">' +
									'<div class="img"><img src = '+contextPath + list[i].imgPath+ list[i].imgNm+'></div>' +
									'<div onclick = "memberView('+list[i].memberNo+')" class="info">' +
										'<span>'+ list[i].memberNickNm +'</span>'+ 
										'<span>'+ list[i].memberNm +'</span>' +
									'</div>' +
									'<div class="del-button-wrap">'+
									'</div>' +
								'</div>'
								);
							
							
						}
					}  
					
								follow.html(html.join(''));
					
				},
				error: function() {

				}



			});
				
			}).on('hide.bs.modal', function() {
				//alert('닫는다');
			});
		
		// 해당 페이지 멤버 팔로워 조회
		$('#followerList2').on('shown.bs.modal', function () {
			var html = [];  
			const follow = $(".list-wrap");
			follow.empty();
			$.ajax({

				url: contextPath + "/board1/myBoard/" + thisMemberNo + "/selectFriend",
				dataType: "JSON",
				type: "GET",
				success: function(list) {
					console.log(list)
					
					
					
					
					if(list.length > 0){
						for(var i = 0; i < list.length; i++){
							
						html.push(
								'<div class="list-item list-item-'+ i +'">' +
									'<div class="img"><img src = '+contextPath + list[i].imgPath+ list[i].imgNm+'></div>' +
									'<div onclick = "memberView('+list[i].toUser+')" class="info">' +
										'<span>'+ list[i].memberNickNm +'</span>'+ 
										'<span>'+ list[i].memberNm +'</span>' +
										'<input type="hidden" name="friendNo" value="' +list[i].memberNo + '">' +
									'</div>' +
									'<div class="del-button-wrap">'+
									'<button class="follow-delete" onclick = "followDelete(event,'+list[i].toUser+')">팔로우 취소</button>'+
									'</div>' +
								'</div>'
								);
							
							
						}
					}  
						
								follow.html(html.join(''));
					
				}
					
				,
				error: function() {

				}



			});
				
			}).on('hide.bs.modal', function() {
				//alert('닫는다2');
			});
		
		 function followDelete(event,friendNo) {
			
		
			if(confirm("정말로 팔로우를 취소하시겠습니까?")) {

			
				
					$.ajax({

						url : contextPath + "/board1/myBoard/" + thisMemberNo + "/deleteFollow2",
						type : "get",
						dataType : "JSON",
						data: {"friendNo" : friendNo},
						success : function(result) {			
							
							
							$(event.target).parent().parent().remove();
							
							var follow_count =  parseInt($('.follow_count span').eq(1).text());
							$('.follow_count span').eq(1).text(follow_count - 1);
 
						
							
						},

						error : function(request, status, error) {

							// 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
							if (request.status == 404) {
								console.log("ajax 요청 주소가 올바르지 않습니다.");

							} else if (request.status == 500) {
								console.log("서버 내부 에러 발생");
								console.log(request.responseText);
							}

						}

					});
				}

		};

		
		
		
		
		
		
	</script>
		<jsp:include page="../main/crud-post.jsp"></jsp:include>
</body>
</html>