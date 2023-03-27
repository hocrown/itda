/**
 * 
 */
$(document).ready(function() {
  $(".createBtn").click(function() {
    var code = generateCode(); // 코드 생성
    $(".notes").val(code); // 생성한 코드를 입력란에 표시
     sessionStorage.setItem("famCode", code);
  });
  
  $(".nextBtn").click(function() {
    var notesValue = $(".notes").val(); // 입력된 값 가져오기
    if (notesValue === "") { // 입력된 값이 비어있으면
      $(".notes").focus(); // 입력란에 포커스 맞추기
      return false; // 버튼 클릭 이벤트 취소
    }
    location.href = "/user/signupstep1"; // 다음 페이지로 이동
  });
});

function generateCode() {
  var code = "";
  var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  var numberIndexes = []; // 숫자를 추가할 위치 저장할 배열

  // 랜덤한 위치 2군데에 숫자 추가
  while (numberIndexes.length < 2) {
    var randomIndex = Math.floor(Math.random() * 6);
    if (numberIndexes.indexOf(randomIndex) === -1) {
      numberIndexes.push(randomIndex);
    }
  }

  // 코드 생성
  for (var i = 0; i < 6; i++) {
    if (numberIndexes.indexOf(i) !== -1) { // 숫자 추가할 위치라면
      code += Math.floor(Math.random() * 10); // 0~9 중 랜덤한 숫자 추가
    } else {
      code += possible.charAt(Math.floor(Math.random() * possible.length)); // 영문자 중 랜덤한 문자 추가
    }
  }

  return code;
}

