window.onload = function(){
    document.getElementById("searchBtn").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}
function updateEmail() {
  var select = document.getElementsByName('email_domain')[0];
  var input = document.getElementById('email_id');
  var selectedValue = select.options[select.selectedIndex].value;
  input.value = input.value.replace(/@[a-z]+\.[a-z]+$/i, '') + selectedValue;
}


// 이전 페이지로 돌아가는 함수
function goBack() {
  window.history.back();
}

$(document).ready(function() {
  // 이전 페이지에서 sessionStorage에 저장된 값들 가져오기
  var name = sessionStorage.getItem('name');
  var year = sessionStorage.getItem('year');
  var month = sessionStorage.getItem('month');
  var day = sessionStorage.getItem('day');
  var gender = sessionStorage.getItem('gender');

  // 입력 필드에 값 채워주기
  $('.notes').val(name);
  $('.notesYear').val(year);
  $('.notesMonth').val(month);
  $('.notesDay').val(day);
  $('input[name="gender"][value="' + gender + '"]').prop('checked', true);

  // img 클릭 시 이전 페이지로 돌아가는 함수 호출
  $('.vector').click(function() {
    goBack();
  });
});
