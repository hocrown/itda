<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/landingPage.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$('#start-btn').click(function() {
				location.href = '/user/login';
			});
		});
	</script>
</head>
<body>
	<div class="layout">
		<span class="identityText">
		하지 못한 말,
		</span>
		<div>
			<img class="logoImg" src="../image/itdaLogo.png" > 
		</div>
	</div>
	<div class="startGroup" id="start-btn">
	<span class="startText">시작하기</span>
	</div>
</body>
</html>