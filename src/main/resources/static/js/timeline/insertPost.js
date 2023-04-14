/**
 * 
 */
$(document).ready(function(){
 var prevUrl = document.referrer;

 	$(".headBox .gobackbtn").click(function(){
    location.href = prevUrl;
	});
	
	
	
});