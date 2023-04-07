/**
 * 
 */
$(document).ready(function(){
  	$(".headBox .vector").click(function(){
    location.href = "/mainlist";
	});
	
	$('.detailEllipsis').click(function() {
  		$('.detailDeleteBox').toggleClass('active');
	});

});

