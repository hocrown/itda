/**
 * 
 */
$(document).ready(function(){

	const referrer = document.referrer;
    $(".headBox .vector").click(function(){
        if (referrer.includes('/mainlist')) {
            window.location.href = "/mainlist";
        } else if(referrer.includes('/mainimg')){
           window.location.href = '/mainimg';
		} else {
			window.location.href='/mainimg';
		}
    });
	
	$(".headBox .addBtn").click(function(){
		location.href = "/bucket/addfamilybucket"; 
	});
});