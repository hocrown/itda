<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/dailyquestion/dailyMonthlyPage.css">
<link rel="stylesheet" type="text/css" href="/css/dailyquestion/sticker.css">
<script type="text/javascript" src="/js/dailyquestion/dailyMonthly.js"></script>

</head>
<body>

	<div class="layout">
		<div class="headBox"><img class="vector" src="/image/vector.png">
			하루를 잇다
		</div>
		
		<span class="putTogetherText">가족 모두가 답변한<br>소중한 날들을 모아봤어요.</span>
		
		<img class="monthlyPageLine" src="/image/monthlyPageLine.png">
			<div class="yearText">2023</div>
			<span class="monthText">4월</span>
			<img class="monthlyPageVector prevMonth" src="/image/monthlyPageVector.png">
			<img class="monthlyPageVector nextMonth" src="/image/monthlyPageVector.png">

		<img class="monthlyPageLine2" src="/image/monthlyPageLine.png">
		<div class="stickerContainer">
		<img src="/image/monthly/backImg04.png" style="position:fixed; top:0;">

		</div>
		
	</div>
	
	
	<script>
		
		const imageURL = "/image/monthly/sticker04.png";
		const stickerContainer = document.querySelector('.stickerContainer');
		
	
		for(let i=1 ; i<=10 ; i++) {	
			const newImage = document.createElement('img');
			newImage.src = imageURL;
			newImage.className = "sticker04-" + i;
			stickerContainer.appendChild(newImage);
		}
	
	</script>
	
	
</body>
</html>