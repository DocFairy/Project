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
th{
color:white;
background-color:#af2045;
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
#scroll{
height:400px;
overflow:auto;
}
.col-md-4{
width:400px;
overflow:auto;
}
span{
font-size:15px;
}
#scroll2{
height:700px;
overflow:auto;
width:400px;
}

</style>
<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/javascript/jquery-3.1.0.min.js"></script>

<script>
function pagingFormSubmit(currentPage) {
	document.pagingForm.currentPage.value = currentPage;
	document.pagingForm.submit();
}
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
		var filename=$(this).parent().prev().text();
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
		var save_filename=$(this).parent().parent().children().first().children().text();
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
	$("#help").on('click',function(){
		alert('1. 올릴 파일의 유형을 선택하고 파일을 업로드하세요. 파일이 문서 리스트에 업로드됩니다. \n\r2. 문서 리스트에서 통합할 파일이 있는 줄의 왼쪽 "옮기기"버튼을 누르세요. 파일이 선택된 파일 리스트로 복사됩니다. \n\r3. 선택된 파일 리스트에 통합할 문서 파일이 모두 올라가면, 통합문서 만들기를 누르세요.\n\r ※ 본 홈페이지에서 받은 문서 양식을 사용해주세요! 또한 상호명이나 사업자번호 등은 통합 리스트의 첫 번째 파일을 따릅니다.');
	});
	$("#remove").on('click',function(){
		location.href='docintegrate';
	});
});
	</script>

</head>

<body>


	<jsp:include page="../header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<aside class="col-md-3 sidebar">
				<div class="block" style="1px solid black;">
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
			<h1 id="stitle">문서 통합</h1><a id="help">도움말</a>
			
			<div class="col-md-4" style=height:700px>
				<div class="card">
					
					<div class="card-content table-responsive">
						<h3 id="stitle1" align="center">문서 리스트</h3>
						<table id="entire" class="table">
						
							<tr>						
								<th class="filename" width="200">파일명</th>
								<th class="filename" width="70">옮기기</th>
								<th class="filename" width="70">삭제</th>
							</tr>
							
							<s:iterator value="list">
								<tr><td><span><a href="fileDownload?save_fileno=${save_fileno}"><s:property
												value="save_filename" /></a></span></td>
									<td class="filename"><input type="button"
										class="checked btn btn-link" value="선택"></td>	
									<td class="filename"><input type="button"
										class="del btn btn-link" value="삭제"></td>
								</tr>
							</s:iterator>
						</table>
			
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
			</ul>  --%>
			
			</div>
			<div id="scroll">
			<div class="col-md-11">
			<h3 id="stitle1" align="center">선택된 파일 리스트</h3>
				<table id="checktable" border="1" class="table">
					<tr>
						<th class="filename" width="500">선택된 파일명</th>
						<th class="filename" width="300">파일 유형</th>
					</tr>
				</table>
				</div>
			</div>
		
			<div id="buttons">

				<input type="hidden" name="msg" value="${msg}" id="msg" />
				<form action="insertfile" method="post"
					enctype="multipart/form-data" onsubmit="return formcheck()">
					<section>
						<div id="container">
							<h3>파일 업로드/통합문서 생성</h3>
							<div class="form-group">
								업로드할 파일 유형을 선택하세요:
								<select name="files.filetype" id="sel">
									<option value="y">가계부</option>
									<option value="cost">거래명세서</option>
									<option value="uum">지급어음명세서</option>
									<option value="left">재고관리대장</option>
									<option value="getu">월말경비정산표</option>
									<option value="dept">외상매출내역</option>
									<option value="print">인쇄물발주서</option>
									<option value="misu">미수금현황표</option>
								</select>
							</div>
							<input type="file" id="upfile" name="upload"> <input
								type="hidden" name="files.memberno"
								value="${session.members.memberno}" /><br> <input type="submit"
								class="btn btn-primary" value="올리기"> <input id="remove"
								type="button" value="리스트 삭제" class="btn btn-primary">
								<input id="inter"
								type="button" value="통합문서 생성" class="btn btn-primary">
						</div>
					</section>


				</form>
			</div>
			<br>

			<!-- 		<div id="integratedList1"> -->
			
				<div class="col-md-4 section-content">
					
				</div>		 
			<!-- 			</div> -->
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>

</html>