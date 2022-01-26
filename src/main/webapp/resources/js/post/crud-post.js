console.log("curd-post.js");

// 즉시 실행 함수 (function(){})()

// 이미지 영역을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수

(function(){
	document.getElementsByClassName("post-img")[0].addEventListener("click", function(){
		document.querySelectorAll("[type='file']")[0].click()
	})
})()

function loadImg(input, num){
	const img = document.getElementsByClassName("post-img")[0].firstElementChild
	if(input.files && input.files[0]){

		// if(deleteImages.indexOf(num) != -1){
		// 	deleteImages.splice(deleteImages.indexOf(num), 1)
		// }

		const reader = new FileReader()

		reader.readAsDataURL(input.files[0])

		reader.onload = function(e){
			console.log(img);
			img.setAttribute("src", e.target.result)
			img.style.width = "100%";
			img.style.height = "100%";
		}

	}else{
		// 취소 클릭
		img.removeAttribute("src")
		img.removeAttribute("style")
	}
}

// function loadImg(input, num) {
// 	// 매개변수 input == 클릭된 input 요소


// 	// 파일이 선택된 경우 true
// 	if (input.files && input.files[0]) {

// 		fileClone[num] = $(input).clone() // 백업 객체에 복제본 추가

// 		// deleteImages 배열에 num값과 같은 번호가 존재하는지 확인
// 		if(deleteImages.indexOf(num) != -1){ //존재하는 경우
// 			// 배열.splice(시작 인덱스, 제거할 수) : 배열 내 시작 인데스 부터 지정된 개수 만큼 요소 삭제
// 			deleteImages.splice(deleteImages.indexOf(num), 1)
// 		}

// 		var reader = new FileReader();
// 		// 자바스크립트 FileReader
// 		// 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 읽을 파일을 가리키는 File 혹은 Blob객체를 이용해 파일의 내용을 읽고 사용자의 컴퓨터에 저장하는 것을 가능하게 해주는 객체


// 		// 선택된 파일 읽기 시작
// 		reader.readAsDataURL(input.files[0]);
// 		// FileReader.readAsDataURL()
// 		// 지정된 내용을 읽기 시작합니다. Blob완료되면 result속성 data:에 파일 데이터를 나타내는 URL이 포함 됩니다.



// 		// FileReader.onload
// 		// load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료 되었을 때마다 발생합니다.

// 		// 다 읽은 경우
// 		reader.onload = function(e) {
// 			//console.log(e.target.result);
// 			// e.target.result
// 			// -> 파일 읽기 동작을 성공한 객체에(fileTag) 올라간 결과(이미지 또는 파일)

// 			$(".boardImg").eq(num).children("img").attr("src", e.target.result);
// 		}

// 	}else{
// 		console.log("취소 클릭함");

// 		// 취소가 실행된 input 태그 앞에 백업해둔 복제본을 추가
// 		$(input).before(fileClone[num].clone())
// 		// -> 원본 복제본의 복제본을 만들어 삽입

// 		$(input).remove() // 원본 삭제

// 		// innerHTML, html()
// 		// -> 작성된 문자열을 HTML Parser를 이용해서 해석 후 화면에 반영 
// 		// -> 문자열 내부에 요소가 있는지 처음에 모른다
// 		// -> 읽을 때 마다 같은 문장이라도 새로운 요소로 인식한다.
// 		// innerHTML = "안녕?"
// 		// innerHTML = "<h1>안녕?<h1>"
// 		// createElement("태그명"), $("<태그명>"), 얻어온 요소
// 		// == DOM 요소
// 		// -> 화면상에는 동일한 DOM 요소가 중복 존재할 수 없다.

// 		// 공통점 : 화면에 요소를 추가할 수 있다.

// 	}
// }
const moviedbInput = document.getElementsByClassName("moviedb-input")[0];
const searchResult2 = document.getElementsByClassName("search-result")[0];
const textareaBox = document.getElementsByClassName("insert-container-textarea")[0];
const textCount = document.getElementsByClassName("text-count")[0];
const postImg = document.getElementsByClassName("post-img")[0];
const reviewTitle = document.getElementsByClassName("modal-review-title")[0];
const starInput = document.getElementsByClassName("rating")[0];
const postSubmit = document.getElementsByClassName("header-tag")[0]
const searchMovie = document.getElementsByClassName("header-tag")[1]
const containerTextCount = document.getElementsByClassName("container-content-count")[0]
function Write(){
	moviedbInput.style.display = "none";	
	searchResult2.style.display = "none";	
	reviewTitle.style.display = "none";	
	starInput.style.display = "none";	
	searchMovie.style.display = "none";	
	
	textareaBox.style.display = "block";
	textCount.style.display = "block";
	postImg.style.display = "block";

	postSubmit.style.display = "inline";
	containerTextCount.style.display = "inline";
}

function Review(){
	moviedbInput.style.display = "flex";	
	searchResult2.style.display = "flex";	
	textareaBox.style.display = "none";
	textCount.style.display = "none";
	postImg.style.display = "none";
	reviewTitle.style.display = "none";	
	starInput.style.display = "none";	
	searchMovie.style.display = "none";
	postSubmit.style.display = "none";
	containerTextCount.style.display = "none";	
}

// document.getElementsByClassName("write")[0].addEventListener("click", function(){
// 	Write()
// })

// document.getElementsByClassName("review")[0].addEventListener("click", function(){
// 	Review()
// })

const inputContent = document.querySelectorAll(".insert-container-textarea > textarea")[0];

inputContent.addEventListener("input", function(){
    const countBox = document.getElementsByClassName("content-count")[0]
    // 바이트로 세는 것은 나중에 하자
    let count = inputContent.value.length
    countBox.innerText = count
    if(count >= 500){
        inputContent.value = inputContent.value.substring(0, 500)
        count = 500   
    }
    
    countBox.innerText = count;
})

console.log("moviedb");

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
    console.log(search);
    await fetchMovie(page);
});
//API 서버에서 데이터 가져오는 함수



async function fetchMovie(page){
    searchResult.innerHTML = "";
    if(search.trim().length>0){
        const multiSearch = "https://api.themoviedb.org/3/search/multi?api_key="+key+"&language=ko-KR&query="+search+"&page="+page
        const result = await fetch(multiSearch).then(res => res.json()) //await을 안하면 promise 객체였다가 await을 하니 배열로 반환됐다.
        for(const items of result.results){
            if(items.title != null){
                const div1 = document.createElement("div");
                const div2 = document.createElement("div");
                const div3 = document.createElement("div");
                const img = document.createElement("img")
    
                div2.className = "search-result-img";
                img.setAttribute("src", base_url + items.poster_path)
                div2.appendChild(img)
                
                div3.className = "search-result-content";
                div3.innerHTML = items.title + "<br> ("+items.release_date+") " + searchGenre(items.media_type, items.genre_ids[0]);
    
                div1.appendChild(div2);
                div1.appendChild(div3);
                searchResult.appendChild(div1);
            }
            

        }
    }

    if(document.getElementsByClassName("search-result-img")){
        const resultImg = document.querySelectorAll(".search-result-img > img")
        for(const items of resultImg){
            items.addEventListener("click", function(e){

                const img = document.querySelector(".post-img > img");
                img.setAttribute("src", this.getAttribute("src"));

                reviewTitle.innerHTML = ""
                Write();
                reviewTitle.style.display = "block";	
            	starInput.style.display = "flex";
                searchMovie.style.display = "inline";
                postSubmit.style.display = "inline";
                const content = this.parentElement.nextElementSibling.innerHTML;
                let title = content.substring(content.indexOf('('), -1);
                // const date =  content.substring(content.indexOf('('), content.indexOf(')')+1);
                let genre = content.substring(content.indexOf('>')+1);
                title = title.replaceAll("<br>", "");

                reviewTitle.innerHTML = title.trim() + "<span>"+ genre + "</span>";
                
            })
        }
    }
}
/* async function fetchMovie(page){
    if(search.trim().length >0){
        const multiSearch = "https://api.themoviedb.org/3/search/multi?api_key="+key+"&language=ko-KR&query="+search+"&page="+page
        await fetch(multiSearch)
        .then(res => res.json()) // response 응답 객체를 json객체로 변환
        .then(function(res){
            searchResult = []
            searchContent = {}
            div.innerHTML = ""
            const movies = res.results
            // 중첩 ajax(fetch chaining)를 지양하자 성능 저하를 초래할 수 있다.
            for(const items of movies){

                    if(items.title != null){
                        // div.innerHTML += items.title + "(" + items.release_date + ")" + "<br>"
                        searchContent = {"title" : items.title, "date" : items.release_date, "movie_id" : items.id }
                        searchResult.push(searchContent)
                        // console.log(searchResult);
                    
                    }
                    // // div.innerHTML += "<img src='"+ base_url + items.poster_path +"'  >"
                    // // div.innerHTML += "<img src='"+ base_url + items.backdrop_path +"'  >"
            }
        })
        .catch(erro => console.log(erro));
    }
    let i = 0
    for(const movieId of searchResult){
        // ( async function(movieId){
            if(movieId.movie_id != null){
                await fetch("https://api.themoviedb.org/3/movie/"+movieId.movie_id+"/credits?api_key="+key+"&language=ko-KR")
                .then(res => res.json())
                .then(async function(res){
                    movieId.director_id = await res.crew[1].id
                    searchResult[i] = await movieId;
                })
                .catch(erro => console.log(erro))
                i++
            }
        // })(movieId)
    }

    for(let j=0; j<searchResult.length; j++){
        if(j > i){
            await searchResult.pop()
        }
    }
    i=0
    console.log(searchResult);
    for(let j=0; j < searchResult.length; j++){
        // (async function(j){
            console.log(searchResult[j]);
            console.log(searchResult[j].director_id);
            if(searchResult[j].director_id != null){
                await fetch("https://api.themoviedb.org/3/person/"+searchResult[j].director_id+"?api_key="+key+"&language=ko-KR")
                .then(res => res.json())
                .then(function(res){
                    console.log(res);
                    // console.log(res.also_known_as[0]);
                    // if(res.also_known_as[0] != null ){
                    //     items.director_name = res.also_known_as[0]
                    //     searchResult[i] = items
                    // }
                    // i++
                })
                .catch(erro => console.log(erro))
            }
        // })(j)
    }
                        


}; */

// 감독이랑 배우를 데리고 오고자 한다.
// 영화를 검색하면

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
//전과 다르다 전과 다른 내용을 어딘가에 저장한다.
let beforeAttachTag;
inputTextarea.addEventListener("input",function(){
    beforeAttachTag = document.getElementsByClassName("attach");
    changeContent();
    const attachTag = document.getElementsByClassName("attach");
    if(beforeAttachTag != null){
    console.log(beforeAttachTag[0].innerText);
    console.log(attachTag[0].innerText);
    for(let i=0; i < attachTag.length; i++){
        console.log(beforeAttachTag[0].innerText);
        console.log(attachTag[0].innerText);
        if(beforeAttachTag[i].innerText.length >0){
            console.log(beforeAttachTag[i].innerText);
            console.log(attachTag[i].innerText);
            if(beforeAttachTag[i].innerText != attachTag[i].innerText){
                console.log("확인");
    
    




    let tagListUl = document.querySelectorAll(".modal-side > ul")[0]
    tagListUl.innerHTML ="";
    if(attachTag.length >0){ // 태그가 존재한다.
        let tagName = attachTag[attachTag.length-1].innerText;
        if(attachTag[attachTag.length-1].innerText.indexOf('#') == '0'){ // innerText를 깜박했따
            tagName = tagName.replace('#', "");
            if(tagName.length >0){
                $.ajax({ //async : false 하면 순서대로 작동되서 잘되나 반응이 느려진다.
                    url: contextPath + "/post/searchTag",
                    data: { "tagName": tagName },
                    type: "POST",
                    dataType : "JSON",
                    success: function (tagList) {
                        for(const items of tagList){
                            tagListUl.innerHTML += '<li>#'+ items.tagName +'</li>';
                            const li = document.querySelectorAll(".modal-side > ul > li")
                            for(const items2 of li){
                                items2.addEventListener("click", function(){
                                    attachTag[attachTag.length-1].innerText = items2.innerText;
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
        }else if(attachTag[attachTag.length-1].innerText.indexOf('@') == 0){
            tagName = tagName.replace('@', "");
            if(tagName.length >0){
                $.ajax({ //async : false 하면 순서대로 작동되서 잘되나 반응이 느려진다.
                    url: contextPath + "/post/searchUser",
                    data: { "tagName": tagName },
                    type: "POST",
                    dataType : "JSON",
                    success: function (tagList) {
                        for(const items of tagList){
                            tagListUl.innerHTML += '<li>@'+ items.memberNickName +'</li>';
                            const li = document.querySelectorAll(".modal-side > ul > li")
                            for(const items2 of li){
                                items2.addEventListener("click", function(){
                                    attachTag[attachTag.length-1].innerText = items2.innerText;
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

function autoComplete(arr){ // 배열 매개변수
    for(const items of arr){
        console.log(items.innerText);
        items.addEventListener("click",function(){

        })
    }
}

function changeContent(){
    const content = inputTextarea.value.replaceAll("\n","<br>");
    const tagRegExp = /#[ㄱ-힣a-zA-Z\d]*/g;
    const userRegExp = /@[ㄱ-힣a-zA-Z\d]*/g;
    const movieRegExp = /\*[ㄱ-힣a-zA-Z\d]*/g;
    let change = content.replace(tagRegExp, function(target){
        return "<a href='#' class='attach' style='color: blue;'>" + target + "</a>";
    })
    change = change.replace(userRegExp, function(target){
        return "<a href='#' class='attach' style='color: purple;'>" + target + "</a>";
    })
    change = change.replace(movieRegExp, function(target){
        return "<a href='#' class='attach' style='color: yellow;'>" + target + "</a>";
    })
    inputDiv.innerHTML = change;
}

