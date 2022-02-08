<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="container-post"> <!-- 마진으로 하면 오류가 난다 무슨 문제인지는 모르겠다. -->
    
    
    <div class="post" href="#target">

        <div class="post-header">
            <div>
                <img class="profile-img" src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
            </div>
            <span>user01</span>  <span>3h</span>
            <div class="dropdown me-1 header-dropdown">
                <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                    <li><a class="dropdown-item" href="#">게시물 수정</a></li>
                    <li><a class="dropdown-item" href="#">신고하기</a></li>
                    <li><a class="dropdown-item" href="#">링크복사</a></li>
                    <li><a class="dropdown-item" href="#">삭제</a></li>
                </ul>
            </div>
        </div>
   
        <div class="post-content">
            <div class="review-title">
                WALL-E <span>(2021-12-31)  드라마</span>
            </div>
            <div class="textarea-box">
                <textarea name="" id="" cols="60" rows="5" readonly>
                    when i was young i listend to the radio
                </textarea>
            </div>
            <div class="post-rating">
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: white" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: white" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: white" aria-hidden="true"></i>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span>3.5</span>
            </div>

            <div class="text-count">
            </div>
            <div class="container-img">
                <img src="${contextPath}/resources/images/temp/walle.jpg" alt="" >
            </div>
        </div>

        <div class="post-footer">
            <div class="container-like">
                <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 100%;">
                <span>300</span>
            </div>
            <div class="container-reply">
                <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 100%;">
                <span>300</span>
            </div>
        </div>
        <div class="input-content-reply">
            <div>
                댓글
            </div>
            <div>
                <input type="text" placeholder="댓글을 달아주세요!">
            </div>
            <div>
                <img class="" src="${contextPath}/resources/images/temp//comment.png" alt="" onclick="insertReply()">
            </div>
        </div>
        <div class="reply">
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 20px; height: 20px; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="line-reply">
               ──── 답글(n)
            </div>
            <div class="child-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="post">

        <div class="post-header">
            <div>
                <img class="profile-img" src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
            </div>
            <span>user01</span>  <span>3h</span>
            <div class="dropdown me-1 header-dropdown">
                <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                    <li><a class="dropdown-item" href="#">게시물 수정</a></li>
                    <li><a class="dropdown-item" href="#">신고하기</a></li>
                    <li><a class="dropdown-item" href="#">링크복사</a></li>
                    <li><a class="dropdown-item" href="#">삭제</a></li>
                </ul>
            </div>
        </div>
   
        <div class="post-content">
            <div class="review-title">
                WALL-E <span>(2021-12-31)  드라마</span>
            </div>
            <div class="textarea-box">
                <textarea name="" id="" cols="60" rows="5" readonly>
                    when i was young i listend to the radio
                </textarea>
            </div>
            <div class="post-rating">
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: yellow" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: white" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: white" aria-hidden="true"></i>
                <i class="fa fa-star rating-star" style="color: white" aria-hidden="true"></i>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span>3.5</span>
            </div>

            <div class="text-count">
            </div>
            <div class="container-img">
                <img src="${contextPath}/resources/images/temp/walle.jpg" alt="" >
            </div>
        </div>

        <div class="post-footer">
            <div class="container-like">
                <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 100%;">
                <span>300</span>
            </div>
            <div class="container-reply">
                <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 100%;">
                <span>300</span>
            </div>
        </div>
        <div class="input-reply">
            <div>
                댓글
            </div>
            <div>
                <input type="text" placeholder="댓글을 달아주세요!">
            </div>
            <div style="flex-basis: 28px; margin-left: auto;">
                <img class="" src="${contextPath}/resources/images/temp//comment.png" alt="">
            </div>
        </div>
        <div class="reply">
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="line-reply">
               ──── 답글(n)
            </div>
            <div class="child-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="parent-reply">
                <div class="profile-reply">
                    <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="">
                </div>
                <div class="user-reply">
                    <div>user01</div>
                    <div>2022-11-31</div>
                </div>
                <div class="content-reply">
                    <div class="text-reply">
                        <div>
                            디지몬 vs 포켓몬
                            <img  src="${contextPath}/resources/images/temp/dots.png" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                <li><a class="dropdown-item" href="#">삭제</a></li>
                                <li><a class="dropdown-item" href="#">신고하기</a></li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <div>
                            <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                            <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 20px; height: 20px;">
                            <span style="opacity: 0.7; font-size: 12px;">300</span>
                        </div>
                        <div style="margin-left: 12px;">
                            <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 20px; height: 20px; opacity: 0.5;">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<img class="top-button" src="${contextPath}/resources/images/temp/top_button.png" alt="">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
    const contextPath = "${contextPath}";
    <c:if test="${loginMember.memberNo != null}">
         const memberNo = ${loginMember.memberNo }
    </c:if>
</script>
<script src="${contextPath}/resources/js/post/post.js"></script>
    