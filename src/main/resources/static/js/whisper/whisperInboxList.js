/**
 * 
 */
$(document).ready(function(){
    $(".whisperInboxListToggle").click(function(){
            window.location.href = "/whisper/inboximg";
    });
    
    $(".send").click(function(){
		window.location.href = "/whisper/writeform";
	});
	
	$(".send2").click(function(){
		window.location.href = "/whisper/outbox";
	});
	
 	$(".headBox .vector").click(function(){
    location.href = "/mainlist";
	});
});