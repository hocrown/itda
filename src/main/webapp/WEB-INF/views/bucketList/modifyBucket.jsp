<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/addBucket.css">
<script type="text/javascript" src="/js/bucketlist/modifyBucket.js"></script>

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
			<input type="hidden" name="type" value="${bucketOne.type }">
			<div class="bucketWriteText">
				버킷리스트 수정하기
			</div>
			
			<div class="typeBox">
				<span class="typeText">유형</span>
				<c:choose>
					<c:when test="${bucketOne.type eq 'family'}">
		
						<input class="radioTypeInput" type="radio" id="family" name="type" value="Family">
						<label class="radioLabelFamily" for="family">
							<div class="ellipseFamily">
								<div id="familySmallEllipse" class="radioClickEllipse">
								</div>
							</div>
							<span class="familyText">가족</span>
						</label>
					
					
						<input class="radioTypeInput" type="radio" id="personal" name="type" value="Personal">
						<label class="radioLabelPersonal" for="personal">
							<div class="ellipsePersonal">
								<div id="personalSmallEllipse">
								</div>
							</div>
							<span class="personalText">개인</span>
						</label>	
	
					</c:when>
					
					<c:otherwise>
						<input class="radioTypeInput" type="radio" id="family" name="type" value="Family">
						<label class="radioLabelFamily" for="family">
							<div class="ellipseFamily">
								<div id="familySmallEllipse">
								</div>
							</div>
							<span class="familyText">가족</span>
						</label>
					
					
						<input class="radioTypeInput" type="radio" id="personal" name="type" value="Personal">
						<label class="radioLabelPersonal" for="personal">
							<div class="ellipsePersonal">
								<div id="personalSmallEllipse" class="radioClickEllipse">
								</div>
							</div>
							<span class="personalText">개인</span>
						</label>	
					
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="titleBox">
				<div class="titleText">제목</div>
				<input class="writeTitleTextarea" name="title" spellcheck="false" value="${bucketOne.title }">
				<img src="../image/bucket/bucketTitleUnderline.png" class="titleUnderline">
			</div>
			
			<div id="fileArea" class="addImgBox">
				<input style="display: none;" type="file" name="file" id="fileInput">
				<img src="data:image/png;base64,${base64ImageData}" style="width: 100%; margin-bottom: 5px;" alt="Preview" id="previewImage" class="addImgImg" />
								
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