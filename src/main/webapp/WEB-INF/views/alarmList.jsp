<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		</div>
	
		<div class="alarmText">알림</div>
		
			<div class="alarmList">
				<div style="min-height: 5px; max-height: 5px;"></div>
				<c:forEach var="alarm" items="${alarmList}">
				    <c:set var="duration" value="${fn:substringBefore(fn:replace(fn:substringAfter(Duration.between(alarm.alarmDateTime, currentTime).toString(), 'PT'), 'H', '시간'),'M')}"/>
				    <c:set var="period" value="${Period.between(alarm.alarmDateTime.toLocalDate(), currentTime.toLocalDate()).getDays()}"/>
				    <c:choose>
				        <c:when test="${period gt 0}">
				            <c:set var="timeDifference" value="${period}일 전"/>
				        </c:when>
				        <c:otherwise>
				            <c:set var="timeDifference" value="${duration}${duration.contains('시간') ? ' 전' : '분 전'}"/>
				        </c:otherwise>
				    </c:choose>
			        <div class="alarmListBox">
				        <c:choose>
				            <c:when test="${alarm.type == 'whisper' && alarm.checked == 1}">
				                <img class="alarmImg" src="/image/whisper.png">
				            </c:when>
				            <c:when test="${alarm.type == 'whisper' && alarm.checked == 0}">
				                <img class="alarmImg" src="/image/whisperNotChecked.png">
				            </c:when>
			             	<c:when test="${alarm.type == 'kok' && alarm.checked == 0}">
				            	<img class="alarmImg" src="/image/bellNotChecked.png">
				            </c:when>
				            <c:when test="${alarm.type == 'kok' && alarm.checked == 1}">
				            	<img class="alarmImg" src="/image/bell.png">
				            </c:when>
				            
				            <c:otherwise>
				                <img class="alarmImg" src="/image/bell.png">
				            </c:otherwise>
				        </c:choose>
			    	    <span class="alarmMessage">${alarm.message}</span>
			    	    <span class="alarmWhen">${timeDifference}</span>
					</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>