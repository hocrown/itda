$(document).ready(function() {
  // 로그인 버튼 클릭 이벤트와 동일한 함수를 정의합니다.
  function loginAction() {
    var userId = $("#userId").val(); // 입력한 아이디
    var userPw = $("#userPw").val(); // 입력한 비밀번호
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
      url: "/admin/login",
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function(response) {
        if (response.result === "success") { // 로그인 성공
          sessionStorage.setItem("userId", userId); // 사용자 아이디를 session storage에 저장
          location.href = "/admin/questionmanagementlist"; // 메인 페이지로 이동
        } else { // 로그인 실패
          alert("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
      },
      error: function(xhr, status, error) {
        console.error(error);
      }
    });
  }

  // 로그인 버튼 클릭 이벤트
  $(".adminLoginBtn").click(function(e) {
    e.preventDefault(); // 기본 이벤트(페이지 전환) 방지
    loginAction();
  });

  // 입력 필드에서 엔터 키 이벤트 처리
  $(".adminIdPwdInput, .adminIdPwdInput.pw").keydown(function(e) {
    if (e.keyCode === 13) { // 엔터 키 코드
      e.preventDefault(); // 기본 이벤트(페이지 전환) 방지
      loginAction();
    }
  });
});