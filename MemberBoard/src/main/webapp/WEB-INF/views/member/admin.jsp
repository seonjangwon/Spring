<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL(JSP Standard Tag Library)사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>admin</h2>
	<c:if test="${loginDTO.m_id eq 'admin'}">
	<a href="/member/findAll">회원목록</a>
	</c:if>
</body>
</html>