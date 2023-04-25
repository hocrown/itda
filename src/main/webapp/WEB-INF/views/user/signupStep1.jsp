<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../noErrorHead.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/user/signupStep1.css">
<script type="text/javascript" src="/js/signupStep1.js"></script>
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
		
		<input type="text" class="notes" value="${id}">
		<img class="idBar" src="../image/underline.png">

		<span class="pwdText">비밀번호</span>
		<input type="password" class="notes2">
		<img class="pwdBar" src="../image/underline.png">
		<button class="eye" title="비밀번호 표시/숨기기"><i class="far fa-eye"></i></button>
		
		<div class="alert-id"></div>
		
		<div class="alert-pw"></div>
		
		<button class="nextBtn">다음</button>

	</div>


</body>
</html>
