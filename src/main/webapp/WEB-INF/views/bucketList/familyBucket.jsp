<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/familyBucket.css">

</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			소망을 잇다
		</div>

		<c:forEach items="${bucketlist}" var="bucket">
			<a href="/bucket/familybucketdetail?bucketSeq=${bucket.bucketSeq }"><div class="bucketBox">
		        <div style="width:100%; height: 150px; background-color: gray;"></div>
		        <div class="bucketTextBox">
			        <div class="bucketTitle">${bucket.title}</div>
			        <div class="bucketRegDate">등록일 ${bucket.regDate }</div>
		        </div>
	        </div></a>
	    </c:forEach>
		<div style="height: 50px;"></div>
		
	</div>	
	
</body>
</html>