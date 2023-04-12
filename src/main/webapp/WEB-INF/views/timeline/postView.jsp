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
</head>

<body> 

<div class="layout">
	<div class="headBox">
		<img src="../image/vector.png" class="gobackbtn">
		<img src="../image/timeline/write.png" class="writebtn">
	</div>
	<div class="postBanner">	
			<img src="../image/timeline/mainpicture.png" class="timelineMainImg">
			<img src="../image/timeline/mainpictureBlind.png" class="blindImg">
			<img src="../image/timeline/profileBox.png" class="profile">
	</div>

	<div class="allPostLayout">
		<c:forEach var="timeline" items="${post}">
		<div class="postLayout">
			
			<div class="postInfo">
		 		<img src="../image/timeline/profile.png" class="profileImg">
		 		<div class="writter">${timeline.userName}</div>
		 		<div class="createDate">등록일 <fmt:formatDate value="${timeline.createDate}" pattern="yyyy.MM.dd"/></div>
			</div>
				<div class="postContent">
					<div class="postContentText">${timeline.content}</div>
					<img src="..${timeline.filepath}" style="width:100%; min-height: 393px;" class="userPic">
				</div>
				<div class="replyLayout">
		       			<div class="replyCountBox">
				        <img src="../image/bucket/replyCountImg.png" class="replyCountImg">
				        <span class="replyCountText">${timeline.replyCount}</span>
						</div>
		        </div>

		</div>
		</c:forEach>		   
	</div>    	
</div>
</body>
</html>