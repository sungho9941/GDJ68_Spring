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
		<input type="hidden" name="num" value="${dto.num}">
		작성자<input class="form-control" type="text" name="writer" value="${dto.writer}"><br>
		제목<input class="form-control" type="text" name="name" value="${dto.name}"><br>
		내용<input class="form-control" type="text" name="contents" value="${dto.contents}"><br>
		
		
		<p>
		<!-- <select name="">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>
		</select> -->
		</p>		
		
		<button type="submit">등록</button>
	</form>
		
</body>
</html>
</body>
</html>