<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/addPersonalBucket.css">

</head>
<body>
	<div class="layout">
		<form class="addPersonalBucketForm" action="/bucket/addpersonalbucketaction" method="post" enctype="multipart/form-data">
			<div class="headBox">
				<img src="../image/vector.png" class="vector">
				소망을 잇다
				<input class="finishBtn" type="image" src="../image/finishBtn.png" alt="완료" onclick="document.getElementById('addPersonalBucketForm').submit();">
			</div>
			
			<div class="writeTitleBox">
				<input class="writeTitleTextarea" name="title" placeholder="제목을 입력해 주세요." spellcheck="false">
			</div>
			
			<div class="addImgBox">
			<div><input type="file" name="file"><img src="../image/addImgImg.png" class="addImgImg"></div>
			<span class="imgAddPlzText">연상되는 사진을 추가해주세요.</span>
			</div>
			
			<div class="addBucketTextareaBox">
				<textarea class="addBucketTextarea" name="contents" spellcheck="false" placeholder="내용을 입력해 주세요."></textarea>
			</div>
		</form>

		<div style="height: 50px;"></div>
		
	</div>	
	
</body>
</html>