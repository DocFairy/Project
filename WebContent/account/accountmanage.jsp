<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

	<!-- 데이트피커 달력표시 -->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
	
	<link rel='stylesheet' href='${pageContext.request.contextPath}/Nwagon.css' type='text/css'>
	<script src='${pageContext.request.contextPath}/Nwagon.js'></script>
	
		<style>
		*{margin:0;padding:0;}
		div{padding:0px; overflow: hidden; height: auto;}
		.hgroup{padding:20px;background-color:#e9e9e9;}
		.hgroup h1{font-family:Tahoma;}
		.hgroup p{margin:10px 0;font-size:10px}
		h2{margin:0;padding:20px;border:1px solid #000;background-color:#f9f9f9;border-width:1px 0;font-family:Tahoma;}
	</style>

	
<script type="text/javascript">
				
	$(document).ready(function(){
		
	
		$("#datepicker").datepicker({
			dateFormat : "yymmdd"
		});
	
		
		$(".row").on('click','.delGraph',function(){
			$(this).parent().remove();
			$(".row").append('<div id="chart_d"></div>');
		});
		
		$("#getdata").on('click',function(){
			var date = $("#datepicker").val();
			$.ajax({
				
				url : 'gogoGraph' ,
				data : {
					"date" : date
				},
				success:function(response){	

					
				if(response.cloth != null){
					
					$("#chart_d").append('<h3>'+response.date+'의 가계부</h3>');
					$("#chart_d").append(
						'<input type="button" value="그래프지우기" class="delGraph btn btn-custom">'
						);
					var options = {
							'dataset': {
								title: 'Web accessibility status',
								values:[response.cloth, response.food, response.health, response.cost, response.save, response.house, response.ex],
								colorset: ['#2BC8C9', '#FF8C00', '#DC143C','#2EB400', '#666666', 'red', 'violet'],
								fields: ['의류비', '식비',  '건강/문화', '경조사/회비', '저축/보험', '주거/통신','기타'] 
							},
							'donut_width' : 50, 
							'core_circle_radius':50,
							'chartDiv': 'chart_d',
							'chartType': 'donut',
							'chartSize': {width:500, height:300}
						};

						Nwagon.chart(options);
					} else {
						alert('가계부 파일이 없습니다!!');
					}
				}
			});
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
#chart_d{
	padding : 5px;
	width : 50%;
	float: right;
} 
h3{
	border-top-style: double;
	border-top-color: purple;
	border-bottom-style: double;
	border-bottom-color : purple;
}
#dateP{
	padding : 5px;
	width : 30%;
	
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
						<ul class="nav">
							<li><a href="calendar">달력</a>
							</li>
							<li class="active"><a href="accountmanage">가계부 관리</a>
							</li>
						</ul>
					</nav>
				</div>
				
			</aside>
			
			<h1>가계부 관리</h1><br><br>
		<div id="dateP">	
			<input type="text" readonly="readonly" id="datepicker">
			<input type="button" id="getdata" value="확인!!" class="btn btn-primary btn-xs" />
		</div>	
			
		
		
	<div id="chart_d">

		</div>
	
	</div>
	

</div>
	
	
			
				
<jsp:include page="../footer.jsp"></jsp:include>

	
</body>

</html>
