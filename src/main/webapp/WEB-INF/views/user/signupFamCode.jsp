<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/user/signupFamCode.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/signupFamCode.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			회원가입
		</div>
		
		<span class="withFamText">가족과 함께해요!</span>
		<span class="ifYouFirstText">잇다가 처음이시라면</span>
		<span class="createCodeText">가족 코드를 생성해주세요.</span>
		
		<span class="famCodeText">가족초대코드</span>
		<input type="text" class="notes" value="${famCode}">
		<img class="codeBar" src="../image/underline.png">
		<button class="createBtn">생성하기</button>
		
		<button class="nextBtn">다음</button>

	</div>
</body>
</html>