
//const searchResult = document.getElementById("searchResult").value;



	
	function getParam(key){
			return new URLSearchParams(location.search).get(key);
		}
	
	
	// 검색값 가져오기
	document.querySelector("input[name=searchResult]").value = getParam("searchResult");
	
	
//인물 클릭시
$("#peple_").on("click",function(){ // ajax 
    // 검색 val()를 가져온다

    $(".search-result").remove();
    const main = $(".main-search");
    const result = $("<div class='search-result'>");
    const peplewrap = $(" <div class='searchboard-pr'>");
    const imgdiv = $("<div>");
    const img_ = $("<img src>");
    const profdiv = $("<div>");
    const profdiv1 = $("<div>");
    const profdiv2 = $("<div>");
    const button = $("<div>");
    const button_ = $("<button id = 'flbtn' onclick = 'flInsert()'>");
    img_.attr("src" ,'img/user.png' );
    imgdiv.append(img_);
    profdiv1.text("닉네임 : 유동훈");
    profdiv2.text("이메일 : ehdgns874@gmail.comdsadsadsadsadsa");
    profdiv.append(profdiv1);
    profdiv.append(profdiv2); 
    button_.text("팔로우");
    button.append(button_);
    peplewrap.append(imgdiv);
    peplewrap.append(profdiv);
    peplewrap.append(button);
    result.append(peplewrap);
    main.append(result);
});

// 팔로우 버튼 클릭시 text 요청중 으로 바꾸기 
    function flInsert(){
        const flbtn = $('#flbtn').text('요청중')
        $('#flbtn').css('color','white');
        $('#flbtn').css('background-color','black');
    };