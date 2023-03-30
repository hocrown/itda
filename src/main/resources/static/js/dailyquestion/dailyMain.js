/**
 * 
 */
 var prevUrl = document.referrer;
 $(document).ready(function() {

 	$(".headBox .vector").click(function(){
    location.href = prevUrl;
	});
	
	$(".headBox .menuBtn").click(function(){
    location.href = "/dailyquestion/dailylist";	
	});
	
});