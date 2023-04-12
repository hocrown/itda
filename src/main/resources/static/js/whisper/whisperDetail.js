$(document).ready(function(){
  const referrer = document.referrer;
  	$(".headBox .vector").click(function(){
	    // 이전 페이지가 whisperInboxImg 인 경우
	    if (referrer.includes('/whisper/main')) {
	      window.location.href = '/whisper/inboximg'
	    }
	    // 이전 페이지가 whisperInboxList 인 경우
	    else if (referrer.includes('/whisper/inboxlist')) {
	      window.location.href = '/whisper/inboxlist';
	    }
	    else if (referrer.includes('/whisper/inboximg')){
			window.location.href = '/whisper/inboximg'
		}
  	});
	
	//점 3개 클릭 시, 삭제하기 창
	$('.detailEllipsis').click(function() {
  		$('.detailDeleteBox').toggleClass('active');
	});

	$(document).on('click', function(event) {
  		if (!$(event.target).closest('.detailDeleteBox').length && !$(event.target).closest('.detailEllipsis').length) {
    		$('.detailDeleteBox').removeClass('active');
  		}
	});
	
	// 삭제 버튼 클릭 시 모달 창 띄우기
	$('.detailDeleteBox').on('click', function() {
		$('.modal').css('display', 'block');
  	});
  
	// 취소 버튼과 모달창 바깥 영역 클릭 시 모달 창 닫기
	$('.btn-cancel-area, .modal').on('click', function() {
    	$('.modal').css('display', 'none');
	});

	// 삭제 버튼 클릭 시 whisperSeq 값 전달하고 whisperInboximg 페이지로 이동
  	$('.btn-delete-area').on('click', function() {
    	const whisperSeq =  document.getElementById('whisperSeq').value;
    	console.log(whisperSeq);
    	$.ajax({
      		url: '/whisper/delete',
      		method: 'POST',
      		data: {
		        whisperSeq: whisperSeq
      		},
      	complete: function(xhr, status) {
	        if (status === 'success') {
          	window.location.href = '/whisper/main';
        	}
	      },
      	error: function(xhr, status, error) {
	        console.error(error);
      	}
    	});
  	});
});
