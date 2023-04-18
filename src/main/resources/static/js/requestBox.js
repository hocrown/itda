/**
 * 
 */
$(document).ready(function() {
	$(".headBox .vector").click(function(){
		window.location.href ='/user/mypage';
  	});
  	
  	$(".radioLabelFamily").click(function() {
    	$("#familySmallEllipse, #commonSmallEllipse").removeClass("radioClickEllipse");
    	$("#familySmallEllipse").addClass("radioClickEllipse");
 	});

 	$(".radioLabelCommon").click(function() {
	    $("#familySmallEllipse, #commonSmallEllipse").removeClass("radioClickEllipse");
	    $("#commonSmallEllipse").addClass("radioClickEllipse");
	});
 

  // 최대 글자수
  var maxLength = 40;
  
  // input 태그에 입력값이 변경될 때마다 호출되는 함수
  $(".request-input").on("input", function() {
    // 현재 입력된 글자 수
    var currentLength = $(this).val().length;
    
    // 최대 글자수에 도달한 경우
    if (currentLength >= maxLength) {
      // 입력값 자르기
      $(this).val($(this).val().substring(0, maxLength));
      
      // 글자 수 표시
      $(".request-text-count").text(maxLength + "/" + maxLength);
    } else { // 최대 글자수에 도달하지 않은 경우
      // 글자 수 표시
      $(".request-text-count").text(currentLength + "/" + maxLength);
    }
  });
	
	
	
	$(".apply-btn").click(function() {
	  var question = $("input[name='question']").val();
	  var typeValue = $("input[name='type']:checked").val();

	  var data = {
	    question: question,
	    type: typeValue
	  };
	  
	  $.ajax({
	    url: "/user/requestquestion",
	    method: "POST",
	    data: JSON.stringify(data),
	    contentType: "application/json; charset=utf-8",
	    success: function(response) {
			$("#messageText").text(response);
      		$('.modal').css('display', 'block');
  			$('.btn-delete-area').on('click', function() {
			$('.modal').css('display', 'none');
			});
	    },
	    error: function(error) {
	      console.error(error);
	    }
	  });
	});
});