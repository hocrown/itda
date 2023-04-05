<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/dailyquestion/dailyList.css">

</head>
<body>

	<div class="layout">
		<div class="headBox"><img class="vector" src="../image/vector.png">
			하루를 잇다
		</div>
		<div class="questionListContainer">
		    <c:forEach items="${familyQuestions}" var="familyQuestion">
		        <div class="questionListBox">
		         <img class="listNum" src="../image/listNum/${familyQuestion.questionOrder}.png" alt="${familyQuestion.questionOrder}">
        		<a href="/dailyquestion/familybylist?dailyQuestionSeq=${familyQuestion.dailyQuestionSeq}&amp;familySeq=${familyQuestion.familySeq}&amp;questionOrder=${familyQuestion.questionOrder}" class="questionTextOfList" style="text-decoration:none">
	            ${familyQuestion.question}
	            </a>
				<span class="finishCount">
				    <c:choose>
				        <c:when test="${familyQuestion.allAnswered}">
				            <img src="../image/familyClearImg.png" alt="checked">  <!-- 두 수가 일치할 경우 이미지 출력 -->
				        </c:when>
				        <c:otherwise>
				            ${familyQuestion.answeredCount}/${familyQuestion.familyMemberCount}  <!-- 두 수가 일치하지 않을 경우 텍스트 출력 -->
				        </c:otherwise>
				    </c:choose>
				</span>
		        </div>
		    </c:forEach>
		</div>
	</div>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.2/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script type="text/javascript" src="/js/dailyquestion/dailyList.js"></script>
</body>
</html>