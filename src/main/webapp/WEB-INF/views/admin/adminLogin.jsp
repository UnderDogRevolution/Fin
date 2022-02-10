<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="${contextPath}/resources/css/admin/adminLogin.css">
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>

</head>
<body>
	<header class="admin-header"> </header>
	<main class="admin-container">
		<div class="container1">
			<div class="adminLogin-header">montage</div>
			<form action="${contextPath}/admin/main" class="adminLogin-main" method = "POST">

				<div class="login-input">
					<div class="input-wrap">
						<input type="text" name = "memberEmail"> <input type="password" name = "memberPw">
					</div>
				</div>
				<div class="login-button">
					<div class="login-btnwrap">
						<button>로그인</button>
					</div>
				</div>

			</form>
			<div class="adminLogin-footer">
				관리자는 특정 ip에서만 접속할 수 있다.<br> 특정 ip가 아닌 곳에서 로그인 시도 시 유동훈
			</div>

		</div>
		<div class="container2">
			<div class="adminLogin-header2">관리자 로그인</div>

			<div class="adminLogin-main2">
				<textarea name="" id="" style="width: 100%; height: 100%;" readonly>
  개인정보 보호 원칙
                    
 ① 개인정보처리자는 개인정보의 처리 목적을 명확하게 하여야 하고 그 목적에 필요한 범위에서 최소한의 개인정보만을 적법하고 정당하게 수집하여야 한다.
                    
 ② 개인정보처리자는 개인정보의 처리 목적에 필요한 범위에서 적합하게 개인정보를 처리하여야 하며, 그 목적 외의 용도로 활용하여서는 아니 된다.
                    
 ③ 개인정보처리자는 개인정보의 처리 목적에 필요한 범위에서 개인정보의 정확성, 완전성 및 최신성이 보장되도록 하여야 한다.
                    
 ④ 개인정보처리자는 개인정보의 처리 방법 및 종류 등에 따라 정보주체의 권리가 침해받을 가능성과 그 위험 정도를 고려하여 개인정보를 안전하게 관리하여야 한다.
                    
 ⑤ 개인정보처리자는 개인정보 처리방침 등 개인정보의 처리에 관한 사항을 공개하여야 하며, 열람청구권 등 정보주체의 권리를 보장하여야 한다.
                    
 ⑥ 개인정보처리자는 정보주체의 사생활 침해를 최소화하는 방법으로 개인정보를 처리하여야 한다.
                    
 ⑦ 개인정보처리자는 개인정보를 익명 또는 가명으로 처리하여도 개인정보 수집목적을 달성할 수 있는 경우 익명처리가 가능한 경우에는 익명에 의하여, 익명처리로 목적을 달성할 수 없는 경우에는 가명에 의하여 처리될 수 있도록 하여야 한다.  <개정2020. 2. 4.>
                    
 ⑧ 개인정보처리자는 이 법 및 관계 법령에서 규정하고 있는 책임과 의무를 준수하고 실천함으로써 정보주체의 신뢰를 얻기 위하여 노력하여야 한다.
                
                </textarea>
			</div>
		</div>
	</main>




</body>
</html>