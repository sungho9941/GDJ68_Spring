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
	
	
	<h1>${requestScope.dto.bookName}</h1>
	<h1>${dto.bookContents}</h1>
	<h1>${dto.bookRate}</h1>
	
	<c:forEach items="${dto.fileDTOs}" var="f">
		<img alt="" src="/resources/upload/bankbook/${f.fileName}">
	</c:forEach>
	
	
	<c:choose>
		<c:when test="${dto.bookSale eq 1}">
			<h1>판매중</h1>
		</c:when>
		<c:otherwise>
			<h1>판매종료</h1>
			
			<h1>?</h1>
		</c:otherwise>
	</c:choose>
	

	
	
	<a href="./update?bookNum=${dto.bookNum}">수정</a>
	<a href="./delete?bookNum=${dto.bookNum}">삭제</a>
	<button id="update">수정</button>
	<button id="del" data-delete-name="bookNum" data-delete-num="${dto.bookNum}">삭제</button>
	<%-- 
	<c:if test="${dto.bookSale eq 1}">
		<h1>판매중</h1>
	</c:if>
	<c:if test="${dto.bookSale eq 0 }">
		<h1>판매종료</h1>
	</c:if>
	 --%>

	<script src="../resources/js/delete.js"></script>
	<!-- <script>
		setBookNum(${dto.bookNum});
	</script> -->
</body>
</html>