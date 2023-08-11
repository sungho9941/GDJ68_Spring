<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>

	<!-- include summernote css/js-->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>

	<c:import url="../temp/header.jsp"></c:import>


	<h1 class="mb-5">${board }add page</h1>
	
	
	<form class="col-md-7" action="./add" method="post" id="frm" enctype="multipart/form-data">
		제목<input class="form-control" type="text" name="name" id="name"><br>
		내용<textarea class="form-control" rows="" cols="" name="contents" id="contents"></textarea>
		작성자<input class="form-control" type="text" value="${member.id}" name="writer" id="writer"><br>
		
		
	
		
		
		<p>
		<!-- <select name="">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>
		</select> -->
		</p>		
		
		<div id="fileList" class="my-5">
			<div class="mb-3">
				<button type="button" id="add">file추가</button>
			</div>

		</div>
		
		<button type="button" id="btn">등록</button>
	</form>
	
	<script src="../resources/js/file.js"></script>

	<script>
		const btn = document.getElementById("btn");
		const name = document.getElementById("name");
		const frm = document.getElementById("frm");

		 $('#contents').summernote({
			 height: 400,
			 callbacks:{
				 onImageUpload:function(files){
					alert("이미지업로드")

					let formData = new FormData(); // <form></form>
					formData.append("files", files[0]); // <input type="file" name="files">

					$.ajax({
						type:'post',
						url:'setContentsImg',
						data:formData,
						enctype:'multypart/form-data',
						cache:false,
						contentType:false,
						processData:false,
						success:function(result){
							$("#contents").summernote('insertImage', result.trim());
						},
						error:function(){
							console.log("error")
						}
					});
				 },
				 onMediaDelete:function(files){
					
					let path = $(files[0]).attr("src"); // /resources/upload/notice/파일명

					$.ajax({
						type:'post',
						url:'./setContentsImgDelete',
						data:{
							path:path
						},
						success:function(result){
							console.log(result);
						},
						error:function(){
							console.log("err");
						}
					})
				 }
			 }
		 });
		
		btn.addEventListener("click", function(){
			console.log(name.value=="");
			console.log(name.length==0);
			if(name.value==""){
				alert("제목은 필수입니다");
				name.focus();
			}else{
				frm.submit();
			}
		})
	</script>
	
</body>
</html>