/**
 * 
 */
$(document).ready(function() {
  $('.sendBtn').on('click', function() {
    // 선택된 옵션에 따라 요청 URL 결정
    let option = $('input[name="sendOption"]:checked').val();
    let url = '';
    if (option === 'direct') {
      url = '/whisper/send';
    } else if (option === 'bomb') {
      url = '/whisper/send?bomb=true';
    } else if (option === 'reservation') {
      const selectedDate = $('.datepicker').val();
      url = '/whisper/send?date=' + selectedDate;
    }

    // 입력한 내용 가져오기
    const recipient = $('.selectCss option:selected').text();
    const whisper = $('.whisperTextarea').val();
    const sender = $('.fromInput').val();

    // 입력값 유효성 검사
    if (recipient === '' || whisper === '' || sender === '') {
      alert('받는 사람, 내용, 보내는 사람 모두 입력해주세요.');
      return;
    }

    // 서버에 데이터 전송
    $.ajax({
      type: 'POST',
      url: url,
      data: {
        recipient: recipient,
        whisper: whisper,
        sender: sender
      },
      success: function(response) {
        alert(response.message);
        window.location.href = '/whisper/list';
      },
      error: function(error) {
        alert('전송 실패. 다시 시도해주세요.');
      }
    });
  });
});