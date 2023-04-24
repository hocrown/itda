/**
 * 
 */
 $(document).ready(function() {
 	$(".headBox .vector").click(function(){
    location.href = "/dailymain";	
	});
	
	$('#prevMonth').click(function() {
    	// 이전 월 데이터 로드 함수 호출
	});

	$('#nextMonth').click(function() {
	    // 다음 월 데이터 로드 함수 호출
	});
	
	const imageURL = "/image/monthly/sticker04.png";
	const stickerContainer = document.querySelector('.stickerContainer');


	for(let i=1 ; i<=10 ; i++) {	
		const newImage = document.createElement('img');
		newImage.src = imageURL;
		newImage.className = "sticker04-" + i;
		stickerContainer.appendChild(newImage);
	}
	



});
	