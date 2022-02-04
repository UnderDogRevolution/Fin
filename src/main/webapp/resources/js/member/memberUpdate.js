const updateCheckObj = {
	"nickName": true,
}


const existingNickName = document.getElementById("nickInput").value;

//  닉네임 중복 검사
document.getElementById("nickInput").addEventListener("change", (e) => {
	
	const memberNickName = e.target.value;
	const regExp = /^[a-zA-Z가-힣\d]{2,20}$/;

 	if(memberNickName == existingNickName){
        updateCheckObj.nickInput = true;

	}else if (memberNickName.length == 0) { // 빈칸
		updateCheckObj.nickInput = false;

	}else if (regExp.test(memberNickName)) {

		// 유효한 경우 중복 검사
		$.ajax({

			url: "nickNameDupCheck",
			data: { "memberNickName": memberNickName },
			type: "GET",

			success: function(result) {

				console.log(result);

				if (result == 0) { // 닉네임 사용 가능

					updateCheckObj.nickInput = true;
					console.log("사용가능");

				} else { // 닉네임 중복

					updateCheckObj.nickInput = false;
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
		alert("유효하지 않은 닉네임입니다.");;
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

			return false;

		}

	}

}

//이미지 수정 부분

$(function() {
	$(".memberImg").on("click", function() {
		var index = $(".memberImg").index(this);

		$("[type=file]").eq(index).click();
	});

});


// 백업용 클론
const fileClone = {}; 


// 삭제 배열 순서
const deleteImages= [];


// 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
function loadImg(input, num) {
	// 매개변수 input == 클릭된 input 요소

	if (input.files && input.files[0]) {

		fileClone[num] = $(input).clone(); // 백업 객체에 복제본 추가
		
		// deleteImages 배열에 num값과 같은 번호가 존재하는 확인
		if(deleteImages.indexOf(num) != -1 ){ // 존재하는 경우

			// 배열.splice(시작 인덱스, 제거할 수) : 배열 내 시작 인덱스 부터 지정된 개수 만큼 요소 삭제 
			deleteImages.splice( deleteImages.indexOf(num), 1);
		} 

		var reader = new FileReader();
		reader.readAsDataURL(input.files[0]);
		reader.onload = function(e) {
			$(".memberImg").eq(num).children("img").attr("src", e.target.result);
		}


	} else{
		console.log("취소 클릭");

		//  백업해둔 복제본 리턴
		$(input).before(fileClone[num].clone());
		// -> 원본 복제본의 복제본은 만들어 삽입

		$(input).remove(); // 원본 삭제

	}
}



