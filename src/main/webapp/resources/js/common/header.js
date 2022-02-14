//헤더 부분
$(".noticewrap").on("click", function(e) {

	if ($('.notice_box').hasClass("show")) {

		$('.notice_box').slideUp(200);
		$('.notice_box').removeClass("show");

	} else {

		$(".notice_box").slideDown(200);
		$(".notice_box").addClass("show");

		var html = [];
		var notice_box = $(".notice_box");
		$.ajax({

			url: contextPath + "/selectAlram",
			type: "get",
			dataType: "JSON",

			success: function(list) {


				console.log("===================================");
				console.log("===================================");
				console.log(list);
				if (list.length > 0) {

					for (var i = 0; i < list.length; i++) {


						html.push(
							
							'<div class="noticeList noticeList' + i + '" data-alram-no="' + list[i].alramNo + '" data-alram-url="'+list[i].alramUrl+'" >' +
							'<div class="img-profile" style="background: url('+contextPath+list[i].profileImage.imgPath + list[i].profileImage.imgName + '); background-size: cover"></div>' +
							'<div class="reply-comment-wrap">' +
							'<span>' + list[i].alramContent + '</span>' +
							'</div>' +

							'</div>'
						);

					}

					notice_box.html(html.join(''));
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

			}

		});




	}
});
$(".namewrap").on("click", function(e) {

	if ($('.myclick').hasClass("show")) {

		$('.myclick').slideUp(200);
		$('.myclick').removeClass("show");

	} else {

		$(".myclick").slideDown(200);
		$(".myclick").addClass("show");

	}
});

$(".boardwrap").on("click", function(e) {

	if ($('.boardMenu').hasClass("show")) {

		$('.boardMenu').slideUp(200);
		$('.boardMenu').removeClass("show");

	} else {

		$(".boardMenu").slideDown(200);
		$(".boardMenu").addClass("show");

	}
});

$("#searchbtn").on("click", function() {
	const result = $("#searchResult").val();
	if (result.trim().length == 0) {
		alert("검색어를 입력해주세요");
	} else {
		$("#search-form").submit();
	}

});


window.onclick = function(event) {
	if (!(event.target.matches('.noticewrap') || event.target.matches('.notice_box'))) {

		$('.notice_box').slideUp(200);
		$('.notice_box').removeClass("show");
	}
	if (!(event.target.matches('.namewrap') || event.target.matches('.myclick') || event.target.matches('.myImg'))) {
		$('.myclick').slideUp(200);
		$('.myclick').removeClass("show");
	}

	if (!(event.target.matches('.boardwrap') || event.target.matches('.boardMenu'))) {
		$('.boardMenu').slideUp(200);
		$('.boardMenu').removeClass("show");
	}



}

$(document).on("click", ".noticeList", function() {

	var alramNo = $(this).data("alram-no");
	var alramUrl = $(this).data("alram-url");
	
	

	$.ajax({

		url: contextPath + "/deleteAlram",
		type: "post",
		data: { "deleteAlramNo": alramNo },
		success: function(result){
			
			if(result > 0){
				
			location.href = alramUrl;
				
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

		}




	});

	// var mode = $(this).data('mode');








});
