<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글관리</title>

<link rel="stylesheet"
	href="${contextPath}/resources/css/admin/adminMember.css">



</head>

<jsp:include page="adminHeader.jsp" />


<body>
	<div class="mainController">
		<main>

			<div class=" adminBoardwraper">

				<jsp:include page="adminSide.jsp" />


				<div class="adminBoard">
					<div class="adminHeader">게시글관리</div>
					<div class="adminBoardMain">
						<div class="adminSearch">
							<form action="" class="adminSearchForm">
								<select name="" id="" class="select">
									<option value="">게시글번호</option>
									<option value="">회원번호</option>
									<option value="">게시글상태</option>

								</select> <input type="text">
								<button>검색</button>
							</form>


						</div>

						<div class="adminBoardtable">
							<div class="table">
								<table class="table table-hover table-striped my-5"
									id="list-table">

									<thead>
										<tr>
											<th style="width: 100px;">게시글번호</th>
											<th style="width: 140px;">작성자</th>
											<th style="width: 200px;">내용</th>
											<th>작성일</th>
											<th>조회수</th>
											<th>상태</th>
										</tr>

									</thead>
									<tbody>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;"><a href = "">동글이<a></td>
											<td style="width: 100px;">2020-03-31</td>
											<td>999</td>
											<td><select name="" id="" class="select">
													<option value="">게시글번호</option>
													<option value="">회원번호</option>
													<option value="">게시글상태</option>

											</select></td>
										</tr>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
										</tr>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
										</tr>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
										</tr>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
										</tr>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
										</tr>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
										</tr>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
										</tr>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
										</tr>
										<tr>
											<td style="width: 70px;">1</td>
											<td style="width: 140px;">김밥계란</td>
											<td style="width: 300px;">user01@gmail.com</td>
											<td style="width: 100px;">정상</td>
											<td>2020-03-31</td>
											<td>1</td>
									</tbody>
									<tfoot>


									</tfoot>
								</table>
							</div>

						</div>




					</div>
				</div>



			</div>
		</main>
	</div>



</body>
</html>