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

    $('.kokBtn').click(function () {
        var userId = $(this).data('user-id');
        var message = "질문에 답변해주세요.";
        var currentDate = new Date().toISOString().slice(0, 10);
        var alarm = {
            userId: userId,
            alarmDate: currentDate,
            checked: 0,
            message: message
        };

        $.ajax({
            type: 'POST',
            url: '/sendAlarm',
            data: JSON.stringify(alarm),
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                console.log(`알림 전송 to ${userId}: ${message}`);
                sendMessage(userId, message);
            },
            error: function (xhr, status, error) {
                console.error(error);
            }
        });
    });

    function sendMessage(userId, message) {
		const socketUrl = window.location.origin + '/ws';
        const socket = new WebSocket(socketUrl);

        socket.addEventListener('open', (event) => {
            console.log('WebSocket connection opened:', event);
            const destination = `/app/alarm/${userId}`;
            const payload = {
              message: message
            };
            socket.send(JSON.stringify({
              command: 'send',
              destination: destination,
              body: JSON.stringify(payload)
            }));
        });

        socket.addEventListener('close', (event) => {
            console.log('WebSocket connection closed:', event);
        });

        socket.addEventListener('error', (event) => {
            console.error('WebSocket error:', event);
        });
    }
});
