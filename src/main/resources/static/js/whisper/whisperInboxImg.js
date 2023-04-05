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
});