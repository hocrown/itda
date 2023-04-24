/**
 * 
 */
$(document).ready(function(){

 	$(".headBox .gobackbtn").click(function(){
    location.href = "/familypost";
	});
	
	  $('#addImgPreview').on('click', function() {
    $('#addImgInput').click();
  });

  $('#addImgInput').change(function() {
    let reader = new FileReader();
    reader.onload = function(event) {
      let img = new Image();
      img.onload = function() {
        $('.addImgBox img').attr('src', img.src);
        $('.addImgBox img').show();
        $('.addImgBox img').css({
          'position': 'absolute',
          'height': '100%',
          'cursor': 'pointer',
          'top': 'unset',
		  'left': 'unset'
        });
      }
      img.src = event.target.result;
    }
    reader.readAsDataURL(this.files[0]);
  });
  
  		$('.addImgBox').on('click', function() {
		  $('#fileInput').click();
		});

		$('#fileInput').on('click', function(event) {
		  event.stopPropagation(); // 이벤트 전달 중지
		});
	
	
	const fileInput = document.getElementById('fileInput');
	const previewImage = document.getElementById('previewImage');

	fileInput.addEventListener('change', () => {
	  const file = fileInput.files[0];
	  const reader = new FileReader();
	  reader.readAsDataURL(file);
	  reader.onload = () => {
	    previewImage.src = reader.result;
	  };
	});
	
	//미리보기 이미지 유무에 따라 이미지 추가안내 텍스트 보이거나 안보이게 설정

		  $('#previewImage').on('load', function() {
		    if ($(this).attr('src') !== '#') {
		      $('.imgAddPlzText').hide();
		    } else {
		      $('.imgAddPlzText').show();
		    }
		  });
		  
		  $('#previewImage').on('error', function() {
		    $('.imgAddPlzText').show();
		  });
	$('.writebtn').on('click',function(){
		

  var form = document.getElementById('insertPostForm');
  
  // 입력 필드의 유효성 검사 수행
  if (form.checkValidity()) {
    // 모든 입력 필드가 유효한 경우, 폼 제출
    form.submit();
  } else {
    // 유효하지 않은 입력 필드가 있는 경우, 사용자에게 알림
    alert('모든 필수 입력 필드를 입력해주세요.');
    // 이벤트 발생시 유효성 검사 메시지 표시
    form.reportValidity();
  }
	});  
  
});