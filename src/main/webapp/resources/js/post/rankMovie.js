rankMovie()
function rankMovie(){
    const sideUl = document.getElementsByClassName("side-ul")[0];
    $.ajax({
        url: contextPath + "/post/rankMovie",
        type: "POST",
        dataType : "JSON",
        success: function (movieList) {
            console.log(movieList)
            sideUl.innerHTML = ""
            for(const movie of movieList){
                const AVG = movie.AVG;
                const director = movie.director;
                const movieDate = movie.movieDate;
                const movieTitle = movie.movieTitle;
                const poster = movie.poster;
                const ratingCount = movie.ratingCount;
                let star = ``;
                console.log(Number(AVG))
                    for(let i=0; i < 10-Math.floor(Number(AVG)*2); i++){
                        star += `<i class="fa fa-star side-star" aria-hidden="true" style="color: white"/></i>`
                    }
                    for(let i =0; i < Math.floor(Number(AVG)*2); i++){
                        star += `<i class="fa fa-star side-star" aria-hidden="true" style="color: yellow"></i>`
                    }
                const temp = `<li>
                                <a href="${contextPath}/search/?searchResult=${movieTitle}&st=movie">
                                    <div>
                                        <div class="postImgwrap">
                                            <img src="${poster}">
                                        </div>
                                        <div class="mvtext">
                                            <div class="side_mvTitle">${movieTitle}</div>
                                            <div class="mvDt"> ${movieDate} | ${director}</div>
                                        </div>
                                        <div class="mvstar-rv">
                                            <div class="star">
                                            `+star+`
                                            </div>
                                            <div class="mvrv"> 총 리뷰 ${ratingCount}개</div>
                                        </div>
                                    </div>
                                </a>
                              </li>`
                sideUl.innerHTML += temp;
                
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