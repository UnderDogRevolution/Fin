// 헤더 공통 js 끝

// 클릭시 친창 보이게 하기 ㅇㄴㅁ;ㅓ리ㅏㅇ너리;ㄴㅁ라
// 친구 목록을 조회 할 수 있게 ajax 처리를 한다
// 보내야 할 것 로그인 멤버 넘버
// 조회성공시 for each 로 나타나게 해야되는데 for each 먼저 위에 써놓고 div 안에 append하게 해야되는거?
// 일단 화면을 봐야되니까 그냥 만들어지는지 확인하자



$('#MessageModal').on('show.bs.modal', function (event) {
    // 모달 열렸을 때 실행
    

    




}).on('hide.bs.modal', function() {
    // 모달 닫히면서 실행 초기화 시키기
    $('.modal-body').remove();
});

// 메세지버튼 클릭시 동작하는함수
// 보내기버튼 클릭과 동시에 친창 부분에 목록이 나타나야된다
// 채팅방이 만들어짐과 동시에 그사람한테도 보여져야 된다.
// 
$('.messagebtn2').on("click",function(){
    $('#MessageModal').modal("hide");
    // 새로고침해서 조회되게 추가
    // 만약 채팅창이 이미 보여져있는 경우? 채팅방이 이미있는 경우는 insert 되지않게하기
    // 없는경우에만 insert 
    // 보내기 버튼 클릭시 채팅방으로 자동이동되게 해야된다
    // 어떻게함?
    searchChatting();
    //
});


// 채팅 삭제 기능
function deletChat(e) {
    console.log(1);
    if (confirm("채팅방을 나가시겠습니까?")) {
        //ajax 사용해야됨 ㅋㅋㅋㅋㅋㅋㅋㅋㅋ으아아ㅓㅇ라미ㅓㄹ
        e.parentNode.remove();
        return false;
    }

}

$('.fas.fa-times.delete-message-room').click(function() {
    deletChat(this);
    return false;
})

function searchChatting() { // 친구 클릭시 동작

    //ajax 실행 시 동작
    // const chatContent = e.parentNode.parentNode.nextSibling.nextSibling.nextSibling.nextSibling;
    // chatContent
    // chatting 창부분 변환 -- chat main 선택
    $(".chatContent").remove();
    // 선택후 
    const msgbtn = $('<svg  onclick = "msgUp()"class = "msgbtn" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M15.379,19.1403 L12.108,12.5993 L19.467,5.2413 L15.379,19.1403 Z M4.86,8.6213 L18.76,4.5343 L11.401,11.8923 L4.86,8.6213 Z M3.359,8.0213 C2.923,8.1493 2.87,8.7443 3.276,8.9483 L11.128,12.8733 L15.053,20.7243 C15.256,21.1303 15.852,21.0773 15.98,20.6413 L20.98,3.6413 C21.091,3.2623 20.739,2.9093 20.359,3.0213 L3.359,8.0213 Z"/></svg>');
    const imgbtn = $('<svg onclick = "imgUp()"  aria-label="사진 또는 동영상 추가" class="_8-yf5 imgbtn" color="#262626" fill="#262626" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M6.549 5.013A1.557 1.557 0 108.106 6.57a1.557 1.557 0 00-1.557-1.557z" fill-rule="evenodd"></path><path d="M2 18.605l3.901-3.9a.908.908 0 011.284 0l2.807 2.806a.908.908 0 001.283 0l5.534-5.534a.908.908 0 011.283 0l3.905 3.905" fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="2"></path><path d="M18.44 2.004A3.56 3.56 0 0122 5.564h0v12.873a3.56 3.56 0 01-3.56 3.56H5.568a3.56 3.56 0 01-3.56-3.56V5.563a3.56 3.56 0 013.56-3.56z" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"></path></svg>');




    // 채팅창 구현하기
    const chatContent = $("<div class='chatContent'>");
    const chatHeader = $("<div class=chatContent-header>")
    const chatHeader_div1 = $("<div>") ;/* 채팅헤더 이미지 영역 */
    const chatHeader_div2 = $("<div>"); /* 채팅헤더 네임영역 */
    const chatMemberImg = $("<img>");/* 대상이미지 */
    const chatMain = $("<div>");/* 채팅 메인 전체 */
    const display = $("<ul id = 'chattingwrap'>"); /*대화부분 */
    const chatFooter = $("<div class='chatContent-footer'>");
    const inputChat = $(" <textarea id='inputChatting'>"); // textarea 부분
    chatMain.addClass("chatContent-main")/* 메인전체 클래스 삽입 */
    display.addClass("display-chatting")/* ul에 class 삽입 */
    
    // 대상 이미지 삽입
    chatHeader_div1.append(chatMemberImg);
    // 대상 이름 삽입
    chatHeader_div2.text("회원이름넣기")
    chatMemberImg.attr("src" ,'img/user.png' )/* 이미지주소설정 */
    


    chatHeader.append(chatHeader_div1);
    chatHeader.append(chatHeader_div2);
    //span1.append(messageput);
    //span2.append(fileput);
    chatFooter.append(inputChat);
    //chatFooter.append(messageput);
    chatFooter.append(msgbtn);
    chatFooter.append(imgbtn);

    //chatFooter.append(span1);
    //chatFooter.append(span2);
    /* putwrap1.append(messageput);
    putwrap1.append(fileput); */

    chatMain.append(display);/* display영역 */
    chatContent.append(chatHeader);
    chatContent.append(chatMain);
    chatContent.append(chatFooter);
    $(".chatwrap").append(chatContent);


}



// 채팅기능 엔터시 동작
// 채팅 삭제 기능

// 채팅 메세지 삭제
function deletMessage(e) {
    console.log(1);
    if (confirm("메세지를 삭제하시겠습니까")) {
        //ajax 
        console.log(e.parentNode.nextElementSibling);
        e.parentNode.nextElementSibling.remove();
        e.parentNode.remove();
    }

}

// 메세지 보내기 버튼 클릭 이것도 ajax

// 이미지 버튼 클릭시 동작하게 설정
    function imgUp(){
        console.log("1");
        var index = $(".imgbtn").index(this);
        $("[type=file]").eq(index).val(""); // 초기화 시켜줘야 같은파일 선택가능
        $("[type=file]").eq(index).click();
    }



// 파일을 선택한 경우 선택된 input 요소를 백업해서 저장하는 용도의 객체
const fileClone = {};

// x버튼이 눌러져 삭제된 이미지 레벨을 저장할 배열
// -> 배열을 input 태그 value로 추가하면 '요소1,요소2,....'형태의 문자열로 변환됨

const deleteImages = [];



// 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
function loadImg(input, num) {
    // 매개변수 value == 클릭된 input 요소


    // 파일이 선택된 경우 true
    if (input.files && input.files[0]) {

        fileClone[num] = $(input).clone(); // 백업객체에 복제본 추가

        // deleteImages 배열에 num값과 같은 번호가 존재하는지 확인
        if (deleteImages.indexOf(num) != -1) { // 존재하는 경우
            deleteImages.splice(deleteImages.indexOf(num), 1);


        }

        var reader = new FileReader();
        // 자바스크립트 FileReader
        // 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 읽을 파일을 가리키는 File 혹은 Blob객체를 이용해 파일의 내용을 읽고 사용자의 컴퓨터에 저장하는 것을 가능하게 해주는 객체


        // 선택된 파일 읽기 시작
        reader.readAsDataURL(input.files[0]);
        // FileReader.readAsDataURL()
        // 지정된 내용을 읽기 시작합니다. Blob완료되면 result속성 data:에 파일 데이터를 나타내는 URL이 포함 됩니다.



        // FileReader.onload
        // load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료 되었을 때마다 발생합니다.

        // 다 읽은 경우
        reader.onload = function (e) {
            //console.log(e.target.result);
            // e.target.result
            // -> 파일 읽기 동작을 성공한 객체에(fileTag) 올라간 결과(이미지 또는 파일)
           
           
           
           
            const divImg = $("<div class = 'chatImg'>")
            const img = $("<img>");
            divImg.append(img);
            img.attr("src", e.target.result);
            const li = $("<li>")
            const ul = $("#chattingwrap")
            const myName = $("<span class = 'myName'>");
            const myMessage =  $("<span class = 'myMessage'>");
            const msgCreate = $("<span class = 'msgCreate'>");
            msgCreate.html("msg.create");
            li.addClass("myChatting");
            myMessage.append(divImg);
            li.append(myName);
            li.append(myMessage);
            li.append(msgCreate);
            ul.append(myName);
            ul.append(li);
           /* 
            const divImg = $("<div class = 'chatImg'>")
            const img = $("<img>");
            divImg.append(img);
            img.attr("src", e.target.result);
            const li = $("<li>")
            const ul = $("#chattingwrap")
            const frName = $("<span class = 'frName'>");
            const frMessage =  $("<span class = 'frMessage'>");
            const msgCreate = $("<span class = 'msgCreate'>");
            frName.html("상대방이름");
            msgCreate.html("msg.create");
            li.addClass("frChatting");
            frMessage.append(divImg);
            li.append(frName);
            li.append(frMessage);
            li.append(msgCreate);
            ul.append(frName);
            ul.append(li);

 */

           



           // console.log(document.getElementById("chattingwrap").scrollHeight)
         /*    document.getElementById("chattingwrap").scrollTop
                = document.getElementById("chattingwrap").scrollHeight; */

        }

    } else { // 취소 클릭시
        console.log("취소클릭함");

        $(input).before(fileClone[num].clone()); // 원본 복제본의 복제본을 만들어 삽입
        $(input).remove(); // 원본 삭제
        // innerHTML , html()
        // innerHTML = "<h1></h1>"
        // -> 작성된 문자열을 HTML Parser 를 이용해서 해석 후 화면에 반영
        //		-> 문자열 내부에 요소가 있는지 처음에 모른다
        // 			-> 읽을 때 마다 같은 문장이라도 새로운 요소로 인식한다.
        // innerHTML = "안녕?";
        // innerHTML = "<h1>안녕?</h1>"

        // createElement("태그명"), $("<태그명>"), 얻어온 요소
        // == DOM 요소 
        //  -> 화면상에는 동일한 DOM요소가 존재할 수 없다.

        // 공통점 : 화면에 요소를 추가할 수 있따.
    }




}

// 메세지 보내기 실행
// XSS 처리함수
function XSS(message){

    let str = message;
  
    str = str.replace(/&/g, "&amp;");
    str = str.replace(/</g, "&lt;");
    str = str.replace(/>/g, "&gt;");
    str = str.replace(/"/g, "&quot;");
  
    return str;
  };


/*   chattingSock.onmessage = function(e){
    // e.data : 전달받은 메세지
    console.log(JSON.parse(e.data))
    // 메소드를 통해 전달받은 객체값을 JSON객체로 변환해서 obj 변수에 저장.
   const obj = JSON.parse(e.data);


   const li = $("<li>");
   const p = $("<p class='chat'>");
   const span = $("<span class='chatDate'>");
   span.html(obj.createDate);

     // const chat = obj.message.replace(/\\n/g, "<br>");
    const i = $("<i class='fas fa-times messageDelete' onclick='deletMessage(this)'>");
 
     // XSS , 개행문자 처리
     if(obj.message != undefined){// 메세지가 있는 경우

         let chat = XSS(obj.message);
         chat = chat.replaceAll("\n","<br>")
         console.log(chat);
         p.html(chat);
        }else{// 메세지가 없는 경우(나가기)
            p.html("<b>"+obj.memberName+"님이 나가셨습니다.</b>")
        }

   if (obj.memberNo == memberNo) {
      li.addClass("myChat");
      li.append(span);
      li.append(p);
   } else {
      li.html("<b>" + obj.memberName + "</b><br>");
      li.append(p);
      li.append(span);
   }


   $(".display-chatting").append(li);

   // 채팅 입력 시 스크롤을 가장 아래로 내리기
   $(".display-chatting").scrollTop($(".display-chatting")[0].scrollHeight);
}
 */

// 메세지 버튼 클릭시 동작
$('.msgbtn').click(function(){
    console.log("1");


})
function msgUp(){ //메세지 보내기

  /*   const li = $("<li>")
    const ul = $("#chattingwrap")
    const text = $("#inputChatting").val();
    const myMessage =  $("<span class = 'myMessage'>");
    const msgCreate = $("<span class = 'msgCreate'>");
    msgCreate.html("msg.create");
    li.addClass("myChatting");
    myMessage.text(text)
    li.append(myMessage);
    li.append(msgCreate);
    ul.append(li);
    $("#inputChatting").val("");
   */
    
     const li = $("<li>")
    const ul = $("#chattingwrap")
    const text = $("#inputChatting").val();
    const frName = $("<span class = 'frName'>");
    const frMessage =  $("<span class = 'frMessage'>");
    const msgCreate = $("<span class = 'msgCreate'>");
    
    if(text.trim().length == 0){
        alert("내용을 입력해주세요");
    }else{

        
        
        
        
        frName.html("상대방이름");
        msgCreate.html("msg.create");
        li.addClass("frChatting");
        frMessage.text(text)
        li.append(frName);
        li.append(frMessage);
        li.append(msgCreate);
        ul.append(frName);
        ul.append(li);
        
        /*  const frImg = $("<img class = 'frImg' src = 'img/라라랜드.jpg'>")
        frName.append(frImg); */
    }
        $("#inputChatting").val("");
    };
    