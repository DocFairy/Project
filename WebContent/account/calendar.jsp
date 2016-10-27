<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
	<title>DocFairy-통합 문서 관리 시스템</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!--[if lt IE 9]>
		<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" />
	<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/swiper.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

   <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
   <script src="${pageContext.request.contextPath}/javascript/script.js"></script>

	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#picker").datepicker({
				dateFormat : "yymmdd",
				showAnim : "slide"	
			});

		$("#getdata").on("click",function(){
			var date = $("#picker").val();
			var date2 = {
				"date" : date	
			};
			
			$.ajax({
				url : "account/accountlist" ,
				method : "post" ,
				data : date2 ,
				dataType : "json" ,
				success : function(response){
					if(response.list!=""){
						$("#entire tr:not(:first)").remove();
					alert('가계부 파일이 있습니다');
						$.each(response.list,function(index,item){
				
						$("#entire").append('<tr><td>'
								+ '<center><a href="accountDownload?save_fileno=' +item.save_fileno+ '">다운로드</a></center>'
								+ '</td><td><center>' + item.save_filename +'</center>' 
								+ '</td><td>' + '<center><input type="button" value="삭제" class="delt btn btn-custom"></center>'
								+'</td></tr>'
							);
					});
					}else{
						$("#entire tr:not(:first)").remove();
						alert('가계부 파일이 없습니다');
						$("#entire").append(
							' <tr> <td> </td> <td> <center><input type="button" class="goMakeAccount btn btn-success" value="가계부만들기"></center> </td> ' 
						+ ' <td> </td> </tr></form>'	
						);
					}
				}
			});
		});	
		
		$("#entire").on('click','.goMakeAccount',function(){
			var data = $("#picker").val();
			var date = {"date" : data}
	
			$("#date").val(data);
			document.getElementById('gogoAccount').submit();
		/* 	$.ajax({
				url : 'account/goMakeAccount',
				data : date,
				success : function(){
					location.href='account/goMakeAccountPage'
				}
			});
 */			
			//location.href='account/goMakeAccount?date=${date}'
		});
		
		$("#entire").on('click','.delt',function(){
			$(this).parent().parent().parent().remove();
			var save_filename = $(this).parent().parent().parent().children().first().next().text();
			
			alert(save_filename);
			 	$.ajax({
					url : 'accountDel',
					method : 'post',
					dataType : 'json',
					data : {
						"del" : save_filename
					} ,
					success : function(){
						alert('success');
					}
				});	 
		});
		
		$("#entire").on('click','.checked',function(){
			var filename=$(this).parent().next().text();
			$("#check").append('<tr class="add"><td>'+filename+'</td><tr>');
			
		});
		
		
		
		
	});	
	</script>
	
	<style type="text/css">
h1{
	padding : 5px;
	magin-right : 20px;
	color:#fff ;
}		
th{
	border : 1px solid black;
	magin-right : 0;
	padding : 5px;
	width : 500px;
	background-color : violet;
	color : "red";
	text-align: center;
}
goMakeAccount{
	margin-right : 0;
	padding : 5px
}
	</style>
</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<aside class="col-md-3 sidebar">
				<div class="block">
					<h3><span>가계부 메뉴</span></h3>
					<nav>
						<nav>
						<ul class="nav">
							<li class="active"><a href="calendar">달력</a>
							</li>
							<li><a href="accountmanage">가계부 관리</a>
							</li>
						</ul>
					</nav>
					</nav>
				</div>
				
			</aside>
			<div id="centerMain">
			<h1>가계부 달력</h1><br><br>
	
	
		<input type="text" id="picker" placeholder="클릭하세용~♡" />
		<input type="button" id="getdata" value="확인!!" class="btn btn-primary btn-xs" />	
			</div>	
<form action="goMakeAccount" method="post" id="gogoAccount" >
<input type="hidden" name="date" id="date">
			<table border="1" id="entire">
				<tr>
				<th class="filename">옮기기</th>
				<th class="filename" width="200">파일명</th>
				<th class="filename" width="70">삭제</th>
				</tr>
				<s:iterator value="list">
				<tr>
				<td class="filename"><input type="button" class="checked" value="선택"></td>
				<td><a href="fileDownload?save_fileno=${save_fileno}"><s:property value="save_filename"/></a></td>
				<td class="filename"><input type="button" class="del" value="삭제"></td>
				</tr>
				</s:iterator>
				</table>
				
				<!-- <table id="check" border="1">
				<tr>
				<th class="filename" width="200">선택된 파일명</th>
				</tr>
				</table>	 -->
</form>				
				
		

	<jsp:include page="../footer.jsp"></jsp:include>


	
</html>