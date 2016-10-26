<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<title>DocFairy-통합 문서 관리 시스템</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!--[if lt IE 9]>
		<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/favicon.ico" />
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,300,700&amp;subset=latin,latin-ext'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/animate.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/swiper.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<style>
	div#buttons {
		width:500px;
	}
	.arang {
		float:left;

	}
	.arang input {
		display : inline-block;
		height:50px;
	}
	 	.row .row{
		/* background-image: url('${pageContext.request.contextPath}/images/images.png');
		background-repeat:no-repeat; */
	}
		 
</style>
<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/javascript/jquery-3.1.0.min.js"></script>

<script>
	function formcheck(){
		if($("#upfile").val()==""){
			alert('파일을 선택하지 않았습니다!');
			return false;
		}
	}
	$(function(){
		var msg=$("#msg").val();
		if(msg!=""){
			alert(msg);	
		}
		$("#entire").on('click','.checked',function(){
			var filename=$(this).parent().next().text();
			$("#checktable").append('<tr class="add"><td>'+filename+'</td><tr>');
			
		});
		$(".del").on('click',function(){
			$(this).parent().parent().remove();
			var save_filename=$(this).parent().parent().children().first().next().children().text();
			$.ajax({
				url:'delfile',
				data:{'uploadFileName':save_filename}
			});
		});
		$("#inter").on('click',function(){
			var alist="";
			if($("#checktable .add").eq(0).children().first().text()==""){
				alert('먼저 파일을 선택하세요!')
				return false;
			}
			$("#checktable .add").each(function(index,item){
				alist+=$("#checktable .add").eq(index).children().first().text()+",";
			});
			$.ajax({
				url:'makefile',
				data:{'uploadFileName':alist},
				success:function(response){
					$("#buttons").append('<a href="fileDownload?integrate='+response.integrate+'">다운로드</a>');
					$("#inter").off();
				}
			});
		});
		
	});
	</script>
<style type="text/css">
th{
	background-color: skyblue;
	border: 1px solid black;

}
#inter{
	float: right;
	margin-right: 34px;
}

</style>	
	
</head>

<body>

	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	<aside class="col-md-3 sidebar">
		<div class="block">
			<h3>
				<span>문서 메뉴</span>
			</h3>
			<nav>
				<ul class="nav">
					<li class="active"><a href="docintegrate">통합문서</a></li>
					<li><a href="docform">문서양식</a></li>
					<li><a href="doctransform">문서변환</a></li>
				</ul>
			</nav>
		</div>
	</aside>


	<h1 id="stitle">통합문서</h1>
<div class="row">
			<div class="col-md-12 col-lg-10 col-lg-offset-1 page-indent content">
	<div class="row">
		<div class="col-md-6">
			<h1>현재 파일 목록</h1>
			<p>
			<table border="1" id="entire" >
				<tr>
					<th class="filename" width="100">옮기기</th>
					<th class="filename" width="330">파일명</th>
					<th class="filename" width="70">삭제</th>
				</tr>
				<s:iterator value="list">
					<tr>
						<td class="filename"><input type="button" class="checked btn btn-success" 
							value="선택"></td>
						<td><a href="fileDownload?save_fileno=${save_fileno}"><s:property
									value="save_filename" /></a></td>
						<td class="filename"><input type="button" class="del btn btn-warning"
							value="삭제"></td>
					</tr>
				</s:iterator>
			</table>
			<p>
			<%-- <ul class="pagination">

				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li class="disabled"><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul> --%>
		</div>
		<div class="col-md-6">
			<h1>선택된 파일 목록</h1>
			<p>
			<table id="checktable" border="1">
				<tr>
					<th class="filename" width="500">선택된 파일명</th>
				</tr>
			</table>
			<p>
			
			</div>
		</div>		
		<p>
		
		<div id="buttons" class="col-md-12">
			<input type="hidden" name="msg" value="${msg}" id="msg" />
			<form action="insertfile" method="post" enctype="multipart/form-data"
				onsubmit="return formcheck()">
				<div class="arang">
					분류 :<select name="files.filetype" id="sel">
						<option value="tax">세금계산서</option>
						<option value="cost">거래명세표</option>
						<option value="mada">거래처별 미수현황표</option>
						<option value="card">법인카드 사용내역서</option>
					</select>
				</div> 
				<div class="arang">
					<input class="btn btn-default" type="file" id="upfile" name="upload">
				</div>
				<div class="arang"> 
					<input
						type="hidden" name="files.memberno"
						value="${session.members.memberno}" />
				</div>
				<div class="arang">
					<input type="submit" class="btn btn-default"
					value="올리기">
				</div>
			</form>
			<input id="inter" type="button" value="통합문서 만들기" class="btn btn-default">

	</div>
	</div>
	</div>

	<jsp:include page="../footer.jsp"></jsp:include>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
</body>

</html>