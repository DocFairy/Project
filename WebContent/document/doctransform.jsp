<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<title>DocFairy-문서 변환 시스템</title>
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
	href="${pageContext.request.contextPath}/css/animate.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/swiper.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/javascript/jquery-3.1.0.min.js"></script>
<script>
	function formcheck() {
		if ($("#upfile").val() == "") {
			alert('파일을 선택하지 않았습니다!');
			return false;
		}
	}

	$(function() {
		var msg = $("#msg").val();
		if (msg != "") {
			alert(msg);
		}
		$("#entire").on('click','.checked',function(){
			var filename=$(this).parent().next().text();
			$.ajax({
				url:'move2',
				data:{'save_filename':filename},
				success:function(response){
					$("#checktable").append('<tr class="add"><td>'+filename+'</td><td>'+response.msg+'</td></tr>');
				}
			});
		});
		$(".del").on(
				'click',
				function() {
					$(this).parent().parent().remove();
					var save_filename = $(this).parent().parent().children()
							.first().next().children().text();
					$.ajax({
						url : 'delfile',
						data : {
							'uploadFileName' : save_filename
						}
					});
				});
		
		
		
		$("#change")
				.on(
						'click',
						function() {
							var type=$("#checktable .add").eq(0).children().first().next().text();
							
							if ($("#checktable .add").eq(0).children().first()
									.text() == "") {
								alert('먼저 파일을 선택하세요!')
								return false;
							}
							var fname = $("#checktable .add").eq(0).children().first()
							.text();
							alert(fname);
			
							$.ajax({
								url : 'changefile',
								data : {
									'uploadFileName' : fname,'arr':type
								},
								success : function(response) {
									$("#button").append(
											'<a href="fileDownload?integrate='
													+ response.integrate
													+ '&fname='+fname+'">다운로드</a>');
									$("#change").off();
								}
							});
						});

		// #change

		// url = changefile

		//
		
		$("#help").on('click',function(){
			alert('1. 올릴 파일의 유형을 선택하고 파일을 업로드하세요. 파일이 문서 리스트에 업로드됩니다. \n\r2. 문서 리스트에서 변환할 파일이 있는 줄의 왼쪽 "옮기기"버튼을 누르세요. 파일이 선택된 선택된 워드로 복사됩니다. \n\r3. 선택된 워드에 변환할 파일이 올라가면, 변환 버튼을 클릭하세요.\n\r ※ 본 홈페이지에서 받은 문서 양식을 사용해주세요!');
		});

	});
</script>

<style type="text/css">
#scroll{
height:400px;
overflow:auto;
}
.col-md-4{
width:400px;
}
span{
font-size:15px;
}
th{
color:white;
background-color:#af2045;
}

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
.col-md-3 sidebar{
	border:1px solid black;
}

#container {
	width: 300px;
	margin: auto;
	margin-right:100px;
}

.pagination{
padding-top:130px;
position:absolute;
margin-left:100px;
}

#help{
float:left;
}
</style>
</head>

<body>

	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	<div class="container">
		<div class="row">
			<aside class="col-md-3 sidebar">
				<div class="block">
					<h3>
						<span>문서 메뉴</span>
					</h3>
					<nav>
						<ul class="nav">
							<li><a href="docintegrate">통합문서</a></li>
							<li><a href="docform">문서양식</a></li>
							<li class="active"><a href="doctransform">문서변환</a></li>
						</ul>
					</nav>
				</div>
			</aside>
			
			<h1 id="stitle">문서 변환</h1><a id="help">도움말</a><br>
			
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
									<td><span><a href="fileDownload?save_fileno=${save_fileno}"><s:property
												value="save_filename" /></a></span></td>
									<td class="filename"><input type="button"
										class="del btn btn-primary" value="삭제"></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
			
			
			
			<div id="scroll">
			<div class="col-md-11">
			<h3 id="stitle1" align="center">선택된 워드 리스트</h3>
				<table id="checktable" border="1" class="table">
					<tr>
						<th class="filename" width="500">선택된 파일명</th>
						<th class="filename" width="300">파일 유형</th>
					</tr>
				</table>
				</div>
			</div>
	
			<div id="buttons" >
				<input type="hidden" name="msg" value="${msg}" id="msg">

				<!-- 				<form action="insertfile" method="post" enctype="multipart/form-data" onsubmit="return formcheck()"> -->
				<%-- 				<select name="files.filetype" id="sel"> --%>
				<!-- 				<option value="tax">세금계산서</option> -->
				<!-- 				<option value="cost">거래명세표</option> -->
				<!-- 				<option value="mada">거래처별 미수현황표</option> -->
				<!-- 				<option value="card">법인카드 사용내역서</option> -->
				<%-- 				</select> --%>
				<!-- 				<input type="file" id="upfile" name="upload"> -->
				<%-- 				<input type="hidden" name="files.memberno" value="${session.members.memberno}"> --%>
				<!-- 				<input type="submit" value="올리기"> -->
				<!-- 				</form> -->
				<form action="insertword" method="post"
					enctype="multipart/form-data" onsubmit="return formcheck()">
						<div id="container">
						<h1 align="left">워드 파일 업로드 / 변환</h1>

						<div class="form-group">
							<select name="files.filetype" id="sel">
								<option value="ima">거래처별 현황</option>
								<option value="genjou">거래처별 미수현황표</option>
								<option value="keibi">경비사용내역</option>
							</select>
						</div>
					 <input type="file" id="upfile" name="upload">
					 <input type="hidden" name="files.memberno" value="${session.members.memberno}">
					 <br>
					 <input type="submit" value="올리기" class="btn btn-primary">
					 <input id="change" type="button" value="변환" class="btn btn-primary">
					 </div>
					
<%-- 					<select name="files.filetype" id="sel"> --%>
<!-- 						<option value="tax">세금계산서</option> -->
<!-- 						<option value="cost">거래명세표</option> -->
<!-- 						<option value="mada">거래처별 미수현황표</option> -->
<!-- 						<option value="card">법인카드 사용내역서</option> -->
<%-- 					</select> --%>
					
				</form>
			</div>
			
			
<!-- 			<table border="1" id="entire"> -->
<!-- 			<h1 id="stitle1" align="center">문서리스트</h1> -->
<!-- 				<tr> -->
<!-- 					<th>옮기기</th> -->
<!-- 					<th class="filename" width="200">파일명</th> -->
<!-- 					<th class="filename" width="70">삭제</th> -->
<!-- 				</tr> -->
<%-- 				<s:iterator value="list"> --%>
<!-- 					<tr> -->
<!-- 						<td class="filename"><input type="button" class="checked btn btn-primary" -->
<!-- 							value="선택"></td> -->
<%-- 						<td><a href="fileDownload?save_fileno=${save_fileno}"><s:property --%>
<%-- 									value="save_filename" /></a></td> --%>
<!-- 						<td class="filename"><input type="button" class="del btn btn-primary" -->
<!-- 							value="삭제" ></td> -->
<!-- 					</tr> -->
<%-- 				</s:iterator> --%>
<!-- 			</table> -->
			
			<!-- 여기서 -->
			
<!-- 			<table id="check" border="1" align="center"> -->
<!-- 				<tr> -->
<!-- 					<th class="filename" width="85" >선택된파일</th> -->
<!-- 				</tr> -->
<!-- 			</table> -->
			
			
<!-- 			<ul class="pagination"> -->

<%-- 				<li><a href="#" aria-label="Previous"> <span --%>
<%-- 						aria-hidden="true">&laquo;</span> --%>
<!-- 				</a></li> -->
<!-- 				<li class="active"><a href="#">1</a></li> -->
<!-- 				<li><a href="#">2</a></li> -->
<!-- 				<li><a href="#">3</a></li> -->
<!-- 				<li class="disabled"><a href="#">4</a></li> -->
<!-- 				<li><a href="#">5</a></li> -->
<%-- 				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span> --%>
<!-- 				</a></li> -->
<!-- 			</ul> -->
			
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