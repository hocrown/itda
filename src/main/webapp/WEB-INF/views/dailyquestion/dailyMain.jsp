<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/dailyquestion/dailyMain.css">


</head>
<body>

	<div class="layout">
		<div class="headBox">
			<img class="vector" src="/image/vector.png">
			하루를 잇다
			<img class="stickerPageLink" src="/image/stickerPageLink.png">
			<img class="menuBtn" src="/image/menuBtn.png" id="dqlist">	
		</div>
		
		<span class="ourFamilyDailyDiaryText">우리 가족 하루 일기</span>
		
			
		<div class="AnswerStickerBox">
			<c:forEach var="i" begin="1" end="${familyMemberCount}">
				<c:choose>
					<c:when test="${i le answeredCount}">
						<img class="AnswerSticker" src="../image/dailyquestionYesAnswer.png">
					</c:when>
					<c:otherwise>
						<img class="AnswerSticker" src="../image/dailyquestionNoAnswer.png">
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		
		<span class="question">${familyQuestions[0].question}</span>
		<span class="numberOfQuestion">#${familyQuestions[0].questionOrder}번째 질문</span>
		<span class="questionDate"><fmt:formatDate value="${familyQuestions[0].askedDate}" pattern="yyyy.MM.dd"/></span>

		
		<div class="answerContainer">
		
		<c:forEach items="${familyAnswers}" var="answer">
		<c:if test="${answer.userId != sessionScope.userId}">
			<div class="memberAnswerBox">
			    <span class="memberText">${answer.userName}</span>
				<c:choose>
					<c:when test="${answer.answer != null}">
						<span class="answerContents">${answer.answer}</span>
					</c:when>
					<c:otherwise>
					<span class="answerContents">아직 응답하지 않았어요.</span>
					<div style="text-align: center; margin-top: 20px;">
					    <button class="kokBtn" data-user-id="${answer.userId}">콕 찌르기!</button>
					</div>
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
		</c:forEach>
			
			<div class="memberAnswerBox">
				<span class="memberText">나</span>
				<span class="answerContents" style="color: #2A221D;">
					<c:choose>
					    <c:when test="${dailyAnswer != null}">
					    	${dailyAnswer.answer}
					    </c:when>
					    <c:otherwise>
					    	<a class="answerContents" href="/dailyquestion/answerform">답변 작성하기</a>
					    </c:otherwise>
				    </c:choose>
   				</span>
			</div>		
	</div>
	</div>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.2/sockjs.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script type="text/javascript" src="/js/dailyquestion/dailyMain.js"></script>
</body>
</html>