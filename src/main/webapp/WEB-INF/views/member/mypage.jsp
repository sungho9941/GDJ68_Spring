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
	<h1>my page</h1>
	
	<div>
		<p>
			<img alt="" src="../resources/upload/member/${member.memberFileDTO.fileName}">
		</p>
		<p>
			${member.id} : ${sessionScope.member.name}
		</p>
		<p>
			${member.email}
		</p>
		<p>
			${member.birth}
		</p>
	</div>
	
	<a class="btn btn-primary" href="./memberUpdate">회원수정</a>
	<div id="productList">

	</div>

	

	<script>
		
		const productList = document.getElementById("productList");
		
		getList(1);

		// productList.addEventListener("click", function(event){
		// 	if(event.target.classList.contains("move")){
		// 		let page = event.target.getAttribute("data-num");
		// 		getList(page);
		// 	}
		// })

		// function getList(page){
		// 	fetch("../bookAccount/list?page="+page, {
		// 		method:"get"
		// 	})
		// 	.then((response)=>{return response.text()})
		// 	.then((r) =>{
		// 		console.log("ajax 실행")
		// 		productList.innerHTML=r;
				
		// 	})
		// 	;
		// }
		

		$("#productList").on("click", ".move", function(){
			let page = $(this).attr("data-num")
			getList(page);
		})

		getList(1);
		function getList(page){
			$.ajax({
				type:'get',
				url:"../bookAccount/list",
				data:{
					page:page
				},
				success:function(result){
					$("#productList").html(result.trim());
				},
				error:function(){
					console.log("error")
				}
			})
		}



	</script>

</body>
</html>