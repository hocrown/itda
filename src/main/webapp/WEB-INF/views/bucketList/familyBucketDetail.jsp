<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
		<div class="layoutz">
		
		        <div class="bucketTextBox">
			        <div class="bucketTitle">${bucketOne.title}</div>
			        <div class="bucketRegDate">등록일 <fmt:formatDate value="${bucketOne.regDate}" pattern="yyyy.MM.dd"/></div>
			        <img src="../image/ellipsis.png" class="ellipsis">
		        </div>
		

		        <img src="..${bucketOne.filepath }" style="width:100%; height: 300px;">
				<div>
				<div class="bucketContents">${bucketOne.contents }</div>
		        </div>
		       
		       	<div class="modalBox"> 
			        <div class="btnBox"><a class="modifyBtn" href="/bucket/modifybucket?bucketSeq=${bucketOne.bucketSeq }">수정하기</a></div>
			        <div class="btnBox"><a class="deleteBtn" href="/bucket/invisibleaction?bucketSeq=${bucketOne.bucketSeq }">삭제하기</a></div>
			        <div class="btnBox">취소</div>
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
	</div>	
</body>
</html>