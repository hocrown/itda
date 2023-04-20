<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>가족 게시판</title>
<link rel="stylesheet" type="text/css" href="/css/timeline/postView.css">
<script type="text/javascript" src="/js/timeline/postView.js"></script>
</head>

<body> 

<div class="layout">
	<div class="headBox">
		<img src="../image/vector.png" class="gobackbtn">
		<img src="../image/timeline/write.png" class="writebtn">
	</div>
	
	<div class="postBanner">	
			<img src="data:image/png;base64,${famImage}" class="timelineMainImg">
			<img src="../image/timeline/mainpictureBlind.png" class="blindImg">
    		<input type="file" id="famProfileInput" style="display:none;">
	</div>

	<div class="fam-name-area">
		  <div class="fam-name">
		    <c:choose>
		      <c:when test="${not empty family.familyName}">
		        <span>${family.familyName}</span>
		        <img src="../../image/textEditBtnImg.png" class="fam-name-edit-btn">
		      </c:when>
		      <c:otherwise>
		             <c:forEach items="${familyMember}" var="member">
				     	<c:if test="${member.userId == family.familyOwner}">
				        	<span>${member.userName}의 가족</span>
				        </c:if>
				      </c:forEach>
		      </c:otherwise>
		    </c:choose>
		  </div>
		  <span class="member-text">멤버 ${familyCount}</span>
		</div>
	<div class="allPostLayout">
		<c:forEach var="timeline" items="${post}">
		
			<div class="postLayout">
				
				<div class="postInfo">
 					<c:forEach items="${familyMember}" var="member">
				 	   <c:if test="${member.userId == timeline.userId}">
					        <c:choose>
					            <c:when test="${not empty member.userImageData}">
					                <img src="data:image/png;base64,${member.encodedImage}" class="fam-member-img">
					            </c:when>
					            <c:otherwise>
					                <img src="${defaultProfileImage}" class="fam-member-img">
					            </c:otherwise>
					        </c:choose>
				        <div class="writter">${timeline.userName}</div>
				        <div class="createDate">등록일 <fmt:formatDate value="${timeline.createDate}" pattern="yyyy년 MM월 dd일"/></div>
					    </c:if>
					</c:forEach>
				</div>
					
				<div class="postContent">
					<a href="/familypost/postcontent?postSeq=${timeline.postSeq}">
						<div class="postContentText">${timeline.content}</div>
						<img src="..${timeline.filepath}" class="userPic">
					</a>
	
					<div class="replyCountBox">
				   	  <img src="../image/bucket/replyCountImg.png" class="replyCountImg">
				   	  <span class="replyCountText">${timeline.replyCount}</span>
					</div>
					</div>
				
				
			
					<c:set var="loopCount" value="0" />
					    <c:forEach items="${reply}" var="reply" varStatus="status">
							<c:if test="${status.last}">
									<c:set var="loopCount" value="${status.index + 1}" />
							</c:if>
						</c:forEach>
			</div>
		</c:forEach>	
	</div>
</div>
</body>
</html>