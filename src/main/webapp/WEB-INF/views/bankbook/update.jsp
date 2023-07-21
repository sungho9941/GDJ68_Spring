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
	
	
	
	<h1>update page</h1>
	
	<form action="./update" method="post">
		<input type="hidden" name="bookNum" value="${dto.bookNum}">
		상품명<input class="form-control" type="text"  name="bookName" value="${dto.bookName}"><br>
		상세설명<textarea class="form-control" rows="" cols="" name="bookContents">${dto.bookContents}</textarea>
		이자율<input class="form-control" type="text" name="bookRate" value="${dto.bookRate}"><br>
		
		
		<p>
			판매가능 <input type="radio" value="1" checked name="bookSale"><br>
			판매중지 <input type="radio" value="0" name="bookSale"><br>
		</p>
		
		
		<p>
		<!-- <select name="">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>
		</select> -->
		</p>		
		
		<button type="submit">등록</button>
		<input type="submit" value="수정">
		<input type="reset" value="수정">
		<input type="button" value="수정">
	</form>
		
</body>
</html>
</body>
</html>