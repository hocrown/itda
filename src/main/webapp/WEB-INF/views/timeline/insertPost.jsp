<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/timeline/insertPost.css">
<script type="text/javascript" src="/js/timeline/insertPost.js"></script>

</head>
<body>
	<div class="layout">
		<div class="headBox">
			일상을 잇다
			<img src="../image/vector.png" class="gobackbtn">
			<input class="finishBtn" type="image" src="../image/finishBtn.png" alt="완료" onclick="document.getElementById('insertPostForm').submit();">
		</div>
		
		<div class="postWriteText">타임라인 작성하기</div>
		
				<form class="insertPostForm" id="insertPostForm" action="/familypost/insertaction" method="post" enctype="multipart/form-data">
				
				<div>
					<div class="addImgBox">
					    <input style="display: none;" type="file" name="file" id="fileInput">
						<img src="#" alt="Preview" id="previewImage" class="addImgImg">
						<span class="imgAddPlzText">사진을 추가하려면</span>
					</div>
					
					<div class="insertContentareaBox">
						<textarea class="insertContentarea" name="content" spellcheck="false" required placeholder="내용을 입력해 주세요."></textarea>
					</div>
					
				</div>	
				
				</form>
	</div>
	
</body>
</html>