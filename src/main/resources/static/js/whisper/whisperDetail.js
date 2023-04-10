/**
 * 
 */
$(document).ready(function(){
  	$(".headBox .vector").click(function(){
    location.href = "/whisper/inboximg";
	});
	
	$('.detailEllipsis').click(function() {
  		$('.detailDeleteBox').toggleClass('active');
	});

});

