<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function pwch(){
		const id = document.getElementById('m_id').value;
		const pw = document.getElementById('m_pw').value;
		
		$.ajax({
			type: 'post',
			url: '/member/pwch',
			data: {"m_pw":pw, "m_id":id},
			datatype: 'text',
			success: function(result){
				console.log('ajax성공');
				console.log(result);
				if(result=="ok"){
					update-form.submit();
				}else{
					alert('비밀번호가 틀렸습니다')
				}					
			},
			error: function(){
				console.log('오타오타');
			}
			
		});
		
	}
</script>

</head>
<body>
	<h2>update</h2>
	<form action="update" method="post" name="update-form" enctype="multipart/form-data">
	아이디 : <input type="text" name="m_id" id="m_id" value="${loginDTO.m_id}" readonly><br>
	비밀번호 : <input type="password" name="m_password" id="m_pw"><br>
	이름 : <input type="text" name="m_name" value="${loginDTO.m_name}"><br>
	이메일 : <input type="text" name="m_email" value="${loginDTO.m_email}"><br>
	전화번호 : <input type="text" name="m_phone" value="${loginDTO.m_phone}"><br>
	현 프로필사진<img alt="afdea" src="/resources/upload/${loginDTO.m_filename}">
	프로필사진 : <input type="file" name="m_file"><br>
	<button onclick="pwch()">수정하기</button>
	</form>
	
</body>
</html>