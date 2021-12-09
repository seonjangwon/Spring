<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL(JSP Standard Tag Library)사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h2>detail</h2>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>조회수</th>
			<th>작성일자</th>
			<th>사진</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<tr>
			<td>${b.b_number}</td>
			<td>${b.b_title}</td>
			<td>${b.m_id}</td>
			<td>${b.b_contents}</td>
			<td>${b.b_hits}</td>
			<td>${b.b_date}</td>
			<td><img alt="tkwls" src="/resources/upload/${b.b_filename}"></td>
			<c:choose>
				<c:when test="${loginDTO.m_id eq 'admin'}">
					<td><a href="/board/delete?b_number=${b.b_number}">삭제</a></td>
					<td>수정 못함</td>
				</c:when>
				<c:when test="${loginDTO.m_id == b.m_id}">
					<td><a href="/board/delete?b_number=${b.b_number}">삭제</a></td>
					<td><a href="/board/update?b_number=${b.b_number}">수정</a></td>
				</c:when>
				<c:otherwise>
					<td>삭제 못함</td>
					<td>수정 못함</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>

	<div>
		<input type="text" id="m_id" name="m_id" value="${loginDTO.m_id}"
			readonly><br> <input type="text" id="c_contents"
			name="c_contents"> <input type="hidden" id="b_number"
			name="b_number" value="${b.b_number}">
		<button onclick="comment_write()">댓글작성</button>
	</div>

	<div id="contents-view">
		<table>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성시간</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${cList}" var="c" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${c.m_id}</td>
					<c:set var="contents" value="${c.c_contents}" />
					<c:choose>
						<c:when test="${fn:contains(contents, 'ㅅㅂ')}">
							<td>장원클린 시스템에의해 댓글이 보이지 않아요</td>
						</c:when>
						<c:otherwise>
							<td>${c.c_contents}</td>
						</c:otherwise>
					</c:choose>
					<td>${c.c_date }</td>
					<td><input type="hidden" id="c_number" value="${c.c_number}">
						<input type="hidden" id="b_number" value="${c.b_number}">
						<c:choose>
							<c:when test="${loginDTO.m_id eq 'admin'}">
								<a href="/comment/delete?b_number=${c.b_number}&c_number=${c.c_number}">삭제</a>
							</c:when>
							<c:when test="${loginDTO.m_id == c.m_id}">
								<a href="/comment/delete?b_number=${c.b_number}&c_number=${c.c_number}">삭제</a>
							</c:when>
							<c:otherwise>
								<td>삭제 못함</td>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script>
/* 여기다 만들고 위로 올리던지 여기가 보기 편해 */

 	function comment_write(){
		const id = document.getElementById('m_id').value;
		const b_number = document.getElementById('b_number').value;
		let c_contents = document.getElementById('c_contents').value;
		
		const view = document.getElementById('contents-view');
		
		$.ajax({
			type:'post',
			url: '/comment/write',
			data: {"m_id":id, "b_number": b_number, "c_contents":c_contents},
			datatype: 'json',
			success: function(result){
				console.log('ajax ');
				console.log(result);
				
				let output = "<table>";
				output += "<tr>";
				output += "<th>번호</th>";
				output += "<th>작성자</th>";
				output += "<th>내용</th>";
				output += "<th>작성시간</th>";
				output += "<th>삭제</th>";
				output += "</tr>";
				$.each(result, function(i){
					let contents = result[i].c_contents;
					
				output += "<tr>";
					output += "<td>"+(i+1)+"</td>";
					output += "<td>"+result[i].m_id+"</td>";
					if(contents.indexOf("ㅅㅂ")==-1){
						output += "<td>"+result[i].c_contents+"</td>";
					}else{
						output += "<td>장원클린 시스템에의해 댓글이 보이지 않아요</td>";
					}
					//output += "<td>"+result[i].c_contents+"</td>";
					output += "<td>"+result[i].c_date+"</td>";
					if(${loginDTO.m_id eq 'admin'}){
						output += "<td>";
						output += "<a href=\"/comment/delete?b_number=${c.b_number}&c_number=${c.c_number}\">삭제</a></td>";
					} else if(${loginDTO.m_id}== result[i].m_id){
						output += "<td>";
						output += "<a href=\"/comment/delete?b_number=${c.b_number}&c_number=${c.c_number}\">삭제</a></td>";
					} else {
						output += "<td>삭제 못함</td>";
					}
					
				output += "</tr>";
				});
				output += "<table>";
				
				view.innerHTML = output;
				c_contents= "";
			},
			error: function(){
				alert('실패');
			}
		});
}

</script>

</html>