<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>index</h2>
	
	<a href="insert">회원가입</a>
	<a href="login">로그인</a>
	
	${sessionScope.loginById}
</body>
</html>