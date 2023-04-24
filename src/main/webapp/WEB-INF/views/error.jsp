<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <meta charset="UTF-8">
    <%@ include file="head.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/error.css">
</head>
<body>
	<div class="layout">
		<div class="headBox" onclick="history.back()">
			<img src="/image/vector.png" class="vector">
			Error
		</div>
	    <div class="error-message">
    	    <span class="error-messageText">${errorMessage}</span>
    	    
    	    <a href="/user/login"><button class="login-move-btn btn">로그인 페이지로</button></a>
    	</div>
</div>
</body>
</html>
