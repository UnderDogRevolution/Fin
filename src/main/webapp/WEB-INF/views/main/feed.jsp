<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="container-post" style="padding-top: 122px; padding-right: 30%;"> <!-- 마진으로 하면 오류가 난다 무슨 문제인지는 모르겠다. -->

    
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

    </div>

    <div class="post"style="width: 500px;">
        <div class="post-header" style="display: flex; align-items: center;">
            <div style="width: 60px; height: 60px;  border-radius: 50px; border: 1px solid black; overflow:hidden; align-items: flex-start;">
            <img src="${contextPath}/resources/images/temp/raraland.jpg" alt="" style="width: 100%; height: 100%;"><!-- resoures -->
            </div>
            <span style="margin-left: 15px;">user01</span>  <span style="opacity: 0.5; margin-left: 10px;">3h</span>
            <div class="dropdown me-1" style="height: 100%; flex-grow: 1; padding-top: 4%;">
                <img src="${contextPath}/resources/images/temp/dots.png" style="width:8%; height: 40%; position: absolute; right: 0; " id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-40,-10">
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
            <div style="display: flex; padding-left: 15px; align-items: center;">
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
                <span style="color: white;">3.5</span>
            </div>

            <div class="text-count">
            </div>
            <div class="container-img">
                <img src="${contextPath}/resources/images/temp/walle.jpg" alt="" style="width: 100%; max-height: 600px;">
            </div>
        </div>
        <div class="post-footer">
            <div class="container-like" style="width: 7%; text-align: center;">
                <img src="${contextPath}/resources/images/temp/popcorn vivid.png" alt="" style="width: 100%; display: none;">
                <img src="${contextPath}/resources/images/temp/popcorn white.png" alt="" style="width: 100%;">
                <span style="color: white; font-weight: bold;">300</span>
            </div>
            <div class="container-reply" style="width: 7%; text-align: center; margin-left: 15px;">
                <img src="${contextPath}/resources/images/temp/reply.png" alt="" style="width: 100%;">
                <span style="color: white; font-weight: bold;">300</span>
            </div>
        </div>
    </div>
    
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/post/post.js"></script>
    