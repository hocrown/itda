<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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