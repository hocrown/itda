<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/user/signupStep1.css">
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			회원가입
		</div>
		
		<span class="helloText">처음 뵙겠습니다.</span>
		<span class="useforText">앞으로 잇다에서 이용할</span>
		<span class="idPwdInputText">아이디와 패스워드를 입력해주세요.</span>
		
		<button class="addProfile"><img src="../image/profile.png"></button>
		
		<span class="idText">아이디</span>
		
		<input type="text" class="notes">
		<button class="doubleChkBtn">중복확인</button>
		<img class="idBar" src="../image/underline.png">

		<span class="pwdText">비밀번호</span>
		<input type="password" class="notes2">
		<img class="pwdBar" src="../image/underline.png">
		<button class="eye"></button>
		
		<button class="nextBtn">다음</button>

	</div>


</body>
</html>