<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
	
	
  <thead>
    <tr>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${bucketlist}" var="bucket">
        <div>${bucket.title}</div>
    </c:forEach>
  </tbody>
	

</body>
</html>