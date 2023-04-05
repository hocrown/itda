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
});