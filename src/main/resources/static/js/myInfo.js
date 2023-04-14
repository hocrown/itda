/**
 * 
 */
$(document).ready(function() {
	$(".headBox .vector").click(function(){
		window.location.href ='/user/mypage';
  	});


	$(".findAddressBtn").on("click", function() {
		new daum.Postcode({
			oncomplete: function(data) {
				$(".myInfoAddress").val(data.address); 
				$("input[class=myInfoAddressDetail]").focus();
			}
		}).open();
	});
	
    $(".myInfopwdChkBtn").on("click", function() {
		console.log('click');
    var pwd = $(".myInfoPwd");
    if (pwd.attr("type") == "password") {
        pwd.attr("type", "text");
        $(this).attr("src", "/image/eye-off.png");
    } else {
        pwd.attr("type", "password");
        $(this).attr("src", "/image/eye.png");
    }
    });
    
    $('.profileImgEllipse, .cameraImg').on('click', function() {
		console.log("Click");
		  $('#fileInput').click();
		});

		$('#fileInput').on('click', function(event) {
		  event.stopPropagation(); // 이벤트 전달 중지
		});

		const fileInput = document.getElementById('fileInput');
		const previewImage = document.getElementById('profileImgEllipse');

		fileInput.addEventListener('change', () => {
		const file = fileInput.files[0];
		const reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload = () => {
	    previewImage.src = reader.result;
		};
	});
    
    
    $(".myInfoPwd").on("input", function() {
	  var userPw = $(this).val(); // 입력한 비밀번호
	  var regex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$/; // 영문자, 숫자, 특수문자 포함 8자 이상인지 검사할 정규식
	  if (regex.test(userPw)) { // 정규식에 맞는다면
	    validPw = true;
	    $(".myInfoPwdText").removeClass("invalid"); // 글씨색을 초기 상태로 변경
	    $(".alert").hide(); // 유효성 검사 실패 문구 숨기기
	  } else {
	    validPw = false;
	    $(".myInfoPwdText").addClass("invalid"); // 빨간색 글씨로 변경
	    $(".alert").text("비밀번호는 8자 이상, 영문자와 숫자, 특수문자를 조합하여 입력하세요.").show();
	  }
	});
	  // 모달창에 입력할 정보
	  var $modal = $("#myModal");
	  var $btn = $(".textEditBtnImg");
	  var $span = $(".close");
	  var $save = $(".saveNickname");
	  var $nickname = $("#nickname");
	  var $myInfoNicknameText = $(".myInfoNicknameText");
	
	  // 모달창 오픈
	  $btn.on("click", function() {
	    $modal.css("display", "block");
	  });
	
	  // 모달창 닫기
	  $span.on("click", function() {
	    $modal.css("display", "none");
	  });
	
	  // 모달창에 입력된 닉네임 정보 myInfo 페이지로 전달
	  $save.on("click", function() {
	    $myInfoNicknameText.text($nickname.val());
	    $modal.css("display", "none");
	  });
	
	  var isModified = false;
	
	  // 입력 폼이 변경되면 수정하기 버튼의 클래스를 변경
	  $("input").on("input", function() {
	    if (!isModified) {
	      $(".myInfoModifyBtn").addClass("modifyBtn");
	      isModified = true;
	    }
	  });
	
	  // 수정하기 버튼을 클릭하면 서버로 정보 전송
	  $(".myInfoModifyBtn").on("click", function() {
	       if (isModified) {
      var userId = "${loginUser.userId}";
      var userPw = $(".myInfoPwd").val();
      var userAddress = $(".myInfoAddress").val();
      var userAddressDetail = $(".myInfoAddressDetail").val();
      var phone = $(".myInfoPhone").val();
      var email = $(".myInfoEmail").val();
      var file = $('#fileInput')[0].files[0]; // 수정된 부분

      // FormData 객체 생성
      var formData = new FormData();
      formData.append('userId', userId);
      formData.append('userPw', userPw);
      formData.append('userAddress', userAddress);
      formData.append('userAddressDetail', userAddressDetail);
      formData.append('userPhone', phone);
      formData.append('email', email);
      formData.append('file', file); // 파일 추가

      // Ajax를 사용하여 정보 전송
      $.ajax({
        type: "POST",
        url: "/user/updateUserInfo",
        data: formData, // 수정된 부분
        processData: false, // 수정된 부분
        contentType: false, // 수정된 부분
        success: function(data) {
          // 정보 업데이트 성공 시
          $(".myInfoModifyBtn").removeClass("modifyBtn");
          isModified = false;
          alert("정보가 업데이트되었습니다.");
          window.location.href ='/user/myinfo';
        },
        error: function() {
          // 정보 업데이트 실패 시
          alert("정보 업데이트에 실패했습니다.");
        }
      });
    }
	});
});