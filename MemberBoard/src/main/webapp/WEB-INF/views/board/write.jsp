<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>write</h2>
	<form action="/board/write" method="post" enctype="multipart/form-data">
	제목 : <input type="text" name="b_title"><br>
	작성자 : <input type="text" name="m_id" value="${loginDTO.m_id}" readonly><br>
	내용 : <input type="text" name="b_contents"><br>
	사진 : <input type="file" name="b_file"><br>
	<input type="submit" value="작성하기">
	</form>
</body>
</html>