<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logout(){
		location.href="logout";
	}
	
	
</script>

</head>
<body>
	<h2>main</h2>
	세션에 저장한 데이터 출력 : ${sessionScope.loginById}
	<!-- 로그아웃 버튼을 클릭하면 logout이라는 주소요청 -->
	<button onclick="logout()">로그아웃</button>
	<!-- 아이디가 admin인 관리자가 로그인 했을 때만 목록 링크가 보이도록 -->
	<c:if test="${sessionScope.loginById eq 'admin'}">	
	<a href="findAll">회원목록(관리자만 보이게)</a>
	</c:if>
	<a href="findAll">회원목록</a>
	
</body>
</html>