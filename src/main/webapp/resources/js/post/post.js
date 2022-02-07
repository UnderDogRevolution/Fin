console.log("post.js");
revealPost()
const option = {
	root: document.getElementById("container-post"),
	rootMargin: '100px 0px 0px 0px',
	threshold: 1.0
  };

const io = new IntersectionObserver((entries, observer) => {
	entries.forEach((entry) => {
		console.log(entry)
	});                            
}, option);


// const like1 = document.querySelectorAll(".container-like > img")[0];
// const like2 = document.querySelectorAll(".container-like > img")[1];

// like1.addEventListener("click", function(){
// 	like1.style.display = "none";
// 	like2.style.display = "block";
// })

// like2.addEventListener("click", function(){
// 	like1.style.display = "block";
// 	like2.style.display = "none";
// })

function revealPost(){
	const postContainer = document.getElementById("container-post")
	
	
	$.ajax({
		url: contextPath + "/post/postView",
		type: "GET",
		dataType: 'json',
		success: function (postList) {
			postContainer.innerHTML = "";
			console.log(postList)
			for(const items of postList){
				const post = document.createElement("div");
				post.className = "post";
				const postHeader = document.createElement("div");
				postHeader.className =  "post-header";
				const postContent = document.createElement("div");
				postContent.className = "post-content";
				const postFooter = document.createElement("div");
				postFooter.className = "post-footer";
				
				// post-header
				const divHeader1 = document.createElement("div")
				const imgHeader1 = document.createElement("img")
				imgHeader1.className = "profile-img";
				if(items.listProfile[0]){
					imgHeader1.setAttribute("src", contextPath + items.listProfile[0].imgPath + items.listProfile[0].imgName);
				}else{
					imgHeader1.setAttribute("src", contextPath +"/resources/images/common/defaultProfileImage.png");
				}
				divHeader1.append(imgHeader1);
				const spanHeader1 = document.createElement("span")
				spanHeader1.innerText = items.memberName;
				const spanHeader2 = document.createElement("span")
				spanHeader2.innerText = items.createDate;
				const divHeader2 = document.createElement("div")
				divHeader2.className = "dropdown me-1 header-dropdown"
				const imgHeader2 = document.createElement("img")
				imgHeader2.setAttribute("id", "dropdownMenuOffset");
				imgHeader2.setAttribute("data-bs-toggle", "dropdown");
				imgHeader2.setAttribute("aria-expanded", "false");
				imgHeader2.setAttribute("data-bs-offset", "-40,-10");
				imgHeader2.setAttribute("src", contextPath + "/resources/images/temp/dots.png");
				const ulHeader = document.createElement("ul")
				ulHeader.className = "dropdown-menu";
				ulHeader.setAttribute("aria-labelledby", "dropdownMenuOffset");
				const liHeader1 = document.createElement("li");
				const liHeader2 = document.createElement("li");
				const liHeader3 = document.createElement("li");
				const aHeader1 = document.createElement("a")
				aHeader1.innerText = "신고하기";
				aHeader1.className = "dropdown-item"
				aHeader1.setAttribute("onclick", "report(0, "+items.postNo+")")
				const aHeader2 = document.createElement("a")
				aHeader2.innerText = "링크복사";
				aHeader2.className = "dropdown-item"
				const aHeader3 = document.createElement("a")
				aHeader3.innerText = "삭제";
				aHeader3.className = "dropdown-item"
				aHeader3.setAttribute("onclick", "deletePost(this)")
				liHeader1.append(aHeader1);
				liHeader2.append(aHeader2);
				liHeader3.append(aHeader3);
				ulHeader.append(liHeader2);
				if(typeof memberNo != "undefined"){ // 아예 변수가 선언조창 안되었을 때 다음과 같이 식별한다.
					ulHeader.append(liHeader1);
					if(items.memberNo == memberNo){
						ulHeader.append(liHeader3);
					}
				}
				divHeader2.append(imgHeader2);
				divHeader2.append(ulHeader);
				postHeader.append(divHeader1);
				postHeader.append(spanHeader1);
				postHeader.append(spanHeader2);
				postHeader.append(divHeader2);
				// post-content
				const divContent1 = document.createElement("div")
				const divContent3 = document.createElement("div")
				if(items.movieTitle != null){
					divContent1.className = "review-title";
					divContent1.innerHTML = items.movieTitle+"<br> <span> "+items.director+" ("+items.movieDate+")  "+items.movieGenre+"</span>"
					postContent.append(divContent1) // 리뷰 타이틀 삽입
					if(items.rating != null){
						divContent3.className = "post-rating";
						const iContent1 = document.createElement("i")
						const iContent2 = document.createElement("i")
						const iContent3 = document.createElement("i")
						const iContent4 = document.createElement("i")
						const iContent5 = document.createElement("i")
						const iContent6 = document.createElement("i")
						const iContent7 = document.createElement("i")
						const iContent8 = document.createElement("i")
						const iContent9 = document.createElement("i")
						const iContent10 = document.createElement("i")
						iContent1.setAttribute("class", "fa fa-star rating-star")
						iContent2.setAttribute("class", "fa fa-star rating-star")
						iContent3.setAttribute("class", "fa fa-star rating-star")
						iContent4.setAttribute("class", "fa fa-star rating-star")
						iContent5.setAttribute("class", "fa fa-star rating-star")
						iContent6.setAttribute("class", "fa fa-star rating-star")
						iContent7.setAttribute("class", "fa fa-star rating-star")
						iContent8.setAttribute("class", "fa fa-star rating-star")
						iContent9.setAttribute("class", "fa fa-star rating-star")
						iContent10.setAttribute("class", "fa fa-star rating-star")
						iContent1.setAttribute("class", "fa fa-star rating-star")
						iContent2.setAttribute("class", "fa fa-star rating-star")
						iContent3.setAttribute("class", "fa fa-star rating-star")
						iContent4.setAttribute("class", "fa fa-star rating-star")
						iContent5.setAttribute("class", "fa fa-star rating-star")
						iContent6.setAttribute("class", "fa fa-star rating-star")
						iContent7.setAttribute("class", "fa fa-star rating-star")
						iContent8.setAttribute("class", "fa fa-star rating-star")
						iContent9.setAttribute("class", "fa fa-star rating-star")
						iContent10.setAttribute("class", "fa fa-star rating-star")
						iContent1.setAttribute("aria-hidden", "true");
						iContent2.setAttribute("aria-hidden", "true");
						iContent3.setAttribute("aria-hidden", "true");
						iContent4.setAttribute("aria-hidden", "true");
						iContent5.setAttribute("aria-hidden", "true");
						iContent6.setAttribute("aria-hidden", "true");
						iContent7.setAttribute("aria-hidden", "true");
						iContent8.setAttribute("aria-hidden", "true");
						iContent9.setAttribute("aria-hidden", "true");
						iContent10.setAttribute("aria-hidden", "true");
						iContent1.setAttribute("aria-hidden", "true");
						iContent2.setAttribute("aria-hidden", "true");
						iContent3.setAttribute("aria-hidden", "true");
						iContent4.setAttribute("aria-hidden", "true");
						iContent5.setAttribute("aria-hidden", "true");
						iContent6.setAttribute("aria-hidden", "true");
						iContent7.setAttribute("aria-hidden", "true");
						iContent8.setAttribute("aria-hidden", "true");
						iContent9.setAttribute("aria-hidden", "true");
						iContent10.setAttribute("aria-hidden", "true");
						if(items.rating == '5'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: yellow");
							iContent3.setAttribute("style", "color: yellow");
							iContent4.setAttribute("style", "color: yellow");
							iContent5.setAttribute("style", "color: yellow");
							iContent6.setAttribute("style", "color: yellow");
							iContent7.setAttribute("style", "color: yellow");
							iContent8.setAttribute("style", "color: yellow");
							iContent9.setAttribute("style", "color: yellow");
							iContent10.setAttribute("style", "color: yellow");
						}else if(items.rating == '4.5'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: yellow");
							iContent3.setAttribute("style", "color: yellow");
							iContent4.setAttribute("style", "color: yellow");
							iContent5.setAttribute("style", "color: yellow");
							iContent6.setAttribute("style", "color: yellow");
							iContent7.setAttribute("style", "color: yellow");
							iContent8.setAttribute("style", "color: yellow");
							iContent9.setAttribute("style", "color: yellow");
							iContent10.setAttribute("style", "color: white");
						}else if(items.rating == '4'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: yellow");
							iContent3.setAttribute("style", "color: yellow");
							iContent4.setAttribute("style", "color: yellow");
							iContent5.setAttribute("style", "color: yellow");
							iContent6.setAttribute("style", "color: yellow");
							iContent7.setAttribute("style", "color: yellow");
							iContent8.setAttribute("style", "color: yellow");
							iContent9.setAttribute("style", "color: white");
							iContent10.setAttribute("style", "color: white");
						}else if(items.rating == '3.5'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: yellow");
							iContent3.setAttribute("style", "color: yellow");
							iContent4.setAttribute("style", "color: yellow");
							iContent5.setAttribute("style", "color: yellow");
							iContent6.setAttribute("style", "color: yellow");
							iContent7.setAttribute("style", "color: yellow");
							iContent8.setAttribute("style", "color: white");
							iContent9.setAttribute("style", "color: white");
							iContent10.setAttribute("style", "color: white");
						}else if(items.rating == '3'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: yellow");
							iContent3.setAttribute("style", "color: yellow");
							iContent4.setAttribute("style", "color: yellow");
							iContent5.setAttribute("style", "color: yellow");
							iContent6.setAttribute("style", "color: yellow");
							iContent7.setAttribute("style", "color: white");
							iContent8.setAttribute("style", "color: white");
							iContent9.setAttribute("style", "color: white");
							iContent10.setAttribute("style", "color: white");
						}else if(items.rating == '2.5'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: yellow");
							iContent3.setAttribute("style", "color: yellow");
							iContent4.setAttribute("style", "color: yellow");
							iContent5.setAttribute("style", "color: yellow");
							iContent6.setAttribute("style", "color: white");
							iContent7.setAttribute("style", "color: white");
							iContent8.setAttribute("style", "color: white");
							iContent9.setAttribute("style", "color: white");
							iContent10.setAttribute("style", "color: white");
						}else if(items.rating == '2'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: yellow");
							iContent3.setAttribute("style", "color: yellow");
							iContent4.setAttribute("style", "color: yellow");
							iContent5.setAttribute("style", "color: white");
							iContent6.setAttribute("style", "color: white");
							iContent7.setAttribute("style", "color: white");
							iContent8.setAttribute("style", "color: white");
							iContent9.setAttribute("style", "color: white");
							iContent10.setAttribute("style", "color: white");
						}else if(items.rating == '1.5'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: yellow");
							iContent3.setAttribute("style", "color: yellow");
							iContent4.setAttribute("style", "color: white");
							iContent5.setAttribute("style", "color: white");
							iContent6.setAttribute("style", "color: white");
							iContent7.setAttribute("style", "color: white");
							iContent8.setAttribute("style", "color: white");
							iContent9.setAttribute("style", "color: white");
							iContent10.setAttribute("style", "color: white");
						}else if(items.rating == '1'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: yellow");
							iContent3.setAttribute("style", "color: white");
							iContent4.setAttribute("style", "color: white");
							iContent5.setAttribute("style", "color: white");
							iContent6.setAttribute("style", "color: white");
							iContent7.setAttribute("style", "color: white");
							iContent8.setAttribute("style", "color: white");
							iContent9.setAttribute("style", "color: white");
							iContent10.setAttribute("style", "color: white");
						}else if(items.rating == '0.5'){
							iContent1.setAttribute("style", "color: yellow");
							iContent2.setAttribute("style", "color: white");
							iContent3.setAttribute("style", "color: white");
							iContent4.setAttribute("style", "color: white");
							iContent5.setAttribute("style", "color: white");
							iContent6.setAttribute("style", "color: white");
							iContent7.setAttribute("style", "color: white");
							iContent8.setAttribute("style", "color: white");
							iContent9.setAttribute("style", "color: white");
							iContent10.setAttribute("style", "color: white");
						}
						
						const spanContent1 = document.createElement("span")
						spanContent1.innerText = items.rating;
						divContent3.append(iContent1)
						divContent3.append(iContent2)
						divContent3.append(iContent3)
						divContent3.append(iContent4)
						divContent3.append(iContent5)
						divContent3.append(iContent6)
						divContent3.append(iContent7)
						divContent3.append(iContent8)
						divContent3.append(iContent9);
						divContent3.append(iContent10);
						divContent3.append(spanContent1);
						
					}

				}
				const divContent2 = document.createElement("div")
				divContent2.className = "textarea-box";
				const tagRegExp = /#[ㄱ-힣a-zA-Z\d]{1,}/g;
  				const userRegExp = /@[ㄱ-힣a-zA-Z\d]{1,}/g;
				let text = items.postContent.replace(tagRegExp, function(target){
					return "<a href='"+contextPath+"/search/?searchResult=%23"+target.replace("#","")+"' style='color: blue;'>" + target + "</a>";
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
				// console.log(text)
				divContent2.innerHTML = text;
				divContent2.setAttribute("onclick", "location.href='"+contextPath+"/post/view/"+items.postNo+"'")
				postContent.append(divContent2) 
				if(items.rating != null){
					postContent.append(divContent3)
				}
				// const divContent4 = document.createElement("div")
				// divContent4.className = "text-count";
				const divContent5 = document.createElement("div")
				divContent5.className = "container-img";
				const imgContent1 = document.createElement("img");
				if(items.checkUsePoster == 1){
					imgContent1.setAttribute("src", items.poster)
					divContent5.append(imgContent1);
					postContent.append(divContent5);
				}else if(items.listPostImage[0]){
					imgContent1.setAttribute("src", contextPath + items.listPostImage[0].postImagePath + items.listPostImage[0].postImageName)
					divContent5.append(imgContent1);
					postContent.append(divContent5);
				}
				
				
				// postContent.append(divContent4)
				
	
				// post-footer
				const divFooter1 = document.createElement("div")
				divFooter1.className = "container-like";
				const imgFooter1 = document.createElement("img")
				imgFooter1.className = "vivid-popcorn"
				imgFooter1.setAttribute("src", contextPath + "/resources/images/temp/new vivid popcorn2.png")
				imgFooter1.setAttribute("style", "width: 100%;");
				const imgFooter2 = document.createElement("img")
				imgFooter2.className = "white-popcorn"
				imgFooter2.setAttribute("src", contextPath + "/resources/images/temp/new white popcorn.png")
				imgFooter2.setAttribute("style", "width: 100%;");

				if(items.checkLike == '1'){
					imgFooter2.setAttribute("style", "width: 100%; display:none;")
				}else{
					imgFooter1.setAttribute("style", "width: 100%; display:none;")
				}

				const spanFooter1 = document.createElement("span")
				spanFooter1.innerText = items.likeCount;
				const spanFooter3 = document.createElement("span");
				spanFooter3.innerText = items.postNo;
				spanFooter3.setAttribute("style", "display:none;")
				divFooter1.append(imgFooter1)
				divFooter1.append(imgFooter2)
				divFooter1.append(spanFooter3)
				divFooter1.append(spanFooter1);
				const divFooter2 = document.createElement("div")
				divFooter2.className = "container-reply";
				const imgFooter3 = document.createElement("img")
				imgFooter3.setAttribute("src", contextPath +"/resources/images/temp/reply.png")
				imgFooter3.setAttribute("style", "width: 100%;");
				const spanFooter2 = document.createElement("span")
				spanFooter2.innerText = items.replyCount;
				divFooter2.append(imgFooter3)
				divFooter2.append(spanFooter2);
				
				postFooter.append(divFooter1);
				postFooter.append(divFooter2);
				// post
	
				post.append(postHeader)
				post.append(postContent)
				post.append(postFooter);
				postContainer.append(post);
			}
			
			//게시글 좋아요
			const whitePopcorn = document.getElementsByClassName("white-popcorn");
			const vividPopcorn = document.getElementsByClassName("vivid-popcorn");

			for (const items of whitePopcorn) {
				items.addEventListener("click", function () {
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
			

			// 댓글 조회
			const replyImg = document.querySelectorAll(".container-reply > img")
			for(const items of replyImg){
				items.addEventListener("click", function(){
					const post = this.parentNode.parentNode.parentNode

					const postNo = post.querySelectorAll(".container-like >span ")[0].innerText;
					
					const inputReplyDiv = document.createElement("div");
					inputReplyDiv.className = "input-content-reply";

					const inputReplyDivIn1 = document.createElement("div");
					inputReplyDivIn1.innerText = "댓글"

					inputReplyDivIn1.addEventListener("click", function(){
						const arr = document.querySelectorAll(".input-content-reply > div")
						const img = document.querySelectorAll(".input-content-reply img")[0]
						const input = document.querySelectorAll(".input-content-reply input")[0]
						if(arr[0].innerText.trim() == "답글"){
							arr[0].innerText = "댓글";
							img.setAttribute("onclick", "insertReply(this)")
							input.setAttribute("placeholder", "댓글을 달아주세요!");
						}
					})

					const inputReplyDivIn2 = document.createElement("div");
					const input = document.createElement("input")
					input.setAttribute("type", "text");
					input.setAttribute("placeholder", "댓글을 달아주세요!");
					inputReplyDivIn2.append(input);
					const inputReplyDivIn3 = document.createElement("div");
					const inputReplyImg = document.createElement("img")
					inputReplyImg.setAttribute("src", contextPath + "/resources/images/temp//comment.png")
					inputReplyImg.setAttribute("onclick", "insertReply(this)")

					inputReplyDivIn3.append(inputReplyImg)

					inputReplyDiv.append(inputReplyDivIn1)
					inputReplyDiv.append(inputReplyDivIn2)
					inputReplyDiv.append(inputReplyDivIn3)

					
					

					
					const temp1 = document.getElementsByClassName("input-content-reply");
					const temp2 = document.getElementsByClassName("reply");
					// 댓글 입력창이 열려있다면  댓글에 관한 모든 div를 없앤다
					if(post.getElementsByClassName("input-content-reply").length > 0){
							if(temp1.length >0){
								for(const items of temp1){
									items.remove()
								}
								for(const items of temp2){
									items.remove()
								}
							}
					}else{// 댓글 입력창이 없다면 먼저 대슥ㄹ에 관한 모든 div를 없앤 후 클릭한 자리에 댓글 관련 div를 추가한다.
						if(temp1.length >0){
							for(const items of temp1){
								items.remove()
							}
							for(const items of temp2){
								items.remove()
							}
						}
						post.append(inputReplyDiv)
						if(Number(post.querySelectorAll(".container-reply > span")[0].innerText) > 0){
							const replyDiv = selectReply(postNo)
							post.append(replyDiv)
						}
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
					
				})
			}

			
			
			
			

			
			
		},
		error: function (req, status, error) {
			console.log("ajax 실패");
			console.log(req.responseText);
			console.log(status);
			console.log(error);
		},
		complete: function(){
			
			document.querySelectorAll('.post').forEach((post) => io.observe(post));
		} 
	})

	
}

// revealPost 경계선

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
					e.parentNode.parentNode.getElementsByTagName("input")[0].value = "";

					if(post.getElementsByClassName("reply")[0]){
						const reply = post.getElementsByClassName("reply")[0];
						reply.remove();
						const replyDiv = selectReply(postNo);
						post.append(replyDiv);
					}else if(!post.getElementsByClassName("reply")[0]){
						const replyDiv = selectReply(postNo);
						post.append(replyDiv);
					}

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

function selectReply(postNo){
	const replyDiv = document.createElement("div");
	replyDiv.className = "reply"
	
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
					e.parentNode.parentNode.getElementsByTagName("input")[0].value = "";

					if(post.getElementsByClassName("reply")[0]){
						const reply = post.getElementsByClassName("reply")[0];
						reply.remove();
						const replyDiv = selectReply(postNo);
						post.append(replyDiv);
					}

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

function deleteReply(e, replyNo){ // 똑같은 이름의 함수가 있으면 다른 함수들도 문제가 생기는 구나! 근데 에러가 안뜨내;; 불친절 하다.
						 // 심지어 매개변수도 잘못 기입(e.g this)되어있으면 함수가 발동하지 않는다.
	const post = e.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode
	const postNo = post.querySelectorAll(".container-like >span ")[0].innerText;
	if(confirm("정말로 삭제 하시겠습니까?")){
		$.ajax({
			url: contextPath + "/reply/deleteReply",
			data: { "replyNo": replyNo},
			type: "POST",
			async: false,
			success: function (result) {
				if(result>0){
					alert("댓글이 삭제 되었습니다.")

					if(post.getElementsByClassName("reply")[0]){
						const reply = post.getElementsByClassName("reply")[0];
						reply.remove();
						const replyDiv = selectReply(postNo);
						post.append(replyDiv);
					}

				}else{
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

