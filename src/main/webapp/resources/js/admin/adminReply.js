function getParam(key) {
	return new URLSearchParams(location.search).get(key)
}


let li;
let blind;
let path;



$(".selectPostsend").on("change", function() {
	const searchPost = $(".selectPostsend").val(); // select 값
	$("#searchPost").val("");
	
	if (searchPost == "memberNo") {
		$("#searchPost").attr('type', 'number');
	} else if (searchPost == "postNo") {
		$("#searchPost").attr('type', 'number');

	} else if (searchPost == "replyNo") {
		$("#searchPost").attr('type', 'number');

	} else if (searchPost == "status") {
		$("#searchPost").attr('type', 'text');

	}else if (searchPost == "memberNm") {
		$("#searchPost").attr('type', 'text');

	}

})



function selectReplyList(cp) {//검색

	if (cp == undefined) {
		cp = 1;
	}

	const searchPost = $(".selectPostsend").val(); // select 값
	const inputResult = $("#searchPost").val(); //input 값

	console.log(inputResult)

	$.ajax({
		url: contextPath + "/admin/searchReply",
		data: { "searchPost": searchPost, "inputResult": inputResult, "cp": cp },
		dataType: "JSON",

		success: function(map) {

			$(".tbody").html("");
			$(".pagination").html("");

			console.log(map.List);
			if (map.List.length == 0) {
				$(".tbody").html("<tr><td colspan='8'>등록된게시글이 존재하지 않습니다.</td></tr>")

			};


			$.each(map.List, function(index, reply) {
				const body = $(".tbody");
				const tr = $("<tr>");
				const td1 = $('<td class="postModalShow" onclick= "postModal(' + reply.replyNo + ')">');
				const td2 = $("<td>");
				const td3 = $("<td>");
				const td4 = $("<td>");
				const td5 = $("<td class = 'replyContent'>");
				const td6 = $("<td>");
				const td7 = $("<td>");
				const td8 = $("<td>");
				const a = $('<a style="text-decoration: none; color: white;"'
					+ 'href="' + contextPath + '/post/view/' + reply.postNo + '">' + reply.replyContent + '</a>')
				
				const a2 = $('<a style="text-decoration: none; color: white;"'
					+ 'href="' + contextPath + '/board1/myBoard/' + reply.memberNo + '">' + reply.memberNm + '</a>')
				
				
				
				const select = $('<select  name="statusCd"  class="select"></select>');
				select.attr("onchange", "changeStatus(event," + reply.replyNo + ")");
				console.log(select);
				for (let i = 600; i < 603; i++) {
					const option = $("<option>");
					option.val(i);

					if (i == reply.status) {
						option.attr("selected", "selected")
					}
					if (i == 600) {
						option.text("일반")
					} else if (i == 601) {
						option.text("삭제")
					} else if (i == 602) {
						option.text("블라인드")
					} 

					select.append(option)
				}

				$(select).on('focus', function() {
					path = this.value;
				});


				$(td1).text(reply.replyNo);
				$(td2).text(reply.postNo);
				$(td3).text(reply.memberNo);
				$(td4).append(a2);
				$(td5).append(a);
				$(td6).text(reply.likeCount);
				$(td7).text(reply.createDt);
				$(td8).append(select);

				tr.append(td1)
				tr.append(td2)
				tr.append(td3)
				tr.append(td4)
				tr.append(td5)
				tr.append(td6)
				tr.append(td7)
				tr.append(td8)
				body.append(tr);
			});
			const pagination = map.pagination;

			if (pagination.startPage != 1) {

				const li1 = $('<li class="page-link" onclick = "selectReplyList(cp)">&lt;&lt;</li>')
				const li2 = $('<li class="page-link" onclick = "selectReplyList(cp)>&lt;</li>');

				$(".pagination").append(li1);
				$(".pagination").append(li2);
			}
			for (let i = pagination.startPage; i <= pagination.endPage; i++) {

				if (i == pagination.currentPage) {
					li = $('<li class="page-link" style="color: black; font-weight: bold;"> ' + i + '</li>');
					$(".pagination").append(li);
				} else {
					li = $('<li class="page-link" onclick = selectReplyList(' + i + ')>' + i + '</li>');
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

function postModal(replyNo) {
	$("#postModal").modal("show");
	$(".postListContent").html("");

	$.ajax({
		url: contextPath + "/admin/replyView",
		data: { "replyNo": replyNo },
		dataType: "JSON",


		success: function(reply) {
			const a2 = $('<a style="text-decoration: none; color: white;"'
					+ 'href="' + contextPath + '/board1/myBoard/' + reply.memberNo + '">' + reply.memberNm + '</a>')
			const a = $('<a style="text-decoration: none; color: white;"'
				+ 'href="' + contextPath + '/post/view/' + reply.postNo + '">' + reply.replyContent + '</a>')
			const select = $('<select  name="statusCd"  class="select"></select>');
			select.attr("onchange", "changeStatus(event," + reply.replyNo + ")");
			for (let i = 600; i < 603; i++) {
				const option = $("<option>");
				option.val(i);
				if (i == reply.status) {
					option.attr("selected", "selected")
				}
				if (i == 600) {
					option.text("일반")
					option.val("600");
				} else if (i == 601) {
					option.text("삭제")
					option.val("601");
				} else if (i == 602) {
					option.text("블라인드")
					option.val("602");
				} 
				select.append(option);
			}
			select.on('focus', function() {
				path = this.value;
				console.log(path);
			})

			$($(".postListContent")[0]).html(reply.replyNo);
			$($(".postListContent")[1]).html(reply.postNo);
			$($(".postListContent")[2]).html(reply.memberNo);
			$($(".postListContent")[3]).append(a2);
			$($(".postListContent")[4]).append(a);
			$($(".postListContent")[5]).html(reply.likeCount);
			$($(".postListContent")[6]).html(reply.createDt);
			$($(".postListContent")[7]).append(select);
			$($(".postListContent")[8]).html(reply.blind);











		},
		error: function() {


		}


	});


}

/*$(document).on('change','.select',function(){
	}) 
*/

$(".select").on('focus', function() {
	path = this.value;
	console.log(path);
})



function changeStatus(event, replyNo) {
	console.log(path);

	const status = $(event.target).val();

	console.log(replyNo, status);
	const e = $(event.target);
	if (status == 602) {
		blind = prompt("사유를 입력해주세요");
		if (blind == null) {
			$(event.target).val(path).prop("selected", true);
			return false;
		} else if (blind.trim().length == 0) {
			alert("블라인드 사유를 입력해주세요")
			$(event.target).val(path).prop("selected", true);
			return false;
		}
		;
	} else if (status == path) {
		return false;
	}

	$.ajax({

		url: contextPath + "/admin/changeStatusReply",
		data: { "replyNo": replyNo, "status": status, "blind": blind },

		success: function() {
			alert("변경되었습니다.");
			$($(".postListContent")[8]).html("");
			if(blind != null){
			$($(".postListContent")[8]).html(blind);
				
			}
		
		},



	});

};
