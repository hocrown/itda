<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/familypost/insertreplyaction">
<input type="text">
<input type="hidden" name="postSeq" value="${content.postSeq}">
<input type="text" name="replyContent">
</form>
</body>
</html>