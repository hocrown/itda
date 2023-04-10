<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/whisper/whisperOutbox.css">
<script type="text/javascript" src="/js/whisper/whisperOutbox.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			마음을 잇다
		</div>
	
		<span class="outboxText">속마음 발신함</span>
		<c:forEach var="entry" items="${whisperByDate}">
        <div class="dateLine1"></div>
        <div class="inboxListDate"><fmt:formatDate value="${entry.key}" pattern="yyyy.MM.dd"/></div>
        <div class="dateLine2"></div>
		
	
	        <c:forEach var="whisper" items="${entry.value}">
	        <div class="inboxList">
	            <img src="/image/whisperCardImg.png" class="cardFrame">
	            <span class="toPersonText">받는 사람</span>
	            <span class="toPersonName">${whisper.receiver}</span>
	            <div class="toPersonLine"></div>
	            <span class="sendDateText">발신일</span>
	            <span class="sendDate"><fmt:formatDate value="${whisper.sendDate}" pattern="yyyy.MM.dd"/></span>
	            <img src="../image/whisperCardStamp.png" class="inboxCardStamp">
	            <span class="fromPersonText">보내는 사람</span>
	            <span class="fromPersonName">${whisper.senderNickname}</span>
	            <div class="fromPersonLine"></div>
	        </div>
	        </c:forEach>
        </c:forEach>
		
	</div>
</body>
</html>