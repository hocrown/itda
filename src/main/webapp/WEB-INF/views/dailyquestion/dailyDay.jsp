<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/dailyquestion/dailyMain.css">

</head>
<body>

	<div class="layout">
		<div class="headBox">
			<img class="vector" src="../image/vector.png">
			하루를 잇다
			<img class="stickerPageLink" src="../image/stickerPageLink.png">
			<img class="menuBtn" src="../image/menuBtn.png" id="dqlist">	
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
		
		<span class="question">${familyQuestion.question}</span>
		<span class="numberOfQuestion">#${familyQuestion.questionOrder}번째 질문</span>
		<span class="questionDate"><fmt:formatDate value="${familyQuestion.askedDate}" pattern="yyyy.MM.dd"/></span>

		
		<div class="answerContainer">
		
<!-- 			세션 유저의 답변 정보를 찾아서 변수에 담기 -->
		<c:set var="myAnswer" value="${familyAnswers.stream().filter(answer -> answer.userId == sessionScope.userId).findFirst().orElse(null)}" />
		
<!-- 		가족 구성원 전체의 답변 정보 출력 -->
		<c:forEach items="${familyAnswers}" var="answer">
<!-- 		    세션 유저의 답변 정보인 경우는 출력하지 않음 -->
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
		                        <button class="kokBtn">콕 찌르기!</button>
		                    </div>
		                </c:otherwise>
		            </c:choose>
		        </div>
		    </c:if>
		</c:forEach>
		
<!-- 		세션 유저의 답변 정보 출력 -->
		<div class="memberAnswerBox">
		    <span class="memberText">나</span>
		    <span class="answerContents" style="color: #2A221D;">
<!-- 		        세션 유저의 답변 정보가 있는 경우 -->
		        <c:if test="${myAnswer != null}">
		            ${myAnswer.answer}
		        </c:if>
<!-- 		        세션 유저의 답변 정보가 없는 경우 -->
		        <c:if test="${myAnswer == null}">
		            <a class="answerContents" href="/dailyquestion/answerform">답변 작성하기</a>
		        </c:if>
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