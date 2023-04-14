<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/user/myPage.css">
<script type="text/javascript" src="/js/myPage.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			마이페이지
		</div>
		<div style="position: absolute;">
		<div class="myPageItemBox" id="myInfo">
			<div class="myPageItemText">내 정보</div>
			<img src="../image/vector.png" class="myPageSmallVector">
		</div>
		<div style="margin:auto; height: 1px; border-bottom: solid 1px; width: 320px;"></div>
		
		<div class="myPageItemBox" id="familyInfo">
			<div class="myPageItemText">가족 정보</div>
			<img src="../image/vector.png" class="myPageSmallVector">
			
		</div>
		<div style="margin:auto; height: 1px; border-bottom: solid 1px; width: 320px;"></div>
		
		<div class="myPageItemBox" id="itdaNotice">
			<div class="myPageItemText">잇다 소식</div>
			<img src="../image/vector.png" class="myPageSmallVector">
			
		</div>
		<div style="margin:auto; height: 1px; border-bottom: solid 1px; width: 320px;"></div>
		
		<div class="myPageItemBox" id="itdaQuestion">
			<div class="myPageItemText">잇다 질문통</div>
			<img src="../image/vector.png" class="myPageSmallVector">
			
		</div>
		<div style="margin:auto; height: 1px; border-bottom: solid 1px; width: 320px;"></div>
		</div>
		<div style="text-align: center;">
		<span class="myPageLogoutBtn">로그아웃</span>
		</div>
	</div>	
	
	

	
</body>
</html>