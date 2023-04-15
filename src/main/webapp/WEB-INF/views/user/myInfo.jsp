<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/user/myInfo.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/js/myInfo.js"></script>
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			내정보
		</div>
		
			<div class="myInfoProfileBox"></div>
			
			<img class="profileImgEllipse" src="data:image/png;base64,${base64ImageData}" id="profileImgEllipse">
			<img src="../image/cameraImg.png" class="cameraImg">
			<input style="display: none;" type="file" name="file" id="fileInput">
			
			<span class="myInfoNicknameText">${loginUser.userName}</span>
			<img src="../image/textEditBtnImg.png" class="textEditBtnImg">
			<span class="myInfoUsernameText">${loginUser.userName}</span>
			<span class="myInfoBirthText">${dateDot}</span>
			
			<span class="myInfoIdText">아이디</span>
			<span class="myInfoId" name="userId">${loginUser.userId}</span>
			<span class="myInfoPwdText">비밀번호</span>
			<input type="password" class="myInfoPwd" name="userPw" value="${loginUser.userPw}">
			<img src="/image/eye.png" class="myInfopwdChkBtn">
			<div class="alert"></div>
			<span class="myInfoRealNameText">이름</span>
			<span class="myInfoRealName">${loginUser.userName}</span>
			<span class="myInfoBirthText2">생년월일</span>
			<span class="myInfoBirth2">${dateStr}</span>			
			
				<span class="genderText">성별</span>
			<c:choose>
			<c:when test="${loginUser.userGender eq 'male'}">
					<span class="maleText">남자</span>
			</c:when>
				<c:otherwise>
					<span class="femaleText">여자</span>
				</c:otherwise>	
			</c:choose>
			<span class="myInfoAddressText">주소</span>
			<input type="text" class="myInfoAddress" value="${loginUser.userAddress}">
			<input type="text" class="myInfoAddressDetail" value="${loginUser.userAddressDetail}">
			<div class="findAddressBtn">주소찾기</div>
		
			<span class="myInfoPhoneText">연락처</span>
			<input class="myInfoPhone" value="${loginUser.userPhone}">
			
			<span class="myInfoEmailText">이메일</span>
			<input class="myInfoEmail" value="${loginUser.email}">
			
			<div class="myInfoModifyBtn">수정하기</div>
			</form>
			<div class="myInfoUserDeactivate">탈퇴하기</div>
			
	</div>	
		
	<!-- Modal -->
	<div id="myModal" class="modal">
	  <div class="modal-content">
	    <img class="close" src="/image/closegray.png">
	    <p class="modal-text">우리 가족에게 난 어떤 존재이고 싶나요?</p>
	    <input type="text" class="modal-input-text" id="nickname" value="${loginUser.userName}" />
	    <img class="saveNickname" src="/image/wcheck.png">
	  </div>
	</div>
	

	
</body>
</html>