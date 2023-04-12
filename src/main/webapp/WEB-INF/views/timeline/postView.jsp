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
			<img src="../image/timeline/search.png" class="searchbtn" strpe="filter: grayscale(70%);">
			<img src="../image/timeline/write.png" class="writebtn">
		</div>
		
			<img src="../image/timeline/mainpicture.png" class="timelineMainImg">
			<img src="../image/timeline/mainpictureBlind.png" class="timelineMainImg">
		
			<img src="../image/timeline/profileBox.png" class="profile">
			

		<div class="postLayout">
			<div class="postInfo">
			 		<img src="../image/timeline/profile.png" class="profileImg">
			 		<div class="writter">아빠</div>
			 		<div class="createDate">등록일 <fmt:formatDate value="${timeline.createDate}" pattern="yyyy.MM.dd"/></div>
			</div>
			<div class="postContent">내용내용내욘요요요요요요요요요요요요요${timeline.content}</div>
			<img src="..${timeline.filepath }" style="width:100%; min-height: 393px;">
		</div>
			
			
			
				        <div class="replyCountBox">
					        <img src="../image/bucket/replyCountImg.png" class="replyCountImg">
					        <span class="replyCountText">${replyCount }</span>
				        </div>
			        </div>
		       	</div>
		       	
		       	
				<c:set var="loopCount" value="0" />
	
</body>
</html>