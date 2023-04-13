<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="adminHead.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="adminLayout">
	<%@ include file="adminNavi.jsp"%>
	
	
	
	</div>
	
	<script>
	$(document).ready(function () {
		$("#navi-statistics").addClass("navi-selected")
	});
	</script>
	
</body>
</html>