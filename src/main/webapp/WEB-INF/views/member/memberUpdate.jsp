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

	<h1 class="mt-4 mb-4">join page</h1>
	
	
	<form action="./memberUpdate" method="post">
	
	
	<div class="mb-4">
	 <label for="pw" class="form-label">pw</label>
 	 <input type="password" value="${member.pw}" name="pw" class="form-control" id="pw" placeholder="pw를 입력하세요">
	</div>
	
	<div class="mb-4">
	 <label for="name" class="form-label">name</label>
 	 <input type="text" value="${member.name}" name="name" class="form-control" id="name" placeholder="name을 입력하세요">
	</div>
	
	<div class="mb-4">
	 <label for="email" class="form-label">email</label>
 	 <input type="email" value="${member.email}" name="email" class="form-control" id="email" placeholder="email을 입력하세요">
	</div>
	
	<div class="mb-4">
	 <label for="birth" class="form-label">birth</label>
 	 <input type="date" value="${member.birth}" name="birth" class="form-control" id="birth" placeholder="email을 입력하세요">
	</div>
	
	<div class="mb-3">
		<button class="btn btn-primary">회원수정</button>
	</div>
	
	</form>
		
</body>
</html>