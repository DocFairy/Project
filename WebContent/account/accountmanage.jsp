<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
							<li><a href="accountboard">게시판</a>
							</li>
						</ul>
					</nav>
				</div>
				
			</aside>
			
			<h1 id="stitle">가계부 관리</h1><br><br>
				
<jsp:include page="../footer.jsp"></jsp:include>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
</body>

</html>