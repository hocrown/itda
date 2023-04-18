/**
 * 
 */

// 이전 url을 저장할 변수
var prevUrl = document.referrer;
$(document).ready(function() {
 	$(".headBox .vector").click(function(){
    location.href = prevUrl;
	});
});