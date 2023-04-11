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
	
	$(".alarmMark").click(function(){
		window.location.href="/alarmlist";
	});
	
	$(".myImg").click(function(){
		window.location.href="/user/mypage";
	});
	
	var socket = new SockJS('/websocket');	
	var stompClient = Stomp.over(socket);
	stompClient.connect({}, function (frame) {
		stompClient.subscribe('/user/queue/alarm', function (alarm) {
    	// 알림을 받았을 때 처리할 로직을 작성합니다.
    	// 예: 알림 메시지를 화면에 표시하거나 로그를 남기는 등
    	console.log('받은 알람: ' + alarm.body);
		});
	});
	
});
