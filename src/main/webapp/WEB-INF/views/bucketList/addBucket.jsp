<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/addBucket.css">
<script type="text/javascript" src="/js/bucketlist/addBucket.js"></script>

</head>
<body>
	<div class="layout">
		<form class="addBucketForm" action="/bucket/addbucketaction" method="post" enctype="multipart/form-data">
			<div class="headBox">
				<a><img src="../image/vector.png" class="vector"></a>
				소망을 잇다
				<input class="finishBtn" type="image" src="../image/finishBtn.png" alt="완료" onclick="document.getElementById('addBucketForm').submit();">
			</div>
			
			<div class="bucketWriteText">
				버킷리스트 작성하기
			</div>
			
			<div class="typeBox">
				<span class="typeText">유형</span>
				
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
						<div id="personalSmallEllipse">
						</div>
					</div>
					<span class="personalText">개인</span>
				</label>		
			</div>
			
			<div class="titleBox">
				<div class="titleText">제목</div>
				<input class="writeTitleTextarea" name="title" spellcheck="false">
				<img src="../image/bucket/bucketTitleUnderline.png" class="titleUnderline">
			</div>
				
			
			
			<div id="fileArea" class="addImgBox">
				<input style="display: none;" type="file" name="file" id="fileInput">
				<img src="#" alt="Preview" id="previewImage" class="addImgImg">
				<span class="imgAddPlzText">연상되는 사진을 추가해주세요.</span>
			</div>
			
			<div class="addBucketTextareaBox">
			<textarea class="addBucketTextarea" name="contents" spellcheck="false" placeholder="내용을 입력해 주세요."></textarea>
			</div>
		</form>

		
	</div>	
	
	<script>
	$(".radioLabelPersonal").click(function() {
	    $("#personalSmallEllipse, #familySmallEllipse").removeClass("radioClickEllipse");
	    $("#personalSmallEllipse").addClass("radioClickEllipse");
	  });

	  $(".radioLabelFamily").click(function() {
	    $("#personalSmallEllipse, #familySmallEllipse").removeClass("radioClickEllipse");
	    $("#familySmallEllipse").addClass("radioClickEllipse");
	  });
	  
	
	$('.addImgBox').on('click', function() {
		  $('#fileInput').click();
		});

		$('#fileInput').on('click', function(event) {
		  event.stopPropagation(); // 이벤트 전달 중지
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
	
	//미리보기 이미지 유무에 따라 이미지 추가안내 텍스트 보이거나 안보이게 설정
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