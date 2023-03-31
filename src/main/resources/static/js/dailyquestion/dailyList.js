/**
 * 
 */

// 이전 url을 저장할 변수
var prevUrl = document.referrer;

 	$(".headBox .vector").click(function(){
    location.href = prevUrl;
	});