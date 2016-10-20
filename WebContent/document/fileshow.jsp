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
	<link rel="shortcut icon" href="images/favicon.ico" />
	<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/animate.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/swiper.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/style.css" />
	<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
<script type="text/javascript" src="../javascript/jquery-3.1.0.min.js"></script>
<script type="text/javascript">

function fileDownload(save_filenum){
	
}
</script>
</head>

<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>

	<div class="container">
		<div class="row">
			<aside class="col-md-3 sidebar">
				<div class="block">
					<h3><span>문서 메뉴</span></h3>
					<nav>
						<ul class="nav">
							<li><a href="docintegrate">통합문서</a>
							</li>
							<li class="active"><a href="docform">문서양식</a>
							</li>
							<li><a href="doctransform">문서변환</a>
							</li>
						</ul>
					</nav>
				</div>
				
				<div class="block">
					<h3>Tags</h3>
					<div class="tags">
					<a href="#" class="btn btn-default btn-xs">Vegetables</a>
						<a href="#" class="btn btn-default btn-xs">Food</a>
						<a href="#" class="btn btn-default btn-xs">Lunch</a>
						<a href="#" class="btn btn-default btn-xs">Carot</a>
						<a href="#" class="btn btn-default btn-xs">Gluten free</a>
					</div>
				</div>
				<div class="block">
					<h3>Keep in touch</h3>
					<p class="social">
						<!-- <a href="#"><i class="fa fa-facebook social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-twitter social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-instagram social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-youtube social-icon-small" aria-hidden="true"></i></a> -->
					</p>
				</div>
			</aside>
			파일미리보기
			<table>
			<tr><th>제목</th><td><s:property value="files.save_filename"/></td></tr>
			<tr><th>미리보기</th><td>파일의 미리보기</td>
			</table>
			<input type="button" value="만들기" onclick="window.open('makeNewForm','pop','resizable=no scrollbars=yes top=300 left=500 width=500 height=300');"/> 
			<form action="fileDownload">
		<%-- 	<input type="submit" id="fileDownload" value="다운"/>
			<input type="hidden" name="save_file" value="${files.save_file}"/> --%>
			<a href="fileDownload?save_fileno=${save_fileno}">
				<%-- <s:property value="save_filename"/> --%>download</a>
			
		
			</div>
		</div>
	

	<footer class="page-footer">
		<jsp:include page="../footer.jsp"></jsp:include>
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
</body>

</html>