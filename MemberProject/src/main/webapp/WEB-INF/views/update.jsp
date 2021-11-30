<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	/* 비밀번호를 입력받고 DB에서 가져온 비밀번호와 비교해서 일치하면 update처리 일치하지 않으면 비밀번호가 일지하지 않습니다 alert출력 */
	function update(){
		const pw = document.getElementById('pw').value;
		const pwdb = '${mdto.m_password}';
		
		if (pw==(pwdb)){			
			/* form전송 */
			update_form.submit();
		} else {
			alert('비밀번호가 틀렸습니다');
		}		
	}
</script>
</head>
<body>
	<h2>update</h2>
	
	
	
	
	<form action="update" method="post" name="update_form">
		<input type="hidden" name="m_number" value="${mdto.m_number}">
		아이디 : <input type="text" name="m_id" value="${mdto.m_id}" readonly><br>
		비밀번호 : <input type="password" name="m_password" id="pw" placeholder="비밀번호를 다시 입력해주세요"><br>
		이름 : <input type="text" name="m_name" value="${mdto.m_name}"><br>
		이메일 : <input type="text" name="m_email" value="${mdto.m_email}"><br>
		전화번호 : <input type="text" name="m_phone" value="${mdto.m_phone}"><br>
		<input type="button" onclick="update()" value="가입하기">
	</form>
	
</body>
</html>