<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>DocFairy-통합 문서 관리 시스템</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!--[if lt IE 9]>
		<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	<link rel="shortcut icon" href="images/favicon.ico" />
	<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/animate.css" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<style>
	#img{
	width:300;
	height:300;
	}
	#intro{
	float:right;
	font-family:fantasy;
	margin-right:100px;
	}
	</style>
	<script src="javascript/pace.min.js"></script>
</head>

<body>
<div class="container">
	<div class="row">
	<jsp:include page="header.jsp"></jsp:include>
	<h1 id="stitle">소개</h1>
	<img src="images/docfairy3.png" id="img" width="550" height="300">
	<div id="intro">
	DocFairy는 유저의 편의를 위해 여러 가지 문서 관련 기능을 제공하는<br> 웹사이트입니다.
	다음과 같은 강력한 기능을 무료로 제공합니다:<br><br>
	<b>1.통합문서 제작기능</b>
	<p>날마다 기록된 매출기록이나 거래내역 등을 올리시기만 하면,<br> 저희 웹사이트에서 그 기간 내에 거래된 모든 내용을 통합해서 <br>문서로 제공합니다.<br>
	원하시는 양식이 없으시면, 언제든지 하단 주소로 연락주세요!<br><br>
	<b>2.그룹핑 기능</b>
	<p>회사나 기타 집단 내에서만 쓸 수 있는 문서를 간단히 공유하고, <br>다운로드 해 보세요!<br><br>
	<b>3.통계관리 기능</b>
	<p>수입/지출 내역을 입력하시면 표/그래프로 한눈에 정리해드립니다.<br><br>

	</div>
	</div>
	</div>

	
<jsp:include page="footer.jsp"></jsp:include>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="javascript/script.js"></script>
</body>

</html>
