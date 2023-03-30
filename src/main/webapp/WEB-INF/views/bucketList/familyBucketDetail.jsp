<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/familyBucketDetail.css">

</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			소망을 잇다
		</div>

		

		        <div style="width:100%; height: 300px; background-color: gray;"></div>
		        <div class="bucketTextBox">
			        <div class="bucketTitle">${bucketOne.title}</div>
			        <div class="bucketRegDate">등록일 ${bucketOne.regDate }</div>
		        </div>
		        <div>
		        <c:forEach items="${reply }" var="reply">
		        <div>${reply.replyContents }</div>
		        <div>${reply.regDate }</div>
		        <div>${reply.userId }</div>
		        <div>${reply.bucketSeq }</div>
		        </c:forEach>
		        </div>
	        </div>

		<div style="height: 50px;"></div>
		
	</div>	
	
</body>
</html>