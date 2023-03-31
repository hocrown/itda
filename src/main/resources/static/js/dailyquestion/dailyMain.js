/**
 * 
 */
var prevUrl = document.referrer;

 $(document).ready(function() {

    $(".headBox .vector").click(function(){
        // Get today's date
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0');
        var yyyy = today.getFullYear();
        var todayString = yyyy + '.' + mm + '.' + dd;

        // Check if the date matches
        if ($('.questionDate').text() == todayString) {
            location.href = "/mainlist";
        } else {
            location.href = prevUrl;
        }
    });
	
	$(".headBox .menuBtn").click(function(){
    location.href = "/dailyquestion/dailylist";	
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