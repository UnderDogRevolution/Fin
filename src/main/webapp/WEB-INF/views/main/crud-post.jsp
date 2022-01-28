<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <form action="${pageContext.servletContext.contextPath}/post/insert" method="post" 
enctype="multipart/form-data" role="form" onsubmit="return postValidate();"> -->
<!-- Modal -->
<div class="modal" id="postModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
         <div class="modal-post">
            <div class="modal-post-header">
                <span>user01</span>  <span class="header-tag" onclick="postValidate()">공유</span> <span class="header-tag" style="display: none;" onclick="Review()">검색 &nbsp; </span>
            </div>
            <div class="modal-post-content">
                <div class="modal-review-title">
                    WALL-E <span>(2021-12-31)  드라마</span>
                </div>
                <!-- 왜 flex를 주니까 margin auto가 먹는가? -->
                <input class="moviedb-input" type="text" style=" width: 80%; margin: auto; flex-grow: 1; font-size: 30px; margin-top: 10px;">
                <div class="search-result">
                    <div>
                        <div class="search-result-img">
                            <img src="${contextPath}/resources/images/temp/walle.jpg" alt="">
                        </div>
                        <div class="search-result-content">
                            Wall-e (2021-01-01) <br>
                            드라마
                        </div>
                    </div>
                    <div>
                        <div class="search-result-img">
                            <img src="${contextPath}/resources/images/temp/walle.jpg" alt="">
                        </div>
                        <div class="search-result-content">
                            Wall-e (2021-01-01) <br>
                            드라마
                        </div>
                    </div>
                    <div>
                        <div class="search-result-img">
                            <img src="${contextPath}/resources/images/temp/walle.jpg" alt="">
                        </div>
                        <div class="search-result-content">
                            Wall-e (2021-01-01) <br>
                            드라마
                        </div>
                    </div>
                    <div>
                        <div class="search-result-img">
                            <img src="${contextPath}/resources/images/temp/walle.jpg" alt="">
                        </div>
                        <div class="search-result-content">
                            Wall-e (2021-01-01) <br>
                            드라마
                        </div>
                    </div>
                    <div>
                        <div class="search-result-img">
                            <img src="${contextPath}/resources/images/temp/walle.jpg" alt="">
                        </div>
                        <div class="search-result-content">
                            Wall-e (2021-01-01) <br>
                            드라마
                        </div>
                    </div>
                </div>
                <div class="modal-side" style="width: 100px; height: 100px; background-color: white; color: black; position: absolute; z-index: 2000; right: -25%;">
                    <ul>
                        
                    </ul>
                </div>
                    <div class="insert-container-textarea">
                        <textarea name="postContent" id="" cols="60" rows="5" ></textarea>
                        <div></div>
                        
                        <!-- <div></div> -->
                    </div>
                <div class="insert-rating" style="display: flex; align-items: center; padding-right: 10px; padding-left: 10px;">
                    <div class="rating">
                        <input type="radio" name="html" value="0.5">
                        <input type="radio" name="html" value="1">
                        <input type="radio" name="html" value="1.5">
                        <input type="radio" name="html" value="2">
                        <input type="radio" name="html" value="2.5">
                        <input type="radio" name="html" value="3">
                        <input type="radio" name="html" value="3.5">
                        <input type="radio" name="html" value="4">
                        <input type="radio" name="html" value="4.5">
                        <input type="radio" name="html" value="5">
                        
                    </div>
                    <div class="rating-value" style="font-size: 20px;">
                        
                    </div>
                    <div class="container-content-count">
                        <span class="content-count">0</span>
                        <span>/500</span>
                    </div>

                </div>
            </div>
            <div class="post-img">
                <img src="" alt="">
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
<div id="fileArea">
    <input type="file" name="images" onchange="loadImg(this,0)"> 
</div>
<script>
    const contextPath = "${contextPath}";
</script>
<script src="${contextPath}/resources/js/post/crud-post.js"></script>