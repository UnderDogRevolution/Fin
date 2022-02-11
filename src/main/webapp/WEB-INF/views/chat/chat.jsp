<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>myChat</title>
<link rel="stylesheet" href="${contextPath}/resources/css/chat/chat.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/main/crud-post.css">
</head>
<body>
	<jsp:include page="../main/crud-post.jsp"></jsp:include>


	<div class="mainContainer">

		<main>


			<!-- 채팅영역 -->
			<div class="chatwrap">
				<!-- 채팅창전체 -->
				<div class="chatMember">

					<!-- 채팅멤버영역 -->
					<div class="MemberName-wrap">
						<div style="width: 30%; height: 100%">
							<img
								src="${contextPath}${loginMember.profileImage.imgPath}${loginMember.profileImage.imgName}">
						</div>

						<div class="MemberName">
							<!-- 사용자 닉네임 -->
							${loginMember.memberName}
						</div>
						<!--  <i class="fas fa-comment-dots" data-bs-toggle="modal" data-bs-target="#MessageModal"></i> -->
						<svg data-bs-toggle="modal" data-bs-target="#MessageModal"
							xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24"
							version="1.1">
                            <g id="Iconly/Bold/Send" stroke="none"
								stroke-width="1" fill="none" fill-rule="evenodd">
                                <g id="Send"
								transform="translate(2.000000, 2.000000)" fill="#000000"
								fill-rule="nonzero">
                                    <path
								d="M19.4353768,0.581982692 C18.935172,0.0685980979 18.1948689,-0.122662829 17.5045863,0.0786644625 L1.40799658,4.759524 C0.679698425,4.96185793 0.163487095,5.54268717 0.0244301664,6.28055169 C-0.11762799,7.03150249 0.378575149,7.98478722 1.02684054,8.38341526 L6.05990101,11.4768091 C6.57611234,11.7938996 7.2423851,11.7143753 7.66955998,11.2835349 L13.4329194,5.48430225 C13.7230382,5.18231131 14.2032348,5.18231131 14.4933536,5.48430225 C14.7834723,5.77622682 14.7834723,6.24934596 14.4933536,6.5513369 L8.71999001,12.3515762 C8.29181472,12.7814099 8.21178196,13.4508232 8.52691097,13.9702476 L11.6021699,19.0537617 C11.9623174,19.6577436 12.5825713,20 13.2628498,20 C13.3428826,20 13.4329194,20 13.5129522,19.9899336 C14.2932716,19.88927 14.9135256,19.3557527 15.1436198,18.6007753 L19.9155733,2.52479106 C20.1256593,1.84027827 19.9355815,1.09536729 19.4353768,0.581982692" />
                                </g>
                            </g>
                        </svg>

					</div>
					<div class="chatList-wrap">
						<!--보낸대상 영역 -->

						<%-- 		<c:choose>
						
							조회된 게시글 목록이 없을 때
							<c:when test="${empty chatRoomList }">
								<tr>
									<td colspan="4">존재하는 채팅방이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="chatRoom" items="${chatRoomList}">
                        <div class="chat" onclick="searchChatting(this,${chatRoom.chatRoomNo},${chatRoom.friendNo});">
                            <!-- for each 문 이용  -->
                            <!-- 채팅 -->
                            <div class="chatMemberImg">
                                <!-- 상대 이미지영역 -->
                                <img class="MemberImg" src="img/user.png" alt="">
                            </div>

                            <!--상대 이름 영역 -->
                            <div class="chatMemberName">
                                <div>
                                    ${chatRoom.friendNm}
                                </div>
                            </div>
                            <!-- x아이콘 -->
                            <i class="fas fa-times delete-message-room"></i>
                            <input type = "hidden" value = "${chatRoom.chatRoomNo}">
                        </div><!-- 채팅끝 -->
                        
                        <input  type="hidden" value="${chatRoom.friendNo}"><!-- 친구회원번호 -->
                        
								</c:forEach>
							</c:otherwise>
						</c:choose> --%>







					</div>
					<!-- 보낸대상 영역 끝 -->

				</div>
				<!-- 채팅창 헤더 -->
				<div class="chatContent">

					<!-- 채팅창 메인 -->
					<div class="chatContent-main">
						<svg xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24"
							version="1.1">
                            <g id="Iconly/Bold/Send" stroke="none"
								stroke-width="1" fill="none" fill-rule="evenodd">
                                <g id="Send"
								transform="translate(2.000000, 2.000000)" fill="#000000"
								fill-rule="nonzero">
                                    <path
								d="M19.4353768,0.581982692 C18.935172,0.0685980979 18.1948689,-0.122662829 17.5045863,0.0786644625 L1.40799658,4.759524 C0.679698425,4.96185793 0.163487095,5.54268717 0.0244301664,6.28055169 C-0.11762799,7.03150249 0.378575149,7.98478722 1.02684054,8.38341526 L6.05990101,11.4768091 C6.57611234,11.7938996 7.2423851,11.7143753 7.66955998,11.2835349 L13.4329194,5.48430225 C13.7230382,5.18231131 14.2032348,5.18231131 14.4933536,5.48430225 C14.7834723,5.77622682 14.7834723,6.24934596 14.4933536,6.5513369 L8.71999001,12.3515762 C8.29181472,12.7814099 8.21178196,13.4508232 8.52691097,13.9702476 L11.6021699,19.0537617 C11.9623174,19.6577436 12.5825713,20 13.2628498,20 C13.3428826,20 13.4329194,20 13.5129522,19.9899336 C14.2932716,19.88927 14.9135256,19.3557527 15.1436198,18.6007753 L19.9155733,2.52479106 C20.1256593,1.84027827 19.9355815,1.09536729 19.4353768,0.581982692" />
                                </g>
                            </g>
                        </svg>

						<div class="chatMessage">
							<div>친구와 자유롭게 채팅해보세요!</div>
							<div>
								<button type="button" class="btn btn-primary message_btn0"
									data-bs-toggle="modal" data-bs-target="#MessageModal">
									메세지 보내기</button>

							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>

	<!-- 이미지 파일 보내기-->
	<div class="fileinput">
		<form action="input" enctype="multipart/form-ata" id="imgForm">

			<input type="file" name="images" id="msgImg"
				onchange="sendImg(this,0)">
		</form>
	</div>




	<!-- 모달 -->
	<div class="modal fade" id="MessageModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered "
			style="max-width: inherit">
			<div class="modal-content">
				<div class="modal-header friendsListheader" style="position: relative;">
					친구 목록
					<div class="x-box">
						<i class="fas fa-times" data-bs-dismiss="modal" aria-label="Close"></i>
						<!-- x아이콘 -->
					
					</div>
					<div>
						<input id="searchpr" class="searchVal" type="text" name = "inputResult">
					</div>
					<svg onclick = "searchMember()" aria-label="새로운 게시물" class="_8-yf5 " color="white"
						fill="#262626" height="24" role="img" viewBox="0 0 24 24"
						width="24" style="position: absolute; right: 20px; cursor: pointer; bottom: 10px;">
						<path
							d="M2 12v3.45c0 2.849.698 4.005 1.606 4.944.94.909 2.098 1.608 4.946 1.608h6.896c2.848 0 4.006-.7 4.946-1.608C21.302 19.455 22 18.3 22 15.45V8.552c0-2.849-.698-4.006-1.606-4.945C19.454 2.7 18.296 2 15.448 2H8.552c-2.848 0-4.006.699-4.946 1.607C2.698 4.547 2 5.703 2 8.552z"
							fill="none" stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2"></path>
						<line fill="none" stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2" x1="6.545" x2="17.455"
							y1="12.001" y2="12.001"></line>
						<line fill="none" stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2" x1="12.003" x2="12.003"
							y1="6.545" y2="17.455"></line></svg>
				</div>
				<!--       <div class="modal-body">
               
               
                    <div class="friendsListMain">
                        친구창
                        <div class="friendsImg-wrap">
                            <img src="img/user.png" alt="">친구이미지
                        </div>
                        <div class="friendsName-wrap">
                            친구이름
                            usero1
                        </div>
                        <div class="messagebtn-wrap">
                            버튼영역
                            <button class="messagebtn2">보내기</button>
                        </div>
                    </div>

                </div>바디 끝부분   -->
				<!--web소켓과 비슷한 js 라이브러리
	 -->
				<script
					src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

				<script>
					// 로그인이 되어 있을 경우에만
					let chattingSock = new SockJS(
							"<c:url value='/chat/mychat' />");
					// contextPath + /chat

					const memberNo = "${loginMember.memberNo}";
					const memberNickName = "${loginMember.memberNickName}";
					const memberName = "${loginMember.memberName}";
					const contextPath = "${contextPath}";
					const myImgPath = "${contextPath}${loginMember.profileImage.imgPath}${loginMember.profileImage.imgName}";
				</script>

				<script src="${contextPath}/resources/js/chat/chat.js"></script>
</body>

</html>