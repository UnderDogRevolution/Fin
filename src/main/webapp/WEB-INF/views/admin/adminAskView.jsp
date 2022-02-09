<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>

<link rel="stylesheet"
	href="${contextPath}/resources/css/admin/adminMember.css">



</head>

<jsp:include page="adminHeader.jsp" />


<body>
	<div class="mainController">
		<main>

			<div class=" adminBoardwraper">

				<jsp:include page="adminSide.jsp" />

				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#staticBackdrop">Launch static backdrop modal</button>

				<!-- Modal -->
				<div class="modal fade" id="staticBackdrop"
					data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
						
							<div class="modal-header">
								<h5 class="modal-title" id="staticBackdropLabel">문의내용</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"	aria-label="Close">ㄷ</button>
							</div>
							<div class="modal-body">
							
							내용 : ${AdminAsk.askContent}
							
							
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"	data-bs-dismiss="modal">닫기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>



</body>
</html>