/**
 * 
 */
$(document).ready(function(){

 	$(".headBox .gobackbtn").click(function(){
    window.location.href = "/familypost";
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
	
	$('.detailModifyText').on('click', function(){
    const postSeq =  document.getElementById('postSeq').value;
    console.log(postSeq);
    window.location.href = `/familypost/updatepost?postSeq=${postSeq}`;
	});
	
	
	// 삭제 버튼 클릭 시 모달 창 띄우기
	$('.detailDeleteText').on('click', function() {
		$('.modal').css('display', 'block');
  	});
  
	// 취소 버튼과 모달창 바깥 영역 클릭 시 모달 창 닫기
	$('.btn-cancel-area, .modal').on('click', function() {
    	$('.modal').css('display', 'none');
	});

  	$('.btn-delete-area').on('click', function() {
    	const postSeq =  document.getElementById('postSeq').value;
    	$.ajax({
      		url: '/familypost/deleteaction',
      		method: 'POST',
      		data: {
		        postSeq: postSeq
      		},
      	complete: function(xhr, status) {
	        if (status === 'success') {
          	window.location.href = '/familypost';
        	}
	      },
      	error: function(xhr, status, error) {
	        console.error(error);
      	}
    	});
  	});
});