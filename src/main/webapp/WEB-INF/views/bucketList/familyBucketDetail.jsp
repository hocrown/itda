<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/bucketDetail.css">

</head>
<body>
	<div class="layout">
		
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			소망을 잇다
			<img src="../image/ellipsis.png" class="ellipsis">
		</div>
		
		<div class="layoutz">
		
		        
		

		        <img src="..${bucketOne.filepath }" style="width:100%; min-height: 250px;">
		        <div class="bucketDetailContainer">
			        <div class="bucketTextBox">
				        <div class="bucketTitle">${bucketOne.title}</div>
				        <div class="bucketRegDate">등록일 <fmt:formatDate value="${bucketOne.regDate}" pattern="yyyy.MM.dd"/></div>
				        
			        </div>
					<div>
					<div class="bucketContents">${bucketOne.contents }</div>
			        </div>
			        <div style="height: 40px;">
			        </div>
		       	</div>
		       	
		        
		        
			        <c:forEach items="${reply }" var="reply">
				        <div>
				        	<div style="position: relative; margin-bottom: 20px;">
					        		<img src="../image/bucket/profileDummy.png" style="position: absolute; top:20px; left:10px;">
						        <div class="replyTextBox">
							        <div class="userNameText">${reply.userName }</div>
							        <div class="replyContentsText">${reply.replyContents }</div>
							        <div class="replyRegDateText"><fmt:formatDate value="${reply.regDate}" pattern="yyyy.MM.dd a hh:mm"/></div>
				        		</div>
					        </div>
					    </div>
			        </c:forEach>

		        
		        <div class="modalBox detailDisNone"> 
			        <div class="btnBox"><a class="finishBtnz" href="/bucket/successaction?bucketSeq=${bucketOne.bucketSeq }">완료하기</a></div>		       	
			        <div class="btnBox"><a class="modifyBtn" href="/bucket/modifybucket?bucketSeq=${bucketOne.bucketSeq }">수정하기</a></div>
			        <div class="btnBox"><a class="deleteBtn" href="/bucket/invisibleaction?bucketSeq=${bucketOne.bucketSeq }">삭제하기</a></div>
			        <div class="btnBox detailCancelBtn">취소</div>
		        </div>

		</div>
	</div>	
	
	<script>
	const ellipsis = document.querySelector('.ellipsis');

	// add a click event listener to the ellipsis image
	ellipsis.addEventListener('click', () => {
	  // get the element you want to toggle the class on
	  const element = document.querySelector('.modalBox');
	  // toggle the "disNone" class on the element
	  element.classList.toggle('detailDisNone');
	});
	
	$('.detailCancelBtn').on('click', function() {
		  $(this).closest('.modalBox').addClass('detailDisNone');
		});
	</script>

</body>
</html>