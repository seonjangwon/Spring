<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	/* 아이디 입력을 라는 동안에 idDuplicate() 함수가 호출하고 입력된값을 콘솔에 출력 */
	function idDuplicate(){
		const id = document.getElementById('m_id').value;
		console.log(id);
		
		const checkResult =document.getElementById('id_dup_check')
		$.ajax({
			type: 'post', // 전송방식(get, post, delete, put등)
			url: 'idDuplicate', // 요청주소(컨트롤러로 요청하는 주속)
			data: {'m_id': id}, // 전송할 데이터 자바스크립트의객체표현방식
			dataType:'text', //요청후 리턴받을 때의 데이터 형식
			success: function(result){ // 요청이 성공적으로 처리 됐을 때 실행할 함수
				console.log('ajax성공');
				console.log(result);
				if (result=="ok"){
					checkResult.style.color = 'green';
					checkResult.innerHTML = '멋진 아이디에요!'
				} else{
					checkResult.style.color = 'red';
					checkResult.innerHTML = '사용중이에요!'
				}
					
			},
			error: function(){ // 요청이 실패했을 때 실행할 함수
				console.log('오타를 찾으세요');
			}
		});
	}
</script>
</head>
<body>
	<h2>insert</h2>
	
	<form action="signup" method="post">
		아이디 : <input type="text" name="m_id" id="m_id" onkeyup="idDuplicate()">
		<span id="id_dup_check"> </span><br>
		비밀번호 : <input type="password" name="m_password"><br>
		이름 : <input type="text" name="m_name"><br>
		이메일 : <input type="text" name="m_email"><br>
		전화번호 : <input type="text" name="m_phone"><br>
		<input type="submit" value="가입하기">
	</form>
</body>
</html>