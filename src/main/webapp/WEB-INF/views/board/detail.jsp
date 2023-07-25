<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../temp/bootStrap.jsp"></c:import>

	
	
	
</head>
<body>

<c:import url="../temp/header.jsp"></c:import>


	<h1>detail page</h1>
	
	<!-- Getter 이름 : 메서드에서 get을 제외하고 첫 번째 글자를 소문자로 바꾼 것 -->
	작성자 <textarea class="form-control mb-5">${dto.boardWriter}</textarea><h1></h1>	
	제목 <h1>${dto.boardName}</h1>
	내용 <h1>${dto.boardContents}</h1>
	작성일 <h1>${dto.boardDate}</h1>
	




	
	<a href="./update?boardNum=${dto.boardNum}">수정</a>
	<a href="./delete?boardNum=${dto.boardNum}">삭제</a>
	 
	
	
	<%-- 
	<c:if test="${dto.bookSale eq 1}">
		<h1>판매중</h1>
	</c:if>
	<c:if test="${dto.bookSale eq 0 }">
		<h1>판매종료</h1>
	</c:if>
	 --%>
</body>
</html>