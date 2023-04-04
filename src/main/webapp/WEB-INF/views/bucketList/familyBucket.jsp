<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/familyBucket.css">
<script type="text/javascript" src="/js/familyBucket.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			소망을 잇다
			<img src="../image/addBtn.png" class="addBtn">
		</div>
		
		

		<c:forEach items="${bucketlist}" var="bucket">
			<c:if test="${bucket.visible eq 'y' }">
				<a href="/bucket/familybucketdetail?bucketSeq=${bucket.bucketSeq }">
				<div class="bucketBox">
			        <img src="..${bucket.filepath }" style="width:100%; height: 200px;">
			        <div class="bucketTextBox">
				        <div class="bucketTitle">${bucket.title}</div>
				        <div class="bucketRegDate">등록일 <fmt:formatDate value="${bucket.regDate}" pattern="yyyy.MM.dd"/></div>
			        </div>
		        </div></a>
		    </c:if>
	    </c:forEach>
		
	</div>	
	
</body>
</html>