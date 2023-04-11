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
  	
  	$("#myInfo").click(function(){
		window.location.href = '/user/myinfo';		  
	});
	
	$("#familyInfo").click(function(){
		window.location.href = '/user/myfaminfo';		  
	});
	
	$("#itdaNotice").click(function(){
		window.location.href = '/user/myinfo';		  
	});
	
	$("#itdaQnA").click(function(){
		window.location.href = '/user/myinfo';		  
	});
});