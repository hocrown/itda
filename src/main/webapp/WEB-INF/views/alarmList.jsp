<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
<title>Insert title here</title>
<script type="text/javascript" src="/js/alarm.js"></script>

</head>
<body>
	<div class="layout">
		<div class="headBox"><img class="vector" src="../image/vector.png">
			알람
		</div>
		<img class="bell" src="/image/bell.png">
		<img class="alarmMark" src="/image/alarmMark.png">
		<img class="myImg" src="/image/myImg.png">		
	</div>

	<div class="alarmList">
		<c:forEach var="alarm" items="${alarmList}">
			<div class="questionListContainer">
		        <div class="questionListBox">
		    	     <img class="listNum" src="/image/listNum/.png">
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>