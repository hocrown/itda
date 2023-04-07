<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/addFamilyBucket.css">
<script type="text/javascript" src="/js/bucketlist/addFamilyBucket.js"></script>

</head>
<body>
	<div class="layout">
		<form class="addBucketForm" action="/bucket/addbucketaction" method="post" enctype="multipart/form-data">
			<div class="headBox">
				<a><img src="../image/vector.png" class="vector"></a>
				소망을 잇다
				<input class="finishBtn" type="image" src="../image/finishBtn.png" alt="완료" onclick="document.getElementById('addBucketForm').submit();">
			</div>
			
			<div class="writeTitleBox">
				<input class="writeTitleTextarea" name="title" placeholder="제목을 입력해 주세요." spellcheck="false">
			</div>
			
			<div id="fileArea" class="addImgBox">
				<input style="display: none;" type="file" name="file" id="fileInput"><img src="#" alt="Preview" id="previewImage" class="addImgImg">
				<span class="imgAddPlzText">연상되는 사진을 추가해주세요.</span>
			</div>
			
			<div class="addBucketTextareaBox">
				<textarea class="addBucketTextarea" name="contents" spellcheck="false" placeholder="내용을 입력해 주세요."></textarea>
			</div>
		</form>

		<div style="height: 50px;"></div>
		
	</div>	
	
	<script>
	
	$('.addImgBox').one('click', function() {
		  $('#fileInput').click();
		});
	
	
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
	
	$(document).ready(function() {
		  $('#previewImage').on('load', function() {
		    if ($(this).attr('src') !== '#') {
		      $('.imgAddPlzText').hide();
		    } else {
		      $('.imgAddPlzText').show();
		    }
		  });
		  
		  $('#previewImage').on('error', function() {
		    $('.imgAddPlzText').show();
		  });
		});
	
	
	</script>
	
</body>
</html>