<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="joinparam" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pw"><br>
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="text" name="email"><br>
		성별 <br>
		<input type="radio" name="gender" value="m" id="m"> <label for="m">남자</label>
		<input type="radio" name="gender" value="w" id="w"> <label for="w">여자</label>
		<input type="radio" name="gender" value="x" id="x" checked> <label for="x">알수 없음</label>
		<input type="submit" value="가입하기">
	</form>
</body>
</html>