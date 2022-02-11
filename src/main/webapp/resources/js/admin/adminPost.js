

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

	} else if (searchPost == "memberNm") {
		$("#searchPost").attr('type', 'text');

	} else if (searchPost == "status") {
		$("#searchPost").attr('type', 'text');

	}


})



function selectPostList(cp) {//검색

	if (cp == undefined) {
		cp = 1;
	}

	const searchPost = $(".selectPostsend").val(); // select 값
	const inputResult = $("#searchPost").val(); //input 값

	console.log(inputResult)

	$.ajax({
		url: contextPath + "/admin/searchPost",
		data: { "searchPost": searchPost, "inputResult": inputResult, "cp": cp },
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
				const td1 = $('<td class="postModalShow" onclick= "postModal(' + post.postNo + ')">');
				const td2 = $("<td>");
				const td3 = $("<td>");
				const td4 = $("<td class = 'postContent'>");
				const td5 = $("<td>");
				const td6 = $("<td>");
				const td7 = $("<td>");
				const td8 = $("<td>");
				const td9 = $("<td>");
				const a2 = $('<a style="text-decoration: none; color: white;"'
					+ 'href="' + contextPath + '/board1/myBoard/' + post.memberNo + '">' + post.memberNm + '</a>')
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

					select.append(option)
				}

				$(select).on('focus', function() {
					path = this.value;
					console.log(path);
				});


				$(td1).text(post.postNo);
				$(td2).text(post.memberNo);
				$(td3).append(a2);
				$(td4).append(a);
				$(td5).append(post.likeCount)
				$(td6).text(post.createDt);
				$(td7).text(post.modifyDt);
				$(td8).append(select);

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

				const li1 = $('<li class="page-link" onclick = "selectPostList(1)">&lt;&lt;</li>')
				const li2 = $('<li class="page-link" onclick = "selectPostList('+pagination.prevPage+')">&lt;</li>');

				$(".pagination").append(li1);
				$(".pagination").append(li2);
			}
			for (let i = pagination.startPage; i <= pagination.endPage; i++) {

				if (i == pagination.currentPage) {
					li = $('<li class="page-link" style="color: black; font-weight: bold;"> ' + i + '</li>');
					$(".pagination").append(li);
				} else {
					li = $('<li class="page-link" onclick = selectPostList(' + i + ')>' + i + '</li>');
					$(".pagination").append(li);
				}

			};

			if (pagination.endPage != pagination.maxPage) {

				const li1 = $('<li  onclick = "selectPostList('+pagination.nextPage+')" class="page-link" >&gt;</li>');
				const li2 = $('<li onclick = "selectPostList('+pagination.maxPage+')" class="page-link">&gt;&gt;</li>');
				//li1.addClass("page-link");
				//li2.addClass("page-link");
				$(".pagination").append(li1);
				$(".pagination").append(li2);
			}


		},
		error: function() {


		}





	});

}

function postModal(postNo) {
	$("#postModal").modal("show");
	$(".postListContent").html("");

	$.ajax({
		url: contextPath + "/admin/postView",
		data: { "postNo": postNo },
		dataType: "JSON",
		

		success: function(post) {
			
			console.log(post.blind);
			const a2 = $('<a style="text-decoration: none; color: white;"'
				+ 'href="' + contextPath + '/board1/myBoard/' + post.memberNo + '">' + post.memberNm + '</a>')
			const a = $('<a style="text-decoration: none; color: white;"'
				+ 'href="' + contextPath + '/post/view/' + post.postNo + '">' + post.postContent + '</a>')
			const select = $('<select  name="statusCd"  class="select"></select>');
			select.attr("onchange", "changeStatus(event," + post.postNo + ")");
			for (let i = 500; i < 505; i++) {
				const option = $("<option>");
				option.val(i);
				if (i == post.status) {
					option.attr("selected", "selected")
				}
				if (i == 500) {
					option.text("일반")
					option.val("500");
				} else if (i == 501) {
					option.text("유저삭제")
					option.val("501");
				} else if (i == 502) {
					option.text("블라인드")
					option.val("502");
				} else if (i == 503) {
					option.text("비공개")
					option.val("503");
				} else if (i == 504) {
					option.text("팔로워 공유")
					option.val("504");
				}
				select.append(option);
			}
			select.on('focus', function() {
				path = this.value;
				console.log(path);
			})

			$($(".postListContent")[0]).html(post.postNo);
			$($(".postListContent")[1]).html(post.memberNo);
			$($(".postListContent")[2]).append(a2);
			$($(".postListContent")[3]).append(a);
			$($(".postListContent")[4]).html(post.likeCount);
			$($(".postListContent")[5]).html(post.createDt);
			$($(".postListContent")[6]).html(post.modifyDt);
			$($(".postListContent")[7]).append(select);
			$($(".postListContent")[8]).html(post.blind);








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



function changeStatus(event, postNo) {

	const status = $(event.target).val();

	console.log(postNo, status);
	const e = $(event.target);
	if (status == 502) {
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

		url: contextPath + "/admin/changeStatus",
		data: { "postNo": postNo, "status": status, "blind": blind },

		success: function() {
			alert("변경되었습니다.")
			if (blind != null) {
				$($(".postListContent")[8]).html(blind);



			}
			$($(".postListContent")[8]).html("");

		},



	});

};







