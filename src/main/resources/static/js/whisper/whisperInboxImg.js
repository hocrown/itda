/**
 * 
 */
$(document).ready(function(){
	
	  const referrer = document.referrer;
  	$(".headBox .vector").click(function(){
	    // 이전 페이지가 mainImg 인 경우
	    if (referrer.includes('/mainimg')) {
	      window.location.href = '/mainimg'
	    }
	    // 이전 페이지가 whisperInboxList 인 경우
	    else if (referrer.includes('/mainlist')) {
	      window.location.href = '/mainlist';
	    }
	    else {
			window.location.href = '/mainimg';
		}
  	});
	
    $(".whisperInboxImgToggle").click(function(){
            window.location.href = "/whisper/inboxlist";
    });
    
	$(".send").click(function(){
		window.location.href = "/whisper/writeform";
	});
	
	$(".send2").click(function(){
		window.location.href = "/whisper/outbox";
	});
	
	
	var prevUrl = document.referrer;
});