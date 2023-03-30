/**
 * @author 윤준호
 * @since 2023-03-29
 */
 $(document).ready(function() {
	$('#answer-form').submit(function(event) {
		event.preventDefault(); // 기본 동작 중지
		var formData = $(this).serialize(); // Form 데이터 가져오기
		formData = formData.replace(/\r?\n/g, '\n'); // 줄 바꿈 문자를 HTML <br> 태그로 변환
		$.ajax({
			url: $(this).attr('action'),
			type: $(this).attr('method'),
			data: formData,
			success: function(data) {
				// 전송이 완료되면 처리할 내용
				 window.location.href = '/dailymain';
			}
		});
	});
	
	$('.answerTextarea').keypress(function(event) {
		if (event.which == 13) { // Enter 키가 눌렸을 때
			event.preventDefault(); // 기본 동작 중지
			var content = $(this).val();
			content += '\n'; // 줄 바꿈 문자 추가
			$(this).val(content);
		}
	});
	
	$(".headBox .vector").click(function(){
    location.href = "/dailymain";	
	});

const textarea = document.querySelector('.answerTextarea');
const characterCount = document.querySelector('.characterCount');

textarea.addEventListener('input', () => {
  const length = textarea.value.length;
  characterCount.innerText = `${length}/100`;
});


});
