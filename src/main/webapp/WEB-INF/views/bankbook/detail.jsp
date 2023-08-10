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
	<a class="btn btn-primary" href="../bookAccount/add?bookNum=${dto.bookNum}">상품가입1</a>
	<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#accountModal">상품가입</button>
	

	<!-- 댓글 -->
	<div>
		<div class="mb-3">
			<textarea name="accountPassword" class="form-control" id="comment"></textarea>
			<button id="commentAdd">댓글등록</button>
		</div>
		
		<div id="commentList">
			<table>
				<thead>
					<tr>
						<th></th>
					</tr>
				</thead>
			</table>
		</div>

	</div>


	<!-- Modal -->
	<div class="modal fade" id="accountModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호 입력</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="mb-4">
					<input type="password" name="accountPassword" class="form-control" id="pw" placeholder="pw를 입력하세요">
				   </div>
			</div>
			<div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="close">Close</button>
			<button type="button" class="btn btn-primary" id="add" data-add-num="${dto.bookNum}">상품가입</button>
			</div>
		</div>
		</div>
	</div>

	
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
	
	<script type="text/javascript">
		 const add = document.getElementById("add");

		//  add.addEventListener("click", function(){
		//  	let bookNum=add.getAttribute("data-add-num");
		//  	let pw = document.getElementById("pw").value;
		// 	// ajax1(bookNum, pw);
		// 	ajax2(bookNum,pw); 
		//  });

		 $("#add").click(function(){
			let bookNum = $("#add").attr("data-add-num");
			let pw = $("#pw").val();
			ajax3(bookNum, pw)	
		})
		 
		//  function ajax2(bookNum, pw){
		// 	console.log("뭔");
		// 	fetch("../bookAccount/add", {
		// 		method:"post",
		// 		body:"bookNum=" + bookNum + "&accountPassword=" + pw,
				
		// 		headers:{
		// 			"content-type":"application/x-www-form-urlencoded"
		// 		}
		// 	})
		// 	.then((response)=>{
		// 		console.log("데");
		// 		return response.text();
		// 	})
		// 	.then((r)=>{
		// 		if(r>0){
		// 			alert("가입완료");
		// 		} else{
		// 			alert("실패");
		// 		}

		// 		location.href="../";
		// 	})
			
		// 	;
		//  }
		
		function ajax3(bookNum, pw){
			$.ajax({
				type:'post',
				url:"../bookAccount/add",
				data:{
					bookNum:bookNum,
					accountPassword:pw
				},
				success:function(response){
					if(response.trim()>0){
						alert("가입완료");
					} else{
						alert("실패");
					}
				},
				error:function(){
					alert("error")
				}
			})
		}





		 function ajax1(bookNum, pw){
			console.log(bookNum);
			console.log(pw);
			

			// 1. ajax 객체생성
			let xhttp = new XMLHttpRequest();

			// 2. 요청정보
			xhttp.open("post", "../bookAccount/add");

			//요청 header 정보
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			//요청 발생(post일 경우 파라미터 작성 key=값&key2=값2)
			xhttp.send("bookNum="+bookNum+"&accountPassword="+pw);

			//응답 처리
			xhttp.onreadystatechange=function(){
				if(this.readyState==4&&this.status==200){
					let r = this.responseText.trim();
					
					console.log(this.responseText);
					console.log(r);
					if(r>0){
						alert("가입성공");
					} else{
						alert("가입실패");
					}

					document.getElementById("close").click();

					location.href="../";
				}
			}
		 }
	</script>
</body>
</html>