<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL(JSP Standard Tag Library)사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function detailAjax(m_number){
		console.log(m_number);
		const view = document.getElementById('detail-view');
		$.ajax({
			type: 'post',
			url: 'detailAjax',
			data: {'m_number':m_number},
			dataType: 'json',
			success: function(result){ // 요청이 성공적으로 처리 됐을 때 실행할 함수
				console.log('ajax성공');
				console.log(result);
				console.log(result.m_number);
				console.log(result.m_id);
				
				let output = "<table class='table'>";
				output += "<tr><th>number</th> <th>id</th> <th>password</th> <th>name</th>";
				output += "<th>email</th> <th>phone</th> </tr>";
				output += "<tr>";
				output += "<td>"+result.m_number+"</td>";
				output += "<td>"+result.m_id+"</td>";
				output += "<td>"+result.m_password+"</td>";
				output += "<td>"+result.m_name+"</td>";
				output += "<td>"+result.m_email+"</td>";
				output += "<td>"+result.m_phone+"</td>";
				output += "</tr>";
				output += "</table>";
				
				view.innerHTML = output;
				
			},
			error: function(){ // 요청이 실패했을 때 실행할 함수
				console.log('오타를 찾으세요');
			}
		});
	}
</script>


</head>
<body>
	<h2>findAll</h2>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>조회</th>
				<th>조회ajax</th>
				<th>삭제</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${mList}" var="m">
				<tr>
					<td>${m.m_number}</td>
					<td>${m.m_id}</td>
					<td>${m.m_password}</td>
					<td>${m.m_name}</td>
					<td>${m.m_email}</td>
					<td>${m.m_phone}</td>
					<td><a href="detail?m_number=${m.m_number}">조회</a></td>
					<td><button onclick="detailAjax('${m.m_number}')">조회ajax</button></td>
					<td><a href="delete?m_number=${m.m_number}">삭제</a></td>
					<td><a href="update?m_number=${m.m_number}">수정</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<!-- ajax결과를 보여줌 -->
	<div id="detail-view">
	
	</div>




</body>
</html>