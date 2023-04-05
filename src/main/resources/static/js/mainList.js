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
	
	var socket = new SockJS('/websocket');	
	var stompClient = Stomp.over(socket);
	stompClient.connect({}, function (frame) {
		stompClient.subscribe('/user/queue/notifications', function (notification) {
    	// 알림을 받았을 때 처리할 로직을 작성합니다.
    	// 예: 알림 메시지를 화면에 표시하거나 로그를 남기는 등
    	console.log('받은 알람: ' + notification.body);
		});
	});
	
	
});
