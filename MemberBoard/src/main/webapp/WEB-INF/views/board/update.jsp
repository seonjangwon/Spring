<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>update</h2>
	<form action="/board/update" method="post" enctype="multipart/form-data">
	제목 : <input type="text" name="b_title" value="${b.b_title}"><br>
	작성자 : <input type="text" name="m_id" value="${loginDTO.m_id}" readonly><br>
	내용 : <input type="text" name="b_contents" value="${b.b_title}"><br>
	현 사진 : <img alt="dd" src="/resources/upload/${b.b_filename}">
	사진 : <input type="file" name="b_file"><br>
	<input type="submit" value="작성하기">
	</form>
</body>
</html>