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

// 댓글 좋아요
const replyVividImg = document.getElementsByClassName("reply-vivid");
const replywhiteImg = document.getElementsByClassName("reply-white");
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
                    location.reload();

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
                    location.reload();
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

