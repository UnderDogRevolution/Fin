function getParam(key) {
	return new URLSearchParams(location.search).get(key)
}


let li;
let blind;
let path = $(".select").val();
function changeStatus(event, postNo) {

	const status = $(".select").val();

	console.log(postNo, status);
	const e = $(event.target);
	if (status == 502) {
		blind = prompt("사유를 입력해주세요");
		if (blind == null) {
			$(event.target).val(path), prop("selected", true);
			return false;
		} else if (blind.trim().length == 0) {
			alert("블라인드 사유를 입력해주세요")
			$(event.target).val(path), prop("selected", true);
			return false;
		};
	} else {

	}

	$.ajax({

		url: contextPath + "/admin/changeStatus",
		data: { "postNo": postNo, "status": status, "blind": blind },

		success: function() {
			alert("값 넘김 성공")
		},



	});

};
$(".selectPostsend").on("change", function() {
	const searchPost = $(".selectPostsend").val(); // select 값
	if (searchPost == "memberNo") {
		$("#searchPost").attr('type', 'number');
	} else if (searchPost == "postNo") {
		$("#searchPost").attr('type', 'number');

	} else if (searchPost == "memberNm") {
		$("#searchPost").attr('type', 'text');

	} else if (searchPost == "status") {
		$("#searchPost").attr('type', 'text');

	}


})



function selectPostList(cp) {//검색

	if(cp == undefined){
		cp = 1;
	}

	const searchPost = $(".selectPostsend").val(); // select 값
	const inputResult = $("#searchPost").val(); //input 값
	
	console.log(inputResult)

	$.ajax({
		url: contextPath + "/admin/searchPost",
		data: { "searchPost": searchPost, "inputResult": inputResult, "cp" : cp },
		dataType: "JSON",

		success: function(map) {

			$(".tbody").html("");
			$(".pagination").html("");

			console.log(map.List);
			if (map.List.length == 0) {
				$(".tbody").html("<tr><td colspan='9'>등록된게시글이 존재하지 않습니다.</td></tr>")
			};


			$.each(map.List, function(index, post) {
				const body = $(".tbody");
				const tr = $("<tr>");
				const td1 = $("<td>");
				const td2 = $("<td>");
				const td3 = $("<td>");
				const td4 = $("<td class = 'postContent'>");
				const td5 = $("<td>");
				const td6 = $("<td>");
				const td7 = $("<td>");
				const td8 = $("<td>");
				const td9 = $("<td>");
				td9.append("")
				const a = $('<a style="text-decoration: none; color: white;"'
					+ 'href="' + contextPath + '/post/view/' + post.postNo + '">' + post.postContent + '</a>')
				const select = $('<select  name="statusCd"  class="select"></select>');
				select.attr("onchange", "changeStatus(event," + post.postNo + ")");
				console.log(select);
				for (let i = 500; i < 505; i++) {
					const option = $("<option>");
					option.val(i);
					if (i == post.status) {
						option.attr("selected", "selected")
					}
					if (i == 500) {
						option.text("일반")
					} else if (i == 501) {
						option.text("유저삭제")
					} else if (i == 502) {
						option.text("블라인드")
					} else if (i == 503) {
						option.text("비공개")
					} else if (i == 504) {
						option.text("팔로워 공유")
					}
					select.append(option);
				}

				console.log(post.postNo);
				$(td1).text(post.postNo);
				$(td2).text(post.memberNo);
				$(td3).text(post.memberNm);
				$(td4).append(a);
				$(td5).text(post.readCount);
				$(td6).text(post.likeCount);
				$(td7).text(post.createDt);
				$(td8).text(post.modifyDt);
				$(td9).append(select);

				tr.append(td1)
				tr.append(td2)
				tr.append(td3)
				tr.append(td4)
				tr.append(td5)
				tr.append(td6)
				tr.append(td7)
				tr.append(td8)
				tr.append(td9)
				body.append(tr);
			});
			const pagination = map.pagination;
			
			if (pagination.startPage != 1) {

				const li1 = $('<li class="page-link" onclick = "selectPostList()">&lt;&lt;</li>')
				const li2 = $('<li class="page-link" onclick = "selectPostList()>&lt;</li>');

				$(".pagination").append(li1);
				$(".pagination").append(li2);
			}
			for (let i = pagination.startPage; i < pagination.endPage; i++) {

				if (i == pagination.currentPage) {
					li = $('<li class="page-link" style="color: black; font-weight: bold;"> '+ i + '</li>');
				$(".pagination").append(li);
				} else {
					li = $('<li class="page-link" onclick = selectPostList('+i+')>'+i+'</li>');
					$(".pagination").append(li);
				}

			};

			if (pagination.endPage != pagination.maxPage) {

				const li1 = $('	<li class="page-link"> &gt;/li>');
				const li2 = $('<li class="page-link">&gt;&gt;</li>');

				$(".pagination").append(li1);
				$(".pagination").append(li2);
			}


		},
		error: function() {


		}





	});

}

