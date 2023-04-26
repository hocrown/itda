<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="noErrorHead.jsp"%>
</head>
<body>
<div class="layout">

  <img class="introImg intro2" src="../image/intro/intro2.png">
</div>

<script>
$('.intro2').on('click', function(){
	window.location.href="/intro3";
});
</script>
</body>

</html>