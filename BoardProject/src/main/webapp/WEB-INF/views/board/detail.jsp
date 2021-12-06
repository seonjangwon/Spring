<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL(JSP Standard Tag Library)사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h2>detail</h2>
	번호 : ${b.b_number}
	<br> 작성작 : ${b.b_writer}
	<br> 비밀번호 : ${b.b_password}
	<br> 제목 : ${b.b_title}
	<br> 내용 : ${b.b_contents}
	<br> 조회수 : ${b.b_hits}
	<br> 작성날짜 : ${b.b_date}
	<br>
	<fmt:formatDate value='${b.b_date}' pattern="yyyy.MM.dd" />
	<fmt:formatDate value='${b.b_date}' pattern="HH:mm:ss" />
	파일 :
	<img alt="a" src="/resources/upload/${b.b_filename}">


	<a href="/board/paging?page=${page}">목록</a>

	<!-- 댓글 -->
	<div id="comment-write">
		<input type="text" id="c_writer" placeholder="작성자"><br> <input
			type="text" id="c_contents" placeholder="댓글내용"><br>
		<button id="comment-write-btn">댓글등록</button>
	</div>

	<div id="comment-list">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>내용</th>
					<th>시간</th>
				</tr>
			</thead>
			<c:forEach items="${commentList}" var="c">
			<tr>
				<td>${c.c_number}</td>
				<td>${c.c_writer}</td>
				<td>${c.c_contents}</td>
				<td>${c.c_date}</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>

<script>
	/* const commentBtn = document.getElementById('comment-write-btn');
	commentBtn.addEventListener("click",function(){
		console.log('댓글 버튼 클릭');
	});  */

	$("#comment-write-btn").click(function() {
		console.log('제이쿼리로 함수추가하기');

		const writer = document.getElementById('c_writer').value;
		const contents = document.getElementById('c_contents').value;
		const boardNo = '${b.b_number}';

		const view = document.getElementById('comment-list');

		/* const writer2= ${"#c_writer"}.val();
		const contents2= ${"#c_contents"}.val(); */

		/* ajax문법을 이용하여 댓글 작어자, 작성내용을 comment/save 주소로 post방식으로 전홍하는 코드를 작성해봅시다 */
		$.ajax({
			type : 'post',
			url : '/comment/save',
			data : {
				"c_writer" : writer,
				"c_contents" : contents,
				"b_number" : boardNo
			},
			dataType : 'json',
			success : function(result) {
				console.log('ajax 성공');
				console.log(result);

				let output = "<table>";
				output += "<thead>";
				output += "<tr>";
				output += "<th>번호</th>";
				output += "<th>작성자</th>";
				output += "<th>내용</th>";
				output += "<th>시간</th>";
				output += "</tr>";
				output += "</thead>";
				output += "<tbody>";

				$.each(result, function(i) {
					output += "<tr>";
					output += "<td>" + result[i].c_number + "</td>";
					output += "<td>" + result[i].c_writer + "</td>";
					output += "<td>" + result[i].c_contents + "</td>";
					output += "<td>" + result[i].c_date + "</td>";
					output += "</tr>";
				});
				/* 쌤이 하신거 */
				/* for(let i in result){
				       output += "<tr>";
				       output += "<td>"+result[i].c_number+"</td>";
				       output += "<td>"+result[i].c_writer+"</td>";
				       output += "<td>"+result[i].c_contents+"</td>";
				       output += "<td>"+result[i].c_date+"</td>";
				       output += "</tr>";
				    } */
				output += "</tbody>";

				view.innerHTML = output;

				// 댓글 입력창을 비움. 
				document.getElementById('c_writer').value = '';
				document.getElementById('c_contents').value = '';

			},
			error : function() {
				console.log('오타를 찾아보아요ㅠㅠ');
			}

		});

	});
</script>
</html>