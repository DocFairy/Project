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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
<style>
div#buttons {
	
	margin-top:200px;
}

.arang {
	float: left;
}

.arang input {
	display: inline-block;
	height: 50px;
}

.row .row {
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
		$.ajax({
			url:'move',
			data:{'save_filename':filename},
			success:function(response){
				$("#checktable").append('<tr class="add"><td>'+filename+'</td><td>'+response.msg+'</td></tr>');
			}
		});
		
		
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
		var type=$("#checktable .add").eq(0).children().first().next().text();
		if($("#checktable .add").eq(0).children().first().text()==""){
			alert('먼저 파일을 선택하세요!')
			return false;
		}
		$("#checktable .add").each(function(index,item){
			alist+=$("#checktable .add").eq(index).children().first().text()+",";
		});
		$.ajax({
			url:'makefile',
			data:{'uploadFileName':alist,'arr':type},
			success:function(response){
				$("#buttons").append('<a href="fileDownload?integrate='+response.integrate+'">다운로드</a>');
				$("#inter").off();
			}
		});
	});
	
});
	</script>
<style type="text/css">
#container {
	width: 300px;
	margin: auto;
	margin-right:100px;
}


/* th{ */
/* 	background-color: skyblue; */
/* 	border: 1px solid black; */

/* } */
/* #inter{ */
/* 	float: right; */
/* 	margin-right: 34px; */
/* } */
/* #integratedList1{ */
/* 	padding : 5px; */
/* 	margin-left : auto; */
/* 	width : 40%; */
/* 	float : left; */
/* 	background-color: violet; */

/* } */
</style>

</head>

<body>


	<jsp:include page="../header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
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
			<div class="col-md-4">
				<div class="card">

					<div class="card-content table-responsive">
						<h1 id="stitle1" align="center">문서 리스트</h1>
						<table border="1" id="entire" class="table">
						
							<tr>

								<th class="filename" width="70">옮기기</th>
								<th class="filename" width="200">파일명</th>
								<th class="filename" width="70">삭제</th>
							</tr>

							<s:iterator value="list">
								<tr>
									<td class="filename"><input type="button"
										class="checked btn btn-primary" value="선택"></td>
									<td><a href="fileDownload?save_fileno=${save_fileno}"><s:property
												value="save_filename" /></a></td>
									<td class="filename"><input type="button"
										class="del btn btn-primary" value="삭제"></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-4">
			<h1 id="stitle1" align="center">선택된 파일 리스트</h1>
				<table id="checktable" border="1" class="table">
					<tr>
						<th class="filename" width="500">선택된 파일명</th>
						<th class="filename" width="200">파일 유형</th>
					</tr>
				</table>

			</div>
			<div class="row">
			<div id="buttons">

				<input type="hidden" name="msg" value="${msg}" id="msg" />
				<form action="insertfile" method="post"
					enctype="multipart/form-data" onsubmit="return formcheck()">
					<section>
						<div id="container">
							<h1 id="stitle3">통합문서 만들기</h1>
							<div class="form-group">

								<select class="form-control" name="files.filetype" id="sel">
									<option value="y">가계부</option>
									<option value="cost">거래명세표</option>
									<option value="mada">거래처별 미수현황표</option>
									<option value="card">법인카드 사용내역서</option>
								</select>
							</div>
							<input type="file" id="upfile" name="upload"> <input
								type="hidden" name="files.memberno"
								value="${session.members.memberno}" /> <input type="submit"
								class="btn btn-primary" value="올리기"> <input id="inter"
								type="button" value="통합문서 만들기" class="btn btn-primary">
						</div>
					</section>


				</form>
			</div>
			<br>

			<!-- 		<div id="integratedList1"> -->




			
				
				<div class="col-md-4 section-content">
					
				</div>
			</div>

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
			<!-- 			</div> -->








		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>

</html>