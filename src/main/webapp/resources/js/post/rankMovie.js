console.log("rankMovie")

function rankMovie(){
    $.ajax({
        url: contextPath + "/post/rankMovie",
        type: "POST",
        dataType : "JSON",
        success: function (movieList) {
            console.log(movieList)
            for(const movie of movieList){
                const AVG = movie.AVG;
                const director = movie.director;
                const movieDate = movie.movieDate;
                const movieTitle = movie.movieTitle;
                const poster = movie.poster;
                const ratingCount = movie.ratingCount;
                const temp = `<li>
                                <a href="">
                                    <div>
                                        <div class="postImgwrap">
                                            <img src="${poster}">
                                        </div>
                                        <div class="mvtext">
                                            <div class="side_mvTitle">${movieTitle}</div>
                                            <div class="mvDt"> ${movieDate} | ${director}</div>
                                        </div>
                                        <div class="mvstar-rv">
                                            
                                            <div class="star">`
                                            if(){
                                                
                                            }
                                            `</div>
                                            <div class="mvrv"> 총 리뷰 ${ratingCount}개</div>
                                        </div>
                                    </div>
                                </a>
                              </li>`
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