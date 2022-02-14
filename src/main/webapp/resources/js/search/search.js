
//const searchResult = document.getElementById("searchResult").value;

function getParam(key) {
	return new URLSearchParams(location.search).get(key);
}


// 검색값 가져오기
document.querySelector("input[name=searchResult]").value = getParam("searchResult");


//인물 클릭시
function searchMember() { // ajax 
	// 검색 val()를 가져온다
	const search = searchParam("searchResult");
	console.log(search);
	$.ajax({
		url: contextPath + "/search/member",
		data: { "search": search },
		type: "GET",
		dataType: 'JSON',
		success: function(list) {
			console.log(list);
			if (list.length == 0) {
				const templateLiterals = ` <div id="no-search-result">
											<img src="${contextPath}/resources/images/temp/search_icon.png">
											<br>
											<span>검색 결과가 없습니다.</span>
										</div>`
				postContainer.innerHTML = templateLiterals;
				return;
			}
			$("#container-post").html("");
			$.each(list, function(index, member) {
				path = contextPath + member.imgPath + member.imgNm
				console.log(path);
				if (member.CNT > 0) { //내가 팔로우한 사람인 경우
					const main = $("#container-post");
					const result = $("<div class='user-post' onclick = 'memberViewResult(" + member.memberNo + ")'>");
					const peplewrap = $(" <div class='searchboard-pr'>");
					const imgdiv = $("<div>");
					const img_ = $("<img>");
					img_.attr("src", path);
					const a = $("<a>");
					a.attr("href", contextPath + "/board1/myBoard/" + member.memberNo);
					const profdiv = $("<div>");
					const profdiv1 = $("<div>");
					const profdiv2 = $("<div>");
					const profdiv3 = $("<div>");
					const profdiv4 = $("<div>");
					const button = $("<div>");
					const button_ = $("<button id = 'flbtn' onclick = 'flInsert(event" + "," + member.memberNo + ")'>");
					a.append(img_);
					imgdiv.append(a);
					profdiv1.text("이름 : " + member.memberNm);
					profdiv2.text("닉네임 : " + member.memberNick);
					profdiv3.text("생년월일 : " + member.memberEmail);
					profdiv4.text("가입일 : " + member.enrollDt);
					profdiv.append(profdiv1);
					profdiv.append(profdiv2);
					profdiv.append(profdiv3);
					profdiv.append(profdiv4);
					button_.text("팔로잉");
					button.append(button_);
					peplewrap.append(imgdiv);
					peplewrap.append(profdiv);
					peplewrap.append(button);
					result.append(peplewrap);
					main.append(result);

					button_.css('background-color', '#942d2d');
					button_.css('color', 'white');
				} else {


					const main = $("#container-post");
					const result = $("<div class='user-post' onclick = 'memberViewResult(" + member.memberNo + ")'>");
					const peplewrap = $(" <div class='searchboard-pr'>");
					const imgdiv = $("<div>");
					const img_ = $("<img>");
					img_.attr("src", path);
					const a = $("<a>");
					a.attr("href", contextPath + "/board1/myBoard/" + member.memberNo);
					const profdiv = $("<div>");
					const profdiv1 = $("<div>");
					const profdiv2 = $("<div>");
					const profdiv3 = $("<div>");
					const profdiv4 = $("<div>");
					const profdiv5 = $("<div>");
					const button = $("<div>");
					const p = $("<p>");
					const button_ = $("<button id = 'flbtn' onclick = 'flInsert(event" + "," + member.memberNo + ")'>");
					button_.text("팔로우")
					a.append(img_);
					imgdiv.append(a);
					profdiv1.text("이름 : " + member.memberNm);
					profdiv2.text("닉네임 : " + member.memberNick);
					profdiv3.text("생년월일 : " + member.memberEmail);
					profdiv4.text("가입일 : " + member.enrollDt);
					profdiv.append(profdiv1);
					profdiv.append(profdiv2);
					profdiv.append(profdiv3);
					profdiv.append(profdiv4);
					button.append(button_);
					peplewrap.append(imgdiv);
					peplewrap.append(profdiv);
					peplewrap.append(button);
					result.append(peplewrap);
					main.append(result);

					button_.css('color', 'white');
					button_.css('background-color', '#545454');



				}






			})


		},
		error: function() {

		}
	})




};



// 팔로우 버튼 클릭시 text 요청중 으로 바꾸기 
function flInsert(event, friendNo) {
	event.stopPropagation();
	console.log($(event.target).text());
	const btn = $(event.target);
	if (btn.text() == "팔로우") {

		$.ajax({
			url: contextPath + "/search/follow",
			data: { "memberNo": memberNo, "friendNo": friendNo },

			success: function(result) {

				btn.text("팔로잉");
				btn.css('color', 'white');
				btn.css('background-color', '#942d2d');

			},
			error: function() {

			}


		});

	} else {

		$.ajax({
			url: contextPath + "/search/cancell",
			data: { "memberNo": memberNo, "friendNo": friendNo },

			success: function(result) {

				if (confirm("정말로 팔로우를 취소하시겠습니까?")) {
					
					btn.text("");
					btn.text("팔로우");
					btn.css('color', 'white');
					btn.css('background-color', '#545454');

				}
				},
				error: function() {

				}


			});


	}

};



function memberViewResult(memberNo) {
	event.stopPropagation();
	location.href = contextPath + "/board1/myBoard/" + memberNo


}


