<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/user/login.css">

</head>
<body>

	<div class="layout">
	<div class="headBox"><img class="vector" src="../image/vector.png">로그인</div>

		<span class="hi">안녕하세요!</span> <span class="weritda">하지 못한 말,
			&nbsp;<span style="font-weight: bold;">잇다</span>입니다.
		</span> <span class="waiting">당신만을 기다리고 있었어요.</span>
		<form>
		<span class="idText">아이디</span>
		<input type="text" class="notes">
		<img class="idBar" src="../image/underline.png">

		<span class="pwdText">비밀번호</span>
		<input type="password" class="notes2">
		<img class="pwdBar" src="../image/underline.png">
		<button class="eye"></button>
		<button type="submit" class="loginBtn">로그인</button>
		</form>
		
		
		<button class="signupBtn">회원가입</button>
		<span class="hoxy">혹시 비밀번호를 잊으셨나요?</span>
	</div>
	
	
</body>
</html>