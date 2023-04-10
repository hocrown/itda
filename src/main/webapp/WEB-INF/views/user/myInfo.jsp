<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/user/myInfo.css">

</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			내정보
		</div>
		
			<div class="myInfoProfileBox"></div>
			<div class="profileImgEllipse"></div>
			<img src="../image/cameraImg.png" class="cameraImg">
			<span class="myInfoNicknameText">박주주</span>
			<img src="../image/textEditBtnImg.png" class="textEditBtnImg">
			<span class="myInfoUsernameText">박주주</span>
			<span class="myInfoBirthText">1997.11.20</span>
			
			<span class="myInfoIdText">아이디</span>
			<span class="myInfoId">itda0428</span>
			<span class="myInfoPwdText">비밀번호</span>
			<span class="myInfoPwd">**********</span>
			<img src="../image/eye.png" class="myInfopwdChkBtn">
			<span class="myInfoRealNameText">이름</span>
			<span class="myInfoRealName">박주동</span>
			<span class="myInfoBirthText2">생년월일</span>
			<span class="myInfoBirth2">2000년4월28일</span>			
			
			<span class="genderText">성별</span>
			<input class="radioGenderInput" type="radio" id="male" name="gender" value="male">
			<label class="radioLabelMale" for="male">
				<div class="ellipseMale">
					<div id="maleSmallEllipse">
					</div>
				</div>
				<span class="maleText">남자</span>
			</label>
			
			<input class="radioGenderInput" type="radio" id="female" name="gender" value="female">
			<label class="radioLabelFemale" for="female" >
				<div class="ellipseFemale">
					<div id="femaleSmallEllipse">
					</div>
				</div>
				<span class="femaleText">여자</span>
			</label>		
		
			<span class="myInfoAddressText">주소</span>
			<span class="myInfoAddress">서울특별시 종로구 창경궁로asdasdasd 254</span>
			<div class="findAddressBtn">주소찾기</div>
		
			<span class="myInfoPhoneText">연락처</span>
			<span class="myInfoPhone">01000000000</span>
			
			<span class="myInfoEmailText">이메일</span>
			<span class="myInfoEmail">itda0428@gmail.com</span>
			
			<div class="myInfoModifyBtn">수정하기</div>
			
			<div class="myInfoUserDeactivate">탈퇴하기</div>
			
	</div>	
	
	

	
</body>
</html>