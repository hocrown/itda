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
			<img src="../image/vector.png" class="gobackbtn">
			<input class="finishBtn" type="image" src="../image/finishBtn.png" alt="완료" onclick="document.getElementById('insertPostForm').submit();">
		</div>

				<form class="insertPostForm" id="insertPostForm" action="/familypost/insertaction" method="post" enctype="multipart/form-data">
					<div class="insertContentareaBox">
						<textarea class="insertContentarea" name="content" spellcheck="false" placeholder="내용을 입력해 주세요."></textarea>
					</div>
				
				<div class="addImgBox">
				  <div class="innerAddImgBox">
				    <img src="../image/timeline/addPicture.png" class="addImgImg" id="addImgPreview">
				    <input type="file" name="file" id="addImgInput" style="display:none;">
				  </div>
				</div>
					
				</form>
	</div>
</body>
</html>