<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/dailyquestion/dailyList.css">
<script type="text/javascript" src="/js/dailyquestion/dailyList.js"></script>
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
			        <c:choose>
			            <c:when test="${familyQuestion.allAnswered}">
			                <a href="/dailyquestion/familybylist?dailyQuestionSeq=${familyQuestion.dailyQuestionSeq}&amp;familySeq=${familyQuestion.familySeq}&amp;questionOrder=${familyQuestion.questionOrder}" class="questionTextOfList" style="text-decoration:none">
			                    ${familyQuestion.question}
			                </a>
			            </c:when>
			            <c:otherwise>
			                <a href="/dailyquestion/familybylist?dailyQuestionSeq=${familyQuestion.dailyQuestionSeq}&amp;familySeq=${familyQuestion.familySeq}&amp;questionOrder=${familyQuestion.questionOrder}" class="questionTextOfList" style="text-decoration:none; color:#80808080">
			                    ${familyQuestion.question}
			                </a>
			            </c:otherwise>
			        </c:choose>
			        <span class="finishCount">
			            <c:choose>
			                <c:when test="${familyQuestion.allAnswered}">
			                    <img src="../image/familyClearImg.png" alt="checked" class="allAnswered">
			                </c:when>
			                <c:otherwise>
<%-- 			                    ${familyQuestion.answeredCount}/${familyQuestion.familyMemberCount} --%>
			                </c:otherwise>
			            </c:choose>
			        </span>
			    </div>
			</c:forEach>
		</div>
	</div>

</body>
</html>