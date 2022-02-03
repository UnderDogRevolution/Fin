const updateCheckObj = {
	"nickName": true,
}





// 닉네임 유효성 검사 ( + 중복 확인 )
$("#nickInput").on("input", function() {

	const memberNickName = $(this).val(); // 입력 받은 이름
	const regExp = /^[a-zA-Z가-힣\d]{2,20}$/;
	const checkNickName = $(this).next();
	const inputNickName = $(this);

	if (memberNickName.length == 0) { // 빈칸
		$(this).removeAttr("class", "unique");
		$(this).removeAttr("class", "duplication");
		checkNickName.html("");
		updateCheckObj.nickName = false;

	} else if (regExp.test(memberNickName)) {

		// 유효한 경우 중복 검사
		$.ajax({

			url: "nickNameDupCheck",
			data: { "nickInput": nickInput },
			type: "GET",

			success: function(result) {

				console.log(result);

				if (result == 0) { // 닉네임 사용 가능

					inputNickName.removeAttr("class", "duplication");
					inputNickName.addClass("unique");
					checkNickName.html(validIcon);
					updateCheckObj.nickName = true;
					console.log("사용가능");

				} else { // 닉네임 중복

					inputNickName.removeAttr("class", "unique");
					inputNickName.addClass("duplication");
					checkNickName.html(invalidIcon);
					updateCheckObj.nickName = false;
					console.log("사용불가능");

				}

			},

			error: function(request, status, error) {

				// 비동기 통신중 서버로부터 에러 응답이 돌아왔을 때 수행
				if (request.status == 404) {
					console.log("ajax 요청 주소가 올바르지 않습니다.");

				} else if (request.status == 500) {
					console.log("서버 내부 에러 발생");
					console.log(request.responseText);
				}

			},
			complete: function() {
				// (마지막에 무조건 수행)

				console.log("complete 수행");
			}

		});



	} else { // 유효하지 않은 경우
		checkNickName.html(invalidIcon);
		updateCheckObj.nickName = false;
	}
});


function memberUpdateValidate() {

	for (key in updateCheckObj) {

		if (!updateCheckObj[key]) {

			let message;

			switch (key) {
				case "nickName": message = "닉네임이 유효하지 않습니다."; break;
			}

			alert(message);

			document.getElementById(key).focus();

			return false; // submit 이벤트 제거

		}

	}

}





