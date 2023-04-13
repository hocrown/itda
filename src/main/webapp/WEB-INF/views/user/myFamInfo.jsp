<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/user/myFamInfo.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/js/myInfo.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			가족정보
		</div>
		
		<div>
			<img src="../../image/dummyImg.jpg" class="fam-profile">
		</div>
		
		<div class="fam-name-area">
			<div class="fam-name">
				<span>박주주의 가족</span><img src="../../image/textEditBtnImg.png" class="fam-name-edit-btn">
			</div>
			<span class="member-text">멤버 4</span>
		</div>
		
		<div class="fam-member-container">	
			<!-- forEach 자리 -->
			<div class="fam-member-box">
				<img src="../../image/dummyImg.jpg" class="fam-member-img">
				<div class="fam-member-name-area">
					<span>아빠</span>
					<img src="../../image/textEditBtnImg.png" class="fam-member-name-edit-btn">
				</div>
				<div class="fam-member-name-area2">
					<span>박정수</span>
					<span class="fam-member-birth">1967.04.15</span>
				</div>
			</div>
			<!-- forEach 닫는자리 -->
		</div>
		
		<div class="fam-code-text">가족코드</div>
		<div style="text-align: center;">
			<div class="fam-code-area">GeAbAbBa<img class="copy-btn" src="../../image/copyBtnImg.png"></div>
		</div>
		
	</div>	

	

	
</body>
</html>