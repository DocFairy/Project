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
	<link rel="shortcut icon" href="images/favicon.ico" />
	<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/animate.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/swiper.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/style.css" />
	<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
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
						<a href="#"><i class="fa fa-facebook social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-twitter social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-instagram social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-youtube social-icon-small" aria-hidden="true"></i></a>
					</p>
				</div>
			</aside>
			docform.jsp
				

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

	<footer class="page-footer">
		<jsp:include page="../footer.jsp"></jsp:include>
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
</body>

</html>