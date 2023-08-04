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
	작성자 <textarea class="form-control mb-5">${dto.writer}</textarea><h1></h1>	
	제목 <h1>${dto.name}</h1>
	내용 <h1>${dto.contents}</h1>
	작성일 <h1>${dto.date}</h1>
	



	<form id="frm" action="">
		<input type="hidden" name="num" value="${dto.num}">
	</form>

		<c:if test="${board ne 'notice'}">
		 <!-- <a href="./reply?num=${dto.num}">답글</a> -->
		<button id="reply" class="c1" data-url="reply">답글</button>
		</c:if>
	
	<!-- <a href="./update?num=${dto.num}">수정</a>
	<a href="./delete?num=${dto.num}">삭제</a> -->
	
	<button id="update" data-url="update" class="c1">수정</button>
	
	<button id="del" data-url="delete" class="btn btn-outline-primary c1" for="btn-check-outlined" data-delete-name="num" data-delete-num="${dto.num}">삭제</button>
	 <script src="../resources/js/delete.js"></script>
	
	
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