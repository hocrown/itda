$(document).ready(function() {
	
    $(".headBox .vector").click(function(){
		window.location.href = "/whisper/inboximg";
	});

	$('.datepicker').datepicker({
    dateFormat: 'yy-mm-dd',
    minDate: 0
	});

    $('.whisperWriteForm').on("submit", function(event) {
		event.preventDefault();

        // 입력한 내용 가져오기
        const receiver = $('#receiverSelect').val();
        const message = $('.whisperTextarea').val();
        const senderNickname = $('.fromInput').val();
        const option = $('input[name="sendOption"]:checked').val();
		
        // 입력값 유효성 검사
        if (receiver === '' || message === '' || senderNickname === '') {
            alert('받는 사람, 내용, 보내는 사람 모두 입력해주세요.');
            return;
        }

		//전송할 data 객체 생성
		const data = {
                receiver: receiver,
                message: message,
                senderNickname: senderNickname,
                option : option
        };

		// 선택된 옵션이 'reservation'인 경우 datepicker 값을 추가
		if (option === 'reservation') {
		    const selectedDate = $('.datepicker').val();
		    data.date = selectedDate;
		}

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
    
    
    // 전달 옵션 클릭 이벤트 처리
	$('.directOptionEllipse, .bombOptionEllipse, .reservationOptionEllipse').on('click', function() {
	    // 모든 옵션의 배경색을 원래대로 되돌림
	    $('.directOptionEllipse, .bombOptionEllipse, .reservationOptionEllipse').css('background', 'rgba(176, 151, 144, 0.4)');
	
	    // 선택한 옵션의 배경색을 변경
	    $(this).css('background', 'rgba(180, 151, 144, 0.7)');
	
	    // 선택한 옵션에 따라 input 값 변경
	    const selectedOption = $(this).data('option');
	    $('input[name="sendOption"]').val(selectedOption);
	
	     // 'reservation' 옵션을 선택한 경우 Datepicker를 표시하고, 그렇지 않으면 숨김
	    if (selectedOption === 'reservation') {
	        $('.datepicker').show();
	    } else {
	        $('.datepicker').hide();
	    }
});
});