<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/timeline/updatePost.css">


</head>
<body>
	<div class="layout">
		<form class="updatePostForm" action="/familypost/updateaction" method="post" enctype="multipart/form-data">
			<div class="headBox">
				<img src="../image/vector.png" class="gobackbtn">
				일상을 잇다
				<input class="finishBtn" type="image" src="../image/finishBtn.png" alt="완료" onclick="document.getElementById('insertContentarea').submit();">
			</div>
			
			<input type="hidden" name="postSeq" value="${postOne.postSeq }">
			
			<div class="postUpdateText">타임라인 수정하기</div>
			
	
			
			<div id="fileArea" class="addImgBox">
				<input type="file" id="fileInput" name="file" style="display: none;">
				<img src="data:image/png;base64,${base64ImageData}" style="width: 100%; margin-bottom: 5px;" alt="Preview" id="previewImage" class="addImgImg" />
			</div>
			
			<div class="insertContentareaBox">
				<textarea class="insertContentarea" name="content" spellcheck="false">${postOne.content}</textarea>
			</div>
			
			
			
		</form>

		
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