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
<script type="text/javascript" src="/js/dailyquestion/dailyMain.js"></script>
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
			    <c:choose>
	                <c:when test="${answer.answer != null}">
		            <span class="memberText" style="color: #2A221D;">${answer.userName}</span>
	                    <span class="answerContents" style="color: #2A221D;">${answer.answer}</span>
	                </c:when>
	                <c:otherwise>
		            <span class="memberText">${answer.userName}</span>
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
</body>
</html>