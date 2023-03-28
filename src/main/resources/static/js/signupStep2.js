function checkAllInputFilled() {
  var nameValue = $('.notes').val();
  var yearValue = $('.notesYear').val();
  var monthValue = $('.notesMonth').val();
  var dayValue = $('.notesDay').val();

  if(nameValue && yearValue && monthValue && dayValue) {
    $('.nextBtn').prop('disabled', false);
  } else {
    $('.nextBtn').prop('disabled', true);
  }
}

$(document).ready(function() {
  // DatePicker 초기화
  $(".notesYear").datepicker({
    dateFormat: 'yy-mm-dd',
    changeYear: true,
    changeMonth: true,
    yearRange: "1900:+0",
    onSelect: function(dateText, inst) {
      var date = $(this).datepicker('getDate');
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var day = date.getDate();
        
      $('.notesYear').val(year);
      $('.notesMonth').val(month);
      $('.notesDay').val(day);

      checkAllInputFilled(); // 입력값이 변경될 때마다 다음 버튼의 활성화 여부 확인
    }
  });

  $(".radioLabelFemail").click(function() {
    $("#femailSmallEllipse, #mailSmallEllipse").removeClass("radioClickEllipse");
    $("#femailSmallEllipse").addClass("radioClickEllipse");
  });

  $(".radioLabelMail").click(function() {
    $("#femailSmallEllipse, #mailSmallEllipse").removeClass("radioClickEllipse");
    $("#mailSmallEllipse").addClass("radioClickEllipse");
  });
  
  // 입력값이 변경될 때마다 다음 버튼의 활성화 여부 확인
  $('.notes, .notesYear, .notesMonth, .notesDay').on('input', function() {
    checkAllInputFilled();
  });

  $('.nextBtn').click(function() {
    if($('.nextBtn').prop('disabled') == false) {
      sessionStorage.setItem('name', $('.notes').val());
      sessionStorage.setItem('year', $('.notesYear').val());
      sessionStorage.setItem('month', $('.notesMonth').val());
      sessionStorage.setItem('day', $('.notesDay').val());
      sessionStorage.setItem('gender', $('.radioGenderInput:checked').val());
          
      window.location.href = "/user/signupstep3";
    }
  });
$(".headBox img").click(function(){
    var id = sessionStorage.getItem("userId");
    location.href = "/user/back1?id=" + id;
});


});