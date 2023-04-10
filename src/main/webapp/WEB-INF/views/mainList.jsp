<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mainList.css">
</head>
<body>
	<div class="layout">
		<div class="headBox">
			잇 다
			<img class="bell" src="/image/bell.png">
			<img class="alarmMark" src="/image/alarmMark.png">
			<img class="myImg" src="/image/myImg.png">		
		</div>

		<img class="mainListToggle" src="/image/listToggle.png">
		
		<div class="dailyTextBox">하루 질문</div>
		<div class="whisperTextBox"><span class="whisperText1">속마음</span><span class="whisperText2">전하기</span></div>
		<div class="bucketTextBox">버킷리스트</div>
		<div class="timelineTextBox">타임라인</div>

		<div class="questionBox">
			<span class="questionText">${todayFamilyQuestion.question}</span>
		</div>

	</div>

<script type="text/javascript" src="/js/mainList.js"></script>
<script type="text/javascript" src="/js/alarm.js"></script>
</body>
</html>