console.log("post.js");

const like1 = document.querySelectorAll(".container-like > img")[0];
const like2 = document.querySelectorAll(".container-like > img")[1];

like1.addEventListener("click", function(){
	like1.style.display = "none";
	like2.style.display = "block";
})

like2.addEventListener("click", function(){
	like1.style.display = "block";
	like2.style.display = "none";
})

function revealPost(){
	const postContainer = document.getElementById("container-post")
	postContainer.innerHTML = "";
	
	$.ajax({
		url: contextPath + "/post/postView",
		type: "GET",
		dataType: 'json',
		success: function (postList) {
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
				imgHeader1.setAttribute("src", contextPath + "/resources/images/temp/raraland.jpg");
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
				const aHeader2 = document.createElement("a")
				aHeader2.innerText = "링크복사";
				aHeader2.className = "dropdown-item"
				const aHeader3 = document.createElement("a")
				aHeader3.innerText = "삭제";
				aHeader3.className = "dropdown-item"
				liHeader1.append(aHeader1);
				liHeader2.append(aHeader2);
				liHeader3.append(aHeader3);
				ulHeader.append(liHeader1);
				ulHeader.append(liHeader2);
				ulHeader.append(liHeader3);
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
					divContent1.innerHTML = items.movieTitle + " <span>("+items.movieDate+")  "+items.movieGenre+"</span>"
					
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
				divContent2.innerText = items.postContent;
				
				// const divContent4 = document.createElement("div")
				// divContent4.className = "text-count";
				const divContent5 = document.createElement("div")
				divContent5.className = "container-img";
				const imgContent1 = document.createElement("img");
				if(items.checkUsePoster == 1){
					imgContent1.setAttribute("src", items.poster)
				}else if(items.listPostImage[0]){
					imgContent1.setAttribute("src", contextPath + items.listPostImage[0].postImagePath + items.listPostImage[0].postImageName)
				}
				divContent5.append(imgContent1);
				
				
				postContent.append(divContent1)
				postContent.append(divContent2)
				if(items.rating != null){
					postContent.append(divContent3)
				}
				// postContent.append(divContent4)
				postContent.append(divContent5);
	
				// post-footer
				const divFooter1 = document.createElement("div")
				divFooter1.className = "container-like";
				const imgFooter1 = document.createElement("img")
				imgFooter1.className = "vivid-popcorn"
				imgFooter1.setAttribute("src", contextPath + "/resources/images/temp/popcorn vivid.png")
				imgFooter1.setAttribute("style", "width: 100%;");
				const imgFooter2 = document.createElement("img")
				imgFooter2.className = "white-popcorn"
				imgFooter2.setAttribute("src", contextPath + "/resources/images/temp/popcorn white.png")
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
				spanFooter2.innerText = "300";
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
		
			const replyImg = document.querySelectorAll(".container-reply > img")

			for(const items of replyImg){
				items.addEventListener("click", function(){
					const post = this.parentNode.parentNode.parentNode
					console.log(post)
					
					
					const inputReplyDiv = document.createElement("div");
					inputReplyDiv.className = "input-content-reply";

					const inputReplyDivIn1 = document.createElement("div");
					inputReplyDivIn1.innerText = "댓글"
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

					if(post.getElementsByClassName("input-content-reply").length > 0){
						post.getElementsByClassName("input-content-reply")[0].remove();
					}else{
						post.append(inputReplyDiv)
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

	
}
function insertReply(e){
	
	console.log(e)
	const post = e.parentNode.parentNode.parentNode
	console.log(post);
	const postNo = post.querySelectorAll(".container-like >span ")[0].innerText;
	console.log(postNo);
	const replyContent = e.parentNode.parentNode.getElementsByTagName("input")[0].value
	console.log(replyContent);
	if(replyContent.trim().length>0){
		$.ajax({ 
			url: contextPath + "/reply/insert",
			data: { "postNo": postNo, "replyContent" : replyContent},
			type: "POST",
			dataType : "JSON",
			success: function (result) {
				if(result>0){
					alert("댓글이 등록되었습니다.")
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





