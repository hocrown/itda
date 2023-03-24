<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/user/signupStep3.css">

</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			회원가입
		</div>	

		<span class="whoareyouText">당신이 어떤 사람인지</span>
		<span class="iWonderText">궁금해요.</span>
		<span class="maybeLikeText">당신이 좋아할 만한</span>
		<span class="giveContentText">콘텐츠를 추천해드리고 싶어요.</span>


		<span class="addressText">주소</span>
		<input type="text" class="notes">
		<img class="addressBar" src="../image/underline.png">
		<button class="addressBtn">주소 찾기</button>
		
		<span class="phoneNumberText">연락처</span>
				
		<input type="number" class="notes1">
		<span class="yearText">-</span>
		<img class="bar1" src="../image/smallBar1.png">
		
		<input type="number" class="notes2">
		<span class="monthText">-</span>
		<img class="bar2" src="../image/smallBar2.png">
		
		<input type="number" class="notes3">
		<img class="bar3" src="../image/smallBar3.png">
		
		<span class="emailText">이메일</span>
		<input type="email" class="notesEmail">
		<img class="emailBar" src="../image/underline.png">
		
		
		<button id="finishBtn" class="finishBtn">가입 완료</button>

	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>


</body>
</html>