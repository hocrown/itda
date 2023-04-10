<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/whisper/whisperInboxImg.css">
<script type="text/javascript" src="/js/whisper/whisperInboxImg.js"></script>



</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			마음을 잇다
			<img src="../image/send.png" class="send">
			<img src="../image/send2.png" class="send2">
		</div>
	
		<span class="inboxText">속마음 보관함</span>
		<span class="whisperArriveText">속마음이 도착했어요! 확인해볼까요?</span>
		
		<img src="../image/imgToggle.png" class="whisperInboxImgToggle">
		
		<div class="whisperImgContainer">
			<div class="whisperImgBox">
				<c:forEach var="whisper" items="${whisperList}" varStatus="status">
					<c:choose>
						<c:when test="${whisper.checked==0}">
							<a href="/whisper/detail/${whisper.whisperSeq}">
							<img class="whisperImgCommon" src="../image/noChkWhisperImg.png">
							</a>
						</c:when>
						<c:otherwise>
							<a href="/whisper/detail/${whisper.whisperSeq}">
							<img class="whisperImgCommon" src="../image/whisperImg.png">
							</a>
							</c:otherwise>
					</c:choose>
				</c:forEach>
				
			</div>
		</div>
	
	</div>
</body>
</html>