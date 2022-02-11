<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <form action="${pageContext.servletContext.contextPath}/post/insert" method="post" 
enctype="multipart/form-data" role="form" onsubmit="return postValidate();"> -->
<!-- Modal -->
<div class="modal" id="postModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="top: -35px;">
    <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content" style="width: 100%; height: 100%; background-color: inherit;">
         <div class="modal-post">
            <div class="modal-post-header">
                <span>${loginMember.memberName}</span>  <span class="header-tag" onclick="postValidate()">공유</span> <span class="header-tag" style="display: none;" onclick="Review()">검색 &nbsp; </span>
            </div>
            <div class="modal-post-content">
                <div class="modal-review-title">
                </div>
                <!-- 왜 flex를 주니까 margin auto가 먹는가? -->
                <input class="moviedb-input" type="text" style=" width: 80%; margin: auto; flex-grow: 1; font-size: 30px; margin-top: 10px;">
                <div class="search-result">
                </div>
                <div class="modal-side" >
                    <ul>
                        
                    </ul>
                </div>
                <div class="insert-container-textarea">
                    <textarea name="postContent" id="" cols="60" rows="5" ></textarea>
                    <div></div>
                </div>
                <div class="insert-rating" style="display: flex; align-items: center; padding-right: 10px; padding-left: 10px;">
                    <div class="rating">
                        <input type="radio" name="html" value="5">
                        <input type="radio" name="html" value="4.5">
                        <input type="radio" name="html" value="4">
                        <input type="radio" name="html" value="3.5">
                        <input type="radio" name="html" value="3">
                        <input type="radio" name="html" value="2.5">
                        <input type="radio" name="html" value="2">
                        <input type="radio" name="html" value="1.5">
                        <input type="radio" name="html" value="1">
                        <input type="radio" name="html" value="0.5">
                        
                    </div>
                    <div class="rating-value" style="font-size: 20px;">
                        
                    </div>
                    <div class="container-content-count">
                        <span class="content-count">0</span>
                        <span>/350</span>
                    </div>

                </div>
            </div>
            <div class="insert-media" >
                <img src="${contextPath}/resources/images/temp/picture.png">
                <img src="${contextPath}/resources/images/temp/youtube.png"onclick="onYoutube();">
                <img  class="on-poster" src="${contextPath}/resources/images/temp/poster.png" style="margin-left: 70%;">
            </div>
            <div class="post-img" style="display: none;">
                <img>
                <!-- <span class="delete-img" style="display: none;">x</span> -->
                <img src="${contextPath}/resources/images/temp/delete.png" class="delete-img">
            </div>
            <!-- <div class="post-footer"> -->
                <!-- <span class="before">이전</span> -->
                <!-- <div style="border: 1px solid black; height: 30px; width: 50px; text-align: center; line-height: 30px;">이전</div> -->
            <!-- </div> -->
        </div>
    </div>
    </div>
<!-- </form> -->

    
</div>
<div id="fileArea" style="display: none;">
    <input class="files" type="file" name="images" onchange="loadImg(this,0)"> 
</div>
<script src="${contextPath}/resources/js/post/crud-post.js"></script>