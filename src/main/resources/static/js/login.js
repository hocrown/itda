/**
 * 
 */
$(document).ready(function() {
  $(".loginBtn").click(function(e) {
    e.preventDefault(); // 기본 이벤트(페이지 전환) 방지

    var userId = $(".notes").val(); // 입력한 아이디
    var userPw = $(".notes2").val(); // 입력한 비밀번호

    // 서버로 전송할 데이터
    var sendData = {
      userId: userId,
      userPw: userPw
    };

    $.ajax({
      type: "POST",
      url: "/user/login",
      data: sendData,
      dataType: "json",
      success: function(response) {
        if (response.result === "success") { // 로그인 성공
          sessionStorage.setItem("userId", userId); // 사용자 아이디를 session storage에 저장
          location.href = "/main"; // 메인 페이지로 이동
        } else { // 로그인 실패
          alert("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
      },
      error: function(xhr, status, error) {
        console.error(error);
      }
    });
  });
$(".headBox img").click(function(){
    location.href = "/";
});

});

