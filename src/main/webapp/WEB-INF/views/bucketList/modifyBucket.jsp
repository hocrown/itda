<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/addFamilyBucket.css">

</head>
<body>
	<div class="layout">
		<form class="modifyBucketForm" action="/bucket/modifyaction" method="post" enctype="multipart/form-data">
			<div class="headBox">
				<img src="../image/vector.png" class="vector">
				소망을 잇다
				<input class="finishBtn" type="image" src="../image/finishBtn.png" alt="완료" onclick="document.getElementById('modifyBucketForm').submit();">
			</div>
			<input type="hidden" name="bucketSeq" value="${bucketOne.bucketSeq }">
			<div class="writeTitleBox">
				<input class="writeTitleTextarea" name="title" value="${bucketOne.title }" spellcheck="false">
			</div>
			
			<div id="fileArea" class="addImgBox">
				<input style="display: none;" type="file" name="file" id="fileInput"><img src="${bucketOne.filepath }" alt="Preview" id="previewImage" class="addImgImg">
			</div>
			
			<div class="addBucketTextareaBox">
				<textarea class="addBucketTextarea" name="contents" spellcheck="false">${bucketOne.contents }</textarea>
			</div>
		</form>

		<div style="height: 50px;"></div>
		
	</div>	
	
	<script>

	
	
	const fileInput = document.getElementById('fileInput');
	const previewImage = document.getElementById('previewImage');

	fileInput.addEventListener('change', () => {
	  const file = fileInput.files[0];
	  const reader = new FileReader();
	  reader.readAsDataURL(file);
	  reader.onload = () => {
	    previewImage.src = reader.result;
	  };
	});
	
	$('#previewImage').on('click', function() {
		  $('#fileInput').click();
		});
	</script>
	
</body>
</html>