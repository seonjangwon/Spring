<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function idch(){
		const id = document.getElementById('m_id').value;
		
		$.ajax({
			type: 'post',
			url: '/member/idch',
			data: {"m_id":id},
			datatype: 'text',
			success: function(result){
				console.log('ajax성공');
				console.log(result);
				if(result=="ok"){
					signup_form.submit();
				}else{
					alert('아이디 중복');
				}
				
			},
			error: function(){
				console.log('오타를 찾아보아요ㅠㅠ');
				
			}
			
		});
		
	}
</script>
</head>
<body>
	<h2>singup</h2>
	<form action="signup" method="post" name="signup_form" enctype="multipart/form-data">
	아이디 : <input type="text" name="m_id"><br>
	비밀번호 : <input type="password" name="m_password"><br>
	이름 : <input type="text" name="m_name"><br>
	이메일 : <input type="text" name="m_email"><br>
	전화번호 : <input type="text" name="m_phone"><br>
	프로필사진 : <input type="file" name="m_file"><br>
	<button onclick="idch()">가입하기!</button>
	</form>
	
</body>
</html>