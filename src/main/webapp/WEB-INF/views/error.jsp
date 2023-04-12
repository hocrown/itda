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
			마음을 잇다
		</div>
	    <div class="error-message">
    	    <span class="error-messageText">${errorMessage}</span>
    	</div>
</div>
</body>
</html>
