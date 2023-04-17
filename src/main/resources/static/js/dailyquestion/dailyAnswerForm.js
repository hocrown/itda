/**
 * @author 윤준호
 * @since 2023-03-29
 */
 $(document).ready(function() {
	
	$('.answerTextarea').keypress(function(event) {
		if (event.which == 13) { // Enter 키가 눌렸을 때
			event.preventDefault(); // 기본 동작 중지
			var content = $(this).val();
			content += '\n'; // 줄 바꿈 문자 추가
			$(this).val(content);
		}
	});
	
var prevUrl = document.referrer;

 	$(".headBox .vector").click(function(){
    location.href = prevUrl;
	});
	

const textarea = document.querySelector('.answerTextarea');
const characterCount = document.querySelector('.characterCount');

textarea.addEventListener('input', () => {
  const length = textarea.value.length;
  characterCount.innerText = `${length}/100`;
});


});
