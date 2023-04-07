<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/whisper/whisperDetail.css">
<script type="text/javascript" src="/js/whisper/whisperDetail.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="/image/vector.png" class="vector">
			마음을 잇다
		</div>
		
		<img src="/image/ellipsis.png" class="detailEllipsis">
		
		<img src="/image/whisperDetailFrame.png" class="whisperDetailFrame">		
		
		<span class="whisperDetailContents">${whisper.message}</span>
		<span class="detailDate"><fmt:formatDate value="${whisper.sendDate}" pattern="yyyy.MM.dd"/></span>
		<span class="detailFromPersonName">${whisper.sender}</span>
		
		<div class="detailDeleteBox">
			<span class="detailDeleteText">삭제하기</span>
		</div>

	</div>
</body>
</html>