
//const searchResult = document.getElementById("searchResult").value;

	function getParam(key){
			return new URLSearchParams(location.search).get(key);
		}
	
	
	// 검색값 가져오기
	document.querySelector("input[name=searchResult]").value = getParam("searchResult");
	
	
//인물 클릭시
$("#peple_").on("click",function(){ // ajax 
    // 검색 val()를 가져온다
	console.log(search);
    $(".container-post").remove();
    const mainwrap = $(".mainwrap");
    const main = $("<div class = 'container-post'>");
    const result = $("<div class='.post'>");
    const peplewrap = $(" <div class='searchboard-pr'>");
    const imgdiv = $("<div>");
    const img_ = $("<img>");
    const profdiv = $("<div>");
    const profdiv1 = $("<div>");
    const profdiv2 = $("<div>");
    const button = $("<div>");
    const button_ = $("<button id = 'flbtn' onclick = 'flInsert()'>");
    
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
    mainwrap.append(main);
});

// 팔로우 버튼 클릭시 text 요청중 으로 바꾸기 
    function flInsert(){
        const btn = $('#flbtn').text();
        const flbtn = $('#flbtn').text('친구')
	if(btn == "팔로우"){
		$('#flbtn').text("친구");
        $('#flbtn').css('color','white');
        $('#flbtn').css('background-color','black');
	}else{
		
		$('#flbtn').text("팔로우");
        $('#flbtn').css('color','black');
        $('#flbtn').css('background-color','white');
		
	}
	
    };