<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/whisper/whisperWrite.css">
<script type="text/javascript" src="/js/whisper/whisperWrite.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			마음을 잇다
			<img src="../image/send.png" class="writeform-send">
		</div>
	
		<form class="whisperWriteForm" method="post">
		<span class="whisperSendText">속마음 전하기</span>
		
		<span class="itdaCarryText">하지 못한 말, 잇다가 대신 전해드려요.</span>
		
		<span class="toText">받는 사람</span>
		
		
		<select class="selectCss" name="" id="receiverSelect" required>
			<option hidden="" disabled selected value="">받는 사람을 선택해주세요.</option>
			<c:forEach items="${myFamily}" var="familyMember">
			<option value="${familyMember.userId}">${familyMember.userName}</option>
			</c:forEach>
		</select>
		
		<div class="whisperTextareaBox">
			<textarea spellcheck="false" class="whisperTextarea" placeholder="미처 말하지 못했던 나의 속마음"></textarea>
		</div>
		
		<div class="whisperCharacterCount">0/200</div>
		
		<span class="fromText">보내는 사람</span>
		
		<input type="text" class="fromInput" placeholder="${myName}" spellcheck="false" value="${myName}">
		
		<span class="sendOption">전달 옵션</span>
		<div class="directOptionEllipse" data-option="direct"></div><span class="directOptionText">전송 즉시 전달돼요</span>
		<div class="bombOptionEllipse" data-option="bomb"></div><span class="bombOptionText">확인 후 수신함에서 사라져요</span>
		<div class="reservationOptionEllipse" data-option="reservation"></div><span class="reservationOptionText">내가 원하는 날짜에 전달돼요</span>
		<input type="text" class="datepicker" placeholder="원하는 날짜를 선택해주세요" style="display:none;">
		<input type="hidden" name="sendOption" value="">
    	
		</form>
	</div>
</body>
</html>