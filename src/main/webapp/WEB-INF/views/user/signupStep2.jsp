<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../noErrorHead.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/user/signupStep2.css">
<script type="text/javascript" src="/js/signupStep2.js"></script>
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
		
	
		<span class="nameText">이름</span>
		<input type="text" class="notes">
		<img class="nameBar" src="../image/underline.png">

		<span class="birthdayText">생년월일</span>
		
		<input type="text" class="notesYear" id="datepicker">
		<span class="yearText">년</span>
		<img class="bar1" src="../image/smallBar1.png">
		
		<input type="number" class="notesMonth">
		<span class="monthText">월</span>
		<img class="bar2" src="../image/smallBar2.png">
		
		<input type="number" class="notesDay">
		<span class="dayText">일</span>
		<img class="bar3" src="../image/smallBar3.png">
		
		<span class="genderText">성별</span>
		
		<input class="radioGenderInput" type="radio" id="male" name="gender" value="male">
		<label class="radioLabelMale" for="male">
			<div class="ellipseMale">
				<div id="maleSmallEllipse">
				</div>
			</div>
			<span class="maleText">남자</span>
		</label>
		
		
		<input class="radioGenderInput" type="radio" id="female" name="gender" value="female">
		<label class="radioLabelFemale" for="female" >
			<div class="ellipseFemale">
				<div id="femaleSmallEllipse">
				</div>
			</div>
			<span class="femaleText">여자</span>
		</label>		
		
		<button class="nextBtn">다음</button>

	</div>

</body>
</html>