<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/error.css">
<%@ include file="noErrorHead.jsp"%>
</head>
<body>
	<div class="layout" style="position: relative;">
		<div class="headBox" onclick="history.back()">
			<img src="/image/vector.png" class="vector">
			Error
		</div>
		<div >
	    <div class="error-message">
    	    <span class="error-messageText">${errorMessage}</span>
    	    
    	    <a href="/user/login"><button class="login-move-btn btn">로그인 페이지로</button></a>
    	</div>
    	</div>
</div>
</body>
</html>
