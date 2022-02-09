console.log("postView")
//게시글 좋아요
const whitePopcorn = document.getElementsByClassName("white-popcorn");
const vividPopcorn = document.getElementsByClassName("vivid-popcorn");

for (const items of whitePopcorn) {
    items.addEventListener("click", function () {
        if(typeof memberNo == "undefined"){
            alert("로그인해주세요")
            return;
        }
        const postNo = this.nextElementSibling.innerText;
        let count = this.nextElementSibling.nextElementSibling;
        $.ajax({
            url: contextPath + "/post/insertLike",
            data: { "postNo": postNo },
            type: "POST",
            async: false,
            success: function (result) {
                if(result >0){
                    items.style.display = "none";
                    items.previousElementSibling.style.display = "block";
                    count.innerText = Number(count.innerText)+1;
                }else{
                    alert("좋아요 기능에 오류가 발생했습니다.")
                }

            },
            error: function (req, status, error) {
                console.log("ajax 실패");
                console.log(req.responseText);
                console.log(status);
                console.log(error);
            }

        })
    })
}
for(const items of vividPopcorn){
    items.addEventListener("click", function(){
        if(typeof memberNo == "undefined"){
            alert("로그인해주세요")
            return;
        }
        const postNo = this.nextElementSibling.nextElementSibling.innerText;
        let count = this.nextElementSibling.nextElementSibling.nextElementSibling;
        $.ajax({ 
            url: contextPath + "/post/deleteLike",
            data : {"postNo": postNo},
            type: "POST",
            async: false,
            success: function (result) {
                if(result>0){
                    items.style.display = "none";
                    items.nextElementSibling.style.display = "block";
                    count.innerText = Number(count.innerText)-1;
                }else{
                    alert("좋아요 연속 클릭으로 오류가 발생했습니다.")
                }
            },
            error: function (req, status, error) {
                console.log("ajax 실패");
                console.log(req.responseText);
                console.log(status);
                console.log(error);
            }
    
        })
    })
}

function deletePost(e){
	const post = e.parentNode.parentNode.parentNode.parentNode.parentNode;
	const postNo = post.querySelectorAll(".container-like >span ")[0].innerText;
	if(confirm("정말로 삭제 하시겠습니까?")){
		$.ajax({
			url: contextPath + "/post/deletePost",
			data: { "postNo": postNo},
			type: "POST",
			async: false,
			success: function (result) {
				if(result>0){
					alert("게시글이 삭제 되었습니다.")
					revealPost()

				}else{
					alert("게시글 삭제 중 문제가 발생했습니다.")
				}
			},
			error: function (req, status, error) {
				console.log("ajax 실패");
				console.log(req.responseText);
				console.log(status);
				console.log(error);
			}
	
		})
	}
}

function deletePost(e){
	const post = e.parentNode.parentNode.parentNode.parentNode.parentNode;
	const postNo = post.querySelectorAll(".container-like >span ")[0].innerText;
	if(confirm("정말로 삭제 하시겠습니까?")){
		$.ajax({
			url: contextPath + "/post/deletePost",
			data: { "postNo": postNo},
			type: "POST",
			async: false,
			success: function (result) {
				if(result>0){
					alert("게시글이 삭제 되었습니다.")
                    location.href = contextPath +"/main";

				}else{
					alert("게시글 삭제 중 문제가 발생했습니다.")
				}
			},
			error: function (req, status, error) {
				console.log("ajax 실패");
				console.log(req.responseText);
				console.log(status);
				console.log(error);
			}
	
		})
	}
}

function insertReply(e){
	console
	if(typeof memberNo == "undefined" || memberNo == ""){
        alert("로그인 해주세요!")
        return;
    }
	const post = e.parentNode.parentNode.parentNode
	const postNo = post.querySelectorAll(".container-like >span ")[0].innerText;
	const replyContent = e.parentNode.parentNode.getElementsByTagName("input")[0].value
	if(replyContent.trim().length>0){
		$.ajax({ 
			url: contextPath + "/reply/insert",
			data: { "postNo": postNo, "replyContent" : replyContent},
			type: "POST",
			async: false,
			success: function (result) {
				if(result>0){
					alert("댓글이 등록되었습니다.")
					const reply = document.getElementsByClassName("reply")[0];
					reply.remove()
                    post.append(selectReply(postNo));
					const replyVividImg = document.getElementsByClassName("reply-vivid");
					const replywhiteImg = document.getElementsByClassName("reply-white");
					replyLike(replyVividImg, replywhiteImg);

				}else{
					alert("댓글 등록 중 문제가 발생했습니다.")
				}
			},
			error: function (req, status, error) {
				console.log("ajax 실패");
				console.log(req.responseText);
				console.log(status);
				console.log(error);
			}
	
		})
	}
}



function comment(e, replyNo){
	
	const post = e.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
	const arr = post.querySelectorAll(".input-content-reply > div")
	const img = post.querySelectorAll(".input-content-reply img")[0]
	const input = post.querySelectorAll(".input-content-reply input")[0]
	if(arr[0].innerText.trim() == "댓글"){
		arr[0].innerText = "답글";
		input.setAttribute("placeholder", "답글을 달아주세요!");
		input.focus();
	}
	img.setAttribute("onclick", "insertComment(this,"+replyNo+")")
}

function insertComment(e, replyNo){
	const post = e.parentNode.parentNode.parentNode
	const postNo = post.querySelectorAll(".container-like >span ")[0].innerText;
	const replyContent = e.parentNode.parentNode.getElementsByTagName("input")[0].value
	if(replyContent.trim().length>0){
		$.ajax({ 
			url: contextPath + "/reply/comment",
			data: { "postNo": postNo, "replyContent" : replyContent, "parentReply" : replyNo},
			type: "POST",
			async: false,
			success: function (result) {
				if(result>0){
					alert("답글이 등록되었습니다.")
					const reply = document.getElementsByClassName("reply")[0];
					reply.remove()
                    post.append(selectReply(postNo));
					const replyVividImg = document.getElementsByClassName("reply-vivid");
					const replywhiteImg = document.getElementsByClassName("reply-white");
					replyLike(replyVividImg, replywhiteImg);
				}else{
					alert("답글 등록 중 문제가 발생했습니다.")
				}
			},
			error: function (req, status, error) {
				console.log("ajax 실패");
				console.log(req.responseText);
				console.log(status);
				console.log(error);
			}
	
		})
	}
};

function reformReply(){
    const arr = document.querySelectorAll(".input-content-reply > div")
    const img = document.querySelectorAll(".input-content-reply img")[0]
    const input = document.querySelectorAll(".input-content-reply input")[0]
    if(arr[0].innerText.trim() == "답글"){
        arr[0].innerText = "댓글";
        img.setAttribute("onclick", "insertReply(this)")
        input.setAttribute("placeholder", "댓글을 달아주세요!");
    }
}

function deleteReply(e, replyNo) { // 똑같은 이름의 함수가 있으면 다른 함수들도 문제가 생기는 구나! 근데 에러가 안뜨내;; 불친절 하다.
                                   // 심지어 매개변수도 잘못 기입(e.g this)되어있으면 함수가 발동하지 않는다.
    const post = e.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode
    const postNo = post.querySelectorAll(".container-like >span ")[0].innerText;
    if (confirm("정말로 삭제 하시겠습니까?")) {
        $.ajax({
            url: contextPath + "/reply/deleteReply",
            data: { "replyNo": replyNo },
            type: "POST",
            async: false,
            success: function (result) {
                if (result > 0) {
                    alert("댓글이 삭제 되었습니다.")

                    location.reload()
                } else {
                    alert("댓글 삭제 중 문제가 발생했습니다.")
                }
            },
            error: function (req, status, error) {
                console.log("ajax 실패");
                console.log(req.responseText);
                console.log(status);
                console.log(error);
            }

        })
    }
}

function report(reportTypeNo, targetPK){
	const reportContent = prompt("신고 사유를 입력해 주세요!")
	$.ajax({
		url: contextPath + "/post/report",
			data: {"reportTypeNo":reportTypeNo, "targetPK": targetPK, "reportContent":reportContent },
			type: "POST",
			async: false,
			success: function (result) {
				if(result>0){
					alert("신고가 접수되었습니다!")


				}else{
					alert("신고 기능에 문제가 발생했습니다.")
				}
			},
			error: function (req, status, error) {
				console.log("ajax 실패");
				console.log(req.responseText);
				console.log(status);
				console.log(error);
			}
	})

}
const detailPostTextarea = document.getElementsByClassName("textarea-box")[0];
const tagRegExp = /#[ㄱ-힣a-zA-Z\d]{1,}/g;
const userRegExp = /@[ㄱ-힣a-zA-Z\d]{1,}/g;
let text = postContent.replace(tagRegExp, function(target){
    return "<a href='#' class='attach' style='color: blue;'>" + target + "</a>";
})
text = text.replace(userRegExp, function(target){
    let memberNo;
    $.ajax({
        url: contextPath + "/post/searchMemberNo",
        data: {"memberName": target.replace("@", "")},
        type: "POST",
        async: false,
        success: function (result) {
            if(result >0){
                memberNo = result;
            }
        },
        error: function (req, status, error) {
            console.log("ajax 실패");
            console.log(req.responseText);
            console.log(status);
            console.log(error);
        }
    })
    if(memberNo>0){
        return "<a href='"+contextPath+"/board1/myBoard/"+memberNo+"' style='color: purple;'>" + target + "</a>";
    }else{
        return target;
    }
})
detailPostTextarea.innerHTML = text

function selectReply(postNo){
    const replyDiv = document.createElement("div");
	replyDiv.className = "reply"
    replyDiv.setAttribute("style", "overflow: visible; max-height: 100%;")
	$.ajax({
		url: contextPath + "/reply/select",
		data: {"postNo": postNo},
		type: "POST",
		dataType: "JSON",
		async : false,
		success: function (replyList) {
			console.log(replyList);
			let plag = 0;
			for(const items of replyList){
				const replyDiv1 = document.createElement("div");
				
				if(items.parentReply == 0){
					replyDiv1.className = "parent-reply"
					if(plag > 0){
						plag = 0;
					}
				}else{
					replyDiv1.className = "child-reply"
					replyDiv1.setAttribute("style", "display: none;")
					if(plag == 0){
						const lineReply = document.createElement("div");
						lineReply.className = "line-reply";
						lineReply.innerText = "──── 답글";
						lineReply.addEventListener("click", function(e){
							let tempE = this.nextElementSibling
							while(tempE.className == "child-reply"){
								if(tempE.style.display == "none"){
									tempE.style.display = "flex";
								}else if(tempE.style.display =="flex"){
									tempE.style.display = "none";
								}
								tempE = tempE.nextElementSibling;
							}
						})
						replyDiv.append(lineReply);
						plag ++;
					}
					
				}
				

				const profileDiv = document.createElement("div");
				profileDiv.className = "profile-reply"
				const profile = document.createElement("img");
				if(items.listProfile[0]){
					profile.setAttribute("src", contextPath + items.listProfile[0].imgPath + items.listProfile[0].imgName);
				}else{
					profile.setAttribute("src", contextPath +"/resources/images/common/defaultProfileImage.png");
				}
				profileDiv.append(profile)

				const userInfo = document.createElement("div")
				userInfo.className ="user-reply";
				const userInfoDiv1 = document.createElement("div")
				userInfoDiv1.innerText = items.memberName;
				userInfo.append(userInfoDiv1)
				const userInfoDiv2 = document.createElement("div")
				userInfoDiv2.innerText = items.replyCreateDate;
				userInfo.append(userInfoDiv2);

				const contentReply = document.createElement("div");
				contentReply.className = "content-reply"

				const textReply = document.createElement("div");
				textReply.className = "text-reply";

				const contentDiv = document.createElement("div");
				contentReply.innerText = items.replyContent;

				const dots = document.createElement("img");
				dots.setAttribute("src", contextPath + "/resources/images/temp/dots.png")
				dots.setAttribute("id", "dropdownMenuOffset")
				dots.setAttribute("data-bs-toggle", "dropdown")
				dots.setAttribute("aria-expanded", "false")
				dots.setAttribute("data-bs-offset", "-40,-10")

				const dropUl = document.createElement("ul");
				dropUl.setAttribute("class", "dropdown-menu")
				dropUl.setAttribute("aria-labelledby", "dropdownMenuOffset")
				
				const dropLi1 = document.createElement("li")
				const dropLi2 = document.createElement("li")
				const dropLi3 = document.createElement("li")
				const a1 = document.createElement("a");
				const a2 = document.createElement("a");
				const a3 = document.createElement("a");
				a1.className = "dropdown-item"
				a2.className = "dropdown-item"
				a3.className = "dropdown-item"
				// a1.setAttribute("href", "#")
				// a2.setAttribute("href", "#")
				// a3.setAttribute("href", "#")
				a1.innerText = "삭제";
				a1.setAttribute("onclick", "deleteReply(this, "+items.replyNo+")")
				a2.innerText = "신고하기";
				a3.innerText = "로그인해 주세요!";
				a2.setAttribute("onclick", "report(1, "+items.replyNo+")")
				dropLi1.append(a1);
				dropLi2.append(a2);
				dropLi3.append(a3);
				if(typeof memberNo != "undefined"){
					if(items.memberNo = memberNo){
						dropUl.append(dropLi1);
						dropUl.append(dropLi2);
					}
				}else{
					dropUl.append(dropLi3);

				}
				contentDiv.append(dots)
				contentDiv.append(dropUl)

				textReply.append(contentDiv);

				
				const constDiv2 = document.createElement("div")
				const vividPopcorn = document.createElement("img");
				vividPopcorn.setAttribute("src", contextPath + "/resources/images/temp/new vivid popcorn2.png")
				vividPopcorn.className = "reply-vivid";
				const whitePopcorn = document.createElement("img");
				whitePopcorn.setAttribute("src", contextPath + "/resources/images/temp/new white popcorn.png")
				whitePopcorn.className = "reply-white";

				if(items.checkLike == 1){
					vividPopcorn.setAttribute("style", "width: 20px; height: 20px;")
					whitePopcorn.setAttribute("style", "width: 20px; height: 20px; display: none;")
				}else{
					vividPopcorn.setAttribute("style", "width: 20px; height: 20px; display: none;")
					whitePopcorn.setAttribute("style", "width: 20px; height: 20px;")

				}

				const likeCount = document.createElement("span")
				likeCount.setAttribute("style", "opacity: 0.7; font-size: 12px; margin-left: 15px;")
				likeCount.innerText = items.likeCount;
				const replyNoSpan = document.createElement("span");
				replyNoSpan.innerText = items.replyNo;
				replyNoSpan.style.display = "none";
				constDiv2.append(vividPopcorn);
				constDiv2.append(whitePopcorn);
				constDiv2.append(replyNoSpan);
				constDiv2.append(likeCount);
				
				const constDiv3 = document.createElement("div");
				constDiv3.setAttribute("style", "margin-left: 12px;");
				const replyPng = document.createElement("img");
				replyPng.className = "comment-img"
				replyPng.setAttribute("src", contextPath + "/resources/images/temp/reply.png");
				replyPng.setAttribute("style", "width: 20px; height: 20px; opacity: 0.5;")
				replyPng.addEventListener("click", function(e){
					e.stopPropagation();
					comment(this, items.replyNo)
				})
			
				// focusout이랑 blur의 이벤트 차이 알것 focusout은 버블링이 있고 blur는 없다. 그리고 이미지는 focus가 안되기 때문에 이 두 이벤트는 적절하지 않다!
				if(items.parentReply == 0){
					constDiv3.append(replyPng);
				}

				const tempDiv = document.createElement("div")
				tempDiv.append(constDiv2)
				tempDiv.append(constDiv3)

				contentReply.append(textReply);
				contentReply.append(tempDiv);

				replyDiv1.append(profileDiv)
				replyDiv1.append(userInfo)
				replyDiv1.append(contentReply)
				
				replyDiv.append(replyDiv1)
			}
			const lineReply = document.getElementsByClassName("line-reply")
			for(const items of lineReply){
				items.addEventListener("click", function(e){
					let tempE = this.nextElementSibling
					while(tempE.className == "child-reply"){
						if(tempE.style.display == "none"){
							tempE.style.display = "flex";
						}else if(tempE.style.display =="flex"){
							tempE.style.display = "none";
						}
						tempE = tempE.nextElementSibling;
					}
				})
			}
			

		},
		error: function (req, status, error) {
			console.log("ajax 실패");
			console.log(req.responseText);
			console.log(status);
			console.log(error);
		}
	})

	return replyDiv
}

const post = document.getElementsByClassName("post")[0]

post.append(selectReply(postNo));
// 댓글 좋아요
const replyVividImg = document.getElementsByClassName("reply-vivid");
const replywhiteImg = document.getElementsByClassName("reply-white");
replyLike(replyVividImg, replywhiteImg);
function replyLike(replyVividImg, replywhiteImg){
	for(const items of replywhiteImg){
		items.addEventListener("click", function () {
			const replyNo = this.nextElementSibling.innerText;
			let count = this.nextElementSibling.nextElementSibling;
			$.ajax({
				url: contextPath + "/reply/insertReplyLike",
				data: { "replyNo": replyNo },
				type: "POST",
				async: false,
				success: function (result) {
					if(result >0){
						items.style.display = "none";
						items.previousElementSibling.style.display = "inline";
						count.innerText = Number(count.innerText)+1;
					}else{
						alert("좋아요 기능에 오류가 발생했습니다.")
					}

				},
				error: function (req, status, error) {
					console.log("ajax 실패");
					console.log(req.responseText);
					console.log(status);
					console.log(error);
				}

			})
		})
	}
	for(const items of replyVividImg){
		items.addEventListener("click", function () {
			const replyNo = this.nextElementSibling.nextElementSibling.innerText;
			let count = this.nextElementSibling.nextElementSibling.nextElementSibling;
			$.ajax({
				url: contextPath + "/reply/deleteReplyLike",
				data: { "replyNo": replyNo },
				type: "POST",
				async: false,
				success: function (result) {
					if(result >0){
						items.style.display = "none";
						items.nextElementSibling.style.display = "inline";
						count.innerText = Number(count.innerText)-1;
					}else{
						alert("좋아요 기능에 오류가 발생했습니다.")
					}

				},
				error: function (req, status, error) {
					console.log("ajax 실패");
					console.log(req.responseText);
					console.log(status);
					console.log(error);
				}

			})
		})
	}
}