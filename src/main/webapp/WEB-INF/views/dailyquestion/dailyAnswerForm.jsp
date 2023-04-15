<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/dailyquestion/dailyAnswer.css">
<script type="text/javascript" src="/js/dailyquestion/dailyAnswerForm.js"></script>

</head>
<body>

	<div class="layout">
		<form id="answer-form" action="/dailyquestion/answer" method="POST">
		<div class="headBox"><img class="vector" src="../image/vector.png">
			하루를 잇다
		<input type="image" src="../image/finishBtn.png" class="finishBtn" alt="완료" onclick="submitForm()">
		</div>
		
		
		<span class="question2">${familyQuestion.question}</span>
		<span class="numberOfQuestion2">#${questionOrder}번째 질문</span>
		<span class="questionDate2"><fmt:formatDate value="${familyQuestion.askedDate}" pattern="yyyy.MM.dd"/></span>
		<input type="hidden" name="dailyQuestionSeq" value="${familyQuestion.dailyQuestionSeq}" />
		<input type="hidden" name="questionOrder" value="${questionOrder}"/>
		<input type="hidden" name="familySeq" value="${familySeq}"/>
	
		<div class="answerBox">
			<textarea spellcheck="false" placeholder="답변을 입력해주세요." class="answerTextarea" name="answer"></textarea>
		</div>
		</form>
		
		<span class="characterCount">0/100</span>
		
	</div>
	
	
</body>
</html>