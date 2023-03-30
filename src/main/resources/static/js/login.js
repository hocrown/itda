$(document).ready(function() {
  $(".eye").click(function() {
    var input = $(".notes2");
    if (input.attr("type") === "password") {
      input.attr("type", "text");
      $(".eye").attr("title", "비밀번호 숨기기");
      $(".eye").html('<i class="far fa-eye-slash"></i>');
    } else {
      input.attr("type", "password");
      $(".eye").attr("title", "비밀번호 표시");
      $(".eye").html('<i class="far fa-eye"></i>');
    }
  });
	
  // 로그인 버튼 클릭 이벤트
  $(".loginBtn").click(function(e) {
    e.preventDefault(); // 기본 이벤트(페이지 전환) 방지
    var userId = $(".notes").val(); // 입력한 아이디
    var userPw = $(".notes2").val(); // 입력한 비밀번호
    if (!userId || !userPw) { // 아이디 또는 비밀번호가 비어있는 경우
      alert("아이디 또는 비밀번호를 입력해주세요.");
      return;
    }
    // 서버로 전송할 데이터
    var data = {
      userId: userId,
      userPw: userPw
    };
    $.ajax({
      type: "POST",
      url: "/user/login",
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function(response) {
        if (response.result === "success") { // 로그인 성공
          sessionStorage.setItem("userId", userId); // 사용자 아이디를 session storage에 저장
          location.href = "/mainimg"; // 메인 페이지로 이동
        } else { // 로그인 실패
          alert("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
      },
      error: function(xhr, status, error) {
        console.error(error);
      }
    });
  });
  
  // enter 키를 눌렀을 때
  $("input").keydown(function(e) {
    if (e.keyCode == 13) { // 엔터키 코드
      e.preventDefault(); // 기본 이벤트(페이지 전환) 방지
      $(".loginBtn").click(); // 로그인 버튼 클릭 이벤트 발생
    }
  });
  
  $(".headBox img").click(function(){
    location.href = "/";
  });
});
