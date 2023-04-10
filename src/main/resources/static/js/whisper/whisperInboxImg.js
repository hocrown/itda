/**
 * 
 */
$(document).ready(function(){
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

 	$(".headBox .vector").click(function(){
    location.href = "/mainlist";
	});
});