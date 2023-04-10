/**
 * 
 */
var prevUrl = document.referrer;

 $(document).ready(function() {
	const referrer = document.referrer;
    $(".headBox .vector").click(function(){
        if (referrer.includes('/mainlist')) {
            window.location.href = "/mainlist";
        } else if(referrer.includes('/mainimg')){
           window.location.href = '/mainimg';
		} else {
			window.location.href='/mainimg';
		}
    });
	
	$(".headBox .menuBtn").click(function(){
    location.href = "/dailyquestion/dailylist";	
	});
	
	$(".headBox .stickerPageLink").click(function(){
    location.href = "/dailyquestion/monthly";	
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
	
	$('.kokBtn').click(function () {
    var targetUserId = $(this).data('user-id');
    var notification = "질문에 답변해주세요.";
    var currentDate = new Date().toISOString().slice(0, 10);
    var alarm = {
        userId: targetUserId,
        alarmDate: currentDate,
        checked: 0,
        message: notification
    };
    
    $.ajax({
        type: 'POST',
        url: '/sendAlarm',
        data: JSON.stringify(alarm),
        contentType: 'application/json; charset=utf-8',
        success: function (data) {
            console.log(`알림 전송 to ${targetUserId}: ${notification}`);
        },
        error: function (xhr, status, error) {
            console.error(error);
        }
    });
});
});