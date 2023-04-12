/**
 * 
 */
var socket = new SockJS('/websocket');
var stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/user/queue/alarm', function (alarm) {
        // 알림을 받았을 때 처리할 로직을 작성합니다.
        // 예: 알림 메시지를 화면에 표시하거나 로그를 남기는 등
        console.log('Received notification: ' + alarm.body);

        // 알림 메시지를 모달의 텍스트에 설정합니다.
        document.getElementById('alarmText').innerText = notification.body;

        // 모달을 표시합니다.
        $('#alarmModal').modal('show');
    });
});