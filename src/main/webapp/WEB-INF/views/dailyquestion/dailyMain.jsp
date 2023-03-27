<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/dailyquestion/dailyMain.css">

</head>
<body>

	<div class="layout">
		<div class="headBox"><img class="vector" src="../image/vector.png">
			하루를 잇다
			<img class="stickerPageLink" src="../image/stickerPageLink.png">
			<img class="menuBtn" src="../image/menuBtn.png">	
		</div>
		
		<span class="ourFamilyDailyDiaryText">우리 가족 하루 일기</span>
		
			
		<div class="AnswerStickerBox">
			<img class="AnswerSticker" src="../image/dailyquestionYesAnswer.png">
			<img class="AnswerSticker" src="../image/dailyquestionYesAnswer.png">
			<img class="AnswerSticker" src="../image/dailyquestionNoAnswer.png">
			<img class="AnswerSticker" src="../image/dailyquestionNoAnswer.png">						
		</div>
		
		<span class="question">오늘 하루동안 가장<br>행복했던 일은 무엇인가요?</span>
		<span class="numberOfQuestion">#1번째 질문</span>
		<span class="questionDate">2023.04.28</span>
		
		<div class="answerContainer">
		
			<div class="memberAnswerBox">
				<span class="memberText">아빠</span>
				<span class="answerContents">아직 응답하지 않았어요.</span>
				<div style="text-align: center; margin-top: 20px;">
					<button class="kokBtn">콕 찌르기!</button>
				</div>
			</div>
			
			<div class="memberAnswerBox">
				<span class="memberText" style="color: #2A221D;">엄마</span>
				<span class="answerContents" style="color: #2A221D;">날씨가 너무 좋아서 요새는 창문만 열어놓아도 너무 행복해</span>
			</div>
			
			
			
		</div>		
		
	</div>
	
	
</body>
</html>