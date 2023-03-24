<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spring Boot Application with JSP</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/figmatest.css">
</head>
<body>
    Hello, Spring Boot App jsp Hi JUno 
    <form action="<c:url value='/user/insert'/>" method="post" id="joinForm" name="joinForm" class="form-horizontal">
    <input class="btn btn-primary" type="submit"  style="margin: 2 0 2 0;" width=70%  value="가입">
    </form>
<button id='button2' class='button2' onClick="location.href='/'">Add</button>
<button id="button3" class="button3" onClick="location.href='/'">Home</button>
<span class="test">asdasd</span>
</body>
</html>