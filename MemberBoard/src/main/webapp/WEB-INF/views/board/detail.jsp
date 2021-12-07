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
	<h2>detail</h2>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>조회수</th>
			<th>작성일자</th>
			<th>사진</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<tr>
			<td>${b.b_number}</td>
			<td>${b.b_title}</td>
			<td>${b.m_id}</td>
			<td>${b.b_contents}</td>
			<td>${b.b_hits}</td>
			<td>${b.b_date}</td>
			<td><img alt="tkwls" src="/resources/upload/${b.b_filename}"></td>
			<c:choose>
				<c:when test="${loginDTO.m_id eq 'admin'}">
					<td><a href="/board/delete?b_number=${b.b_number}">삭제</a></td>
					<td>수정 못함</td>
				</c:when>
				<c:when test="${loginDTO.m_id == b.m_id}">
					<td><a href="/board/delete?b_number=${b.b_number}">삭제</a></td>
					<td><a href="/board/update?b_number=${b.b_number}">수정</a></td>
				</c:when>
				<c:otherwise>
					<td>삭제 못함</td>
					<td>수정 못함</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</body>
</html>