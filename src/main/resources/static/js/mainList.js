/**
 * 
 */
$(document).ready(function(){
    $(".mainListToggle").click(function(){
        window.location.href = "/mainimg";
    });
    $(".dailyTextBox").click(function(){
		window.location.href = "/dailymain";
	});
	
	$(".questionBox").click(function(){
		window.location.href="/dailymain";
	});
	
	$(".bucketTextBox").click(function(){
		window.location.href="/bucket/bucketview";
	});
	
	$(".whisperTextBox").click(function(){
		window.location.href="/whisper/main";
	});
	
	$(".bell").click(function(){
		window.location.href="/alarmlist";
	});
	
	$(".myImg").click(function(){
		window.location.href="/user/mypage";
	});
});
