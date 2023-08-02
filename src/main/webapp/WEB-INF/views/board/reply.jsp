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


	<h1 class="mb-5">${board} Reply page</h1>
	
	
	<form action="./reply" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${num }">
		제목<input class="form-control" type="text" name="name"><br>
		내용<textarea class="form-control" rows="" cols="" name="contents"></textarea>
		작성자<input class="form-control" type="text" value="${member.id}" name="writer"><br>
		
		
	
		
		
		<p>
		<!-- <select name="">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>
		</select> -->
		</p>		
		
		<button type="submit">등록</button>
<!-- 		<input type="submit" value="ADD">
		<input type="reset" value="ADD">
		<input type="button" value="ADD"> -->
	</form>
	
	
</body>
</html>