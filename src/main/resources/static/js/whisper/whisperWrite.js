$(document).ready(function() {

    // 전달 옵션 클릭 이벤트 처리
    $('.directOptionEllipse, .bombOptionEllipse, .reservationOptionEllipse').on('click', function() {
        // 모든 옵션의 배경색을 원래대로 되돌림
        $('.directOptionEllipse, .bombOptionEllipse, .reservationOptionEllipse').css('background', 'rgba(176, 151, 144, 0.4)');

        // 선택한 옵션의 배경색을 변경
        $(this).css('background', 'rgba(180, 151, 144, 0.7)');

        // 선택한 옵션에 따라 input 값 변경
        const selectedOption = $(this).data('option');
        $('input[name="sendOption"]').val(selectedOption);
        console.log(selectedOption);

         // 'reservation' 옵션을 선택한 경우 Datepicker를 표시하고, 그렇지 않으면 숨김
        if (selectedOption === 'reservation') {
            $('.datepicker').show();
        } else {
            $('.datepicker').hide();
        }

    });

    $(".headBox .vector").click(function(){
        window.location.href = "/whisper/inboximg";
    });

    //전송할 data 객체 생성
    const data = {};

    $('.datepicker').datepicker({
        dateFormat: 'yy-mm-dd',
        minDate: 0,
        onSelect: function(dateText) {
            const selectedDate = $(this).datepicker('getDate');
            console.log(selectedDate);
            const formattedDate = $.datepicker.formatDate('yy-mm-dd', selectedDate);
            console.log(formattedDate);
            data.date = formattedDate;
        }
    });

    $('.whisperWriteForm').on("submit", function(event) {
        event.preventDefault();

		
        // 입력한 내용 가져오기
        const receiver = $('#receiverSelect').val();
        const message = $('.whisperTextarea').val();
        const senderNickname = $('.fromInput').val();
        const option = $('input[name="sendOption"]').val();
		console.log(option);
        // 입력값 유효성 검사
        if (receiver === '' || message === '' || senderNickname === '') {
            alert('받는 사람, 내용, 보내는 사람 모두 입력해주세요.');
            return;
        }

        //전송할 data 객체에 값 할당
        data.receiver = receiver;
        data.message = message;
        data.senderNickname = senderNickname;
        data.option = option;

        // 서버에 데이터 전송
        $.ajax({
            type: 'POST',
            url: '/whisper/send',
            data: data,
            success: function(response) {
                console.log(response.result)
                alert(response.message);
                window.location.href = '/whisper/inboximg';
            },
            error: function(error) {
                alert(error.responseText);
            }
        });
    });

});
