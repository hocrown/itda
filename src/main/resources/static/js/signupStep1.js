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
  $(".nextBtn").click(function() {
    var userId = $(".notes").val(); // 입력한 아이디
    var userPw = $(".notes2").val(); // 입력한 비밀번호

    // 아이디 유효성 검사
    if (userId.length < 6) { // 6글자 이상이 아니라면
      $(".idText").addClass("invalid"); // 빨간색 글씨로 변경
      $(".notes").val("").attr("placeholder", "6글자 이상 입력하세요.").focus(); // 입력란 초기화 및 포커스 이동
      $(".alert").text("아이디는 6글자 이상 입력하세요.").show();
      return false; // 유효성 검사 실패
    }

    // 비밀번호 유효성 검사
    var regex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$/; // 영문자, 숫자, 특수문자 포함 8자 이상인지 검사할 정규식
    if (!regex.test(userPw)) { // 정규식에 맞지 않는다면
      $(".pwdText").addClass("invalid"); // 빨간색 글씨로 변경
      $(".notes2").val("").attr("placeholder", "8자 이상, 영문자와 숫자, 특수문자 조합 입력하세요.").focus(); // 입력란 초기화 및 포커스 이동
      $(".alert").text("비밀번호는 8자 이상, 영문자와 숫자, 특수문자를 조합하여 입력하세요.").show();
      return false; // 유효성 검사 실패
    }

    // 모든 유효성 검사 통과 시
    sessionStorage.setItem("userId", userId); // 입력한 아이디를 session storage에 저장
    sessionStorage.setItem("userPw", userPw); // 입력한 비밀번호를 session storage에 저장
    location.href = "/user/signupstep2"; // 다음 페이지로 이동
  });
});

// 입력란 내용이 변경될 때마다 유효성 검사를 실행하고 문구를 출력
$(".notes").on("input", function() {
  var userId = $(this).val(); // 입력한 아이디
  if (userId.length >= 6) { // 6글자 이상이라면
    $(".idText").removeClass("invalid"); // 글씨색을 초기 상태로 변경
    $(".alert").hide(); // 유효성 검사 실패 문구 숨기기
  } else {
    $(".idText").addClass("invalid"); // 빨간색 글씨로 변경
    $(".alert").text("아이디는 6글자 이상 입력하세요.").show();
  }
});

$(".notes2").on("input", function() {
  var userPw = $(this).val(); // 입력한 비밀번호
  var regex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$/; // 영문자, 숫자, 특수문자 포함 8자 이상인지 검사할 정규식
  if (regex.test(userPw)) { // 정규식에 맞는다면
    $(".pwdText").removeClass("invalid"); // 글씨색을 초기 상태로 변경
    $(".alert").hide(); // 유효성 검사 실패 문구 숨기기
  } else {
    $(".pwdText").addClass("invalid"); // 빨간색 글씨로 변경
    $(".alert").text("비밀번호는 8자 이상, 영문자와 숫자, 특수문자를 조합하여 입력하세요.").show();
  }
});
