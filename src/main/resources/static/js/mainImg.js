/**
 * 
 */
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
	
	$(".alarmMark").click(function(){
		window.location.href="/alarmlist";
	});
	
	$(".myImg").click(function(){
		window.location.href="/user/mypage";
	});
	

});
