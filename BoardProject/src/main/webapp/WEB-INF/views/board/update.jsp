<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function update_check(){
		const pw =document.getElementById('b_pw').value;
		const pwch = '${b.b_password}';
		
		if (pw==pwch){
			update_form.submit();
		} else {
			alert('비밀번호가 틀렸습니다!');
		}
	}
</script>
</head>
<body>
	<h2>update</h2>
	번호 : ${b.b_number} <br>
	작성작 : ${b.b_writer}<br>
	비밀번호 : ${b.b_password}<br>
	제목 : ${b.b_title}<br>
	내용 : ${b.b_contents}<br>
	조회수 : ${b.b_hits}<br>
	작성날짜 : ${b.b_date}<br>
	
	<form action="/board/update" method="post" name="update_form">
	<input type="hidden" name="b_number" value="${b.b_number}">
	작성자 : <input type="text" name="b_writer" value="${b.b_writer}" readonly><br>
	비밀번호 : <input type="password" name="b_password" id="b_pw"><br>
	제목 : <input type="text" name="b_title" value="${b.b_title}"><br>
	내용 : <input type="text" name="b_contents" value="${b.b_contents}"><br>
	<button type="button" onclick="update_check()">수정</button>
	</form>
</body>
</html>