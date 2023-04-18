/**
 * 
 */
$(document).ready(function() {
	
	$(".headBox .vector").click(function(){
		window.location.href ='/user/mypage';
  	});
  	
  	 $(".fam-profile").click(function(){
        $("#famProfileInput").click();
    });

    $("#famProfileInput").change(function(){
		var file = this.files[0];
        var formData = new FormData();
        formData.append('profileImage', file);

        $.ajax({
            url: '/user/updateFamilyProfile',
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
                // 서버에서 반환된 이미지 URL을 사용해 프리뷰 업데이트
                $('.fam-profile').attr('src', response.imageUrl);
            },
            error: function(err) {
                console.error(err);
                alert('이미지 업로드에 실패했습니다.');
            }
        });
    });

    $(".fam-member-name-edit-btn").click(function(){
        var userId = $(this).data('userid');
        var currentName = $("#famMemberName" + userId).text();
        
        var inputField = $("<input>")
                .attr("type", "text")
                .attr("id", "editFamMemberName" + userId)
                .attr("value", currentName);
        
        $("#famMemberName" + userId).replaceWith(inputField);
        
        $("#editFamMemberName" + userId).focusout(function() {
			var updatedName = $("#editFamMemberName" + userId).val();
	        // 서버에 변경된 닉네임 업데이트 요청
	        $.ajax({
	            url: '/user/updateFamilyMemberNickname',
	            type: 'POST',
	            data: {
	                targetUserId: userId,
	                targetNickName: updatedName
	            },
	            success: function(response) {
	                if (response.success) {
	                    var nameSpan = $("<span>")
	                            .attr("id", "famMemberName" + userId)
	                            .text(updatedName);
	                    $("#editFamMemberName" + userId).replaceWith(nameSpan);
	                } else {
	                    alert('닉네임 업데이트에 실패했습니다.');
	                }
	            },
	            error: function(err) {
	                console.error(err);
	                alert('닉네임 업데이트에 실패했습니다.');
	            }
	        });
    	});
    });
});