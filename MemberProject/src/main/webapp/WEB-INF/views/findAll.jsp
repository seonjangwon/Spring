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
	<h2>findAll</h2>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>조회</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${mList}" var="m">
				<tr>
					<td>${m.m_number}</td>
					<td>${m.m_id}</td>
					<td>${m.m_password}</td>
					<td>${m.m_name}</td>
					<td>${m.m_email}</td>
					<td>${m.m_phone}</td>
					<td><a href="detail?m_number=${m.m_number}">조회</a></td>
					<td><a href="delete?m_number=${m.m_number}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>







</body>
</html>