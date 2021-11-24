<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<h2>insert</h2>
	
	<form action="insertparam" method="post"><br>
		이름 : <input type="text" name="t_name"><br>
		나이 : <input type="text" name="t_age"><br>
		전화번호 : <input type="text" name="t_phone"><br>
		성별 : <input type="radio" name="t_gender" id="m" value="m"><label for="m">남자</label>
		<input type="radio" name="t_gender" id="w" value="w"><label for="w">여자</label><br>
		생년월일 : <input type="date" name="t_birth"><br>
		주소 : <input type="text" name="t_address"><br>
		<input type="submit" value="등록">
	</form>
	
</body>
</html>