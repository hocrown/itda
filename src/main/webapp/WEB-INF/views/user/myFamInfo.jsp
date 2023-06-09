<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/user/myFamInfo.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/js/myFamInfo.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			가족정보
		</div>
		
		<div>
    		<input type="file" id="famProfileInput" style="display:none;">
    		<img src="data:image/png;base64,${famImage}" class="fam-profile">
		</div>
		
		<div class="fam-name-area">
		  <div class="fam-name">
		    <c:choose>
		      <c:when test="${not empty family.familyName}">
		        <span id="familyName">${family.familyName}</span>
		        <img src="/image/textEditBtnImg.png" class="fam-name-edit-btn" data-familySeq="${family.familySeq}" alt="수정">
		      </c:when>
		      <c:otherwise>
		             <c:forEach items="${familyMember}" var="member">
				     	<c:if test="${member.userId == family.familyOwner}">
				        	<span id="familyName">${member.userName}의 가족</span>
				        	<img src="/image/textEditBtnImg.png" class="fam-name-edit-btn" data-familyseq="${family.familySeq}" alt="수정">
				        </c:if>
				      </c:forEach>
		      </c:otherwise>
		    </c:choose>
		  </div>
		  <span class="member-text">멤버 ${familyCount}</span>
		</div>
		<div class="fam-member-container">    
        	<c:forEach items="${familyMember}" var="member" varStatus="status">
            	<div class="fam-member-box">
		            <img src="data:image/png;base64,${profileImage[status.index]}" class="fam-member-img">
		            <div class="fam-member-name-area">
                   		<span id="famMemberName${member.userId}">${member.targetNickName}</span>
                   		<img src="../../image/textEditBtnImg.png" class="fam-member-name-edit-btn" data-userid="${member.userId}">
                	</div>
		            <div class="fam-member-name-area2">
		                <span>${member.userName}</span>
		                <span class="fam-member-birth">${member.userBirth}</span>
		            </div>
		        </div>
		    </c:forEach>
		</div>
		
		<div class="fam-code-text">가족코드</div>
		<div style="text-align: center;">
			<div class="fam-code-area">${famCode}<img class="copy-btn" src="../../image/copyBtnImg.png"></div>
		</div>
	</div>	

	

	
</body>
</html>