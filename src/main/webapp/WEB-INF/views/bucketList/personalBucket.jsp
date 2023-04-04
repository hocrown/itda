<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/bucketListView.css">
<script type="text/javascript" src="/js/bucketListView.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			소망을 잇다
			<img src="../image/addBtn.png" class="addBtn">
		</div>
		
		<span class="ourBucketText">우리 가족 버킷리스트</span>
		
		<div class="testz">
		
			<div class="testbox">
				<a href="#"><div class="testspan">함께</div></a>
				<div class="bordermy" style="height: 30px;"></div>
			</div>
		<c:forEach items="${myFam }" var="fam" varStatus="status">
			<div id="box${status.index }" class="testbox">
				<a href="/bucket/personalbucket?userId=${fam }"><div id="sticker${status.index }" class="testspan">${fam }</div></a>
				<div class="bordermy" style="height: 30px;"></div>
			</div>
		</c:forEach>
		</div>

		<div class="listLayout">
			<div class="listContainer">
				<c:forEach items="${bucketlist}" var="bucket">	
					<c:if test="${bucket.visible eq 'y' }">
						<a href="/bucket/familybucketdetail?bucketSeq=${bucket.bucketSeq }">
						<img src="..${bucket.filepath }" style="width:100%; height: 155px;">
						<div style="position: relative;">
							<img src="../image/bucket/chkLine.png" style="width: 100%">
							<span class="bucketTitleSpan">${bucket.title}</span>				
						</div>
						<div style="height: 25px;"></div>
						</a>
					</c:if>
				</c:forEach>			
			</div>		
		</div>
<!-- 		<img src="../image/bucket/bucketBackground.png" class="imgBack">
 -->		
		
<%-- 
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
 --%>		
	</div>	
	
</body>
</html>