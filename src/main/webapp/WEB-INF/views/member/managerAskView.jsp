<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<title>바라는 점</title>

<style type="text/css">
html, body {
	background: #0D0D0D;
	color: #FDFDFD;
	height: 100%;
	padding: 0px;
	margin: 0px;
	font-family: "Noto Sans KR";
}

input {
	font-family: "Noto Sans KR";
}

#wrap {
	width: 80%;
	height: auto;
	margin: 5% auto 0 auto;
	font-size: 1rem;
	color: #000000;
	text-align: center;
}

.side {
	float: left;
	width: 22%;
	height: 94%;
	line-height: 100%;
	background-color: #0D0D0D;
}

.col-form-label {
	margin-bottom: 0.5rem;
	font-weight: bold;
	font-size: 1.5rem;
}

.contents {
	float: left;
	width: 78%;
	height: 94%;
	line-height: 50%;
	background-color: #ffffff;
	border-radius: 1rem;
	line-height: normal;
}


</style>
</head>


<div id="wrap">
	<div class="header"></div>
	<div class="side">
		<a class="btn btn-danger btn-lg" a	href="askView" role="button">바라는 점</a><br> 

	</div>


<div class="container my-5">
	<h1 id="boardName">
	   게시판
	   
	   <select id="selectCategory" name="ct">
		  <option>전체</option>
		  <c:forEach items="${category}"  var="c">
			 <option value="${c.categoryCode}">${c.categoryName }</option>
		  </c:forEach>
	   </select>
	</h1>
	  
	  
	  
	  <%-- 파라미터 중 sv가 있다면 변수 생성 --%>
	  <c:if test="${!empty param.sv}">
		  <c:set var="s"  value="&sk=${param.sk}&sv=${param.sv}" />
	  </c:if>
	  
	  <%-- 파라미터 중 ct가 있다면 변수 생성 --%>
	  <c:if test="${!empty param.ct}">
		  <c:set var="c"  value="&ct=${param.ct}" />
	  </c:if>
	  
	  
	  
	  <div class="list-wrapper">
		  <table class="table table-hover table-striped my-5" id="list-table">
			  <thead>
				  <tr>
					  <th>글번호</th>
					  <th>제목</th>
					  <th>내용</th>
					  <th>작성자</th>
					  <th>작성일</th>
				  </tr>
			  </thead>


			  <%-- 게시글 목록 출력 --%>
			  <tbody>
			  
				  <c:choose>
					  
					  <c:when test="${empty boardList}"> 
						  <tr>
							  <td colspan="6">문의글이 존재하지 않습니다.</td>
						  </tr>
					  </c:when>
					  
					  <c:otherwise>
						  <c:forEach items="${boardList}" var="board">
						  
							  <%-- 조회된 게시글 목록이 있을 때 --%>
							  <tr>
								  <%-- 글 번호 --%>
								  <td>${board.boardNo}</td>
								  
								  <%-- 글 제목 --%>
								  <td class="boardTitle">
									  <a href="${contextPath}/board/view/${board.boardNo}?cp=${pagination.currentPage}${c}${s}">
									  <!-- <a href="view"> -->
									  
										  <c:choose>
											  <c:when test="${board.statusName eq '블라인드' }">                                                          
												  <strong style="color:red; font-size:11px">
													  관리자에 의해 블라인드 처리된 게시글입니다.
												  </strong>
											  </c:when>
											  <c:otherwise> 
												  
												  <c:if test="${board.imgList[0].imgLevel == 0}">
													  <img src="${contextPath}${board.imgList[0].imgPath}${board.imgList[0].imgName}">
													  
												  </c:if>
											  
												  ${board.boardTitle}
											  </c:otherwise>
										  </c:choose>
									  
									  </a>
								  </td>
								  
								  
								  <%-- 작성자 --%>
								  <td>${board.memberName }</td>
							  
														  
								  <%-- 작성일 --%>
								  <td>${board.createDate }</td>
							  </tr>
						  </c:forEach>
					  </c:otherwise>
				  
				  </c:choose>
			  </tbody>
		  </table>
	  </div>


	  <%---------------------- Pagination ----------------------%>
	  
	  

	  <div class="my-5">
		  <ul class="pagination">
			  
			  
			  <c:if test="${pagination.startPage != 1 }">
				  <li><a class="page-link" href="list?cp=1${c}${s}">&lt;&lt;</a></li>
				  <li><a class="page-link" href="list?cp=${pagination.prevPage}${c}${s}">&lt;</a></li>
			  </c:if>
			  
			  <%-- 페이지네이션 번호 목록 --%>
			  <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1"  var="i">
				  <c:choose>
					  <c:when test="${i == pagination.currentPage}">
						  <li><a class="page-link" style="color:black; font-weight:bold;">${i}</a></li>   
					  </c:when>
					  
					  <c:otherwise>
						  <li><a class="page-link" href="list?cp=${i}${c}${s}">${i}</a></li>
					  </c:otherwise>
				  </c:choose>
			  </c:forEach>
			  
			  <c:if test="${pagination.endPage != pagination.maxPage }">
				  <li><a class="page-link" href="list?cp=${pagination.nextPage}${c}${s}">&gt;</a></li>
				  <li><a class="page-link" href="list?cp=${pagination.maxPage}${c}${s}">&gt;&gt;</a></li>
			  </c:if>
		  </ul>
	  </div>


	  
  </div>
  </div>
  
  <jsp:include page="../common/footer.jsp"></jsp:include>


  <script>
	  // 주소 쿼리스트링에서 검색 관련 값을 얻어와 유지
	  
	  /* 
	  location.search : 주소 중 쿼리스트링만 반환
	  
	  URLSearchParams 객체 : 쿼리스트링에서 원하는 파라미터의 값을 얻어올 수 있는 객체
	  
	  - has() : 일치하는 파라미터가 있으면 true
	  - get("Key") : 일치하는 파라미터의 Value를 반환
	  - getAll("Key") : 일치하는 모든 파라미터의 Value 반환
	  
	  - append(Key, Value) : 새로운 파라미터를 추가
	  - delete(Key) : 특정 파라미터 제거
	  
	  */
	  
	  // 쿼리스트링에서 파라미터를 얻어와 반환하는 함수
	  function getParam(key){
		  return new URLSearchParams(location.search).get(key);
	  }
	  
	  


	  
	 
	  
	  
	
	  
	  // 카테고리 select가 change 됐을 때
	  document.getElementById("selectCategory").addEventListener("change", function(){
		  console.log(this.value);
		  
		  // 쿼리스트링을 누적할 변수
		  let qs = "";
		  
		  // 쿼리스트링에 cp가 없으면 1, 있으면 작성된 값
		  if(getParam("cp") == null)  qs += "?cp=1";
		  else						qs += "?cp=" + getParam("cp");
		  
		  
		  // 카테고리 select가 '전체'가 아니면 qs에 쿼리스트링 추가
		  if( this.value != "전체" ) qs += "&ct=" + this.value;
		  
		  
		  // 검색 파라미터가 있으면 qs에 추가
		  if(getParam("sv") != null ){
			  
			  qs += "&sk=" + getParam("sk") + "&sv=" + getParam("sv");
			  
		  }
		  
		  
		  
		  location.href = "list" + qs;
		  
	  });
	  
	  
	  
  </script>
  
</body>

</html>