<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DocFairy</title>
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
<body class="home-page">
	<header>
		<div class="login">
			<s:if test="#session.members == null">
				<form action="${pageContext.request.contextPath}/members/login" method="post">
				<ul style="list-style: none;padding: 5px;">
					<li style="float: left;"><input type="text" placeholder="Id" name="id" class="text form-control"  required="required" aria-required="true"></li>
					<li style="float: left;"><input type="password" name="password" placeholder="Password" class="text form-control" required="required" aria-required="true"></li>
					<li style="float: left;"><input type="submit" value="로그인" class="btn btn-primary btn-sm"></li>
				</ul>
				</form>
				<ul style="list-style: none;padding: 5px;">
					<li><a id="join" href="${pageContext.request.contextPath}/join">회원가입</a></li>
					<li><a id="find" href="${pageContext.request.contextPath}/find">아이디/비밀번호 찾기</a></li>
				</ul>
			</s:if>
				
				<s:if test="#session.members != null">
					<ul style="list-style: none;">
					<li style="font-size: 1.0em; float: left; padding: 5px 0 0 5px;"><s:property value="#session.members.id"/> 님 </li>
					<li style="float: left;"><a href="${pageContext.request.contextPath}/members/logout"  class="btn btn-default btn-xs">로그아웃</a></li>
					<li style="float: left;"><a href="${pageContext.request.contextPath}/members/updateForm" class="btn btn-default btn-xs">회원정보 수정</a><br></li>
					</ul>
				</s:if>
				
		</div>
		<div class="container hidden-xs logo">
			<a href="${pageContext.request.contextPath}/index"><img class="img-responsive" src="${pageContext.request.contextPath}/images/docfairy2.png" alt="Logo" />
			</a>
		</div>
		<div class="navbar-wrapper">
			<div class="container">
				<nav class="navbar navbar-static-top">
					<div class="navbar-header">
						<a class="navbar-brand visible-xs" href="${pageContext.request.contextPath}/index"><img class="img-responsive" src="${pageContext.request.contextPath}/images/logos/logo-xs.png" alt="" />
						</a>
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>

					</div>
				
					<br>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-center navbar-nav">
							<li><a href="${pageContext.request.contextPath}/index">홈</a></li>

							<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#">문서</a>
								<ul class="dropdown-menu text-center">
									<li><a href="${pageContext.request.contextPath}/document/docintegrate">통합문서</a>
									</li>
									<li><a href="${pageContext.request.contextPath}/document/docform">문서양식</a>
									</li>
									<li><a href="${pageContext.request.contextPath}/document/doctransform.action">문서변환</a>
                                    </li>
								</ul>
							<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#">그룹핑</a>
								<ul class="dropdown-menu text-center">
									<li><a href="${pageContext.request.contextPath}/grouping/groupmanage.action">그룹 관리</a></li>
									<li><a href="${pageContext.request.contextPath}/grouping/groupdocdownload">서식 관리</a></li>
                       			 </ul>
								
								<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#">가계부</a>
                        <ul class="dropdown-menu text-center">
                           <li><a href="${pageContext.request.contextPath}/account/calendar">달력</a>
                           </li>
									<li><a href="${pageContext.request.contextPath}/account/accountmanage">가계부관리</a>
									</li>
								
								</ul>
							</li>
							<li><a href="${pageContext.request.contextPath}/card">소개</a>
							</li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
	</header>
</body>
</html>