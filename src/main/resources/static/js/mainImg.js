/**
 * 
 */
// 이미지 hover 시 src 속성 변경 함수
function changeToGif(element, newSrc) {
  element.src = newSrc;
}

// 이미지 hover 종료 시 src 속성 변경 함수
function changeToPng(element, originalSrc) {
  element.src = originalSrc;
}
$(document).ready(function(){
    $(".mainImgToggle").click(function(){
            window.location.href = "/mainlist";
        });
        
	$(".questionBox").click(function(){
		window.location.href="/dailymain";
	});
	
	$(".mainDailyQuestion").click(function(){
		window.location.href = "/dailymain";
	});
	
	$(".mainBucketList").click(function(){
		window.location.href="/bucket/bucketview";
	});
	
	$(".mainWhisper").click(function(){
		window.location.href="/whisper/main";
	});
	
	$(".mainTimeLine").click(function(){
		window.location.href="/familypost";
	});
	
	$(".bell").click(function(){
		window.location.href="/alarmlist";
	});
	
	$(".myImg").click(function(){
		window.location.href="/user/mypage";
	});
	

});
