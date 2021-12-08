<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL(JSP Standard Tag Library)사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>index</h2>
	<h3>회원</h3>
	<a href="/member/signup">회원가입</a>
	<a href="/member/signin">로그인</a>
	<!-- 로그인 했으면 안보이게 -->
	<a href="/member/signout">로그아웃</a>
	<!-- 로그아웃 하면 안보이게 -->

	<c:if test="${loginDTO.m_id eq 'admin'}">
		<h3>관리자 메뉴</h3>
		<a href="/member/admin">관리자 페이지</a>

	</c:if>

	<c:choose>
		<c:when test="${loginDTO.m_id eq 'admin'}">
			<h3>로그인 정보</h3>
			아이디 : ${loginDTO.m_id} 이름 : ${loginDTO.m_name}
			<h3>관리자 메뉴</h3>
			<a href="/member/admin">관리자 페이지</a>
		</c:when>
		<c:when test="${loginDTO.m_id != null}">
			<h3>로그인 정보</h3>
			아이디 : ${loginDTO.m_id} 이름 : ${loginDTO.m_name}사진 :
			<img alt="dd" src="/resources/upload/${loginDTO.m_filename}">
			<h3>회원 메뉴</h3>
			<a href="/member/mypage">마이페이지</a>
		</c:when>
	</c:choose>


	<h3>게시판</h3>
	<a href="/board/write">게시글 작성</a>
	<br>
	<a href="/board/findAll">게시글 목록</a>
</body>
</html>