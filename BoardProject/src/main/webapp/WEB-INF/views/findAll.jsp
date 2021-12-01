<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL(JSP Standard Tag Library)사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>

</script>
</head>
<body>
	<h2>findAll</h2>
	
	
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>조회수</th>
				<th>작성시간</th>
				<th>작성시간</th>
				<th>조회</th>
				<th>삭제</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bList}" var="b">
				<tr>
					<td>${b.b_number}</td>
					<td>${b.b_writer}</td>
					<td>${b.b_title}</td>
					<td>${b.b_contents}</td>
					<td>${b.b_hits}</td>
					<td>${b.b_date}</td>
					<td><fmt:formatDate value='${b.b_date}' pattern="HH:mm:ss"/></td>
					<td><a href="detail?b_number=${b.b_number}">조회</a></td>
					<td><a href="delete?b_number=${b.b_number}">삭제</a></td>
					<td><a href="update?b_number=${b.b_number}">수정</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="text" id="search" onkeyup="Search()" placeholder="검색">
	
</body>
</html>