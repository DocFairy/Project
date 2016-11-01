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
		/*  div{padding:0px; overflow: hidden; height: auto;}  */
		.hgroup{padding:20px;background-color:#e9e9e9;}
		.hgroup h1{font-family:Tahoma;}
		.hgroup p{margin:10px 0;font-size:10px}
		h2{margin:0;padding:20px;border:1px solid #000;background-color:#f9f9f9;border-width:1px 0;font-family:Tahoma;}
	</style>
 
	
<script type="text/javascript">
				
	$(document).ready(function(){
		
	
		$("#datepicker, #datepickerFrom, #datepickerTo").datepicker({
			dateFormat : "yymmdd"
		});
	
		$("#dateFromTo").on('click',function(){
			var dateFrom = $("#datepickerFrom").val();
			var dateTo = $("#datepickerTo").val();
		 	 if(dateFrom.length == 0){alert("시작날짜 입력하세요"); return false;}
			 if(dateTo.length == 0){alert("마지막 날짜 입력하세요"); return false;}
			 if(dateFrom > dateTo){alert("시작날짜를 더 빠르게 설정하세요"); return false;}
			
			$.ajax({
				url : 'gogoChart',
				data : {
					"dateFrom" : dateFrom ,
					"dateTo"   : dateTo
				},
				success : function(response){
					
					if(response.outdate != null){
					
						
					var outdate = response.outdate;
					var firstDay = response.firstDay;
					var secondDay = response.secondDay;
				
					$("#chart_c_a").append(
							'<input type="button" value="차트지우기" class="delChart btn btn-custom">'
							);
					
					var options = {
							'legend':{
								names: outdate,
								hrefs: []
							},
							'dataset':{
								title:'Playing time per day',
								values: secondDay,
								colorset: ['#DC143C','#FF8C00'],
								fields:['수입', '지출']
							},
							'chartDiv' : 'chart_c_a',
							'chartType' : 'line',
							'chartSize' : {width:700, height:300},
							'minValue' : 0,
							'maxValue' : 300000,
							'increment' : 50000,
							'isGuideLineNeeded' : true  //default set to false
						};
						Nwagon.chart(options);
					
					
					} else {
						alert('가계부 파일이 없습니다');
					}
				}
				
			});
		});
		
		$("#chart_d").on('click','.delGraph',function(){
			$(this).parent().remove();
			$("#chart_d").append('<div id="chart_d_a"></div>');
		});
		
		$("#chart_c").on('click','.delChart',function(){
			$(this).parent().remove();
			$("#chart_c").append('<div id="chart_c_a"></div>');
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
					
					$("#chart_d_a").append('<h3>'+response.date+'의 가계부</h3>');
					$("#chart_d_a").append(
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
							'chartDiv': 'chart_d_a',
							'chartType': 'donut',
							'chartSize': {width:700, height:300}
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
	float : left;
	width : 100%;
	border-bottom-style: groove;
	border-bottom-color: navy;
	border-bottom-width: medium;
} 

h3{
	border-top-style: double;
	border-top-color: purple;
	border-bottom-style: double;
	border-bottom-color : purple;
	width : 100%;
}
#dateP{
	padding : 5px;
	width : 100%;
	float : left;
	
}
#dateC{
	padding : 5px;
	widht : 100%;
	float : left;
}
.block{
	height : 100%;
}
p{
	padding : 5px;
	width : 100%;
	float : left;
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
				<div class="col-md-3 sidebar">
					<div class="block">
					</div>
				</div>
			</aside>
			
	<div class="col-md-9">
			<h1 id="stitle">가계부 관리</h2><br><br>
	
		<div id="dateP">	
				<p>그래프 </p>
			<input type="text" readonly="readonly" id="datepicker">
			<input type="button" id="getdata" value="확인!!" class="btn btn-primary btn-xs" />
		</div>	
	<div id="chart_d">
		<div id="chart_d_a" class="chart_d_a">
		</div>
	</div>
			
			
		<div id="dateC">
				<p>차트</p>
			<input type="text" readonly="readonly" id="datepickerFrom">~
			<input type="text" readonly="readonly" id="datepickerTo">
			<input type="button" id="dateFromTo" value="확인" class="btn btn-primary btn-xs" />
			<br>
		</div>
	<div id="chart_c">
		<div id="chart_c_a" class="chart_c_a">
		</div>
	</div>	
		
		
		
	</div>	
	
	
	</div>
	

</div>
	
	
			
				
<jsp:include page="../footer.jsp"></jsp:include>

	
</body>

</html>
