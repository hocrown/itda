<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/dailyquestion/dailyAnswer.css">
<script type="text/javascript" src="/js/dailyquestion/dailyAnswer.js"></script>

</head>
<body>

	<div class="layout">
		<form id="answer-form" action="/dailyquestion/answer" method="POST">
		<div class="headBox"><img class="vector" src="../image/vector.png">
			하루를 잇다
		<input type="image" src="../image/finishBtn.png" class="finishBtn" alt="완료">
		</div>
		
		
		<span class="question2">${todayFamilyQuestion.question}</span>
		<span class="numberOfQuestion2">#${todayFamilyQuestion.questionOrder}번째 질문</span>
		<span class="questionDate2"><fmt:formatDate value="${todayFamilyQuestion.askedDate}" pattern="yyyy.MM.dd"/></span>
		
	
		<div class="answerBox">
			<textarea spellcheck="false" placeholder="답변을 입력해주세요." class="answerTextarea" name="answer"></textarea>
		</div>
		<input type="hidden" name="dailyQuestionSeq" value="${todayFamilyQuestion.dailyQuestionSeq}" />
		<input type="hidden" name="questionOrder" value="${todayFamilyQuestion.questionOrder}"/>
		<input type="hidden" name="familySeq" value="${famSeq}"/>
		
		</form>
		
		<span class="characterCount">0/100</span>
		
	</div>
	
	
</body>
</html>