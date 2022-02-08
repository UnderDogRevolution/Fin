let blind;
let path = $(".select").val();
function changeStatus(event , postNo){
	
	const status = $(".select").val();
	
	console.log(postNo, status);
	const e  = $(event.target);
	if(status == 502){
		 blind = prompt("사유를 입력해주세요");
		 if(blind == null){
			$(event.target).val(path),prop("selected", true);
			return false;
		}else if(blind.trim().length == 0){
			alert("블라인드 사유를 입력해주세요")
			$(event.target).val(path),prop("selected", true);
			return false;
		};
	}else{
		
	}

	$.ajax({
		
		url : contextPath + "/admin/changeStatus",
		data : { "postNo" : postNo  , "status" : status , "blind" : blind},
		
		success:function(){
			alert("값 넘김 성공")
		},
		
		
		
	});

};


function selectPostList(){//검색
	const searchPost = $(".selectPostsend").val(); // select 값
	const inputResult = $("#searchPost").val(); //input 값
	console.log(name);
	console.log(searchPost);
	$.ajax({
		url : contextPath + "/admin/searchPost",
		data : {"searchPost" : searchPost , "inputResult" : inputResult},
		dataType : "JSON",
		
		success:function(){
			
			
			
		},
		error:function(){
			
			
		}
		
		
		
		
		
	});
	
}

