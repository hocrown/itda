<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/user/requestBox.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/js/requestBox.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
		</div>
		
		<img src="../image/requestBoxOutlineImg.png" class="outline-img">
		
		<span class="request-intro-text">하루 일기에서 '이런'<br>질문이 나왔으면 좋겠어요.</span>
		<span class="request-descript-text">여기 <잇다 질문통>을 통해 제시해주세요. <br>잇다가 대신 물어봐 드릴게요!</span>
		<div class="request-input-box"><input name="question" class="request-input" spellcheck="false"></div>
		<span class="request-text-count">0/40</span>
		
		<span class="typeText">공개 범위</span>
		
		<input class="radioTypeInput" type="radio" id="common" name="type" value="common">
		<label class="radioLabelCommon" for="common">
			<div class="ellipseCommon">
				<div id="commonSmallEllipse">
				</div>
			</div>
			<span class="commonText">전체 사용자</span>
		</label>
		
		
		<input class="radioTypeInput" type="radio" id="family" name="type" value="family">
		<label class="radioLabelFamily" for="family" >
			<div class="ellipseFamily">
				<div id="familySmallEllipse">
				</div>
			</div>
			<span class="familyText">우리 가족만</span>
		</label>		
		
		<div class="apply-btn">신청하기</div>
		
		
		<!-- 모달 창 -->
		<div class="modal">
		  <div class="modal-content">
		    <div class="modal-deleteText"><p id="messageText"></p></div>
		    <div class="modal-btn-box">
		    	<button class="btn-delete-area">확인</button>
		    </div>
		  </div>
		</div>
		
		
		
	</div>	

	

	
</body>
</html>