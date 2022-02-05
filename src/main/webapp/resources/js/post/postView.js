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