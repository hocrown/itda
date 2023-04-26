<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="noErrorHead.jsp"%>
</head>
<body>
<div class="layout">

  <img class="introImg intro1" src="../image/intro/intro1.png">
</div>

<script>
$('.intro1').on('click', function(){
	window.location.href="/intro2";
});
</script>
</body>


</html>