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
	<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
  <script src="${pageContext.request.contextPath}/javascript/jquery-3.1.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/javascript/jquery-ui.js"></script>
	
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
					$.each(response.list,function(index,item){
				
						$("#entire").append('<tr><td>'
								+ '<input type="button" value="옮기기" class="trans">'
								+ '</td><td>' + item.save_filename 
								+ '</td><td>' + '<input type="button" value="삭제" class="delt">'
								+'</td></tr>'
							);
					});
					}else{
						$("#entire tr:not(:first)").remove();
					}
				}
			});
			alert(date);
		});	
		$("#entire").on('click','.delt',function(){
			$(this).parent().parent().remove();
			var save_filename=$(this).parent().parent().children().first().next().text();
			
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
	});	
	</script>
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
							<li><a href="accountboard">게시판</a>
							</li>
						</ul>
					</nav>
					</nav>
				</div>
				
			</aside>
			<h1 id="stitle">가계부 달력</h1><br><br>
	
	
		<input type="text" id="picker" placeholder="클릭하세용~♡" />
		<input type="button" id="getdata" value="확인!!" class="btn btn-primary btn-xs" />	
		
			<table border="1" id="entire">
				<tr>
				<th>옮기기</th>
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
				<table id="check" border="1">
				<tr>
				<th class="filename" width="200">선택된 파일명</th>
				</tr>
				</table>	

	<jsp:include page="../footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>

</html>