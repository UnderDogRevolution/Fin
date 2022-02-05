// 입장한 채팅방 상대 회원 번호
let targetNo;
let createDate;
selectChatRoom();
// 헤더 공통 js 끝

// 클릭시 친창 보이게 하기 ㅇㄴㅁ;ㅓ리ㅏㅇ너리;ㄴㅁ라
// 친구 목록을 조회 할 수 있게 ajax 처리를 한다
// 보내야 할 것 로그인 멤버 넘버
// 조회성공시 for each 로 나타나게 해야되는데 for each 먼저 위에 써놓고 div 안에 append하게 해야되는거?
// 일단 화면을 봐야되니까 그냥 만들어지는지 확인하자

function selectChatRoom() {

	$.ajax({

		url: contextPath + "/chat/selectChatRoom",
		dataType: "JSON",
		success: function(chatList) {
			$.each(chatList, function(index, room) {

				const path = "'" + contextPath + room.img[0].imgPath + room.img[0].imgName + "'";

				const chatListWrap = $(".chatList-wrap");
				const chat = $('<div class = "chat" onclick="searchChatting(event, this,' + room.chatRoomNo + ',' + room.friendNo + ',' + path + ');">');
				const img = $('<img class="MemberImg">');
				img.attr("src", contextPath + room.img[0].imgPath + room.img[0].imgName);
				const imgdiv = $('<div class="chatMemberImg">');
				const nmdiv = $('<div class="chatMemberName">');
				const nm = $('<div>');
				const icon = $('<i class="fas fa-times" onclick = "deleteChat(event,' + room.chatRoomNo + ')">');
				icon.addClass("delete-message-room");
				imgdiv.append(img);
				nm.append(room.friendNm);
				nmdiv.append(nm);
				chat.append(imgdiv);
				chat.append(nmdiv);
				chat.append(icon);
				chatListWrap.append(chat);
				console.log(chat);
				console.log(room.chatRoomNo);
				console.log(room.chatRoomNo);


			});

		},


	});

}

// 채팅방 업로드 되면 그 채팅방 요소만 추가하기
function selectchatting(frNo, memberNo, chatRoomNo) {


	$.ajax({

		url: contextPath + "/chat/selectChatRoom",
		dataType: "JSON",
		success: function(chatList) {
			$.each(chatList, function(index, room) {

				console.log(chatRoomNo);
				console.log(room.chatRoomNo);
				if (chatRoomNo == room.chatRoomNo) {

					const chatListWrap = $(".chatList-wrap");
					const chat = $('<div class = "chat" onclick="searchChatting(event, this,' + room.chatRoomNo + ',' + room.friendNo + ')">');
					const img = $('<img class="MemberImg">');
					img.attr("src", contextPath + room.img[0].imgPath + room.img[0].imgName);
					const imgdiv = $('<div class="chatMemberImg">');
					const nmdiv = $('<div class="chatMemberName">');
					const nm = $('<div>');
					const icon = $('<i class="fas fa-times" onclick = "deleteChat(event,' + room.chatRoomNo + ')">');
					icon.addClass("delete-message-room");
					imgdiv.append(img);
					nm.append(room.friendNm);
					nmdiv.append(nm);
					chat.append(imgdiv);
					chat.append(nmdiv);
					chat.append(icon);
					chatListWrap.prepend(chat);
				}


			});

		},


	});

};



$('#MessageModal').on('show.bs.modal', function(event) {
	// 모달 열렸을 때 실행
	const content = $(".modal-content");
	const body = $("<div class = 'modal-body'>");
	content.append(body);
	$.ajax({

		url: contextPath + "/chat/searchFollower",
		dataType: "JSON",
		type: "POST",
		success: function(rList) {

			$.each(rList, function(index, fr) {
				const body = $(".modal-body");
				const frMain = $("<div class = 'friendsListMain'>");
				const imgwrap = $("<div class = 'friendsImg-wrap'>");
				const img = $("<img>");
				const namewrap = $("<div class = 'friendsName-wrap'>");
				const msgwrap = $("<div class = 'messagebtn-wrap'>");
				const btn = $("<button class = 'messagebtn2' onclick = 'goChatting(" + fr.follower + ")'>");
				btn.text("보내기");
				img.attr("src", contextPath + fr.imgPath + fr.imgNm);
				namewrap.text(fr.memberNm);
				msgwrap.append(btn);
				imgwrap.append(img);
				frMain.append(imgwrap);
				frMain.append(namewrap);
				frMain.append(msgwrap);
				body.append(frMain);
			});
		},
		error: function() {

		}



	});


}).on('hide.bs.modal', function() {
	// 모달 닫히면서 실행 초기화 시키기
	$(".modal-body").remove();
});

// 채팅방 생성
function goChatting(friendNo) {

	$.ajax({

		url: contextPath + "/chat/goChatting",
		data: { "memberNo": memberNo, "friendNo": friendNo },
		type: "POST",
		dataType: "JSON",
		success: function(result) {
			console.log(result);
			console.log(result.result);
			console.log(result.chatRoom.imgPath);
			const number = result.result;
			var chat;
			if (number > 0) {

				const path = contextPath + result.chatRoom.imgPath + result.chatRoom.imgNm
				const path1 = "'" + contextPath + result.chatRoom.imgPath + result.chatRoom.imgNm + "'";
				const chatListWrap = $(".chatList-wrap");
				chat = $('<div class = "chat" onclick="searchChatting(event, this,' + result.chatRoom.chatRoomNo + ',' + friendNo + ',' + path1 + ')">');
				const img = $('<img class="MemberImg">');
				img.attr("src", path);
				const imgdiv = $('<div class="chatMemberImg">');
				const nmdiv = $('<div class="chatMemberName">');
				const nm = $('<div>');
				const icon = $('<i class="fas fa-times" onclick = "deleteChat(event,' + result.chatRoom.chatRoomNo + ')">');
				icon.addClass("delete-message-room");
				imgdiv.append(img);
				nm.append(result.chatRoom.memberName);
				nmdiv.append(nm);
				chat.append(imgdiv);
				chat.append(nmdiv);
				chat.append(icon);
				chatListWrap.prepend(chat);
				$("#MessageModal").modal('hide');
				chat.click();
			} else {

			}
		},


		error: function() {

		}


	});


}



// 채팅 삭제 기능
function deleteChat(event, chatRoomNo) {
	event.stopPropagation();
	console.log(event.target);
	console.log(event.target.parentNode);
	console.log(chatRoomNo)
	if (confirm("채팅방을 나가시겠습니까?")) {
		$.ajax({
			url: contextPath + "/chat/delete",
			data: { "chatRoomNo": chatRoomNo, "memberNo": memberNo },
			type: "GET",

			success: function(data) {
				const Content = $(".chatContent");
				Content.remove();
				const chatwrap = $(".chatwrap");
				const chatContent = $("<div class = 'chatContent'>");
				const chatMain = $("<div class = 'chatContent-main'>");
				const icon =
					$('<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"  viewBox="0 0 24 24" version="1.1"><g id="Iconly/Bold/Send" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"><g id="Send" transform="translate(2.000000, 2.000000)" fill="#000000" fill-rule="nonzero"><path d="M19.4353768,0.581982692 C18.935172,0.0685980979 18.1948689,-0.122662829 17.5045863,0.0786644625 L1.40799658,4.759524 C0.679698425,4.96185793 0.163487095,5.54268717 0.0244301664,6.28055169 C-0.11762799,7.03150249 0.378575149,7.98478722 1.02684054,8.38341526 L6.05990101,11.4768091 C6.57611234,11.7938996 7.2423851,11.7143753 7.66955998,11.2835349 L13.4329194,5.48430225 C13.7230382,5.18231131 14.2032348,5.18231131 14.4933536,5.48430225 C14.7834723,5.77622682 14.7834723,6.24934596 14.4933536,6.5513369 L8.71999001,12.3515762 C8.29181472,12.7814099 8.21178196,13.4508232 8.52691097,13.9702476 L11.6021699,19.0537617 C11.9623174,19.6577436 12.5825713,20 13.2628498,20 C13.3428826,20 13.4329194,20 13.5129522,19.9899336 C14.2932716,19.88927 14.9135256,19.3557527 15.1436198,18.6007753 L19.9155733,2.52479106 C20.1256593,1.84027827 19.9355815,1.09536729 19.4353768,0.581982692"/>');
				const message = $('<div class = "chatMessage">');
				const messagediv1 = $('<div>');
				const messagediv2 = $('<div>');
				const messagebtn = $('<button type="button" class="btn btn-primary message_btn0" data-bs-toggle="modal" data-bs-target="#MessageModal">')
				messagediv1.html("친구와 자유롭게 채팅해보세요!")
				messagebtn.html("메세지 보내기");
				messagediv2.append(messagebtn);
				message.append(messagediv1);
				message.append(messagediv2);
				chatMain.append(icon);
				chatMain.append(message);
				chatContent.append(chatMain);
				chatwrap.append(chatContent);

			},

			error: function() {


			}
		})

		event.target.parentNode.remove();
	}

}



// 채팅방입장
function searchChatting(event, e, chatNo, frNo, path) { // 친구 클릭시 동작
	console.log(event.target)

	//event.stopPropagation();
	// 전역 변수에 현재 입장한 채팅방 상대 회원 번호 저장

	targetNo = frNo;

	//ajax 실행 시 동작
	// const chatContent = e.parentNode.parentNode.nextSibling.nextSibling.nextSibling.nextSibling;
	// chatContent
	// chatting 창부분 변환 -- chat main 선택
	$.ajax({
		url: contextPath + "/chat/join",
		data: { "chatNo": chatNo, "memberNo": memberNo, "frNo": frNo },
		type: "GET",
		dataType: "JSON", // json :js 객체 형태의 문자열
		// 응답 데이터 형식이 json 형식임을 알려주어
		// 자동으로 JS 객체로 변환을 시킬 수 있게 함
		success: function(data) {



			const msgbtn = $('<svg  onclick = "msgUp()"class = "msgbtn" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M15.379,19.1403 L12.108,12.5993 L19.467,5.2413 L15.379,19.1403 Z M4.86,8.6213 L18.76,4.5343 L11.401,11.8923 L4.86,8.6213 Z M3.359,8.0213 C2.923,8.1493 2.87,8.7443 3.276,8.9483 L11.128,12.8733 L15.053,20.7243 C15.256,21.1303 15.852,21.0773 15.98,20.6413 L20.98,3.6413 C21.091,3.2623 20.739,2.9093 20.359,3.0213 L3.359,8.0213 Z"/></svg>');
			const imgbtn = $('<svg onclick = "imgUp()"  aria-label="사진 또는 동영상 추가" class="_8-yf5 imgbtn" color="#262626" fill="#262626" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M6.549 5.013A1.557 1.557 0 108.106 6.57a1.557 1.557 0 00-1.557-1.557z" fill-rule="evenodd"></path><path d="M2 18.605l3.901-3.9a.908.908 0 011.284 0l2.807 2.806a.908.908 0 001.283 0l5.534-5.534a.908.908 0 011.283 0l3.905 3.905" fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="2"></path><path d="M18.44 2.004A3.56 3.56 0 0122 5.564h0v12.873a3.56 3.56 0 01-3.56 3.56H5.568a3.56 3.56 0 01-3.56-3.56V5.563a3.56 3.56 0 013.56-3.56z" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"></path></svg>');

			const chatRoomNo = $('<input class = "chatRoomNo" type = "hidden" value = ' + chatNo + '>');


			const chatContent = $("<div class='chatContent'>");
			const chatHeader = $("<div class=chatContent-header>")
			const chatHeader_div1 = $("<div>");/* 채팅헤더 이미지 영역 */
			const chatHeader_div2 = $("<div>"); /* 채팅헤더 네임영역 */
			const chatMemberImg = $("<img>");/* 대상이미지 */

			// 채팅창 구현하기



			const chatMain = $("<div>");/* 채팅 메인 전체 */
			const display = $("<ul id = 'chattingwrap'>"); /*대화부분 */
			const chatFooter = $("<div class='chatContent-footer'>");
			const inputChat = $(" <textarea id='inputChatting'>"); // textarea 부분
			chatMain.addClass("chatContent-main")/* 메인전체 클래스 삽입 */
			display.addClass("display-chatting")/* ul에 class 삽입 */

			// 대상 이미지 삽입
			chatHeader_div1.append(chatMemberImg);
			// 대상 이름 삽입
			chatHeader_div2.text(data.memberName)
			chatMemberImg.attr("src", path)/* 이미지주소설정 */
			console.log("맴버넘버" + memberNo);


			chatHeader.append(chatHeader_div1);
			chatHeader.append(chatHeader_div2);
			//span2.append(fileput);
			chatFooter.append(inputChat);
			chatFooter.append(msgbtn);
			chatFooter.append(imgbtn);
			chatFooter.append(chatRoomNo);

			chatMain.append(display);/* display영역 */
			chatContent.append(chatHeader);
			chatContent.append(chatMain);
			chatContent.append(chatFooter);
			$(".chatwrap").append(chatContent);




			for (let i = 0; i < data.message.length; i++) {
				if (data.message[i].memberNo == memberNo) {

					const path = contextPath + data.message[i].imgPath + data.message[i].imgName
					const p = $("<p>");
					p.html(data.message[i].message);
					const ul = $("#chattingwrap")
					const img = $("<img style = 'width: 30px; height: 30px'>");
					const div = $("<div style =  width: 40px; height : 60px; padding-left : 10px;'>")
					const divt = $("<div class = 'myChattingwrap'>");
					img.attr("src", path);
					div.append(img);
					const li = $("<li>")
					li.addClass("myChatting");
					const myMessage = $("<span class = 'myMessage'>");
					myMessage.html(p);
					const msgCreate = $("<span class = 'msgCreate'>");
					msgCreate.html(data.message[i].createDate);

					li.append(myMessage);
					li.append(msgCreate);
					divt.append(li);
					divt.append(img);
					ul.append(divt);

				} else {
					/*const divImg = $("<div class = 'chatImg'>")
					const li = $("<li>")
					const ul = $("#chattingwrap")
					const frName = $("<span class = 'frName'>");
					const frMessage = $("<span class = 'frMessage'>");
					const msgCreate = $("<span class = 'msgCreate'>");
					frName.html(data.memberName);
					msgCreate.html(data.message[i].createDate);
					li.addClass("frChatting");
					frMessage.append(divImg);
					frMessage.html(data.message[i].message);
					li.append(frName);
					li.append(frMessage);
					li.append(msgCreate);
					ul.append(frName);
					ul.append(li);*/


					const path = contextPath + data.message[i].imgPath + data.message[i].imgName
					
					const p = $("<p>");
					p.html(data.message[i].message);
					const ul = $("#chattingwrap")
					const divt = $("<div class = 'frChattingwrap'>");
					const frdiv = $("<div>");
					const li = $("<li>")
					li.addClass("frChatting");
					const img = $("<img style = 'width: 30px; height: 30px;'>");
					img.attr("src", path);
					const frName = $("<div class = 'frName'>");
					frName.html(data.memberName);

					const frMessage = $("<span class = 'frMessage'>");
					frMessage.html(p)

					const msgCreate = $("<span class = 'msgCreate'>");
					msgCreate.html(data.message[i].createDate);
					li.append(frMessage);
					li.append(msgCreate);
					frdiv.append(frName);
					frdiv.append(li);
					divt.append(img);
					divt.append(frdiv);
					ul.append(divt);

				}

			}

			$(".display-chatting").scrollTop($(".display-chatting")[0].scrollHeight);
		}, error: function() {


		}


	});


	$(".chatContent").remove();
	// 선택후 

}
// 채팅기능 엔터시 동작
// 채팅 삭제 기능



// 메세지 보내기 버튼 클릭 이것도 ajax

const fileClone = {};

// x버튼이 눌러져 삭제된 이미지 레벨을 저장할 배열
// -> 배열을 input 태그 value로 추가하면 '요소1,요소2,....'형태의 문자열로 변환됨

const deleteImages = [];




// 이미지 버튼 클릭시 동작하게 설정
function imgUp() {
	var index = $(".imgbtn").index(this);
	$("[type=file]").eq(index).val(""); // 초기화 시켜줘야 같은파일 선택가능
	$("[type=file]").eq(index).click();
}

function sendImg() {
	// 매개변수 value == 클릭된 input 요소
	const Img = document.getElementById("msgImg").files[0];
	const chatRoomNo = $(".chatRoomNo").val();
	console.log(Img);
	// 파일이 선택된 경우 true
	var reader = new FileReader();
	// 다 읽은 경우

	var form = $("#imgForm")[0];
	var data = new FormData(form);
	reader.onload = function(e) {
		//console.log(e.target.result);
		// e.target.result
		// -> 파일 읽기 동작을 성공한 객체에(fileTag) 올라간 결과(이미지 또는 파일)
		$.ajax({

			url: contextPath + "/chat/imgUp",
			data: data,
			enctype: 'multipart/form-data',
			type: "POST",
			processData: false,
			contentType: false,
			success: function(result) {
				const obj = {};
				obj.memberNo = memberNo;
				obj.memberName = memberName;
				obj.message = '<img style = "width : 250px; height : 250px;" src ="' + contextPath + result + '">';
				obj.chatRoomNo = chatRoomNo;
				obj.targetNo = targetNo;
				obj.path = myImgPath;
				obj.type = 1;

				chattingSock.send(JSON.stringify(obj));
			},


		})








	}
	reader.readAsArrayBuffer(Img);






}





// 메세지 보내기 실행
// XSS 처리함수
function XSS(message) {

	let str = message;

	str = str.replace(/&/g, "&amp;");
	str = str.replace(/</g, "&lt;");
	str = str.replace(/>/g, "&gt;");
	str = str.replace(/"/g, "&quot;");

	return str;
};






function msgUp() { //메세지 보내기
	const message = $("#inputChatting").val();
	const chatRoomNo = $(".chatRoomNo").val();
	if (message.trim().length == 0) {
		alert("내용을 입력하세요")
	} else {
		const obj = {};
		obj.memberNo = memberNo;
		obj.memberName = memberName;
		obj.message = message;
		obj.chatRoomNo = chatRoomNo;
		obj.targetNo = targetNo;
		obj.path = myImgPath;
		chattingSock.send(JSON.stringify(obj));
		$("#inputChatting").val("");
	}
};



chattingSock.onmessage = function(e) {
	// e.data : 전달받은 메세지
	// 메소드를 통해 전달받은 객체값을 JSON객체로 변환해서 obj 변수에 저장.
	console.log(JSON.parse(e.data));
	const obj = JSON.parse(e.data);
	console.log("소켓 응답 : " + obj.message);
	console.log(obj.path);
	const p = $("<p>");
	if (obj.message != undefined) {// 메세지가 있는 경우

		//let chat = XSS(obj.message);
		//chat = chat.replaceAll("\n", "<br>");
		p.html(obj.message);
		console.log(obj.message);
		$.ajax({

			url: contextPath + "/chat/updateJoinUp",
			data: { "targetNo": obj.targetNo, "chatRoomNo": obj.chatRoomNo },
			type: "POST",

			success: function(result) {

				if (result == 1) {


				} else if (result == 2) {
					if (memberNo != obj.memberNo) {
						selectchatting(obj.targetNo, obj.memberNo, obj.chatRoomNo)

					}

				}


			}
		});

	} else {// 메세지가 없는금방 초대된 상태

	}

	if (memberNo == obj.memberNo) {

		const ul = $("#chattingwrap")
		const img = $("<img style = 'width: 30px; height: 30px'>");
		const div = $("<div style =  width: 40px; height : 60px; padding-left : 10px;'>")
		const divt = $("<div class = 'myChattingwrap'>");
		img.attr("src", obj.path);
		div.append(img);
		const li = $("<li>")
		li.addClass("myChatting");
		const myMessage = $("<span class = 'myMessage'>");
		myMessage.html(p);
		const msgCreate = $("<span class = 'msgCreate'>");
		msgCreate.html(obj.createDate);

		li.append(myMessage);
		li.append(msgCreate);
		divt.append(li);
		divt.append(img);
		ul.append(divt);


	} else {
		const ul = $("#chattingwrap")
		const divt = $("<div class = 'frChattingwrap'>");
		const frdiv = $("<div>");
		const li = $("<li>")
		li.addClass("frChatting");
		const img = $("<img style = 'width: 30px; height: 30px;'>");
		img.attr("src", obj.path);
		const frName = $("<div class = 'frName'>");
		frName.html(obj.memberName);

		const frMessage = $("<span class = 'frMessage'>");
		frMessage.html(p)

		const msgCreate = $("<span class = 'msgCreate'>");
		msgCreate.html(obj.createDate);
		li.append(frMessage);
		li.append(msgCreate);
		frdiv.append(frName);
		frdiv.append(li);
		divt.append(img);
		divt.append(frdiv);
		ul.append(divt);
	}


	$(".display-chatting").scrollTop($(".display-chatting")[0].scrollHeight);
}



