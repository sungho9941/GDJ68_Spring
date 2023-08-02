<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="../resources/css/index.css">-->

<c:import url="../temp/bootStrap.jsp"></c:import>

</head>
<body>

	<c:import url="../temp/header.jsp"></c:import>
	

	<section class="container mt-5">
	<h1 class="mb-5" align="center">${board }z list</h1>

	<table class="table table-dark table-hover">
		<thead>
			<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="d">
				<tr>
				<td>${d.num}</a></td>
				
				<td><a href="./detail?num=${d.num}">
				<c:catch>
						<c:forEach begin="1" end="${d.depth}">></c:forEach>
				</c:catch>
				${d.name}</a></td>
				
				<td>${d.writer}</td>
				<td>${d.date}</td>
				<td>${d.hit}</td>
				
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	
	
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	  <c:if test="${pager.pre }">
	    <li class="page-item">
	      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    </c:if>
	    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	    
	    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
	    
	    </c:forEach>
	    
	    <c:if test="${pager.next }">
	    <li class="page-item">
	      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	    </c:if>
	  </ul>
	</nav>

<div class="input-group mb-3">
  	<form action="./list" method="get">
  		<select name="kind" class="form-select" aria-label="Default select example">
	 	<option value="name">제목</option>
	  	<option value="contents">내용</option>
	  	<option value="writer">작성자</option>
	    </select>
	  
  <input type="text" name="search" class="form-control" aria-label="Amount (to the nearest dollar)">


		<div class="col-auto">
	    <button type="submit" class="btn btn-primary mb-3">Confirm identity</button>
	  	</div>
	  	</form>
	  </div>

	<a class="btn btn-danger" href="./add">글 작성</a>
	</section>
	
	<%-- 
	<c:forEach begin="1" end="10" step="2" var="num">
		<h1>${num}</h1>
	</c:forEach>
	 --%>
	 
	
</body>
</html>