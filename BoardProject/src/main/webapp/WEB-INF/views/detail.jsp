<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>detail</h2>
	번호 : ${b.b_number} <br>
	작성작 : ${b.b_writer}<br>
	비밀번호 : ${b.b_password}<br>
	제목 : ${b.b_title}<br>
	내용 : ${b.b_contents}<br>
	조회수 : ${b.b_hits}<br>
	작성날짜 : ${b.b_date}<br>
	<fmt:formatDate value='${b.b_date}' pattern="yyyy.MM.dd"/>
	<fmt:formatDate value='${b.b_date}' pattern="HH:mm:ss"/>
</body>
</html>