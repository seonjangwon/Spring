<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>mypage</h2>
	<table>
	<tr>
	<th>아이디</th>
	<th>비밀번호</th>
	<th>이름</th>
	<th>이메일</th>
	<th>전화번호</th>
	<th>사진</th>
	</tr>
	<tr>
	<td>${loginDTO.m_id}</td>
	<td>${loginDTO.m_password}</td>
	<td>${loginDTO.m_name}</td>
	<td>${loginDTO.m_email}</td>
	<td>${loginDTO.m_phone}</td>
	<td><img alt="lwfja;lfl" src="/resources/upload/${loginDTO.m_filename}"></td>
	</tr>
	</table>
	<a href="/member/update">수정</a>
	<a href="/member/myboard?m_id=${loginDTO.m_id}">내 게시글 목록</a>
	<a href="/">홈</a>
	
</body>
</html>