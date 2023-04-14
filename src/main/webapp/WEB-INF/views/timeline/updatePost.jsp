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
		<form class="updatePostForm" action="/familypost/updateaction method="post" enctype="multipart/form-data">
			<div class="headBox">
				<img src="../image/vector.png" class="gobackbtn">
				<input class="finishBtn" type="image" src="../image/finishBtn.png" alt="완료" onclick="document.getElementById('insertContentarea').submit();">
			</div>
			<input type="hidden" name="postSeq" value="${postOne.postSeq }">
			
			
			<div class="insertContentareaBox">
				<textarea class="insertContentarea" name="content" spellcheck="false">${postOne.content}</textarea>
			</div>
			
			<div id="fileArea" class="addImgBox">
				<input style="display: none;" type="file" name="file" id="fileInput"><img src="${postOne.filepath }" alt="Preview" id="previewImage" class="addImgImg">
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