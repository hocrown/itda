window.onload = function(){
    document.getElementById("searchBtn").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector(".address_output").innerHTML = data.address; // 주소 넣기
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

$(document).ready(function() {

	// img 클릭 시 이전 페이지로 돌아가는 함수 호출
	$(".headBox img").click(function(){
	    location.href = "/user/back2";
	});
	

	$('#finishBtn').click(function() {
		
		  // 주소, 상세주소, 이메일이 모두 입력되었는지 확인합니다.
	  if ($('#address_kakao').val() == "" || $('input[name=address_detail]').val() == "" || $('#email_id').val() == "") {
	    alert("주소와 이메일을 모두 입력해주세요.");
	    return false;
	  }
	var data = {
	    // 입력된 데이터와 sessionStorage의 값을 객체에 담습니다.
	    userAddress: $('#address_kakao').val(),
	    userAddressDetail: $('input[name=address_detail]').val(),
	    email: $('#email_id').val(),
	    // sessionStorage에서 값을 가져와서 객체에 담습니다.
	    userName: sessionStorage.getItem('name'),
	    famCode: sessionStorage.getItem('famCode'),
	    userId: sessionStorage.getItem('userId'),
	    userPw: sessionStorage.getItem('userPw'),
	    year: sessionStorage.getItem('year'),
	    month: sessionStorage.getItem('month'),
	    day: sessionStorage.getItem('day'),
	    userGender: sessionStorage.getItem('gender'),
	    approve: sessionStorage.getItem('approve'),
	    userPhone: $('.notes1').val() + $('.notes2').val() + $('.notes3').val()
  };

  // 서버로 데이터를 전송합니다.
  $.ajax({
    type: 'POST',
    url: '/user/signup',
    contentType: 'application/json',
    data: JSON.stringify(data),
    success: function(response) {
      // 데이터 전송에 성공한 경우 처리합니다.
      console.log(response);
      // 처리 결과에 따른 동작 수행(로그인 페이지로 이동)
      window.location.href = '/user/login';
    },
    error: function(xhr, status, error) {
      // 데이터 전송에 실패한 경우 처리합니다.
      console.error(xhr.responseText);
      alert("회원가입에 실패하였습니다. 다시 시도해주세요.");
      window.location.href = '/user/login';
    }
  });
});

});
