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
	<div>
	
	<s:form action="account/saveAccount" method="post">
	<table border="1">
		<tr>
			<th>날짜</th><th>내용</th><th>수입</th>
			<th>지출</th><th>비고</th><th>추가</th><th>삭제</th>
		<tr>
		<tr>
			<td><input type="text" name="date"></td>
			<td><input type="text" name="content"></td>
			<td><input type="text" name="in"></td>
			<td><input type="text" name="out"></td>
			<td><input type="text" name="note"></td>
			<td><input type="button" id="add" value="  +  "></td>
			<td><input type="button" id="del" value="  -  "></td>
	</table>
	<s:submit>저장</s:submit><s:reset>취소</s:reset>
	</s:form>
	
</div>
				
				
		

	<jsp:include page="../footer.jsp"></jsp:include>



</body>
</html>