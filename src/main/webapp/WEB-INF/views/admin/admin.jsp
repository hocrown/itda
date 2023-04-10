<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../css/admin/admin.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="//code.jquery.com/ui/1.13.0/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
	<title>관리자 페이지</title>
</head>
<body>
	<div class="adminLayout">
		<div class="adminContainer">
			<img class="adminLogo" src="../image/itdaLogo.png">
			<form>
				<div>
					<div class="adminIdPwdText">아이디</div><br>
					<input class="adminIdPwdInput" spellcheck="false">
				</div>
				
				<div style="margin-top: 30px;">
					<div class="adminIdPwdText">비밀번호</div><br>
					<input class="adminIdPwdInput" spellcheck="false" type="password">
				</div>
				<button type="submit" class="adminLoginBtn">로그인</button>
			</form>
			
		</div>
	</div>
	
	
	
</body>
</html>