<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL(JSP Standard Tag Library)사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<form action="/board/search" method="get">
		<select name="searchtype">
			<option value="b_title">제목</option>
			<option value="b_writer">작성자</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어">
		<input type="submit" value="검색">
	</form>

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
				<th>사진</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bList}" var="b">
				<tr>
					<td>${b.b_number}</td>
					<td><a
						href="/board/detail?b_number=${b.b_number}&page=${paging.page}">${b.b_writer}</a></td>
					<td><a
						href="/board/detail?b_number=${b.b_number}&page=${paging.page}">${b.b_title}</a></td>
					<td>${b.b_contents}</td>
					<td>${b.b_hits}</td>
					<td>${b.b_date}</td>
					<td><fmt:formatDate value='${b.b_date}' pattern="HH:mm:ss" /></td>
					<td><a
						href="/board/detail?b_number=${b.b_number}&page=${paging.page}">조회</a></td>
					<td><a href="/board/delete?b_number=${b.b_number}">삭제</a></td>
					<td><a
						href="/board/update?b_number=${b.b_number}&page=${paging.page}">수정</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<c:choose>
			<c:when test="${paging.page<=1}">
				[이전]&nbsp;
			</c:when>
			<c:otherwise>
				<!-- 현재 페이지에서 1감소한 페이지 요청하는 링크 -->
				<a href="/board/paging?page=${paging.page-1}">[이전]</a>&nbsp;
			</c:otherwise>
		</c:choose>

		<!-- for(int i = startPage; i<=endPage; i++)같은 느낌이다 -->
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
			step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
					${i}
				</c:when>
				<c:otherwise>
					<a href="/board/paging?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${paging.page>=paging.maxPage}">
				[다음]
			</c:when>
			<c:otherwise>
				<a href="/board/paging?page=${paging.page+1}">[다음]</a>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>