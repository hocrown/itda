/**
 * 
 */
var prevUrl = document.referrer;
var socket = new SockJS('/websocket');
var stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/user/queue/notifications', function (notification) {
        // 알림을 받았을 때 처리할 로직을 작성합니다.
        // 예: 알림 메시지를 화면에 표시하거나 로그를 남기는 등
        console.log('Received notification: ' + notification.body);
    });
});
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
	
	
	$.ajax({
    url: '/getSessionUserId',
    type: 'GET',
    success: function(data) {
        var userId = data.userId;
        console.log(userId);
    }
    });
	
 const userId = userId;
  const socket = new WebSocket('ws://yourserver.com/notifications');

  socket.addEventListener('message', (event) => {
    const message = event.data;
    console.log(`Received notification: ${message}`);
  });

  socket.addEventListener('open', (event) => {
    console.log('Connected to the notification server');
  });

  socket.addEventListener('close', (event) => {
    console.log('Disconnected from the notification server');
  });

  $('.kokBtn').click(function () {
    var targetUserId = $(this).data('user-id');
    var notification = "질문에 답변해주세요.";
    socket.send(JSON.stringify({targetUserId: targetUserId, notification: notification}));
});
});