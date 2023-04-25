<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mainImg.css">
<script type="text/javascript" src="/js/mainImg.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			잇 다
			<img class="bell" src="/image/bell.png">
			<img class="alarmMark hidden" src="/image/alarmMark.png">
			<img class="myImg" src="/image/myImg.png">		
		</div>
		
		<img class="mainBackground" src="/image/mainBackground.png">
		
		<img class="mainTimeLine"	src="/image/mainTimeLine.png" onmouseover="changeToGif(this, '/image/mainTimeLine.gif')" onmouseout="changeToPng(this, '/image/mainTimeLine.png')">
		<img class="mainBucketList" src="/image/mainBucketList.png" onmouseover="changeToGif(this, '/image/mainBucketList.gif')" onmouseout="changeToPng(this, '/image/mainBucketList.png')">
		<img class="mainDailyQuestion" src="/image/mainDailyQuestion.png" onmouseover="changeToGif(this, '/image/mainDailyQuestion.gif')" onmouseout="changeToPng(this, '/image/mainDailyQuestion.png')">
		<img class="mainWhisper" src="/image/mainWhisper.png" onmouseover="changeToGif(this, '/image/mainWhisper.gif')" onmouseout="changeToPng(this, '/image/mainWhisper.png')">
		
		<img class="mainImgToggle" src="/image/imgToggle.png">

		<div class="questionBox">
			<span class="dailyQuestionText">오늘의 질문</span>
			<span class="questionText">${todayFamilyQuestion.question}</span>
		</div>
	</div>
</body>
</html>