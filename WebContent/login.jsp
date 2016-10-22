<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>DocFairy - Login</title>
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
	<script type="text/javascript">
		function login(){
			
		}	
	</script>
</head>

<body>
	<header>
	<jsp:include page="header.jsp"></jsp:include>
   </header>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-12">

				<section class="login-form">
					<h1>로그인</h1>
					<div class="row">
						<div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3">
							<form action="${pageContext.request.contextPath}/members/login" method="post">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span>
										</div>
										<div class="animated-form-control">
											<input placeholder="아이디" type="text" name="id" class="text form-control" required="required" aria-required="true" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span>
										</div>
										<div class="animated-form-control">
											<input placeholder="비밀번호" type="password" name="password" class="text form-control" required="required" aria-required="true" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-primary pull-right" value="로그인">
								</div>
							</form>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<footer class="page-footer">
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/modernizr-custom.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
</body>
</html>