<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
<link rel="stylesheet" type="text/css" href="css/alarmList.css">
<title>Insert title here</title>
<script type="text/javascript" src="/js/alarmList.js"></script>

</head>
<body>
	<div class="layout">
		<div class="headBox"><img class="vector" src="../image/vector.png">
			<span class="alarmHeadText">잇다</span>
			<img class="bell" src="/image/bell.png">
			<img class="alarmMark" src="/image/alarmMark.png">
			<img class="myImg" src="/image/myImg.png">		
		</div>
	
		<div class="alarmText">알림</div>
		
			<div class="alarmList">
				<div style="min-height: 5px; max-height: 5px;"></div>
				<c:forEach var="alarm" items="${alarmList}">
					
				        <div class="alarmListBox">
				    	     <img class="alarmImg" src="/image/bell.png">
				    	     <span class="alarmMessage">${alarm.message }</span>
				    	     <span class="alarmWhen">1시간 전</span>
						</div>
					
				</c:forEach>
			</div>
	
	</div>

</body>
</html>