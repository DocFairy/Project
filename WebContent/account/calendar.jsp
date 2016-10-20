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
	<link rel="shortcut icon" href="../images/favicon.ico" />
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
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#picker").datepicker({
				dateFormat : "yy-mm-dd",
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
					alert(response);
				}
			});
			
			alert(date);
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
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				<nav class="text-center">
					<ul class="pagination">
						<li>
							<a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<li class="active"><a href="#">1</a>
						</li>
						<li><a href="#">2</a>
						</li>
						<li><a href="#">3</a>
						</li>
						<li class="disabled"><a href="#">4</a>
						</li>
						<li><a href="#">5</a>
						</li>
						<li>
							<a href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<jsp:include page="../footer.jsp"></jsp:include>


</html>