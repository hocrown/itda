<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../css/admin/admin.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="//code.jquery.com/ui/1.13.0/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<% 
	//세션 체크
	try {
		com.project.itda.common.CheckAuth.checkLogin(session);
	} catch (com.project.itda.common.AccessDeniedException e) {
		//세션 값이 없는 경우, error 메세지로 이동
		request.setAttribute("errorMessage",e.getMessage());
		response.sendRedirect(request.getContextPath() + "/error");
	}
%>