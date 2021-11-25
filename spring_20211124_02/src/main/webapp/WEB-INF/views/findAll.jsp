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
				<th>이름</th>
				<th>나이</th>
				<th>전번</th>
				<th>성별</th>
				<th>생일</th>
				<th>주소</th>
				<th>상세조회</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tList}" var="t">
			<tr>
				<td>${t.t_number}</td>
				<td>${t.t_name}</td>
				<td>${t.t_age}</td>
				<td>${t.t_phone}</td>
				<td>${t.t_gender}</td>
				<td>${t.t_birth}</td>
				<td>${t.t_address}</td>
				<!-- detail이라는 주소로 t_number 파라미터를 전달함
					링크로 서버에 데이터 전송
					서버에서 t_number를 받아서 출력해보세요 -->
				<td><a href="detail?t_number=${t.t_number}">조회</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>