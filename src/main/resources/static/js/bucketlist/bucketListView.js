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
		location.href = "/bucket/addbucket"; 
	});
});

document.addEventListener('click', function (event) {
            const ripple = document.createElement('div');
            ripple.className = 'ripple';
            ripple.style.left = event.clientX - 5 + 'px';
            ripple.style.top = event.clientY - 5 + 'px';
            document.body.appendChild(ripple);

            setTimeout(function () {
                ripple.remove();
            }, 1000);
        });