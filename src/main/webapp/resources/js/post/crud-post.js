console.log("curd-post.js");

// 즉시 실행 함수 (function(){})()

// 이미지 영역을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
let youtubePath = null;

(function(){
	document.querySelectorAll(".insert-media > img")[0].addEventListener("click", function(){
		document.querySelectorAll("[type='file']")[0].click()
        
	})
})()

const crudImg = document.getElementsByClassName("post-img")[0].firstElementChild
const deleteImg = document.getElementsByClassName("delete-img")[0]
const inputFile = document.getElementsByClassName("files")[0]
const onPoster = document.getElementsByClassName("on-poster")[0]
// const tempURL = document.getElementsByClassName("temp-url")[0]
function loadImg(input, num){
	if(input.files && input.files[0]){
        

		// if(deleteImages.indexOf(num) != -1){
		// 	deleteImages.splice(deleteImages.indexOf(num), 1)
		// }A
        postImg.style.display = "block";
		const reader = new FileReader()

		reader.readAsDataURL(input.files[0])

		reader.onload = function(e){

			crudImg.setAttribute("src", e.target.result)
			crudImg.style.width = "100%";
			crudImg.style.height = "100%";
		}
        deleteImg.style.display = "inline";
        // onPoster.style.display = "inline";
        const youtubeBox = document.getElementsByClassName("youtube-box")[0];
        if(youtubeBox){
            youtubePath = null;
            youtubeBox.remove()
        }
        


	}else{
        
		// 취소 클릭
		crudImg.removeAttribute("src")
		crudImg.removeAttribute("style")
        deleteImg.style.display = "none";
        // onPoster.style.display = "none";
        postImg.style.display = "none";
	}

    
}

deleteImg.addEventListener("click", function(e){

    e.stopPropagation();
    
    if(crudImg.hasAttribute("src")){
        crudImg.removeAttribute("src");
        crudImg.removeAttribute("style");
        inputFile.value = "";
        deleteImg.style.display = "none";
        // onPoster.style.display = "inline";
        postImg.style.display = "none";
    }

    const youtubeFrame = document.querySelectorAll(".post-img > div")[0]
    if(typeof youtubeFrame != "undefined"){
        youtubeFrame.remove();
        deleteImg.style.display = "none"
        postImg.style.display = "none";
        youtubePath = null;
    }
    
})
let movie;

const moviedbInput = document.getElementsByClassName("moviedb-input")[0];
const searchResult2 = document.getElementsByClassName("search-result")[0];
const textareaBox = document.getElementsByClassName("insert-container-textarea")[0];
// const textCount = document.getElementsByClassName("text-count")[0];
const postImg = document.getElementsByClassName("post-img")[0];
const reviewTitle = document.getElementsByClassName("modal-review-title")[0];
const starInput = document.getElementsByClassName("rating")[0];
const starValueInput = document.getElementsByClassName("rating-value")[0];
const postSubmit = document.getElementsByClassName("header-tag")[0]
const searchMovie = document.getElementsByClassName("header-tag")[1]
const containerTextCount = document.getElementsByClassName("container-content-count")[0]
const insertMedia = document.getElementsByClassName("insert-media")[0]
function Write(){
    movie = null;
	moviedbInput.style.display = "none";	
	searchResult2.style.display = "none";	
	reviewTitle.style.display = "none";	
	starInput.style.display = "none";	
	starValueInput.style.display = "none";	
	searchMovie.style.display = "none";	
	
	textareaBox.style.display = "block";
	// textCount.style.display = "block";
	
    postImg.style.display = "none";
	postSubmit.style.display = "inline";
	containerTextCount.style.display = "inline";

    onPoster.style.display = "none";

    insertMedia.style.display = "block"
}

function Review(){
	moviedbInput.style.display = "flex";	
	searchResult2.style.display = "flex";	
	textareaBox.style.display = "none";
	// textCount.style.display = "none";
	postImg.style.display = "none";
	reviewTitle.style.display = "none";	
	starInput.style.display = "none";	
	starValueInput.style.display = "none";	
	searchMovie.style.display = "none";
	postSubmit.style.display = "none";
	containerTextCount.style.display = "none";	
    onPoster.style.display = "none";
    insertMedia.style.display = "none"
}


const inputContent = document.querySelectorAll(".insert-container-textarea > textarea")[0];

inputContent.addEventListener("input", function(){
    const countBox = document.getElementsByClassName("content-count")[0]
    // 바이트로 세는 것은 나중에 하자
    let count = inputContent.value.length

    const row = inputContent.value.split("\n").length; // 여기서는 \n이 몇개인지 세준다.
    countBox.innerText = count
    if(row > 9){
        inputContent.value = inputContent.value.slice(0, -1);
        inputContent.value = inputContent.value.substring(0, 350)
    }
    if(count >= 350){
        inputContent.value = inputContent.value.substring(0, 350);
        count = 350   
    }
    
    countBox.innerText = count;
})


let page = 1;
const key = "a93bbecafca4d9f151b867232f870461";
let search = "";
const base_url = "https://image.tmdb.org/t/p/w500/";
let movieGenres;
let tvGenres;
const div = document.getElementsByClassName("moviedb-content")[0];
const input = document.getElementsByClassName("moviedb-input")[0];
const searchResult = document.getElementsByClassName("search-result")[0];

(async function(){
    movieGenres = await fetch("https://api.themoviedb.org/3/genre/movie/list?api_key="+key+"&language=ko-KR").then(res => res.json());
    tvGenres = await fetch("https://api.themoviedb.org/3/genre/tv/list?api_key="+key+"&language=ko-KR").then(res => res.json());
})()

function searchGenre(type, id){
    if(type == 'movie'){
        for(const items of movieGenres.genres){
            if(items.id == id){
                return items.name
            }
        }
    }else if(type = 'tv'){
        for(const items of tvGenres.genres){
            if(items.id == id){
                return items.name
            }
        }
    }

}
// fetch() HTTP 요청 전송 기능을 제공하는 Web API이다. (자바스크립트 내장 라이브러리)
// Server와의 비동기 요청 방식을 기능한다.
input.addEventListener("input", async function(){
    search = this.value;
    // console.log(search); // 영화 검색 인풋 내용
    await fetchMovie(page);
});
//API 서버에서 데이터 가져오는 함수



async function fetchMovie(page){
    searchResult.innerHTML = "";
    let id;
    if(search.trim().length>0){
        const multiSearch = "https://api.themoviedb.org/3/search/multi?api_key="+key+"&language=ko-KR&query="+search+"&page="+page
        const result = await fetch(multiSearch).then(res => res.json()) //await을 안하면 promise 객체였다가 await을 하니 배열로 반환됐다.
        for(const items of result.results){
            if(items.title != null && items.media_type == 'movie'){
                id = items.id
                const div1 = document.createElement("div");
                const div2 = document.createElement("div");
                const div3 = document.createElement("div");
                const img = document.createElement("img")
    
                div2.className = "search-result-img";
                if(items.poster_path == null){
                    img.setAttribute("src", contextPath + "/resources/images/temp/no-pictures.png")
                }else{
                    img.setAttribute("src", base_url + items.poster_path)
                }
                div2.appendChild(img)
                
                div3.className = "search-result-content";
                div3.innerHTML = items.title + "<br> ("+items.release_date+") " + searchGenre(items.media_type, items.genre_ids[0]) +"<span style='display:none'>"+id+"</span>";
    
                div1.appendChild(div2);
                div1.appendChild(div3);
                searchResult.appendChild(div1);
            }
            

        }

        // const directorSearch = "https://api.themoviedb.org/3/movie/"+id+"/credits?api_key="+key+"&language=ko-KR"
        // const credits = await fetch(directorSearch).then(res => res.json())
        // for(const items of credits.crew){
        //     if(items.job == 'Director'){
        //         console.log(items.name);
        //     }
        // }
    }
    // 글 클릭하면 이미지 클릭되게 하면 될 듯?
    if(document.getElementsByClassName("search-result-img")){
        const resultImg = document.querySelectorAll(".search-result-img > img")
        for(const items of resultImg){
            items.addEventListener("click", async function(e){
                inputFile.value = ""

                const img = document.querySelector(".post-img > img");
                img.setAttribute("src", this.getAttribute("src"));
               
                reviewTitle.innerHTML = ""
                Write();
                postImg.style.display = "block";
                reviewTitle.style.display = "block";	
            	starInput.style.display = "flex";
            	starValueInput.style.display = "block";
                searchMovie.style.display = "inline";
                postSubmit.style.display = "inline";
                insertMedia.style.display = "block"
                const content = this.parentElement.nextElementSibling.innerHTML;
                let title = content.substring(content.indexOf('<br'), -1);
                // const date =  content.substring(content.indexOf('('), content.indexOf(')')+1);
                let genre = content.substring(content.indexOf(')')+1,content.indexOf('<s')).trim();
                let id = content.substring(content.indexOf('\">')+2, content.indexOf('</'));
                let date = content.substring(content.indexOf('(')+1, content.indexOf(')'));
                let director;
                const directorSearch = "https://api.themoviedb.org/3/movie/"+id+"/credits?api_key="+key+"&language=ko-KR"
                const credits = await fetch(directorSearch).then(res => res.json())
                for(const items of credits.crew){
                    if(items.job == 'Director'){
                        console.log(items.name);
                        director = items.name;
                    }
                }
                reviewTitle.innerHTML = "<span style='font-size: 20px; '>"+title+ "  </span> <br>" + "<span style='opacity: 0.5;'>"+director+" ("+date+")"+ genre + "</span>";

                movie = {}
                movie.poster = this.getAttribute("src");
                movie.movieNo = id;
                movie.movieTitle = title;
                movie.movieDate = date;
                movie.movieGenre = genre;
                movie.director = director; 

                deleteImg.style.display = "inline";
                onPoster.style.display = "inline";
                
                onPoster.addEventListener("click", function(e){
                    e.stopPropagation();
                    inputFile.value = "";
                    crudImg.setAttribute("src", movie.poster); // this의 레벨은 영역을 좀만 벗어나도 달라진다.
                    postImg.style.display = "block"
                    // tempURL.innerText = movie.poster;
                    deleteImg.style.display = "inline";
                    const youtubeBox = document.getElementsByClassName("youtube-box")[0];
                    if(youtubeBox){
                        youtubePath = null;
                        youtubeBox.remove()
                    }
                })
                
            })
        }
    }
}

const inputTextarea = document.querySelectorAll(".insert-container-textarea > textarea")[0];
const inputDiv = document.querySelectorAll(".insert-container-textarea > div")[0];
// const space = document.querySelectorAll(".insert-container-textarea > div")[1];

inputDiv.addEventListener("click", function(){
    this.classList.remove("top");
    inputTextarea.classList.add("top");
    inputTextarea.focus();
})

inputTextarea.addEventListener("blur", function(){
    this.classList.remove("top");
    inputDiv.classList.add("top");
})

inputTextarea.addEventListener("input",function(){
    changeContent();
    modalSide.style.display = "none";
    inputDiv.height = "auto"
    let scHeight = inputDiv.scrollHeight; 
    inputDiv.style.height = `${scHeight}px`
    inputTextarea.style.height = inputDiv.style.height;
})

function autoComplete(arr){ // 배열 매개변수
    for(const items of arr){
        console.log(items.innerText);
        items.addEventListener("click",function(){

        })
    }
}

function changeContent(){
    const content = inputTextarea.value.replaceAll("\n","<br>").replaceAll(" ", "&nbsp;"); // 두번째 공백이 입력되지 않는다 따라서 공백 처리를 해보자
    const tagRegExp = /#[ㄱ-힣a-zA-Z\d]{1,}/g;
    const userRegExp = /@[ㄱ-힣a-zA-Z\d]{1,}/g;
    let change = content.replace(tagRegExp, function(target){
        return "<a href='#' class='attach' style='color: #0075de;'>" + target + "</a>";
    })
    change = change.replace(userRegExp, function(target){
        return "<a href='#' class='attach' style='color: #ffd700;'>" + target + "</a>";
    })
    inputDiv.innerHTML = change;
    // innerText로 주고받으면 자동으로 xss처리 및 개행문자 처리가 된다! 위의 경우는 태그를 쓰기때문에 안된다 ㅠ
}
// const bef = []
let tagListUl = document.querySelectorAll(".modal-side > ul")[0]
const modalSide = document.getElementsByClassName("modal-side")[0];
// MUtationObserver는 신이야!
const observer = new MutationObserver(mutations => {
    mutations.forEach(mutation =>{
        tagListUl.innerHTML ="";
        if(mutation.removedNodes.length > 0){
            for(let i=0; i < mutation.removedNodes.length; i++){
                 if(mutation.addedNodes[i] != null){

                    // console.log(mutation.addedNodes);
                   
                    if(mutation.removedNodes[i].innerText != mutation.addedNodes[i].innerText){
                        let tagName = mutation.addedNodes[i].innerText;
                        // console.log(mutation.addedNodes[i].innerText.indexOf('#'));
                        if(  tagName != null && tagName.length >0 ){
                            // console.log(mutation.addedNodes[i]);
                            if(tagName.indexOf('#') > -1){
                                tagName = tagName.replace('#', "");
                                $.ajax({ //async : false 하면 순서대로 작동되서 잘되나 반응이 느려진다.
                                    url: contextPath + "/post/searchTag",
                                    data: { "tagName": tagName },
                                    type: "POST",
                                    dataType : "JSON",
                                    success: function (tagList) {
                                       // 태그의 위치 변경은 변화된 노드의 상대 좌표를 계산한 값을 이용했다. 
                                        const top = getAbsoluteTop(mutation.addedNodes[i]) - getAbsoluteTop(textareaBox)
                                        modalSide.style.top = Number(top) + 24 + "px"; 
                                        
                                        const left = getAbsoluteLeft(mutation.addedNodes[i]) - getAbsoluteLeft(textareaBox)
                                        console.log(getAbsoluteTop(mutation.addedNodes[i]))
                                        modalSide.style.left = (Number(left) - 4) + "px"; 
                                        tagListUl.innerHTML ="";
                                       
                                        for(const items of tagList){
                                            tagListUl.innerHTML += '<li>#'+ items.tagName +'</li>';
                                            if(getAbsoluteTop(mutation.addedNodes[i]) != 0){
                                                modalSide.style.display = "block";
                                            }else{
                                                modalSide.style.display = "none";
                                            }
                                            const li = document.querySelectorAll(".modal-side > ul > li")
                                            for(const items2 of li){
                                                items2.addEventListener("click", function(){
                                                    mutation.addedNodes[i].innerText = items2.innerText;
                                                    inputTextarea.value = inputDiv.innerText;
                                                })
                                            }
                                        }
                                    },
                                    error: function (req, status, error) {
                                        console.log("ajax 실패");
                                        console.log(req.responseText);
                                        console.log(status);
                                        console.log(error);
                                    }
                            
                                })
                            }else if(tagName.indexOf('@') > -1){
                                tagName = tagName.replace('@', "");
                                if(tagName.length >0){
                                    $.ajax({ //async : false 하면 순서대로 작동되서 잘되나 반응이 느려진다.
                                        url: contextPath + "/post/searchUser",
                                        data: { "tagName": tagName },
                                        type: "POST",
                                        dataType : "JSON",
                                        success: function (tagList) {
                                            const top = getAbsoluteTop(mutation.addedNodes[i]) - getAbsoluteTop(textareaBox)
                                            modalSide.style.top = Number(top) + 24 + "px"; 
                                            
                                            const left = getAbsoluteLeft(mutation.addedNodes[i]) - getAbsoluteLeft(textareaBox)
                                            modalSide.style.left = (Number(left) - 4) + "px"; 
                                            tagListUl.innerHTML ="";
                                            for(const items of tagList){
                                                tagListUl.innerHTML += '<li>@'+ items.memberNickName +'</li>';
                                                if(getAbsoluteTop(mutation.addedNodes[i]) != 0){
                                                    modalSide.style.display = "block";
                                                }else{
                                                    modalSide.style.display = "none";
                                                }
                                                const li = document.querySelectorAll(".modal-side > ul > li")
                                                for(const items2 of li){
                                                    items2.addEventListener("click", function(){
                                                        mutation.addedNodes[i].innerText = items2.innerText;
                                                        inputTextarea.value = inputDiv.innerText;
                                                    })
                                                }
                    
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
                        }
                    }
                }
            }
        }
    })
})

const config = {
    childList: true, // 텍스트 노드를 포함한 하위 요소의 변경(추가/삭제)을 관찰
    attributes: false, // 속성 변경을 관찰
    characterData: false, // characterData 노드 값 변경 관찰
    subtree: false, // 자손 노드의 변경 관찰
    attributeOldValue: false, // 변경 전 속성 값을 저장
    characterDataOldValue: false // 변경 전 데이터 값을 저장
    // attributeFilter: ["class"], // 관찰할 속성명 리스트
}

observer.observe(inputDiv, config);
//observer.disconnect(); //테스트 중에 켜있으면 확인이 안된다.

// 게시글 삽입
function postValidate(){
    if(typeof memberNo == "undefined"){
        alert("로그인 해주세요!")
        return;
    }
    if(inputTextarea.value.trim().length == 0){
        alert("내용을 입력해주세요!")
        return;
    }
        const rating = document.getElementsByClassName("rating-value")[0].innerText
        if(movie != null){
            if(rating != ""){
                movie.rating = rating;
            }else{
                alert("별점을 등록하세요!")
                return;
            }
        }

        const postVO = {}
        const tagName = document.querySelectorAll(".insert-container-textarea > div > .attach");
        const tagArr = []
        
        for(const items of tagName){
            if(items.innerText.length > 21){
                alert("해시태그의 길이가 너무 깁니다! (최대 20)")
                return;
            }
            if(items.innerText.indexOf('#') >-1){
                tagArr.push(items.innerText.replace('#', ""));
            } 
            if(items.innerText.indexOf('@') > -1){
                // 피 태그자의 멤버no
                $.ajax({ 
                    url: contextPath + "/post/searchUser",
                    data: { "tagName": items.innerText.replace("@", "")},
                    type: "POST",
                    dataType : "JSON",
                    success: function (tagList) {
                        for(const items of tagList){
                            console.log(items) // memberNo가 받아옴
                            console.log("태그 유저")
                            console.log(items.memberNo)
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
        
        postVO.postContent = inputTextarea.value;
        postVO.tagArr = tagArr;
        postVO.movie = movie;
        console.log(postVO);
        
        // image 영역
        const formData = new FormData();
        const image = document.getElementsByClassName("files")[0]
        if(image.files.length > 0){
            
        }
        if(inputFile.value.length >0){
            formData.append('image', image.files[0])
            postVO.checkUsePoster = 0;
        }else if(youtubePath != null){
            const youtube = {}
            const youtubeUrl =  (youtubePath.match(/(http|https|ftp|telnet|news|mms):\/\/[^\"'\s()]+/i))[0];
            const youtubeId = youtubeUrl.substring(30)
            youtube.path = youtubePath;
            youtube.id = youtubeId;
            youtube.thumbnail = `https://img.youtube.com/vi/${youtubeId}/0.jpg`
            postVO.youtube = youtube;
            postVO.checkUsePoster = 0;
        }else if(crudImg.getAttribute("src") != null && movie != null){
            console.log(movie);
            postVO.checkUsePoster = 1;
        }else{
            postVO.checkUsePoster = 0;
        }
        
        formData.append('key', new Blob([JSON.stringify(postVO)], {type:"application/json"}));
        console.log(formData);
        $.ajax({ 
            url: contextPath + "/post/insert",
            type: "POST",
            data: formData,
            contentType: false, // multipart/form-data로 전송하기위해 필요
            processData : false, // formData를 string으로 변환하지 않는다.
            enctype : 'multipart/form-data',
            async : false,
            success: function (result) {
                if(result >0){
                    alert("게시글 등록 성공!");
                    location.href = contextPath + "/post/view/" + result;
                }else{
                    alert("게시글 등록 실패!");
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

// star rating
const starRadio = document.querySelectorAll(".rating > input")
const ratingValue = document.getElementsByClassName("rating-value")[0]
for(const items of starRadio){
    items.addEventListener("click", function(){
        ratingValue.innerText = this.value;
    })
}



function onYoutube(){
    youtubePath = prompt("유튜브 경로를 넣어주세요")
    // const youtubeId =  youtubePath.substring(youtubePath.indexOf("src=", youtubePath.indexOf('" title')));
   

    if(youtubePath.indexOf('title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope;') > 0){
        const divArr = document.querySelectorAll(".post-img > div");
        for(const items of divArr){
            items.remove()
        }
        inputFile.value = "";
        postImg.style.display = "block";
        crudImg.removeAttribute("src");
        const youtubeBox = document.createElement("div")
        youtubeBox.className = "youtube-box"
        youtubeBox.innerHTML = youtubePath;
        postImg.append(youtubeBox); // innerHTML을 하면 그 안에 요소들이 재정의 된다 따라서 안에 요소들이 정의된 변수명들이 미스매칭되는 문제가 발생한다.
        deleteImg.style.display = "inline";

    }else{
        alert("유튜브 경로가 잘못되었습니다.")
        youtubePath = null;
        
    }
}

document.addEventListener("click", function(e){
    
    if(e.target == modalSide){
    }else{
        modalSide.style.display = "none";
    }

})

function getAbsoluteTop(element) {
    return window.pageYOffset + element.getBoundingClientRect().top;
}

function getAbsoluteLeft(element) {
    return window.pageYOffset + element.getBoundingClientRect().left;
}

function XSSCheck(str, level) {
    if (level == undefined || level == 0) {
        str = str.replace(/\<|\>|\"|\'|\%|\;|\(|\)|\&|\+|\-/g,"");
    } else if (level != undefined && level == 1) {
        str = str.replace(/\</g, "&lt;");
        str = str.replace(/\>/g, "&gt;");
    }
    return str;
}
