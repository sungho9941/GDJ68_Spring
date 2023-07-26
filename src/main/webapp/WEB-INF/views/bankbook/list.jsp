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
	<h1 class="mb-5" align="center">Bankbook list</h1>

	<table class="table table-dark table-hover">
		<thead>
			<th>상품명</th><th>이자율</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="d">
				<tr>
				<td><a href="./detail?bookNum=${d.bookNum}">${d.bookName}</a></td>
				<td>${d.bookRate}</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	
	<%-- 
	<c:forEach begin="1" end="${pager.totalPage}" var="i">
		<a href="./list?page=${i}">${i}</a>
	</c:forEach>
	 --%>
	
	<nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:if test="${pager.pre }">
    <li class="page-item">
      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="i">
    
    <li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
    
    </c:forEach>
    <c:if test="${pager.next }">
    <li class="page-item">
      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>


	<a class="btn btn-danger" href="./add">상품등록</a>
	</section>
	
	<%-- 
	<c:forEach begin="1" end="10" step="2" var="num">
		<h1>${num}</h1>
	</c:forEach>
	 --%>
	 
	
</body>
</html>